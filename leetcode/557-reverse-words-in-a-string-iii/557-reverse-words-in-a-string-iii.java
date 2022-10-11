class Solution {
    public String reverseWords(String s) {
        String[] str = s.trim().split("\\s+");
        StringBuilder sb=new StringBuilder();
        StringBuilder first=new StringBuilder(str[0]);
        first.reverse();
        sb.append(first);
        for(int i=1;i<str.length;i++){
            StringBuilder sec=new StringBuilder(str[i]);
            sec.reverse();
            sb.append(" "+sec);
        }
        return sb.toString();
    }
}