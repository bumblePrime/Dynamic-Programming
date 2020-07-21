import java.util.*;
public class DCoin
{
	public static int[][] coin(int d[],int a,int n)
	{
		int r=n+1,c=a+1,m[][]=new int[r][c];
		Arrays.fill(m[0],Integer.MAX_VALUE);
		for(int i=1;i<r;i++)
		{
			for(int j=1;j<c;j++)
			{
				int x=j-d[i];
				if(x<0)
				{
					m[i][j]=m[i-1][j];
					continue;
				}
				m[i][j]=Math.min(m[i-1][j],(1+m[i][x]));
			}
		}
		return m;
	}
	public static void main(String arg[])
	{
		InOut io=new InOut(arg[0],arg[1]);//Refer Appendix I
		int n=io.in.nextInt(),d[]=new int[n+1];
		io.out.print("Entered Denominations:");
		for(int i=1;i<n+1;i++)
		{
			d[i]=io.in.nextInt();
			io.out.print(d[i]+" ");
		}
		io.out.println();
		int a=io.in.nextInt();
		io.out.println("Entered Amount:"+a);
		Arrays.sort(d);
		int m[][]=coin(d,a,n);				
		for(int i=1;i<m.length;i++)
		{
			for(int j=1;j<m[0].length;j++)
				io.out.format("%2s ",m[i][j]);
			io.out.println();
		}		
		io.out.println("Number of Coins Required:"+m[m.length-1][m[0].length-1]);
		io.in.close();
		io.out.close();
	}
}