#include<iostream>
using namespace std;
// 5
//   *
//  ***
// *****
//  ***
//   *
int main(){
    int n;
    cin>>n;
    int sp=(n/2);
    int st=1;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=sp;j++){
            cout<<' ';
        }
        for(int j=1;j<=st;j++)
            cout<<'*';
            cout<<endl;
        if(i<=n/2){
            sp-=1;
            st+=2;
        }else{
            sp+=1;
            st-=2;
        }
        }
    }