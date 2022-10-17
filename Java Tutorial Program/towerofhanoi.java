class towerOfHanoi
{
static void towerOfHano(int n, char from_rod,char to_rod, char aux_rod)
{
    if (n == 0)
    {
        return;
    }
    towerOfHano(n - 1, from_rod, aux_rod, to_rod);
    System.out.println("Move disk "+ n + " from rod " + from_rod +" to rod " + to_rod );
    towerOfHano(n - 1, aux_rod, to_rod, from_rod);
}

public static void  main(String args[])
{
    int n = 3; // Number of disks
    towerOfHano(n, 'A', 'C', 'B');
}
}
