#include<iostream>
using namespace std;
// 5
//                 1
//         2       3       2
// 3       4       5       4       3
//         2       3       2
//                 1
int main(){
    int n;
    cin>>n;
    int val=1,c=0;
    int fpos=n/2+1,bpos=(n/2)+1;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=bpos;j++){
            if(j>=fpos&&j<=bpos){
                cout<<val<<"\t";
                if(j<=(n/2)+1&&(i==1||i==n))
                    val++;
                else if(j<(n/2)+1)
                    val++;
                else
                    val--;
            }
            else
                cout<<"\t";
            if(val>c&&i<=(n/2)+1)
                c=val;
            else if(val<c&&i>(n/2)+1)
                c=val;
        }
        if(i<n/2+1){
            fpos--;
            bpos++;
        }else{
            fpos++;
            bpos--;
        }
        val=c;
        if(i==(n/2)+1)
            val=i-1;
        cout<<endl;
    }
    return 0;
}