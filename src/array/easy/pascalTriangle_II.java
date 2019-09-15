package array.easy;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class pascalTriangle_II {
	public List<Integer> getRow(int rowIndex) {
		ArrayList<Integer> ret = new ArrayList<>();
		if (rowIndex < 0) {
			return ret;
		}
		ArrayList<Integer> row = new ArrayList<>();
		row.add(1);
		for (int i = 0; i < rowIndex; i++) {
			int cols = row.size();
			ArrayList<Integer> temp = new ArrayList<>();
			for (int j = 0; j < cols; j++) {
				int s1 = j - 1 < 0 ? row.get(j) : row.get(j - 1) + row.get(j);
				temp.add(s1);
			}
			temp.add(1);
			row = temp;
		}
		return row;
	}

	public static void main(String[] args) {
		pascalTriangle_II pt = new pascalTriangle_II();
		List<Integer> ret = pt.getRow(0);
		for (Integer num : ret) {
			System.out.printf("%4d", num);
		}
		System.out.println();
	}
}
