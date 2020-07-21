import java.util.*;
public class DWar
{
	public static int[][] Warshall(int g[][],int n)
	{
        int p[][]=g.clone();
        for(int k=0;k<n;k++)
        for(int i=0;i<n;i++)
        for(int j=0;j<n;j++)
        if ( p[i][k]!=Integer.MAX_VALUE && p[k][j]!=Integer.MAX_VALUE && p[i][k]+p[k][j]<p[i][j])
        p[i][j]=p[i][k]+p[k][j];
        return p;
        
	}
	public static void main(String arg[])
	{
        /*Scanner in=new Scanner(System.in);
        System.out.print("Enter Number of nodes:");
        int n=in.nextInt(),g[][]=new int[n][n];
        System.out.println("Enter Adjacency Matrix:");
        for(int i=0;i<n;i++)
        for(int j=0;j<n;j++)
        {
            int a=in.nextInt();
            if(i!=j)
            g[i][j]=(a!=0)?a:Integer.MAX_VALUE;
            else
            g[i][j]=0;
            
        }
        int p[][]=Warshall(g,n);
        System.out.println("All Pairs Shortest Path:");
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            System.out.print(p[i][j]+" ");
            System.out.println();
        }*/
		InOut io=new InOut(arg[0],arg[1]);
        int n=io.in.nextInt(),g[][]=new int[n][n];
        for(int i=0;i<n;i++)
        for(int j=0;j<n;j++)
        if(io.in.hasNextInt())
        g[i][j]=io.in.nextInt();
        else
        {
            g[i][j]=Integer.MAX_VALUE;
            io.in.next();
        }
        int p[][]=Warshall(g,n);
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            if(p[i][j]==Integer.MAX_VALUE)
            io.out.print("INF ");
            else
            io.out.format("%3s ",p[i][j]);
            io.out.println();
        }
		io.in.close();
		io.out.close();
	}
}