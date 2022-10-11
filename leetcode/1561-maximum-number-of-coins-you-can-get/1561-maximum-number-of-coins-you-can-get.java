class Solution {
    public int maxCoins(int[] p) {
         Arrays.sort(p);
         int i=p.length-2;
         int ans=0;
         for(int j=0;j<p.length/3;j++){
            ans+=p[i];
            i-=2;
            
         }
        return ans;
    }
}