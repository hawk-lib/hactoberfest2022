class Solution {
    public List<Integer> partitionLabels(String S) {
        Map<Character, Integer> map = new HashMap<>();
        // Store the last index of every character
        for(int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            map.put(ch, i);
        }
        int max = 0;
        List<Integer> result = new ArrayList<>();
        int start = 0;
        for(int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            int index = map.get(ch);
            max = Math.max(index, max);
            // we evaluate the maximum possible index of the current         substring
            if(max == i) {
                int len = max - start + 1;
                result.add(len);
                start = i + 1;
            }
        }
        return result;
    }
}