class Solution {
    public int minFlips(String target) {
        int pair = 0;
        for(int i = 0;i<target.length();i++){
            if(pair%2 == 0){
                if(target.charAt(i) == '1')
                    pair++; }
            else{
                if(target.charAt(i) == '0')
                    pair++;
            }
        }
        return pair;
    }
}
