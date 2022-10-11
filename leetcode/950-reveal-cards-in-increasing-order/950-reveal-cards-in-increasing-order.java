class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
		Arrays.sort(deck);
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = n-1; i>=1; i--){
            q.add(deck[i]);
            q.add(q.remove());
        }
        
        q.add(deck[0]);   // when the last card is remaining we just have to remove the card without replacing 
        
        for(int i = n-1; i>=0; i--){
            deck[i] = q.remove();
        }
        
        return deck;
    }
}