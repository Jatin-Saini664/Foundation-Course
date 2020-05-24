#include<iostream>
#include<string.h>

using namespace std;

int main(){
    int p;
    cin>>p;
    while(p!=0){
        int n,a,b;
        cin>>n>>a>>b;
        char arr[max(a,1)];
        b-=1;
        char ch='b';
        for(int i=a-1;i>=0;i--){
            if(b!=0){
                arr[i]=ch;
                ch+=1;b-=1;
            }else
                arr[i]='a';
        }
        for(int i=0;i<n;i++){
            cout<<arr[b];
            b+=1;
            if(b==a)
                b=0;
        }
        cout<<"\n";
        p--;
    }
}