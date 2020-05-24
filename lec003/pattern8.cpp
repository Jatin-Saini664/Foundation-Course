#include<iostream>
using namespace std;
// 5
// *   *
//  * *
//   *
//  * *
// *   *
int main(){
    int n;
    cin>>n;
    int fpos=1, bpos=n;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=n;j++){
            if(j==fpos||j==bpos)
                cout<<"*";
            else
                cout<<" ";
        }
        fpos++;
        bpos--;
        cout<<endl;
    }
    return 0;
}