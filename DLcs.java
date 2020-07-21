import java.util.*;
public class DLcs
{
    public String lcs(String s1,String s2)
    {
        int r=s1.length(),c=s2.length();
        int arr[][]=new int[r+1][c+1];
        for (int i=1;i<=r;i++) 
        { 
            for (int j=1;j<=c;j++) 
            { 
                if (s1.charAt(i-1) == s2.charAt(j-1)) 
                    arr[i][j]=arr[i-1][j-1] + 1; 
                else
                    arr[i][j]=Math.max(arr[i-1][j],arr[i][j-1]); 
            } 
        } 
        String s="";
        for(int i=r,j=c;i>0 && j>0;i--,j--)
        {
            if(s1.charAt(i-1)==s2.charAt(j-1))
            s=s1.charAt(i-1)+s;
            else if(arr[i-1][j]>arr[i][j-1])
            j++;
            else
            i++;
        }
        return s;
    }
	public static void main(String arg[])
	{
		InOut io=new InOut(arg[0],"");
		DLcs ob=new DLcs();
		String s1=io.in.next(),s2=io.in.next();
		System.out.println("LCS is "+ob.lcs(s1,s2));
		io.in.close();
	}
}