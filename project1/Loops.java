package project1;

public class Loops {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("loops in java");
		for(int i=0;i<=10;i++) {
			System.out.print(i+" ");
		}
		System.out.println();
		
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(j);
			}
			System.out.println();
		}
		
		int i=1;
		while(i<=5) {
			System.out.println(i);
			i++;
		}
		
		do {
			System.out.println(i);
			i++;
		}
		while(i<5);
		
		//break and continue
		for(i=0;i<10;i++) {
			if(i==5) {
				break;
			}
			System.out.println(i);
		}
		//here up to 4 tk hi print hua jaise hi 5 aaya break use pure loop se bahar leke aa gya
		
		for(i=0;i<10;i++) {
			if(i==5) {
				continue;
			}
			System.out.println(i);
		}
		
		//yaha jaise hi 5 aaya then neeche ke statements chhor ke again loop me le aaya jisse
		//sb print hus bs 5 ko chhor ke
		
		
		
		

	}

}
