import java.util.*;

public class Minimum_Ascii_Delete_Sum_For_Two_Strings {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		int[][] dp = new int[s1.length()][s2.length()];
		for(int[] len : dp) {
			Arrays.fill(len, -1);
		}
		System.out.println(dfs(s1, s2, 0, 0, dp));

	}

	 public static int dfs(String s1, String s2, int p1, int p2, int[][] memo) {
	        
	        if (p1 == s1.length()) {
	            int del = 0;
	            while (p2 != s2.length()) {
	                del += s2.charAt(p2++) + 0;
	            }
	            return del;
	        } else if (p2 == s2.length()) {
	            int del = 0;
	            while (p1 != s1.length()) {
	                del += s1.charAt(p1++) + 0;
	            }
	            return del;
	        }
	        
	        if (memo[p1][p2] != -1)
	            return memo[p1][p2];
	        
	        if (s1.charAt(p1) == s2.charAt(p2)) {
	            memo[p1][p2] = dfs(s1, s2, p1 + 1, p2 + 1, memo);
	        } else {
	            int a = s1.charAt(p1) + dfs(s1, s2, p1 + 1, p2, memo);
	            int b = s2.charAt(p2) + dfs(s1, s2, p1, p2 + 1, memo);
	            memo[p1][p2] = Math.min(a, b);
	        }
	        
	        return memo[p1][p2];
	    }
}
