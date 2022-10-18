#include <iostream>
using namespace std;
int main() {
    int n;
    cin >>n;
    int m;
    m = n/2;
    for(int i= 1;i<=n;i++){
        cout<<"*"<<"\t";
    }
    cout<<endl;
    for(int i = 1;i<=m;i++){
        for(int j= m;j>=i;j--){
            cout<<"*"<<"\t";
        }
        for(int k = 1;k<=2*i-1;k++){
            cout<<" "<<"\t";
        }
        for(int j= m;j>=i;j--){
            cout<<"*"<<"\t";
        }
        cout<<endl;
    }
    for(int i =1;i<=m-1;i++){
        for(int j =1;j<=i+1;j++){
            cout<<"*"<<"\t";
        }
        for(int j =1;j<=2*(m-i)-1;j++){
            cout<<" "<<"\t";
        }
        for(int j =1;j<=i+1;j++){
            cout<<"*"<<"\t";
        }
        cout<<endl;
    }
    for(int i= 1;i<=n;i++){
        cout<<"*"<<"\t";
    }
    return 0;
}
