class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int evenSum=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
                evenSum+=nums[i];
            }
        }
        int[] res=new int[nums.length];
        int k=0;
        for(int i=0;i<queries.length;i++){
            int temp=nums[queries[i][1]];
            if(temp%2==0){
                evenSum-=temp;
            }
            nums[queries[i][1]]+=queries[i][0];
            temp=nums[queries[i][1]];
            if(temp%2==0){
                evenSum+=temp;
            }
            res[k++]=evenSum;
        }
        return res;
    }
}