#include<iostream>

using namespace std;

int main(){
    int p;
    cin>>p;
    while(p!=0){
        int n;
        cin>>n;
        int left[10],right[10];
        for(int i=0;i<10;i++){
            left[i]=0;
            right[i]=0;
        }
        int arr[n],c=0,b=0;
        for(int i=0;i<n;i++){
            cin>>arr[i];
            if(left[arr[i]]==0){
                left[arr[i]]=1;
                c+=1;
            }else{
                right[arr[i]]+=1;
                b+=1;
            }
        }
        int i=0;
        while(c>b+1&&i<10){
            if(b==0&&c>=2&&left[i]==1){
                c-=1;b+=1;
            }else if(left[i]==1&&right[i]>=1){
                c-=1;b+=1;
            }
            i++;
        }
        cout<<min(c,b)<<"\n";
        p--;
    }
}