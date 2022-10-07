/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Input: nums = [3,2,4], target = 6
Output: [1,2]
Input: nums = [3,3], target = 6
Output: [0,1]
Constraints:
   2 <= nums.length <= 104
  -109 <= nums[i] <= 109
  -109 <= target <= 109
  Only one valid answer exists.
*/

import java.util.*;
Class PairSum{
    public static int[] twoSum(int[] arr, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for(int i = 0;i < arr.length;i++){
            if(map.containsKey(target - arr[i])){
                ans[0] = i;
                ans[1] = map.get(target - arr[i]);
                break;
            }
            map.put(arr[i],i);
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in):
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i < n;i++)arr[i] = sc.nextInt();
        int target = sc.nextInt();
        int[] ans = twoSum(arr,target);
        System.out.println(arr[0] + " " + arr[1]);
    } 
}
