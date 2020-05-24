import java.util.*;
class grading{
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        System.out.println("Enter The Number");
        int a=scn.nextInt();
        if(a>90){
            System.out.println("Excellent");
        }else if(a<=90 && a>80){
            System.out.println("Very Good");
        }else if(a<=80 && a>70)
            System.out.println("Good");
        else if(a<=70 && a>60){
            System.out.println("Average");
        }else{
            System.out.println("poor");
        }
    }
}