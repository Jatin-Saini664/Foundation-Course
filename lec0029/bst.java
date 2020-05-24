import java.util.*;

public class bst {
    static class node{
        int data;
        node left;
        node right;
        node(int d){
            data=d;
            left=right=null;
        }
    }

    public static node construct(int[] arr,int fst,int rgt){
        if(fst>rgt){
            return null;
        }else if(fst==rgt){
            node baseAns = new node(arr[fst]);
            return baseAns;
        }
        int mid=0;
        mid=(fst+rgt)/2;
        node root= new node(arr[mid]);
        root.left=construct(arr, fst, mid-1);
        root.right=construct(arr, mid+1, rgt);
        return root;
    }
    public static void display(node root){
        if(root==null)
            return;
        if(root.left!=null){
            System.out.print(root.left.data);
        }
        System.out.print(" <-- "+root.data+" --> ");
        if(root.right !=null){
            System.out.print(root.right.data);
        }
        System.out.println();
        if(root.left!=null){
            display(root.left);
        }
        if(root.right!=null){
            display(root.right);
        }
    }
    public static int Size(node root){
        if(root==null)
            return 0;
        int count=1;
        if(root.left!=null){
            count+=Size(root.left);
        }
        if(root.right!=null){
            count+=Size(root.right);
        }
        return count;
    }
    public static int height(node root) {
        if(root==null)
            return 0;
        int myHeight=0;
        if(root.left!=null)
            myHeight=height(root.left);
        if(root.right!=null){
            int rh = height(root.right);
            if(rh>myHeight)
                myHeight=rh;
        }
        return myHeight+1;
    }
    static class lcaHelper{
        boolean left;
        boolean right;
    }
    public static int lca(node root,int lft,int rgt){
        if(root==null){
            return Integer.MIN_VALUE;
        }
        if(lft<root.data&&rgt<root.data)
            return lca(root.left,lft,rgt);
        else if(lft>root.data&&rgt>root.data)
            return lca(root.right,lft,rgt);
        else
            return root.data;
    }
    static int sn=320;

    public static void BSTConvert(node root){
        if(root==null){
            return;
        }
        if(root.left!=null){
            BSTConvert(root.left);
        }
        root.data=sn-root.data;
        sn=root.data;
        if(root.right!=null){
            BSTConvert(root.right);
        }
        return;
    }
    public static void main(String args[]){
        int[] arr = {10,20,30,50,60,70,80};
        node root=construct(arr, 0, arr.length-1);
        // display(root);
        // System.out.println(Size(root));
        // System.out.println(height(root));
        BSTConvert(root);
        display(root);
    }
}