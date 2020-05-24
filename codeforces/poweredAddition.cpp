#include<iostream>
#include<math.h>
#define ll long long int

using namespace std;

int main(){
    int p;
    cin>>p;
    while(p!=0){
        int n;
        cin>>n;
        ll arr[n+1];
        int c=-1,k=0,s=0;
        ll ans=0;
        for(int i=0;i<n;i++){
            cin>>arr[i];
            if(c==-1&&i>=1){
                if(arr[i]<arr[i-1]){
                    c+=1;
                    ans=arr[i-1]-arr[i];
                    k=0;int j=0;
                    while(j>=0){
                        if(pow(2,k)>=ans){
                            s=k;
                            break;
                        }
                        k+=1;j+=1;
                    }
                    //s+=1;
                    if(k==0)
                        s+=1;
                    arr[i]+=pow(2,k);
                }
            }else if(i>=1){
                if(arr[i]<arr[i-1]){
                    c+=1;
                    ans=arr[i-1]-arr[i];
                    k=s;int j=0;
                    while(j>=0){
                        if(pow(2,k)>=ans){
                            s=k;
                            break;
                        }
                        k+=1;j+=1;
                    }
                    //s+=1;
                    arr[i]+=pow(2,k);
                }
            }
        }
        for(int i=0;i<n;i++)
            cout<<arr[i]<<" ";
        cout<<"\n";
        cout<<s<<"\n";
        p--;
    }
}