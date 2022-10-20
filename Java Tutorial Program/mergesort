class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=m;i<m+n;i++){
            nums1[i]=nums2[i-m];
        }
    int gap=((m+n)/2)+((m+n)%2);
    while(gap!=0){
        for(int i=0;i<m+n-gap;i++){
            if(nums1[i]>nums1[i+gap]){
                int t=nums1[i];
                nums1[i]=nums1[i+gap];
                nums1[i+gap]=t;
            }
        }
        if(gap==1)break;
        gap=(gap/2)+(gap%2);
    }    
    }
}
