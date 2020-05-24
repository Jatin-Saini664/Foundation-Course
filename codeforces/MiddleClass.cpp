#include<iostream>
#define ll long long int

using namespace std;

int[] sort(int[] left,int[] right){
    int i=0,j=0,k=0;
    int arr[left.size()+right.size()];
    while(i<left.size()&&j<right.size()){
        if(left[i]>right[j]){
            arr[k]=left[i];
            i++;k++;
        }else{
            arr[k]=right[j];
            j++;k++;
        }
    }
    while(i<left.size()){
        arr[k]=left[i];
        i++;k++;
    }
    while(j<right.size()){
        arr[k]=right[j];
        j++;k++;
    }
    return arr;
}
int[] merge(int[] arr,int lo,int hi){
    if(lo==hi){
        int ans[1];
        ans[0]=arr[lo];
        return ans;
    }
    int mid=(lo+hi)/2;
    int left[] = merge(arr,lo,mid);
    int right[] = merge(arr,mid+1,hi);
    int myans[left.size()+right.size()];
    myans=sort(left,right);
    return myans;
}
int main(){
    int p;
    cin>>p;
    while(p!=0){
        int n;int x;
        ll s=0;
        cin>>n>>x;
        int arr[n],c=0;
        for(int i=0;i<n;i++){
            cin>>arr[i];
            if(arr[i]>=x){
                c++;s+=(arr[i]-x);
                arr[i]=-1;
            }
        }
        int arr1[]=merge(arr,0,arr.size()-1);
        int i=0;
        while(s!=0&&i<n-c){
            if(arr1[i]<x&&x-arr1[i]<=s){
                c++;s-=(x-arr1[i]);
            }
            else if(x-arr1[i]>s){
                break;
            }   
            i++;
        }
        cout<<c<<"\n";
        p--;
    }
    return 0;
}