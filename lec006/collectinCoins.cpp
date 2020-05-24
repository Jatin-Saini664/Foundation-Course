#include<iostream>
using namespace std;

int main(){
    int n,a,b,c,r1=0,r2=0,r3=0;
    int t;
    cin>>t;
    while(t--){
        r1=0,r2=0,r3=0;
        cin>>a>>b>>c>>n;
        r1=(a>b)?(a>c)?a:c:(b>c)?b:c;
        r2=(a<b)?(a<c)?a:c:(b<c)?b:c;
        r3=(a!=r1&&a!=r2)?a:(b!=r1&&b!=r2)?b:(c!=r1&&c!=r2)?c:c;
        n-=(r1-r2);
        n-=(r1-r3);
        if(n%3==0&&n>=0)
            cout<<"YES"<<endl;
        else
            cout<<"NO"<<endl;
    }
}