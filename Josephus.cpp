#include <bits/stdc++.h> 
#include <ext/pb_ds/assoc_container.hpp>
#include <ext/pb_ds/tree_policy.hpp>
#define vi vector <int>
#define vll vector <long long>
#define pi pair <int,int>
typedef long long ll;
using namespace __gnu_pbds;
using namespace std;
template <typename T> 
using ordered_set = tree<T,null_type,less<T>,rb_tree_tag,tree_order_statistics_node_update>;
int gcd(int a, int b)
{
    if (a == 0)
    return b;
    return gcd(b % a, a);
}
ll ncr(int n, int r)
{
    if (n < r) return 0;
    long long p = 1, k = 1;
    if (n - r < r)
        r = n - r;
    if (r != 0) {
        while (r) {
            p *= n;
            k *= r;
            long long m = __gcd(p, k);
            p /= m;
            k /= m;
            n--;
            r--;
        }
    }
    else
        p = 1;
    return p;
}
template <typename T>
vector <T> vcreate(int n){
    vector <T> v(n);
    for (int i = 0; i < n; i++)
    {
        cin>>v[i];
    }
    return v;
}
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int n,k; cin>>n>>k;
    ordered_set <int> s;
    for (int i = 0; i < n; i++)
    {
        s.insert(i+1);
    }
    
    int ind=k%n;
    while(n--){
        auto itr=s.find_by_order(ind);
        cout<<*itr<<" ";
        s.erase(itr);
        if(n) ind=(ind%n+k)%n;
    }
    
    return 0;
    }