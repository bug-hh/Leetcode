package array.medium;


public class NextPermutation {
	/*
  解题思路：先从数组最后找出数组从右往左升序排列断开的地方，因为「从右往左是升序，那么表示从左往右是降序」，
  而一个排列，如果从左往右是降序，那么这个排列是字典序最大的。
  假设这个断开的位置是 i，即表示 nums[i] > nums[i - 1],所以从右往左看是降序，
  那么数组从 0 -> i - 1 是升序排列，即「字典序最小排列」，
  现在要找这个排列的下一个排列（这个排列的后面一个字典序排列),那么就要在  j = i -> nums.length - 1 中，
  找到一个 diff = nums[j] - num[i - 1] > 0 且 diff 要最小的 nums[j],然后把 nums[j] 与 nums[ i - 1] 交换，
  最后把 i -> nums.length - 1 所有数字按照升序排列即可。
	 */
	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length < 2) {
			return;
		}

		/*
		先从数组最后往前找，找到第一个满足 nums[i] > nums[i - 1] 的 i
		 */
		int i = nums.length - 1;
		while (i > 0 && nums[i] <= nums[i - 1]) {
			i--;
		}

		/* 如果 i = 0，说明整个数组从索引 0 -> nums.length 都是按照降序排列，
		那么这个序列已经是这个排列中最大的了，没有比它更大的，所以按照题目要求，
		直接返回最小的序列，也就是索引从 0 -> nums.length 按照升序进行排列。
		 */
		if (i == 0) {
			reverseArray(nums, 0, nums.length - 1);
		} else {
			/*
			当找到第一个满足 nums[i] > num[i - 1] 的 i 后，且 i > 0,
			那么说明，从 j = i -> nums.length - 1 的所有数中，找到满足条件「diff = num[j] - nums[i - 1]最小, 且 diff > 0 的那个 j」，
			如果 j 存在：
				那么，记为 nums[j]，
				把 nums[j] 与 nums[i - 1] 做交换，最后把从 i -> nums.length - 1 的所有数字全部反转，
				因为本来 i -> nums.length - 1 的数是按照降序排列，那么这是「字典序最大的排列」，现在把它反转，
				就变成了「字典序最小的排列」
			如果 j 不存在：
				那么表示现在这个数组表示的序列是字典序最大的序列，没有比它更大的，所以按照题目要求，返回最小序列，
				即：数组元素从索引 0 -> nums.length - 1 按照升序排列。
			 */
			int diff = nums[i] - nums[i - 1];
			int index = diff > 0 ? i : -1;
			for (int j = i + 1; j < nums.length; j++) {
				int tempDiff = nums[j] - nums[i - 1];
				// 注意一定要有这个等号
				/*
				例：2 3 1 |3 3 3 3 3
				   2 3 3 |3 3 3 3 1 有了这个等号，1 才会和最后一个 3 交换
				   2 3 3 |1 3 3 3 3 然后经过反转后，1 就在最前面，就是最接近 2 3 1 3 3 3 3 3 的数
				 */
				if (tempDiff > 0 && diff >= tempDiff) {
					diff = tempDiff;
					index = j;
				}
			}

			if (index != -1) {
				int temp = nums[index];
				nums[index] = nums[i - 1];
				nums[i - 1] = temp;

				reverseArray(nums, i, nums.length - 1);
			} else {
				reverseArray(nums, 0, nums.length - 1);
			}
		}
	}

	public void reverseArray(int[] arr, int begin, int end) {
		while (begin < end) {
			int temp = arr[end];
			arr[end] = arr[begin];
			arr[begin] = temp;
			begin++;
			end--;
		}
	}

	public static void main(String[] args) {
		int[] arr = {1, 1, 5, 2, 3};
		NextPermutation np = new NextPermutation();
		np.nextPermutation(arr);
		for (int n : arr) {
			System.out.printf("%4d", n);
		}
		System.out.println();
	}
}
