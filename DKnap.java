import java.util.*;
public class DKnap
{
    public static int sack(List<Integer> w,List<Integer> v,int c)
    {
        int r=w.size(),s[][]=new int[r+1][c+1];
        for(int i=1;i<=r;i++)
        {
            for(int j=1;j<=c;j++)
            {
                if(w.get(i-1) <= j)
                s[i][j]=Math.max((v.get(i-1)+s[i-1][j-w.get(i-1)]),s[i-1][j]);
                else
                s[i][j]=s[i-1][j];
            }
        }
        return s[r][c];
    }
	public static void main(String arg[])
	{
        InOut io=new InOut(arg[0],arg[1]);//Refer Appendix I
        List<Integer> v=new ArrayList<Integer>(2),w=new ArrayList<Integer>(2);
        while(io.in.hasNextInt())
        v.add(io.in.nextInt());
        int c=v.get(v.size()-1);
        v.remove(v.size()-1);
        w=v.subList(v.size()/2,v.size());
        v=v.subList(0,v.size()/2);
        io.out.println("Given Weights:"+Arrays.toString(w.toArray()));
        io.out.println("Given Values :"+Arrays.toString(v.toArray()));
		io.out.println("Capacity Of Knapsack:"+c+"\nMax Value:"+sack(w,v,c));
		io.in.close();io.out.close();
	}
}