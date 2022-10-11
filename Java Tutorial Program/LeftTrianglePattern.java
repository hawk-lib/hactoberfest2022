import java.io.*;


public class LeftTrianglePattern {
	
	public static void StarleftTriangle(int k)
	{
		int a, b;

		
		for (a = 0; a < k; a++) {

			for (b = 2 * (k - a); b >= 0; b--) {
				
				System.out.print(" ");
			}

			for (b = 0; b <= a; b++) {
				
				System.out.print("* ");
			}
			System.out.println();
		}
    }
	public static void main(String args[])
	{
		int k = 5;
		StarleftTriangle(k);
	}
}

