import java.util.*;

public class hashMap<K,V> {
    private class HMnode{
        K key;
        V val;
        HMnode(K key,V val){
            this.key=key;this.val=val;
        }
    }
    private int size;
    private LinkedList<HMnode>[] buckets;

    hashMap(){
        this.size=0;
        buckets = new LinkedList[4];
        for(int i=0;i<4;i++){
            buckets[i]=new LinkedList<>();
        }
    }

    private int hashFunctions(K key){
        int hc = key.hashCode();
        if(hc<0)
            hc=-hc;
        int bi = hc%buckets.length;
        return bi;
    }

    private int findInBucket(int bi,K key){
        int ki=0;
        for(HMnode node: buckets[bi]){
            if(node.key==key){
                return ki;
            }
            ki++;
        } 
        return -1;
    }

    private void rehash(){
        LinkedList<HMnode>[] oldBucket = buckets;
        buckets = new LinkedList[2*oldBucket.length];
        for(int b=0;b<buckets.length;b++){
            buckets[b] = new LinkedList<>();
        } 
        for(int b=0;b<oldBucket.length;b++){
            for(HMnode node : oldBucket[b]){
                put(node.key,node.val);
            }
        }
    }

    public void put(K key,V val){
        int bi = hashFunctions(key);
        int ki = findInBucket(bi, key);
        if(ki==-1){
            HMnode node = new HMnode(key, val);
            buckets[bi].addLast(node);
            size++;
        }else{
            buckets[bi].get(ki).val = val;
        }
        if(2.0<((this.size*1.0)/buckets.length)){
            rehash();
        }
    }

    public boolean containsKey(K key){
        int bi = hashFunctions(key);
        int ki = findInBucket(bi, key);
        if(ki==-1)
            return false;
        else
            return true;
    }

    public V get(K key){
        int bi = hashFunctions(key);
        int ki = findInBucket(bi, key);
        if(ki==-1)
            return null;
        else
            return buckets[bi].get(ki).val;
    }

    public V remove(K key){
        int bi = hashFunctions(key);
        int ki = findInBucket(bi, key);
        if(ki==-1)
            return null;
        else{
            HMnode node = buckets[bi].remove(ki);
            size--;
            return node.val;
        }
    }

    public Set<K> keySet(){
        Set<K> mp = new HashSet<>();
        for(int b=0;b<buckets.length;b++){
            for(HMnode node: buckets[b]){
                mp.add(node.key);
            }
        } 
        return mp;
    }

    public int size(){
        return this.size;
    }
}