#include<iostream>

using namespace std;

int main(){
    int n;
    bool isprime = true;
    cout<<"Enter The Number"<<endl;
    cin>>n;
    for(int i=2;i<=n;i++){
        isprime=true;
        for(int j=2;j*j<=i;j++){
            if(i%j==0){
                isprime=false;
                break;
            }
        }
        
        if(isprime)   //if(j*j>i){cout<<i<<endl}
            cout<<i<<endl;
    }
    return 0;
}