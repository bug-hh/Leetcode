package array.medium;

public class MaxiumProductSubarray {
  /*
  解析：
  使用 DP 来做，使用 两个数组 max，min，max[i] 表示 num[0:i](包括 num[i])范围内的最大乘积，
  min[i] 表示 num[0:i](包括 num[i]) 范围内的最小乘积，那么
  max[i] = maximum(max[i-1] * num[i], min[i-1] * num[i], num[i]),
  min[i] = minimum(max[i-1] * num[i], min[i-1] * num[i], num[i])
  这道题的答案就是 max 数组里面的最大值。
  详细解答见：https://www.cnblogs.com/grandyang/p/4028713.html
   */
  public int maxProduct(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }

    int[] max = new int[nums.length];
    int[] min = new int[nums.length];
    max[0] = nums[0];
    min[0] = nums[0];

    int ret = nums[0];
    for (int i = 1; i < nums.length; i++) {
      int temp1 = max[i - 1] * nums[i];
      int temp2 = min[i - 1] * nums[i];
      max[i] = temp1 > temp2 ? temp1 : temp2;
      max[i] = nums[i] > max[i] ? nums[i] : max[i];

      min[i] = temp1 < temp2 ? temp1 : temp2;
      min[i] = nums[i] < min[i] ? nums[i] : min[i];

      ret = max[i] > ret ? max[i] : ret;
    }
    return ret;
  }

  public static void main(String[] args) {
    MaxiumProductSubarray obj = new MaxiumProductSubarray();
  }
}
