package array.easy;

import java.util.ArrayList;
import java.util.List;

public class pascalTriangle_I {
	public List<List<Integer>> generate(int numRows) {
		ArrayList<List<Integer>> ret = new ArrayList<>();
		if (numRows <= 0) {
			return ret;
		}
		ArrayList<Integer> row = new ArrayList<>();
		row.add(1);

		ret.add(row);
		for (int i = 1; i < numRows; i++) {
			int cols = row.size();
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for (int j = 0; j < cols; j++) {
				int s1 = j - 1 < 0 ? row.get(j) : row.get(j - 1) + row.get(j);
				temp.add(s1);
			}
			temp.add(1);
			ret.add(temp);
			row = temp;
		}
		return ret;
	}

	public static void main(String[] args) {
		pascalTriangle_I pt = new pascalTriangle_I();
		List<List<Integer>> ret = pt.generate(0);
		for (List<Integer> list : ret) {
			for (Integer num : list) {
				System.out.printf("%4d", num);
			}
			System.out.println();
		}
	}
}
