import java.util.*;

public class lec0032 {
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
    static class helper implements Comparable<helper>{
        int vtx;
        String path;
        int cost;
        helper(int vt, String p, int ct){
            vtx=vt; path=p; cost=ct;
        }
        public int compareTo(helper other){
            return this.cost - other.cost;
        }
    }
    public static void dijikstra(ArrayList<ArrayList<edge>> graph,int s,int d){
        PriorityQueue<helper> pq= new PriorityQueue<>();
        boolean[] visited = new boolean[graph.size()];
        pq.add(new helper(s,""+s,0));
        while(pq.size()>0){
            helper cp = pq.remove();
            if(visited[cp.vtx]==true)
                continue;
            else{
                visited[cp.vtx]=true;
            }
            if(cp.vtx==d){
                System.out.println(cp.path+" @ "+cp.cost);
                break;
            }
            for(int e=0;e<graph.get(cp.vtx).size();e++){
                edge ce = graph.get(cp.vtx).get(e);
                if(visited[ce.nbr]==false){
                    pq.add(new helper(ce.nbr,cp.path+" -> "+ce.nbr,cp.cost+ce.wt));
                }
            }
        } 
    }
    static class primesHelper implements Comparable<primesHelper>{
        int vtx;
        int par;
        int wt;
        primesHelper(int vt,int p,int w){
            vtx=vt;par=p;wt=w;
        }
        public int compareTo(primesHelper other){
            return this.wt - other.wt;
        }
    }
    public static void primesMST(ArrayList<ArrayList<edge>> graph, int s){
        PriorityQueue<primesHelper> pq= new PriorityQueue<>();
        boolean[] visited = new boolean[graph.size()];
        ArrayList<ArrayList<edge>> mst = new ArrayList<>();
        for(int i=0;i<graph.size();i++){
            mst.add(new ArrayList<edge>());
        }
        pq.add(new primesHelper(s,-1,0));
        //visited[s]=true;
        while(pq.size()>0){
            primesHelper cp = pq.remove();
            if(visited[cp.vtx]==true){
                continue;
            }else
                visited[cp.vtx]=true;
            if(cp.par!=-1){
                addEdge(mst, cp.vtx, cp.par, cp.wt);
            }
            for(int e=0;e<graph.get(cp.vtx).size();e++){
                edge ce = graph.get(cp.vtx).get(e);
                if(visited[ce.nbr]==false){
                    pq.add(new primesHelper(ce.nbr, cp.vtx, ce.wt));
                }
            }
        }
        display(mst);
    } 
    public static boolean isCycle(ArrayList<ArrayList<edge>> graph,int s,boolean[] visited){
        visited[s]=true;
        int count=0;
        boolean c=false;
        for(int e=0;e<graph.get(s).size();e++){
            edge ce = graph.get(s).get(e);
            if(visited[ce.nbr]==false){
                c=isCycle(graph, ce.nbr, visited);
            }
            else
                count++;
            if(c)
                return true;
            if(count>=2)
                return true;
        }
        visited[s]=false;
        return false;
    }
    // public static int component(ArrayList<ArrayList<edge>> graph, int s,int d,int[] visited){
    // }
    public static void main(String[] args) {
        ArrayList<ArrayList<edge>> graph = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            graph.add(new ArrayList<edge>());
        }
        addEdge(graph, 0, 1, 10);
        addEdge(graph, 0, 3, 40);
        addEdge(graph, 1, 2, 10);
        addEdge(graph, 2, 3, 10);
        //addEdge(graph, 3, 4, 2);
        addEdge(graph, 4, 5, 3);
        addEdge(graph, 4, 6, 8);
        addEdge(graph, 5, 6, 3);
        // dijikstra(graph, 0, 6);
        //primesMST(graph, 0);
        //System.out.println(isCycle(graph, 0, new boolean[graph.size()]));
        int[] visit = new int[graph.size()];
        visit[0]=0;
        System.out.println(component(graph, 0, 6,-1,visit));
    }
}