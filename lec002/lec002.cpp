#include<iostream>
#include<cmath>

using namespace std;

int main(){
    int n,c,p,l;
    cout<<"Enter The Number";
    cin>>n;
    c=n;
    l=trunc(log10(n))+1;
    cout<<"Enter the postion";
    cin>>p;
    while(trunc(log10(n))+1>p){
        n=n/10;
    }
    cout<<n%10;
    while(c!=0){
        if(c%10!=n%10)
            cout<<c%10;
        c/=10;
    }
    return 0;
}