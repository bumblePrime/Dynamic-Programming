import java.util.*;
public class DRod
{
	public int price(ArrayList<Integer> p,int l)
	{
		int v[]=new int[l+1];
		for(int i=1;i<=l;i++)
		{
			int max=-1;
			for(int j=0;j<i;j++)
				max=Math.max(max,p.get(j)+v[i-j-1]);
			v[i]=max;
		}
		return v[l];
	}
	public static void main(String arg[])
	{
		InOut io=new InOut(arg[0],"");
		DRod ob=new DRod();
		ArrayList<Integer> p=new ArrayList<Integer>(2);
		while(io.in.hasNext())
			p.add(io.in.nextInt());
		System.out.print("Enter Length Of Rod:");
		int l=(new Scanner(System.in)).nextInt();
		System.out.println("Maximum Price:"+ob.price(p,l));
		io.in.close();
	}
}