import java.util.*;

public class lec0028 {
    static class node {
        int data;
        node left;
        node right;
        node(int d){
            data=d;
            left=right=null;
        }
    }
    static node root = null;

    public static void construct(){
        // int[] data = {10,20,30,80,120,130,-1,-1,-1,-1,40,90,100,110,-1,-1,-1,-1,-1,50,60,-1,70};
        int[] data = {50,30,20,-1,40,37,-1,52,45,-1,-1,-1,-1,70,60,55,-1,-1,80,75,-1,90};
        ArrayList<node> cplist = new ArrayList<>();
        for(int i=0;i<data.length;i++){
            if(data[i]==-1&&cplist.get(cplist.size()-1)==null)
                continue;
            if(data[i]==-1)
                cplist.remove(cplist.size()-1);
            else{
                node nn = new node(data[i]);
                if(root==null)
                    root=nn;
                else{
                    node cp = cplist.get(cplist.size()-1);
                    if(cp.left==null)
                        cp.left=nn;
                    else
                        cp.right=nn;
                }
                cplist.add(nn);
            }
        }
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
        public static int Max(node root){
            if(root==null)
                return 0;
            int max=root.data;
            int ce=0;
            if(root.left!=null){
                ce=Max(root.left);
                if(ce>max)
                    max=ce;
            }
            if(root.right!=null){
                ce=Max(root.right); 
                if(ce>max)
                    max=ce;
            }
            return max;
        }
        public static int Min(node root){
            if(root==null)
                return Integer.MAX_VALUE;
            int min=root.data;
            int ce=0;
            if(root.left!=null){
                ce=Min(root.left);
                if(ce<min)
                    min=ce;
            }
            if(root.right!=null){
                ce=Min(root.right); 
                if(ce<min)
                    min=ce;
            }
            return min;
        }

    public static boolean bst(node root){
        if(root==null){
            return true;
        }else if(root.left==null&&root.right==null){
            return true;
        }
        boolean lans =bst(root.left); 
        if(lans==false){
            return false;
        }
        boolean rans =bst(root.right);
        if(rans==false){
            return false;
        } 
        int max=Max(root.left);
        int min=Min(root.right);
        boolean myans=root.data>=max&&root.data<=min;
        if(myans){
            return true;
        }
        return false;
    }

    // static class bstHelper {
    //     int min=Integer.MAX_VALUE;
    //     int max=Integer.MIN_VALUE;
    //     boolean isbst=true;
    // }

    static class bstHelper{
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        boolean isbst=true;
        int size=0;
        node maxroot= null;
    }
    public static bstHelper isTreeBST(node root) {
        if(root==null){
            return new bstHelper();
        }else if(root.left==null&&root.right==null){
            bstHelper baseAns = new bstHelper();
            baseAns.min=root.data;baseAns.max=root.data;
            return baseAns;
        }
        bstHelper lans = isTreeBST(root.left);
        bstHelper rans = isTreeBST(root.right);  
        bstHelper myans=new bstHelper();
        myans.isbst=lans.isbst&&rans.isbst&&lans.max<root.data&&root.data<rans.min;
        if(myans.isbst){
            if(root.left!=null)
                myans.min=lans.min;
            else
                myans.min=root.data;
            if(root.right!=null)
                myans.max=rans.max;
            else
                myans.max=root.data;
        }
        return myans;
    }
    public static bstHelper largeBST(node root){
        if(root==null){
            return new bstHelper();
        }
        else if(root.left==null&&root.right==null){
            bstHelper baseAns = new bstHelper();
            baseAns.min=root.data;baseAns.max=root.data;baseAns.size=1;baseAns.maxroot=root;
            return baseAns;
        }
        bstHelper lAns = largeBST(root.left);
        bstHelper rAns = largeBST(root.right);
        bstHelper myAns = new bstHelper();
        myAns.isbst=lAns.isbst&&rAns.isbst&&lAns.max<root.data&&root.data<rAns.min;
        if(myAns.isbst){
            if(root.left!=null){
                myAns.min=lAns.min;
            }else
                myAns.max=root.data;
            if(root.right!=null){
                myAns.max=rAns.max;
            }else
                myAns.max=root.data;
            myAns.maxroot=root;
            myAns.size=lAns.size+rAns.size+1;
        }else{
            if(lAns.size>rAns.size){
                myAns.size=lAns.size;
                myAns.maxroot=lAns.maxroot;
            }else{
                myAns.size=rAns.size;
                myAns.maxroot=rAns.maxroot;
            }
        }
        return myAns;
    }
    public static void main(String args[]){
        construct();
        display(root);
        // System.out.println(bst(root));
        bstHelper istbst=isTreeBST(root);
        System.out.println(istbst.isbst);
        // bstHelper bst = largeBST(root);
        // System.out.println(bst.maxroot.data);
        // System.out.println(bst.size);
    }
}