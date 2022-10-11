class Solution {
    public int[] searchRange(int[] nums, int target) {
       int[] ans = new int[2];
		ans[0] = findFirst(nums, target, 0, nums.length - 1);
		ans[1] = findLast(nums, target, 0, nums.length - 1);
		return ans;
	}

	private int findFirst(int[] nums, int target, int start, int end) {
		int position = -1;
		while (start <= end) {
			int mid = (start + end) / 2;
            
			if (nums[mid] >= target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
			if (nums[mid] == target){
                position = mid;
            }
		}
		return position;
	}

	private int findLast(int[] nums, int target, int start, int end) {
		int position = -1;
		while (start <= end) {
			int mid = (start + end) / 2;
            
			if (nums[mid] <= target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
			if (nums[mid] == target){
                position = mid;
            }
		}
		return position;
	}
}