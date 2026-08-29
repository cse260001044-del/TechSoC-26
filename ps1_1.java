// sorry for using java
import java.util.*;
class ps1_1
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Rows: ");
        int a = sc.nextInt();
        System.out.print("Columns: "); 
        int b = sc.nextInt();
        System.out.print("Generations: ");
        int c = sc.nextInt();
        int k=0,m=0,n=0;
        System.out.println("Input Initial State:");
        char arr[][] = new char[a][b];
        char brr[][] = new char[a][b];
        for(int i=0;i<a;i++)
        {
            for(int j=0;j<b;j++)
           arr[i][j] = sc.next().charAt(0);
        }
        for(int i=0;i<a;i++)
        {
            for(int j=0;j<b;j++){
                  brr[i][j] = arr[i][j];
                  if(arr[i][j]=='#')
                  m++;
            }
        }
        System.out.println("Initial population: "+m);
        if(c==0)
        n=m;
        while(c!=0){
            n=0;
        for(int i=0;i<a;i++)
        {
            for(int j=0;j<b;j++)
                {
                    k=0;
                     if(i-1>=0&&j-1>=0&&arr[i-1][j-1]=='#') // top left
                    k++;
                     if(j-1>=0&&arr[i][j-1]=='#')           // left
                    k++;
                     if(j+1<b&&arr[i][j+1]=='#')            // right
                    k++;
                     if(i-1>=0&&j+1<b&&arr[i-1][j+1]=='#') // top right
                    k++;
                     if(j+1<b&&i+1<a&&arr[i+1][j+1]=='#')  // bottom right
                    k++;
                     if(i-1>=0&&arr[i-1][j]=='#')          // top
                    k++;
                     if(i+1<a&&arr[i+1][j]=='#')           // bottom
                    k++;
                     if(j-1>=0&&i+1<a&&arr[i+1][j-1]=='#') // bottom left
                    k++;
                    if(arr[i][j]=='#'&&(k<2 || k>3))
                    brr[i][j]='.';
                    if(arr[i][j]=='.'&&(k==3))
                    brr[i][j] ='#';
                    if(arr[i][j]=='#')
                    n++;
                }
        }
        if(n>m)
        m=n;
        for(int i=0;i<a;i++)
        {
            for(int j=0;j<b;j++)
                  arr[i][j] = brr[i][j];
        }
        c--;
        }
        System.out.println("Max Population: "+m);
        System.out.println("Final Population "+n);
        for(int i=0;i<a;i++)
        {
            for(int j=0;j<b;j++)
                System.out.print(arr[i][j]+" ");
                System.out.println();
        }
    }
}