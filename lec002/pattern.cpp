#include<iostream>

using namespace std;

int main(){
    int start, n,x,y,i,temp;
    cout<<"Enter The Number\n";
    cin>>n;
    start = 2*n-1;
    i=1,x=n,y=1;
    int post=0,pow=1;
    int s=0,x1;
    while(start!=0){
        if(start==(2*n-1)){
            i=1;
        }else if(start==n-2){
            i=n-1;
        }
        if(y<n){
        pow=1,s=0,post=0,temp=0,x1=x;
        while(temp<i){
            cout<<x;
            post=pow*x+post;
            pow=pow*10;
            temp++;
        }
        while(temp<n){
            s=x--;
            cout<<s;
            post=pow*s+post;
            pow=pow*10;
            temp++;
        }
        i++,x=x1--;
        if(temp==n){
            cout<<"1";
        }
        cout<<post<<endl;
    }else if(y==n){
        s=1;
        while(s<=(2*n-1)){
            cout<<"1";
        }
        cout<<endl;
    }else{
        post=0,pow=1,s=0,temp=0;
        x=x1;
        while(temp<i){
            cout<<x;
            post=pow*x+post;
            pow=pow*10;
            temp++;
        }
        while(temp<n){
            s=x++;
            cout<<s;
            post=pow*s+post;
            pow=pow*10;
            temp++;
        }
        if(temp==n){
            cout<<"1";
        }
        i--,x=x1++;
        cout<<post<<endl;
    }
    y++;
    start--;
    }
}