import java.util.*;
      
      public class pattern13{
      
      public static void main(String[] args) {
          Scanner scn = new Scanner(System.in);
          int n;
          n=scn.nextInt();
          int fpos=1,bpos=n;
          int c=(n/2)+1;
          for(int i=1;i<=n;i++){
              for(int j=1;j<=n;j++){
                  if(i<=c){
                      if(i/2==0&&(j>=fpos&&j<=c||j==bpos)){
                          System.out.print('*');
                          System.out.print('\t');
                      }
                      else if(i/2!=0&&(j==c||j==bpos)&&i!=c){
                          System.out.print('*');
                          System.out.print('\t');
                      }
                      else if(i==c&&(j>=fpos&&j<=bpos)){
                          System.out.print('*');
                          System.out.print('\t');
                      }
                      else
                        System.out.print('\t');
                  }
                  else{
                      if(i<n&&(j==c||j==fpos)){
                          System.out.print('*');
                          System.out.print('\t');
                      }
                      else if(i==n&&(j>=c&&j<=bpos||j==fpos)){
                          System.out.print('*');
                          System.out.print('\t');
                      }
                      else
                        System.out.print('\t');
                  }
              }
              System.out.println();
          }
       }
      }