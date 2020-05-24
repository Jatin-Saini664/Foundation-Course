#include<iostream>
#include<cstring>
#include<bits/stdc++.h>

using namespace std;

int main(){
    int num=1;
    int denr=7;
    map<int,int> mp;
    mp.clear();
    int max=0,mlen=0;
    for(int i=7;i<1000;i++){
        denr=i;
        string res;
        int rem = num%denr; 
        while((rem!=0)&&(mp.find(rem)==mp.end())){
            mp[rem]=res.length();
            rem*=10;
            int res_part = rem/denr;
            res+=to_string(res_part);
            res=rem%denr; 
        }
        if(rem!=0&&mlen<res.substr(mp[rem]).length()){
            max=rem;
            mlen=res.substr(mp[rem]).length();
        }
        mp.clear();
    }
    cout<<max<<endl;
}