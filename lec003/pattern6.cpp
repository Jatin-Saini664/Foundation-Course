#include<iostream>
using namespace std;
// 6
// 1
// 1       1
// 1       2       1
// 1       3       3       1
// 1       4       6       4       1
// 1       5       10      10      5       1
int main(){
    // int n,a,b,c;
    // int d;
    // cin>>n;
    // cout<<'1'<<endl;
    // int powe=1;
    // int post1=11;
    // int post2=0;
    // for(int i=2;i<=n;i++){
    //     c=0,b=0;
    //     for(int j=1;j<=i;){
    //         a=post1%10;
    //         if(a<=0)
    //             a=1;
    //         post1=post1/10;
    //         c=a+b;
    //         cout<<c<<'\t';
    //         j++;
    //         if(j<i)
    //             b=a;
    //         else
    //             b=0;
    //         post2=post2+c*powe;
    //         powe*=10;
    //     }
    //     cout<<endl;
    //     post1=post2;
    //     powe=1;
    //     post2=0;
    // }
    int n;
    cin>>n;
    for(int cr=0;cr<n;cr++){
        int ncr=1;
        for(int cc=0;cc<=cr;cc++){
            cout<<ncr<<" ";
            int ncr1=(ncr*(cr-cc)/(cc+1));
            ncr=ncr1;
        }
        cout<<endl;
    }
    return 0;
}