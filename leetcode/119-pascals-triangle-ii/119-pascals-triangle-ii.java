class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> l=new ArrayList<>();
        for(int i=0;i<=rowIndex;i++){
            l.add(1);
            for(int j=i-1;j>0;j--){
                l.set(j,l.get(j)+l.get(j-1));
            }
        }
        return l;
    }
}