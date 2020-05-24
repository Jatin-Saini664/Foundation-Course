#include<iostream>
using namespace std;
// 4
// 1                                               1
// 1       2                               2       1
// 1       2       3               3       2       1
// 1       2       3       4       3       2       1
int main(){
    int n,c,sp;
    cin>>n;
    sp=n*2-3;
    for(int i=1;i<=n;i++){
        c=1;
        for(int j=1;j<=i;j++){
            cout<<c<<'\t';
            c++;
        }
        if(i<n){
            for(int j=1;j<=sp;j++){
                cout<<'\t';
            }
        }
        for(int j=1;j<=i;j++){
            if(c==n+1){
                c-=2;
                j++;
            }
            else
                c--;
            cout<<c<<'\t';
        }
        cout<<endl;
        sp=sp-2;
    }
    return 0;
}