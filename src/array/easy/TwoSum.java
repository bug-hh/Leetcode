package array.easy;

import java.util.HashMap;
import java.util.HashSet;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		if (nums == null || nums.length < 2) {
			return null;
		}

		HashMap<Integer, Integer> res = new HashMap<>();
		int[] ret = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if (!res.containsKey(nums[i])) {
				res.put(target - nums[i], i);
			} else {
				ret[0] = i;
				ret[1] = res.get(nums[i]);
			}
		}
		return ret;
	}
}
