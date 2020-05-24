import java.util.*;

class lec0027{
    static class node {
        int data;
        node left;
        node right;
        node(int d){
            data=d;
            left=right=null;
        }
    }

    static class diaHelper{
        int height;
        int dia;
    }

    static class bHelper{
        boolean isbal=true;
        int ht=0;
    }

    static node root = null;

    public static void construct(){
        int[] data = {10,20,30,80,120,130,-1,-1,-1,-1,40,90,100,110,-1,-1,-1,-1,-1,50,60,-1,70};
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
    static int max=0;
    public static int diameter(node root){
        if(root==null){
            return 0;
        }
        int count=1;
        int lcount=0,rcount=0;
        if(root.left!=null){
            lcount=diameter(root.left);
        }
        if(root.right!=null){
            rcount=diameter(root.right);
        }
        count+=lcount+rcount;
        if(count>max){
            max=count;
        }
        return (lcount>rcount)?(lcount+1):(rcount+1);
    }
    // public static int diameter2(node root){
    //     if(root==null){
    //         return 0;
    //     }
    //     int ld=diameter2(root.left);
    //     int rd=diameter2(root.right);

    //     int lh=height(root.left);
    //     int rh=height(root.right);

    //     int mydia = Math.max(lh+rh+1,Mtah.max(ld,rd));
    //     return mydia;
    // } 
    public static diaHelper diameterDp(node root){
        if(root==null){
            diaHelper baseans = new diaHelper();
            return baseans;
        }else if(root.left==null&&root.right==null){
            diaHelper baseans = new diaHelper();
            baseans.height = 1;
            baseans.dia = 1;
            return baseans;
        }
        diaHelper lAns = diameterDp(root.left);
        diaHelper rAns = diameterDp(root.right);
        diaHelper myans = new diaHelper();
        myans.dia = Math.max(lAns.height+rAns.height+1,Math.max(lAns.dia,rAns.dia));
        myans.height = Math.max(lAns.height,rAns.height)+1;
        return myans; 
    }
    public static bHelper balanced(node root){
        if(root==null){
            bHelper baseans= new bHelper();
            return baseans;
        }
        bHelper lAns = balanced(root.left);
        bHelper rAns = balanced(root.right);
        bHelper myans= new bHelper();
        myans.isbal=lAns.isbal&&rAns.isbal&&lAns.ht-rAns.ht>=-1&&lAns.ht-rAns.ht<=1;
        myans.ht=Math.max(lAns.ht,rAns.ht)+1;
        return myans;
    }
    public static void main(String args[]){
        construct();
        // display(root);
        // diameter(root);
        // System.out.println(max);
        // diaHelper ans = diameterDp(root);
        // System.out.println(ans.dia);
        bHelper ans = balanced(root);
        System.out.println(ans.isbal);
    }
}