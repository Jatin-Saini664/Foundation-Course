import java.util.*;

class homeworkQuestion{
    static Scanner scn = new Scanner(System.in);
    public static void input(int[] arr){
        for(int i=0;i<arr.length;i++){
            arr[i]=scn.nextInt();
        }
    }
    public static int findData(int[] arr, int item){
        int size=arr.length-1;
        int a = 0;
        int mid=0;
        while(a<=size){
            mid=a+(size-a)/2;
            if(arr[mid]==item){
                return mid+1;
            }
            if(arr[mid]<item)
                a=mid+1;
            else
                size=mid-1;
        }
        return -1;
    }
    public static int firstIndex(int[] arr, int item){
        int size= arr.length-1;
        int a=0;
        int mid=0;
        while(size>=a){
            mid=a+(size-a)/2;
            if(arr[mid]==item)
                break;
            else if(arr[mid]<item)
                a=mid+1;
            else
                size=mid-1;
        }
        a=0;
        size=mid;
        while(size>=a){
            mid=a+(size-a)/2;
            if(mid==a&&mid==size){
                mid=a;
                break;
            }
            if(arr[mid]<item)
                a=mid+1;
            if(arr[mid]==item){
                if(arr[mid]==arr[mid-1])
                    size=mid-1;
                else
                    size=mid;
            }
        } 
        if(mid!=2)
            mid+=1;
        return mid;
    }
    public static int lastIndex(int[] arr, int item){
        int size=arr.length-1;
        int a=0;
        int mid=0;
        while(size>=a){
            mid=a+(size-a)/2;
            if(arr[mid]==item)
                break;
            else if(arr[mid]<item)
                a=mid+1;
            else
                size=mid-1;
        }
        a=mid;
        size=arr.length-1;
        mid=0;
        while(size>=a){
            mid=a+(size-a)/2;
            if(size-a==1&&arr[size]!=arr[a])
                size-=1;
            else if(size-a==1&&arr[size]==arr[a])
                a+=1;
            if(mid==a&&mid==size){
                mid=a;
                break;
            }
            if(arr[mid]>item)
                size=mid-1;
            else if(arr[mid]==item){
                if(arr[mid]==arr[mid+1])
                    a=mid+1;
                else
                    a=mid;
            }
        }
        return mid+1;
    }
    public static void firstLastIndex(int[] arr,int item){
        int first = 0;
        int last = arr.length-1;
        int mid=0;
        int g=arr.length;
        int g1=-1;
        while(last>=first){
            mid=(first+last)/2;
            if(arr[mid]==item){
                if(g>mid){
                    g=mid;
                }
                last=mid-1;
            }
            else if(arr[mid]>item)
                last=mid-1;
            else if(arr[mid]<item)
                first = mid+1;
        }
        last=arr.length-1;
        first=0;
        mid=0;
        while(last>=first){
            mid=(first+last)/2;
            if(arr[mid]==item){
                if(g1<mid){
                    g1=mid;
                }
                first=mid+1;
            }
            else if(arr[mid]>item)
                last=mid-1;
            else
                first=mid+1;
        }
        System.out.println(g);
        System.out.println(g1);
    }
    public static void smallerLargestElement(int[] arr, int item){
        // int size=arr.length-1;
        // int a=0;
        // int mid=0;
        // boolean t= false;
        // int mid1=0;
        // int g=0;
        // while(size>=a){
        //     t=false;
        //     mid=a+(size-a)/2;
        //     if(arr[mid]==item){
        //         t=true;
        //         break;
        //     }
        //     if(arr[mid]>item)
        //         size=mid-1;
        //     else 
        //         a=mid+1;
        // }
        // if(t)
        //     System.out.println("the smallest and the largest no is: " + arr[mid]);
        // else{
            // a=0;
            // size=arr.length-1;
            // mid=0;
            // g=0;
            // while(size>=a){
            //     mid=a+(size-a)/2;
            //     if(arr[mid]>item)
            //         size=mid-1;
            //     else{
            //         if(mid!=g){
            //             g=mid;
            //             a=mid+1;
            //             continue;
            //         }
            //         else
            //             break;
            //     }
            // }
            // size = arr.length-1;
            // a=0;
            // mid1=0;
            // g=0;
            // while(size>=a){
            //     mid1=a+(size-a)/2;
            //     if(arr[mid1]<item)
            //         a=mid1+1;
            //     else{
            //         if(mid1!=g){
            //             g=mid1;
            //             size=mid1-1;
            //             continue;
            //         }
            //         else
            //             break;
            //     }
            // }
            // System.out.println("smaller Largest no: "+ arr[mid]+" larger smallest no:"+arr[g]);
            // int first = 0;
            // int last = arr.length-1;
            // mid=0;
            // mid1=0;
            // g=0;
            // int g1=0;
            // while(last>=first){
            //     mid=(first+last)/2;
            //     mid1=(first+last)/2;
            //     if(arr[mid1]>item){
            //         if(g1!=mid1){
            //             g1=mid1;
            //             last=mid1-1;
            //         }
            //         else
            //             last=mid1-1;
            //     }
            //     if(arr[mid]<item){
            //         if(g!=mid){
            //             g=mid;
            //             first=mid+1;
            //         }
            //         else
            //             first=mid+1;
            //     }
            // }
            // System.out.println(arr[g1]);
            // System.out.println(arr[g]);
        int lo=0;
        int hi=arr.length-1;
        int mid=0;
        while(hi>=lo){
            mid=(lo+hi)/2;
            if(arr[mid]>item)
                hi=mid-1;
            else if(arr[mid]<item)
                lo=mid+1;
            else{
                System.out.println(mid);
                break;
            }
        } 
        if(hi==-1)
            System.out.println("-1"+lo);
        else if(lo==arr.length)
            System.out.println(h1+" "+"-1");
        else 
            System.out.println(hi+" "+lo);
    }
    public static void maxSum(int[] arr){
        // int sum=0;
        // int a=0;
        // int size=(arr.length-1)/2;
        // int pos=0;
        // int pos1=0;
        // int sum1=100000;
        // int s=(arr.length-1)/2;
        // for(int i=0;i<arr.length/2+2;i++){
        //     pos=a;sum=0;
        //     while(s>a){
        //         if(size<0)
        //             size=arr.length-1;
        //         if(a==arr.length)
        //             a=0;
        //         if(a!=size)
        //             sum+=arr[a]+arr[size];
        //         else
        //             sum+=arr[a];
        //         a++;size--;
        //     }
        //     if(sum<sum1){
        //         sum1=sum;
        //         pos1=pos;
        //     }
        //     a=pos+1;
        //     s++;
        //     size=s;
        //     if(size>=arr.length)
        //         size=(arr.length-size);
        //     if(a==arr.length)
        //         break;
        // }
        // sum=0;
        // for(int i=0;i<arr.length;i++){
        //     sum+=arr[pos1]*i;
        //     pos1++;
        //     if(pos1==arr.length)
        //         pos1=0;
        // }
        int sum=0;
        int rot=0;
        for(int i=0;i<arr.length;i++){
            max=max+arr[i];
            rot=rot+(i*arr[i]);
        }
        int mymax=0;
        for(int i=1;i<arr.length;i++){
            rot=rot+(sum-arr.length*arr[i-1]);
            if(mymax<rot)
                mymax=rot;
        }
        System.out.println(mymax);
    }
    public static void main(String[] args){
        int size;
        size=scn.nextInt();
        int[] arr = new int[size];
        input(arr);
        //int item=scn.nextInt();
        //System.out.print(findData(arr,item));
        //System.out.println(firstIndex(arr,item));
        //System.out.println(lastIndex(arr,item));
        smallerLargestElement(arr,item);
        //maxSum(arr);
    }
}