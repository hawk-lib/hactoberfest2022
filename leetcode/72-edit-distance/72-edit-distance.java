class Solution {
    public int minDistance(String word1, String word2) {
          char[] str1=word1.toCharArray();
          char[] str2=word2.toCharArray();
          int[][] dp=new int[str1.length+1][str2.length+1];
        for(int i=0;i<dp[0].length;i++){
            dp[0][i]=i;
        }
        for(int i=0;i<dp.length;i++){
            dp[i][0]=i;
        }
        for(int i=1;i<=str1.length;i++){
            for(int j=1;j<=str2.length;j++){
                if(str1[i-1]==str2[j-1]){
                    dp[i][j]=dp[i-1][j-1];
                }
                else{
                    
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                }
            }
        }
        return dp[str1.length][str2.length];
    }
}