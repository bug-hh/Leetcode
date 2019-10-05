package array.medium;

import java.util.*;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		ArrayList<List<Integer>> ret = new ArrayList<>();

		if (nums == null || nums.length < 3) {
			return ret;
		}

		Arrays.sort(nums);
		int i = 0;
		while (i < nums.length - 2) {
			int target = -nums[i];
			int left = i + 1, right = nums.length - 1;
			while (left < right) {
				int sum = nums[left] + nums[right];
				if (sum < target) {
					left++;
				} else if (sum > target) {
					right--;
				} else {
					ArrayList<Integer> tempList = new ArrayList<>();
					tempList.add(nums[i]);
					tempList.add(nums[left]);
					tempList.add(nums[right]);
					ret.add(tempList);
					//对第二个数进行去重
					while (left < nums.length - 1 && nums[left] == tempList.get(1)) {
						left++;
					}

					//对第三个数进行去重
					while (right >= 0 && nums[right] == tempList.get(2)) {
						right--;
					}
				}
			}

			//对第一个数进行去重
			while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
				i++;
			}
			i++;
		}
		return ret;
	}

	public static void main(String[] args) {
		int[] arr = {-1, 0, 1, 2, -1, -4};
		ThreeSum ts = new ThreeSum();
		List<List<Integer>> ret = ts.threeSum(arr);
		for (List<Integer> list : ret) {
			for (Integer num : list) {
				System.out.printf("%4d", num);
			}
			System.out.println();
		}
	}

}
