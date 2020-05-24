import java.util.*;
      
      public class pattern12{
      
      public static void main(String[] args) {
          Scanner scn = new Scanner(System.in);
          int n;
          n=scn.nextInt();
          int fpos=1,bpos=n;
          for(int i=1;i<=n;i++){
              for(int j=1;j<=n;j++){
                  if(i==1||i>(n/2)+1&&(j>=fpos&&j<=bpos)){
                      System.out.print('*');
                      System.out.print('\t');
                  }
                  else if(i!=1&&i<=(n/2)+1&&(j==fpos||j==bpos)){
                      System.out.print('*');
                      System.out.print('\t');
                  }
                  else
                    System.out.print('\t');
              }
              if(i<(n/2)+1){
                fpos++;
                bpos--;
              }
              else{
                  fpos--;
                  bpos++;
              }
              System.out.println();
          }
       }
      }