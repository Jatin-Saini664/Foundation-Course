#include<iostream>
using namespace std;
// 5
//   *
//  * *
// *   *
//  * *
//   *
int main(){
    int n;
    cin>>n;
    int fpos=n/2+1,bpos=n/2+1;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=n;j++){
            if(j==fpos||j==bpos)
                cout<<"*";
            else
                cout<<" ";
        }
        if(i<n/2+1){
            fpos--;
            bpos++;
        }else{
            fpos++;
            bpos--;
        }
        cout<<endl;
    }
    return 0;
}