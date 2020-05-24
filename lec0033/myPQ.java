import java.util.*;

public class myPQ<T extends Comparable<T>> {
    ArrayList<T> list;
    myPQ(){
        list = new ArrayList<>();
    }
    private void swap(int i,int j) {
        T temp = list.get(i);
        list.set(i,list.get(j));
        list.set(j,temp);
    }
    private void upheapify(int ci) {
        int pi = (ci-1)/2;
        if(ci>=0&&isSwap(pi,ci)){
            swap(pi,ci);
            upheapify(pi);
        }
    }
    private void downheapify(int pi) {
        int lci = 2*pi+1;
        int rci = 2*pi+2;
        int si = pi;
        if(lci<list.size()&&isSwap(pi,lci)){
            si = lci; 
        }
        if(rci<list.size()&&isSwap(si,rci)){
            si=rci;
        }
        if(si!=pi){
            swap(pi,si);
            downheapify(si);
        }
    }
    public boolean isSwap(int i,int j) {
        T ith = list.get(i);
        T jth = list.get(j);
        if(ith.compareTo(jth)>0){
            return true;
        }else{
            return false;
        }
    }
    public void add(T val) {
        list.add(val);
        upheapify(list.size()-1);
    }
    public T remove() {
        swap(0,list.size()-1);
        T rval = list.remove(list.size()-1);
        downheapify(0);
        return rval;
    }
    public T peek() {
        return list.get(0);
    }
    public int size(){
        return list.size();
    }
} 