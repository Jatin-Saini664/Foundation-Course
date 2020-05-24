import java.util.*;
      
      public class pattern14{
      
      public static void main(String[] args) {
          Scanner scn = new Scanner(System.in);
          int n;
          n=scn.nextInt();
          int fpos=(n/2)+1,bpos=(n/2)+1;
          int c=(n/2)+1;
          for(int i=1;i<=n;i++){
              for(int j=1;j<=n;j++){
                  if(i<c){
                      if(j==1||j==n){
                        System.out.print('*');
                        System.out.print('\t');
                      }
                      else
                        System.out.print('\t');
                  }
                  else if(i>=c){
                    if(j==1||j==n||j==bpos||j==fpos){
                        System.out.print('*');
                        System.out.print('\t');
                      }
                    else
                        System.out.print('\t');  
                  }
              }
              if(i>=c){
                  fpos--;
                  bpos++;
              }
              System.out.println();
          }
       }
      }