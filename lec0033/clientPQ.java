import java.util.*;

public class clientPQ{
    static class student implements Comparable<student>{
        int roll_no;
        String name;
        int marks;
        student(int r,String n,int m){
            this.roll_no = r;
            this.name=n;
            this.marks=m;
        }
        public int compareTo(student other) {
            return this.marks - other.marks;
        }
    }
    public static void main(String[] args) {
        // myPQ<student> pq = new myPQ<>();
        // pq.add(10);
        // pq.add(50);
        // pq.add(30);
        // pq.add(80);
        // pq.add(20);
        // pq.add(25);
        // pq.add(98);
        // pq.add(new student(1,"a",75));
        // pq.add(new student(2,"b",87));
        // pq.add(new student(3,"c",198));
        // pq.add(new student(4,"d",108));
        // pq.add(new student(5,"e",98));
        // pq.add(new student(6,"f",34));
        // pq.add(new student(7,"g",69));
        // pq.add(new student(8,"h",-3));
        // while(pq.size()>0){
        //     // System.out.println(pq.remove());
        //     student temp = pq.remove();
        //     System.out.println("Name ->"+temp.name+" , Roll No -> "+temp.roll_no+" , Marks = "+temp.marks);
        // }
        myPQ<Integer> pq = new myPQ<>();
        int k=3;
        int[] arr = {10,5,2,18,13,4,159,7,1,20};
        for(int i=0;i<arr.length;i++){
            if(i<3){
                pq.add(arr[i]);
            }else{
                if(pq.peek()<arr[i]){
                    pq.remove();
                    pq.add(arr[i]);
                }
            }
        }
        while(pq.size()>0){
            System.out.println(pq.remove());
        }
    }
}