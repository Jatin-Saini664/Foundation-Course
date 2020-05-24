import java.nio.IntBuffer;
import java.util.*;

class lec0031 {
    static class edge {
        int src;
        int nbr;
        int wt;

        edge(int sc, int nb, int w) {
            src = sc;
            nbr = nb;
            wt = w;
        }
    }

    public static void addEdge(ArrayList<ArrayList<edge>> graph, int a, int b, int w) {
        graph.get(a).add(new edge(a, b, w));
        graph.get(b).add(new edge(b, a, w));
    }

    public static void display(ArrayList<ArrayList<edge>> graph) {
        for (int v = 0; v < graph.size(); v++) {
            System.out.print(v + " -> ");
            for (int e = 0; e < graph.get(v).size(); e++) {
                edge ce = graph.get(v).get(e);
                System.out.print("[ " + ce.nbr + " @ " + ce.wt + " ] , ");
            }
            System.out.println();
        }
    }

    public static boolean path(ArrayList<ArrayList<edge>> graph, int a, int end, boolean[] visited) {
        if (a == end)
            return true;
        visited[a] = true;
        boolean ans = false;
        for (int i = 0; i < graph.get(a).size(); i++) {
            edge ce = graph.get(a).get(i);
            if (visited[ce.nbr] == false) {
                ans = path(graph, ce.nbr, end, visited);
            }
            if (ans) {
                return true;
            }
        }
        visited[a] = false;
        return false;
    }

    public static void allPaths(ArrayList<ArrayList<edge>> graph, int a, int end, boolean[] visited, String path) {
        if (a == end) {
            System.out.println(path + a);
        }
        visited[a] = true;
        for (int i = 0; i < graph.get(a).size(); i++) {
            edge ce = graph.get(a).get(i);
            if (visited[ce.nbr] == false) {
                allPaths(graph, ce.nbr, end, visited, path + a + " -> ");
            }
        }
        visited[a] = false;
    }

    static class sPathHelper {
        ArrayList<String> ans = new ArrayList<>();
        int nn = 0;
    }

    public static sPathHelper sPath(ArrayList<ArrayList<edge>> graph, int a, int end, boolean[] visited) {
        if (a == end) {
            // ArrayList<String> ans= new ArrayList<>();
            sPathHelper bans = new sPathHelper();
            bans.ans.add(" --> " + a);
            bans.nn = 1;
            // ans.add(" --> "+a);
            return bans;
        }
        // ArrayList<String> myans=new ArrayList<>();
        sPathHelper myans = new sPathHelper();
        visited[a] = true;
        for (int i = 0; i < graph.get(a).size(); i++) {
            edge ce = graph.get(a).get(i);
            if (visited[ce.nbr] == false) {
                sPathHelper recans = sPath(graph, ce.nbr, end, visited);
                // if(myans.size()!=0&&recans.size()!=0&&myans.get(0).length()>5+recans.get(0).length()){
                // myans.remove(0);
                // myans.add(" --> "+a+recans.get(0));
                // }else if(recans.size()!=0)
                // myans.add(" --> "+a+recans.get(0));
                if (myans.nn != 0 && recans.nn != 0 && myans.nn > recans.nn + 1) {
                    myans.ans.remove(0);
                    myans.ans.add(" --> " + a + recans.ans.get(0));
                    myans.nn = recans.nn + 1;
                } else if (recans.nn != 0) {
                    myans.ans.add(" --> " + a + recans.ans.get(0));
                    myans.nn = recans.nn + 1;
                }
            }
        }
        visited[a] = false;
        return myans;
    }

    static String minPath = "";
    static String maxPath = "";
    static int minCost = Integer.MAX_VALUE;
    static int maxCost = Integer.MIN_VALUE;

