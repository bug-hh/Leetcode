package array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	// 解析参考：https://www.cnblogs.com/grandyang/p/4515925.html
	public List<List<Integer>> fourSum(int[] nums, int target) {
		ArrayList<List<Integer>> ret = new ArrayList<>();
		if (nums == null || nums.length < 4) {
			return ret;
		}

		Arrays.sort(nums);
		// fix 第一个数
		for (int i = 0; i < nums.length - 3; i++) {
			// fix 第二个数
			for (int j = i + 1; j < nums.length - 2; j++) {
				int temp = target - nums[i] - nums[j];
				int left = j + 1, right = nums.length - 1;
				while (left < right) {
					int sum = nums[left] + nums[right];
					if (sum > temp) {
						right--;
					} else if (sum < temp) {
						left++;
					} else {
						ArrayList<Integer> tempList = new ArrayList<>();
						tempList.add(nums[i]);
						tempList.add(nums[j]);
						tempList.add(nums[left]);
						tempList.add(nums[right]);
						ret.add(tempList);

						// 对第 3 个数进行去重
						while (left < nums.length && nums[left] == tempList.get(2)) {
							left++;
						}

						// 对第 4 个数进行去重
						while (right >= 0 && nums[right] == tempList.get(3)) {
							right--;
						}
					}
				}

				// 对第 2 个数进行去重
				while (j < nums.length - 1 && nums[j] == nums[j + 1]) {
					j++;
				}
			}

			// 对第 1 个数进行去重
			while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
				i++;
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		FourSum fs = new FourSum();
		int[] arr = {1, 0, -1, 0, -2, 2};
		int target = 0;
		List<List<Integer>> ret = fs.fourSum(arr, target);
		for (List<Integer> list : ret) {
			for (Integer num : list) {
				System.out.printf("%4d", num);
			}
			System.out.println();
		}
	}
}

/*
[-3,-2,-1,0,0,1,2,3]
0
 */
