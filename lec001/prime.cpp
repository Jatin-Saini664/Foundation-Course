#include<iostream>

using namespace std;

int main(){
    int n;
    bool isprime=true;
    cout<<"Enter The Number\n";
    cin>>n;
    // for(int i=2;i<n/2;i++){
    for(int i=2;i*i<=n;i++){// we need to check for i less than square root n
        if(n%i==0){
            cout<<"not prime";
            isprime=false;
            break;
        }
    }
    if(isprime){
        cout<<"prime";
    }
    return 0;
}