#include<iostream>
using namespace std;
// 5
// *****
//  ****
//   ***
//    **
//     *
int main(){
    int n;
    cin>>n;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=i-1;j++)
            cout<<" ";
        for(int j=1;j<=n-(i-1);j++)
            cout<<'*';
        cout<<endl;
    }
    return 0;
}