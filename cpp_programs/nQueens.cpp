#include<iostream>

using namespace std;

bool place(int x[],int k,int i)
{
    for(int j=0;j<k;j++)
    {
        if(x[j]==i || abs(x[j]-i)==abs(k-j))
        {
            return false;
        }
    }
    return true;
}
unsigned long int nQueen(int x[],int k,int n,unsigned long int count)
{
    for(int i=0;i<n;i++)
    {
        if(place(x,k,i))
        {
            x[k]=i;
            if(k==n-1)
            {
                for(int j=0;j<n;j++)
                {
                    cout<<x[j]<<" ";
                }
                cout<<endl;
                count++;
            }
            else
            {
                count=nQueen(x,k+1,n,count);
            }
        }
    }
    return count;
}
int main()
{
    int n;
    cout<<"Enter number = ";
    cin>>n;
    int x[n];
    for(int i=0;i<n;i++)x[i]=0;
    unsigned long count=0;
    count=nQueen(x,0,n,count);
    cout<<"No. of results = "<<count<<endl;
}

