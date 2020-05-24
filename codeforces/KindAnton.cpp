#include<iostream>
#define ll long long int

using namespace std;

int main(){
    int p;
    cin>>p;
    while(p!=0){
        int n;
        cin>>p;
        int arr1[n],arr2[n];
        for(int i=0;i<n;i++){
            cin>>arr1[i];
        }
        for(int i=0;i<n;i++){
            cin>>arr2[i];
        }
        ll c=0;
        char ch='Y';
        if(arr1[0]==arr2[0]){
            if(arr1[1]!=arr2[1])
                c=arr2[1]-arr2[0];
            for(int i=2;i<n;i++){
                if(c>arr2[i]&&c-arr2[i]!=arr1[i]){
                    cout<<"NO"<<"\n";
                    return 0;
                }else if(c<arr2[i]&&arr2[i]-c!=arr1[i]){
                    cout<<"NO"<<"\n";
                    return 0;
                }
            }
        }else {
            cout<<"NO"<<"\n";
            return 0;
        }
        cout<<"YES"<<"\n";
        p--;
    }
}