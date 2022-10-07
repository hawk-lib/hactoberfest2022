package File6_Recursion;

public class V17TowerOfHanoi {
    public static void main(String[] args) {
        int n = 3;
        toh(n, "Source", "Destination", "Helper");
    }

    public static void toh(int n, String src, String dest, String help){

        // Step 4
        // Base Condition: when n reaches to 0 by gradual decrement in its value, we have to return
        if(n==0){
            return;
        }
        
        // Step 1: we have to move n-1 disks to the helper using destination tower
        // Our helper will behave like destination and detination will work as helper
        toh(n-1,src,help,dest);
        
        // Step 2: move nth disc from source to destination
        System.out.println("Move " + n + "th disc from " + src + " to " + dest);

        // Step 3: Move n-1 disc from helper to destination using source as helper
        // Helper works as source
        // Source works as helper
        toh(n-1, help, dest, src);
    }
}
