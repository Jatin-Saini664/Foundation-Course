#include<iostream>
using namespace std;
// 5
// 0
// 1       1
// 2       3       5
// 8       13      21      34
// 55      89      144     233     377
int main(){
    int n,a=0,b=1,c=0;
    cin>>n;
    // cout<<'0'<<endl;
    // cout<<'1'<<'\t'<<'1'<<endl;
    // a=1;
    // for(int i=3;i<=n;i++){
    //     for(int j=1;j<=i;j++){
    //         c=a+b;
    //         cout<<c<<'\t';
    //         a=b;
    //         b=c;
    //     }
    //     cout<<endl;
    // }
    for(int cr=0;cr<n;cr++){
        for(int cc=0;cc<=cr;cc++){
            cout<<a<<' ';
            c=a+b;
            a=b;
            b=c;
        }
        cout<<endl;
    }
    return 0;
}