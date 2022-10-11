class Solution {
    public int maximum69Number (int num) {
        Integer num1=num;
        String str=num1.toString();
        char[] ch=str.toCharArray();
        for(int i=0;i<ch.length;i++)
        {
            if(ch[i]=='6')
            {
                ch[i]='9';
                break;
            }
        }
        str=new String(ch);
        return Integer.parseInt(str);
    }
}