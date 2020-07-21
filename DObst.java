import java.util.*;
public class DObst
{
    public static int obst(List<Integer> key,List<Integer> freq)
    {
        int n=key.size(),c[][]=new int[n+1][n+1];
        for(int i=0;i<n;i++)
        c[i][i]=freq.get(i);
        for(int i=2;i<=n;i++)
        {
            for(int j=0;j<=n-i+1;j++)
            {
                int k=i+j-1;
                c[j][k]=Integer.MAX_VALUE;
                for(int l=j;l<=k;l++)
                {
                    int a=((l>j)?c[j][l-1]:0)+((l<k)?c[l+1][k]:0)+sum(freq,j,k);
                    if(a<c[j][k])
                    c[j][k]=a;
                }
            }
        }
        return c[0][n-1];
    }
    public static int sum(List<Integer> f,int x,int y)
    {
        int s=0;
        for(int i=x;i<=y && i<f.size();i++)
        s+=f.get(i);
        return s;
    }
	public static void main(String arg[])
	{
        InOut io=new InOut(arg[0],arg[1]);
        List<Integer> k=new ArrayList<Integer>(2),f=new ArrayList<Integer>(2);
        while(io.in.hasNextInt())
        k.add(io.in.nextInt());
        f=k.subList(k.size()/2,k.size());
        k=k.subList(0,k.size()/2);
        io.out.println("Given Keys:"+Arrays.toString(k.toArray()));
        io.out.println("Given Freq:"+Arrays.toString(f.toArray()));
		io.out.println("Cost Of OBST:"+obst(k,f));
		io.in.close();io.out.close();
	}
}