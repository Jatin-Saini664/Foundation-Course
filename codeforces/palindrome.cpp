#include<iostream>

using namespace std;

int main(){
    int p;
    cin>>p;
    while(p!=0){
        int n,k;
        cin>>n>>k;
        int arr[n+1];
        int c=0,j=0,s=0;
        for(int i=0;i<n;i++){
            cin>>arr[i];
            if(i==n/2)
                j=i-1;
            if(i>=n/2){
                if(arr[i]+arr[j]>c)
                    c=arr[i]+arr[j];
                j--;
            }
        }
        j=n-1;
        for(int i=0;i<n/2;i++){
            if(arr[i]+arr[j]!=c){
                if(arr[i]+k>=c||arr[j]+k>=c)
                    s+=1;
                else
                    s+=2;
            }
            j--;
        }
        cout<<s<<"\n";
        p--;
    }
}