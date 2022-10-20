#include <bits/stdc++.h>
using namespace std;
int main()
{ 

    //code by ayush
    int n;
    cout << "Enter the limit\n";
    cin >> n;
    string s ="******************************************************";
    for(int i=-n;i<=n;i++){
        int p=(i<0)?-i:i;
        int k =n-p+1;
        cout<<s.substr(0,k)<<endl;
    };

    //code by samar
    
    // for (int i = 0; i <= n; i++)
    // {
    // if(i<(n+1)/2)
    // {
    //         for (int j = 0; j <= i; j++)
    //         {
    //             cout << "*";
    //         }
    // }
    // else
    // for(int j=n-i;j>=1;j--){
    //         cout << "*";
    // }
    // cout<<endl;
    // }

    return 0;
}