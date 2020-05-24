import java.util.*;

// Generic Tree Lec 1
public class genericTree {
    static class node{
        int data;
        ArrayList<node> child;
        node(int d){
            data=d;
            child=new ArrayList<>();
        } 
    }

    static node root = null;
    
    public static void construct(int[] data){
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
    public static void findparent(node root,int data){
        if(root == null)
            return;
        for(int i=0;i<root.child.size();i++){
            if(root.child.get(i).data==data){
                System.out.print(root.data+" ");
            }
        }
        for(int i=0;i<root.child.size();i++){
            findparent(root.child.get(i),data);
        }
    }
    public static int maximum(node root){
        int max=root.child.get(0).data,pos=0;
        for(int i=1;i<root.child.size();i++){
            if(root.child.get(i).data >max){
                max=root.child.get(i).data;
                pos=i;
            }
        }
        return pos;
    }
    public static void Sort(node root,int lvl){
        if(root==null){
            return;
        }
        int pos=0;
        if(root.child.size()==0)
            return;
        else
            pos=maximum(root);
        if(root.data < root.child.get(pos).data){
            int temp=root.data;
            root.data=root.child.get(pos).data;
            root.child.get(pos).data=temp;
        }
        for(int i=0;lvl!=1&&i<root.child.size();i++){
            Sort(root.child.get(i),0);
        }
        if(lvl==0)  
            Sort(root,1);
    } 
    public static void main(String[] args){
        int[] data = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,70,-1,120,-1,-1,90,-1,-1,40,100,70};
        construct(data);
        Sort(root,0);
        display(root);
        // findparent(root,70);
    }
}