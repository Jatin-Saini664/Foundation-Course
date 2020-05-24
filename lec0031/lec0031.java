import java.util.*;

public class lec0031 {
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
    // static int count=7;
    // static int source=0;
    // public static void hamilPath(ArrayList<ArrayList<edge>> graph,int s,boolean[] visited,String path,int c){
    //     if(c==count-1){
    //         path=path+s;
    //         if(graph.get(s).nbr==source){
    //             System.out.println(path+".");
    //         }else{
    //             System.out.println(path);
    //         }
    //         return;
    //     }
    //     visited[s]=true;
    //     for(int e=0;e<graph.get(s).size();e++){
    //         edge ce = graph.get(s).get(e);
    //         if(visited[ce.nbr]==false)
    //             hamilPath(graph, ce.nbr, visited,path+s+" --> ", c+1);
            
    //     }
    //     visited[s]=false;
    // }
    public static void hamiltonionPathCycle(ArrayList<ArrayList<edge>> graph,int s,boolean[] visited,ArrayList<Integer> path){
        if(path.size()==graph.size()-1){
            path.add(s);
            for(int i=0;i<path.size();i++){
                System.out.print(path.get(i)+" --> ");
            }
            int os=path.get(0);
            for(int e=0;e<graph.get(s).size();e++){
                if(graph.get(s).get(e).nbr==os){
                    System.out.print("*");
                }
            }
            System.out.println();
            path.remove(path.size()-1);
            return;
        }
        visited[s]=true;
        path.add(s);
        for(int e=0;e<graph.get(s).size();e++){
            edge ce = graph.get(s).get(e);
            if(visited[ce.nbr]==false)
                hamiltonionPathCycle(graph, ce.nbr, visited,path);
        }
        visited[s]=false;
        path.remove(path.size()-1);
    }
    static class bfsHelper{
        int vtx=0;
        String path="";
        int cost=0;
    } 
    public static void bfsPrint(ArrayList<ArrayList<edge>> graph,int s,boolean[] visited){
        Queue<bfsHelper> arr = new LinkedList<>();
        visited[s]=true;
        bfsHelper c= new bfsHelper();
        c.vtx=s;c.path+=s;c.cost=0;
        arr.add(c);
        while(arr.size()!=0){
            bfsHelper p = arr.remove();
            System.out.println(p.path+" @ "+p.cost);
            for(int e=0;e<graph.get(p.vtx).size();e++){
                edge ce = graph.get(p.vtx).get(e);
                if(visited[ce.nbr]==false){
                    bfsHelper ch = new bfsHelper();
                    ch.vtx=ce.nbr;ch.path=p.path+" --> "+ce.nbr;ch.cost=p.cost+ce.wt;
                    arr.add(ch);
                    visited[ce.nbr]=true;
                }
            }
        }
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<edge>> graph = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            graph.add(new ArrayList<edge>());
        }
        addEdge(graph, 0, 1, 10);
        addEdge(graph, 0, 3, 40);
        addEdge(graph, 1, 2, 10);
        addEdge(graph, 2, 3, 10);
        addEdge(graph, 2, 5, 9);
        addEdge(graph, 3, 4, 2);
        addEdge(graph, 4, 5, 3);
        addEdge(graph, 4, 6, 8);
        addEdge(graph, 5, 6, 3);
        // display(graph);
        // hamilPath(graph, 0, new boolean[graph.size()], "", 0);
        // hamiltonionPathCycle(graph, 0, new boolean[graph.size()], new ArrayList<Integer>());
        bfsPrint(graph, 0, new boolean[graph.size()]);
    }
}