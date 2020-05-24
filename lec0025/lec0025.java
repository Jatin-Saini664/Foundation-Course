import java.util.*;

// Generic Tree Lec 3
public class lec0025 {
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
    public static void lPrint(node root){
        Queue<node> qu = new LinkedList<>();
        qu.add(root);
        while(qu.size()>0){
            //remove
            node cn = qu.remove();
            //work
            System.out.println(cn.data+" ");
            //add child
            for(int i=0;i<cn.child.size();i++){
                qu.add(cn.child.get(i));
            }
        }
    }
    public static void lPrint1(node root){
        Queue<node> qu = new LinkedList<>();
        qu.add(root);
        int n=1;
        while(qu.size()>0){
            node cn = qu.remove();
            System.out.print(cn.data+" ");
            for(int i=0;i<cn.child.size();i++){
                qu.add(cn.child.get(i));
            }
            n--;
            if(n==0){
                System.out.println();
                n=qu.size();
            }
        } 
    }
    public static void lPrint2(node root){
        Queue<node> qu = new LinkedList<>();
        qu.add(root);
        qu.add(null);
        while(qu.size()>0){
            node cn= qu.remove();
            if(cn==null){
                System.out.println();
                if(qu.size()>0)
                    qu.add(null);
                continue;
            }
            System.out.print(cn.data+" ");
            for(int i=0;i<cn.child.size();i++){
                qu.add(cn.child.get(i));
            }
        }
    }
    public static void lPrint3(node root){
        Queue<node> qu = new LinkedList<>();
        qu.add(root);
        int n= root.data;
        int temp=root.child.get(root.child.size()-1).data;
        while(qu.size()>0){
            node cn = qu.remove();
            System.out.print(cn.data+" ");
            if(cn.data==n){
                System.out.println();
                if(cn.child.size()>0)
                    n=cn.child.get(cn.child.size()-1).data;
                else
                    n=temp;
            }
            for(int i=0;i<cn.child.size();i++){
                qu.add(cn.child.get(i));
            }
            if(cn.child.size()>0)
                temp = cn.child.get(cn.child.size()-1).data;
        }
    }
    public static void lPrint4(node root){
        Queue<node> p = new LinkedList<>();
        Queue<node> c = new LinkedList<>();
        p.add(root);
        while(p.size()>0){
            node cn= p.remove();
            System.out.print(cn.data+" ");
            for(int i=0;i<cn.child.size();i++){
                c.add(cn.child.get(i));
            }
            if(p.size()==0){
                System.out.println();
                while(c.size()>0){
                    p.add(c.remove());
                }
            }
        }
    }
    public static void LOTPrint(node root){
        Queue<node> qu = new LinkedList<>();
        ArrayList<node> st = new ArrayList<>();
        qu.add(root);
        boolean isReverse=false;
        while(qu.size()>0){
            node cn = qu.remove();
            System.out.print(cn.data+" ");
            if(isReverse){
                for(int i=cn.child.size()-1;i>=0;i--){
                    st.add(cn.child.get(i));
                }
            }else{
                for(int i=0;i<cn.child.size();i++){
                    st.add(cn.child.get(i));
                }
            }
            if(qu.size()==0){
                isReverse= !isReverse;
                System.out.println();
                while(st.size()>0){
                    qu.add(st.remove(st.size()-1));
                }
            }
        }
    }
    public static int heightOfTree(node root){
        if(root==null)
            return 0;
            int max=0;
        for(int i=0;i<root.child.size();i++){
            int c=height(root.child.get(i));
            if(c>max)
                max=c;
        }
        return max+1;
    }
    public static void main(String args[]){
        construct();
        // display(root);
        //lPrint(root);
        // lPrint1(root);
        // lPrint2(root);
        // LOTPrint(root);
        // lPrint3(root); // Work only for distinct data
        // lPrint4(root);
        System.out.println(heightOfTree(root));
    }
}