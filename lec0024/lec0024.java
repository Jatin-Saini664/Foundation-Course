import java.util.*;

//Generic Tree Lec 2
class lec0024{
    static class node{
        int data;
        ArrayList<node> child;
        node(int d){
            data=d;
            child=new ArrayList<>();
        } 
    }

    static node root = null;
    
    public static void construct(){
        int[] data = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,70,-1,120,-1,-1,90,-1,-1,40,100,70};
        ArrayList<node> cplist = new ArrayList<>();
        for(int i=0;i<data.length;i++){
            if(data[i]==-1&&cplist.get(cplist.size()-1)==null){
                continue;
            }
            if(data[i]==-1){
                cplist.remove(cplist.size()-1);
            }else{
                node nn = new node(data[i]);
                if(root == null){
                    root = nn;
                }else{
                    node cp = cplist.get(cplist.size()-1);
                    cp.child.add(nn);
                }
                cplist.add(nn);
            }
        }
    }
    public static void display(node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" --> ");
        for(int i=0;i<root.child.size();i++){
            System.out.print(root.child.get(i).data+",");
        }
        System.out.println();
        for(int i=0;i<root.child.size();i++){
            display(root.child.get(i));
        }
    }
    public static int Size(node root){
        if(root == null)
            return 0;
        int c=0;
        for(int i=0;i<root.child.size();i++){
            c+=Size(root.child.get(i));
        }
        return c+1;
    }
    public static int maxno(node root){
        if(root==null)
            return 0;
        int max=root.data,max1=0;
        for(int i=0;i<root.child.size();i++){
            max1=maxno(root.child.get(i));
            if(max1>max)
                max=max1;
        }
        return max;
    } 
    public static int path(node root,int data){
        if(root == null){
            return 0;
        }
        int c=0;
        if(data==root.data){
            System.out.print(root.data+" --> ");
            return 1;
        }
        for(int i=0;i<root.child.size();i++){
            c=path(root.child.get(i),data);
            if(c==1){
                System.out.print(root.child.get(i).data+",");
                return 1;
            }
        }
        return 0;
    }
    public static ArrayList path1(node root,int data){
        if(root == null){
            return null;//
        }
        if(data == root.data){
            ArrayList<Integer> myans= new ArrayList<>();
            myans.add(root.data);
            return myans;
        }
        for(int i=0;i<root.child.size();i++){
            ArrayList<Integer> recans = path1(root.child.get(i),data);
            if(recans!=null){
                recans.add(root.data);
                return recans;
            }
        }
        return null;
    }
    public static int LCA(node root,int data,int data1){
        if(root == null)
            return -1;
        ArrayList<Integer> ans1=path1(root,data);
        ArrayList<Integer> ans2=path1(root,data1);
        if(ans1==null&&ans2==null){
            return -1;
        }
        else if(ans1==null){
            return data1;
        }else if(ans2==null){
            return data;
        }
        int i=ans1.size()-1,j=ans2.size()-1;
        while(i>=0&&j>=0){
            if(ans1.get(i)!=ans2.get(j)){
                break;
            }
            i--;j--;
        }
        return ans1.get(i+1);
    }
    public static boolean dataPresent(node root,int data){
        if(root == null){
            return false;
        }
        if(root.data==data){
            return true;
        }
        for(int i=0;i<root.child.size();i++){
            boolean find = dataPresent(root.child.get(i),data);
            if(find) return true;
        }
        return false;
    }
    public static void main(String args[]){
        construct();
        // display(root);
        // System.out.println(Size(root));
        // System.out.println(maxno(root));
        // System.out.println(path(root,120));
        // System.out.println(path1(root,100));
        int lca = LCA(root,800,110);
        if(lca!=-1){
            System.out.println(lca);
        }else{
            System.out.println("lca is not present");
        }
        // System.out.println(dataPresent(root,50));
    }
}