    public static void longandShortPath(ArrayList<ArrayList<edge>> graph,int a,int end,boolean[] visited,String path,int cost){
        if(a==end){
            path=path+a;
            if(cost<minCost){
                minCost=cost;
                minPath=path;
            }
            if(cost>maxCost){
                maxCost=cost;
                maxPath=path;
            }
            return;
        }
        visited[a]=true;
        for(int i=0;i<graph.get(a).size();i++){
            edge ce = graph.get(a).get(i);
            if(visited[ce.nbr]==false)
                longandShortPath(graph,ce.nbr,end,visited,path+a+" --> ",cost+ce.wt);
        }
        visited[a]=false;
    }
    static int ceilCost=Integer.MAX_VALUE;
    static int floorCost=Integer.MIN_VALUE;
    static String ceilPath="";
    static String floorPath="";
    public static void ceilandFloorPath(ArrayList<ArrayList<edge>> graph,int a,int end,boolean[] visited,String path,int cost,int x){
        if(a==end){
            path=path+a;
            // ceil ---- qualified min
            if(cost>x&&cost<ceilCost){
                ceilCost=cost;
                ceilPath=path;
            }
            // floor ---- qualified max
            if(cost<x&&cost>floorCost){
                floorCost=cost;
                floorPath=path;
            }
            return;
        }
        visited[a]=true;
        for(int i=0;i<graph.get(a).size();i++){
            edge ce = graph.get(a).get(i);
            if(visited[ce.nbr]==false)
                ceilandFloorPath(graph,ce.nbr,end,visited,path+a+" --> ",cost+ce.wt,x);
        }
        visited[a]=false;
    }
    // public static int KLargestPath(ArrayList<ArrayList<edge>> graph,int a,int end,boolean[] visited,String path,int cost,int k,int x){
    //     if(a==end){
    //         path=path+a;
    //         if(cost<x&&cost>floorCost){
    //             floorCost=cost;
    //             floorPath=path;
    //             k--;
    //         }
    //         return k;
    //     }
    //     visited[a]=true;
    //     int  d=0;
    //     int min=k;
    //     for(int i=0;i<graph.get(a).size();i++){
    //         edge ce = graph.get(a).get(i);
    //         if(visited[ce.nbr]==false)
    //             d=KLargestPath(graph,ce.nbr,end,visited,path+a+" --> ",cost+ce.wt,k,x);
    //             if(d<k)
    //                 min=d;
    //     }
    //     visited[a]=false;
    //     return min;
    // }
    public static void KthLargestPath(ArrayList<ArrayList<edge>> graph, int k){
        int factor=Integer.MAX_VALUE;
        for(int i=0;i<k;i++){
            ceilCost=Integer.MIN_VALUE;
            ceilandFloorPath(graph, 0, 6, new boolean[graph.size()], "", 0, factor);
            factor=ceilCost;
        }
        System.out.println(ceilPath+" @ "+factor);
    }
    public static void main(String args[]) {
        ArrayList<ArrayList<edge>> graph = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            graph.add(new ArrayList<edge>());
        }
        addEdge(graph, 0, 1, 10);
        addEdge(graph, 0, 3, 40);
        addEdge(graph, 1, 2, 10);
        addEdge(graph, 2, 3, 10);
        addEdge(graph, 3, 4, 2);
        addEdge(graph, 4, 5, 3);
        addEdge(graph, 4, 6, 8);
        addEdge(graph, 5, 6, 3);
        // display(graph);
        // boolean[] visited = new boolean(graph.size());
        // System.out.println(path(graph, 0, 6,new boolean[graph.size()]));
        // allPaths(graph, 0, 6, new boolean[graph.size()], "");
        // sPathHelper ans = sPath(graph, 0, 6, new boolean[graph.size()]);
        // int max=Integer.MAX_VALUE;
        // String p="a";
        // for(int i=0;i<ans.size();i++){
        // if(ans.get(i).length()<max){
        // max=ans.get(i).length();
        // p=ans.get(i);
        // }
        // }
        // System.out.println(p);
        // System.out.println(ans.ans.get(0));
        // longandShortPath(graph, 0, 6, new boolean[graph.size()],"",0);
        // System.out.println(minPath+" @ "+minCost);
        // System.out.println(maxPath+" @ "+maxCost);
        // ceilandFloorPath(graph, 0, 6, new boolean[graph.size()], "", 0,48);
        // System.out.println(ceilPath+" @ "+ceilCost);
        // System.out.println(floorPath+" @ "+floorCost);
        // int k=3;
        // int factor=Integer.MAX_VALUE;
        // while(k!=0){
        //     floorCost=Integer.MIN_VALUE;
        //     k=KLargestPath(graph, 0, 6, new boolean[graph.size()], "", 0,k,factor);
        //     factor=floorCost;
        // }
        // System.out.println(floorPath+" @ "+factor);
        KthLargestPath(graph, 3);
    }
}