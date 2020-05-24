import java.util.*;

public class lec0026 {
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
        int[] data = {10,20,30,80,-1,-1,40,-1,-1,50,60,-1,70};
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
    public static boolean find(node root,int d){
        if(root==null)
            return false;
        if(root.data==d)
            return true;
        boolean c=false;
        if(root.left!=null)
            c=find(root.left,d);
        if(c)
            return c;
        if(root.right!=null)
            c=find(root.right,d);
        if(c)
            return c;
        else
            return false;
    }
    public static int height(node root){
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
    public static void preorder(node root){
        if(root==null)
            return;
        System.out.print(root.data+" ");
        if(root.left!=null)
            preorder(root.left);
        if(root.right!=null)
            preorder(root.right);
    }
    public static void inorder(node root){
        if(root==null)
            return;
        if(root.left!=null)
            inorder(root.left);
        System.out.print(root.data+" ");
        if(root.right!=null)
            inorder(root.right);
    }
    public static void postorder(node root){
        if(root==null)
            return;
        if(root.left!=null)
            postorder(root.left);
        if(root.right!=null)
            postorder(root.right);
        System.out.print(root.data+" ");
    }
    public static node preInConstruct(int[] pre,int[] in,int ps,int pe,int is,int ie){
        if(ps==pe){
            node baseNode = new node(pre[ps]);
            return baseNode;
        }
        if(ps>pe)
            return null;
        node croot = new node(pre[ps]);
        int i=is,count=0;
        while(pre[ps]!=in[i]){
            count++;
            i++;
        }
        croot.left=preInConstruct(pre, in, ps+1, ps+count, is, i-1);
        croot.right=preInConstruct(pre, in, ps+count+1, pe, i+1, ie);
        return croot;
    }
    public static node postInConstruct(int[] post,int[] in,int ps,int pe,int is,int ie){
        if(ps==pe){
            node baseNode = new node(post[ps]);
            return baseNode;
        }
        if(pe>ps){
            return null;
        }
        node croot = new node(post[ps]);
        int i=is,count=0;
        while(post[ps]!=in[i]){
            count++;
            i--;
        }
        croot.right = postInConstruct(post, in, ps-1, ps-count, i+1, ie);
        croot.left = postInConstruct(post, in, ps-count-1, pe, is, i-1);
        return croot;
    }
    public static node preConstruct(int[] post,int[] in,int ps,int pe){
        if(ps==pe){
            node baseNode = new node(post[ps]);
            return baseNode;
        }
        if(ps>pe){
            return null;
        }
        node pre = new node(post[ps]);
        int i=ps;
        int count=0;
        while(post[ps]!=in[i]){
            count++;
            i--;
        }
        pre.left= preConstruct(post, in, ps-count-1, pe);
        pre.right= preConstruct(post, in, ps-1, i);
        return pre;
    } 
    public static void main(String args[]){
        construct();
        // display(root);
        // System.out.println(Size(root));
        // System.out.println(Max(root));
        // System.out.println(find(root,50));
        // System.out.println(height(root));
        // preorder(root);
        // inorder(root);
        int[] pre={10,20,30,40,50,60,70,80};
        int[] in ={20,40,30,50,10,60,80,70};
        int[] post = {40,50,30,20,80,70,60,10};
        // postorder(root);
        // preInConstruct(pre, in,0,pre.length-1,0,in.length-1);
        // node piroot=postInConstruct(post, in, post.length-1, 0, 0, in.length-1);
        node preroot=preConstruct(post, in, post.length-1, 0);
        display(preroot);
    }
}