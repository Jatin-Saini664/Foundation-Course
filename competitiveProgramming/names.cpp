#include<iostream>
map<string, int> names;
map<string, int>::iterator pt;

int main()
{
    ifstream fil("names.txt");
    string tmp = "";
    int val=0;
    char in;
    DWORDLONG sum = 0;    
  
    fil>>in;
    while(!fil.eof())
    {
        if (in == '\"')
        {
            if (tmp.size() > 0) names[tmp]= val;
            tmp = "";
            val = 0;
         }
        else if (in >= 'A' && in <= 'Z')
        {
            tmp += in;
            val+=(int)in-64;
        }
        fil>>in;
    }
    
    pt = names.begin();
    for(int i=0; i<names.size();i++ ) 
    {
        sum += (pt->second * (i+1));
        pt++;
    }    
    cout<<"sum: "<<sum<<endl;
}