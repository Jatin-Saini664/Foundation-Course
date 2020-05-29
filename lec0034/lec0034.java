import java.util.*;

public class lec0034 {
    public static void findMedian(int[] arr) {
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();
        double median = 0;
        for(int i=0;i<arr.length;i++){
            if(left.size()==right.size()){
                if(arr[i]<median){
                    left.add(arr[i]);
                    median = left.peek();
                }else if(arr[i]>median){
                    right.add(arr[i]);
                    median = right.peek();
                }
            }else if(left.size()>right.size()){
                if(arr[i]<median){
                    right.add(left.remove());
                    left.add(arr[i]);
                }else{
                    right.add(arr[i]);
                }
                median = (1.0*(left.peek()+right.peek()))/2;
            }else if(right.size()>left.size()){
                if(arr[i]>median){
                    left.add(right.remove());
                    right.add(arr[i]);
                }else{
                    left.add(arr[i]);
                }
                median = (1.0*(left.peek()+right.peek()))/2;
            }
            System.out.print(median+"   ");
        }
    } 
    public static void findMedian1(int[] arr) {
        int sum=0;
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }
        if(pq.size()%2==0){
            for(int i=0;i<=arr.length/2;i++){
                int s = pq.remove();
                if(i>=arr.length/2-1){
                    sum+=s;
                }
                pq.add(s);
            }
            System.out.println(sum/2);
        }else{
            for(int i=0;i<=arr.length/2;i++){
                int s=pq.remove();
                if(i==arr.length/2)
                    System.out.println(s);
                pq.add(s);
            }
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] arr = {5,11,4,15,7,3,8,9,10};
        findMedian(arr);
        findMedian1(arr);
    }
}