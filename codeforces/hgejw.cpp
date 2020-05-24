#include<iostream>

using namespace std;

int main(){
    int p;
    cin>>p;
    while(p!=0){
        int n,k;
        cin>>n>>k;
        int arr[n+1];
        for(int i=0;i<n;i++){
            cin>>arr[i];
        }
        int l=0,l1=0;
        int c=0,max=0;
        for(int i=1;i<k&&k<=n;i++){
            if(i-1>=0&&i+1<n){
            if(arr[i]>arr[i-1]&&arr[i]>arr[i+1]){
                arr[i]=-1;
                c++;
            }
            }else if(i-1>=0&&i+1==n&&arr[i]>arr[i-1]){
                arr[i]=-1;
                c++;
            }
            if(arr[l-1]==-1)
                c--;
            if(c>max&&i==k-1){
                l1=l;
                max=c;
            }
            if(i==k-1){
                l++;
                k++;
            }
        }
        cout<<max+1<<" "<<l1+1<<"\n";
        p--;
    }
}