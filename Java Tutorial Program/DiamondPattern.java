import java.util.*;  
class DiamondPattern{
    public static void main(String[] args){
    int i,j,k;
    Scanner sc= new Scanner(System.in);
    System.out.print("Enter the number of row for diamond shape : ");  
    int no = sc.nextInt();  
    for(i=0;i<no;i++)
    {
	    for(j=0;j<no-i-1;j++){
                     System.out.print(" ");
	    }
	    for(k=0;k<2*i+1;k++){
		        System.out.print("*");
		}
		 System.out.println("");
	    }
	    
	 for(i=no-1;i>0;i--)
    {
	    for(j=no-1;j>=i;j--){
                     System.out.print(" ");
	    }
	   for(k=2*i-1;k>0;k--){
		        System.out.print("*");
		}
		 System.out.println("");
	    }
    } 
} 
