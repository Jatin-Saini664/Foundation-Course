// #include<iostream>

// using namespace std;

// void main(){
//     int n;
//     char s[5000];
//     cin>>n;
//     for(int i=0;i<n;i++){
//         cin>>s[i];
//     }
//     int count=0,max=0;
//     for(int i=0;i+2<n;i++){
//         count=0;
//         if(s[i]==s[i+1]&&s[i]!=s[i+2]){
//             count=palin(s,i,i+1);
//         }
//         else if(s[i]==s[i+2]){
//             count=palin(s,i,i+2);
//         }
//         if(count>max)
//             max=count;
//     }
//     for(int j=pos1;j<=pos2;j++)
// }
#include<iostream>

using namespace std;

int main(){
    int n;
    int maxa=0,maxb=0;
    int c=0;
    cin>>n;
    //int arr1[n],arr2[n];
    int a[n];
    int b[n];
    for(int i=0;i<n;i++){
        cin>>a[i];
        maxa+=a[i];
    }
    for(int i=0;i<n;i++){
        cin>>b[i];
        maxb+=b[i];
        if(a[i]==b[i]&&a[i]==1)
            c++;
    }
    if(maxa-c==0)
        cout<<-1;
    else{
        maxa-=c;
        maxb-=c;
        int j=1;
        while(j<=n){
            if(maxa*j>maxb)
                break;
            j++;
        }
        cout<<j;
    }
    return 0;
}