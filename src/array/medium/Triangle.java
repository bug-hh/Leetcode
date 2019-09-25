package array.medium;

import java.net.MalformedURLException;
import java.util.List;

public class Triangle {
  /*
  假设 trianle[i][j] 表示从顶端第 0 行 第 0 列 到 第 i 行，第 j 列最小路径和，
  那么[i][j] 只能由[i-1][j-1] 或者[i - 1][j]才能达到。
  所以 triangle[i][j] = min(triangle[i-1][j-1], triangle[i - 1][j]) + triangle[i][j]
  而对于每一行数组中的边界值（即 j == 0 或者 j == cols - 1）时，只能由上一行的边界值达到
  例如 [2][0] 只能由[1][0] 到达，那么 triangle[2][0] = triangle[1][0] + triangle[2][0]
  例如 [2][4] 是 第 2 行数组中最后一个元素，那么triangle[2][4] = triangle[1][3] + triangle[2][4]
  具体解析见：https://www.cnblogs.com/grandyang/p/4286274.html
   */
  public int minimumTotal(List<List<Integer>> triangle) {
    if (triangle == null || triangle.size() == 0) {
      return 0;
    }

    int rows = triangle.size();
    if (rows == 1) {
      return triangle.get(0).get(0);
    }

    int ret = triangle.get(0).get(0);

    for (int i = 1; i < rows; i++) {
      int cols = triangle.get(i).size();
      for (int j = 0; j < cols; j++) {
        // 处理边界值
        if (j == 0 || j == cols - 1) {
          int temp = j == 0 ? triangle.get(i).get(j) + triangle.get(i - 1).get(j) : triangle.get(i).get(j) + triangle.get(i - 1).get(j - 1);
          triangle.get(i).set(j, temp);
        } else {
          int temp1 = triangle.get(i - 1).get(j - 1) < triangle.get(i - 1).get(j) ? triangle.get(i - 1).get(j - 1) : triangle.get(i - 1).get(j);
          temp1 += triangle.get(i).get(j);
          triangle.get(i).set(j, temp1);
        }
        if (i == rows - 1) {
          if (j == 0) {
            ret = triangle.get(i).get(j);
          } else {
            ret = triangle.get(i).get(j) < ret ? triangle.get(i).get(j) : ret;
          }
        }
      }
    }

    return ret;
  }
  public static void main(String[] args) throws MalformedURLException, InterruptedException {
    Triangle obj = new Triangle();

  }
}
