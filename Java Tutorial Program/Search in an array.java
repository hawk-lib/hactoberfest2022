import java.util.Scanner;
public class SearchTheNo {
    public static void main(String[] args) {

            Scanner S1 = new Scanner(System.in);
            int size = S1.nextInt();
            int number[] = new int[size];
            for(int i =0; i<size; i++){
                number[i] = S1.nextInt();
            }
            int x = S1.nextInt();

            for(int i = 0; i<number.length; i++){
                if (number[i]==x){
                    System.out.println("Number foundddd at : "+ i);

                }
            }

    }
}
