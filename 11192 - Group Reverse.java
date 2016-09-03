import java.util.*;
import java.io.*;
public class Main{
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);	
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int g = Integer.parseInt(st.nextToken());
			if(g==0)
				break;
			char[] arr = st.nextToken().toCharArray();
			g = arr.length/g;
			for (int i = 0; i < arr.length-g+1; i+=g) 
			{
				gen(i,i+g-1,arr);
			}
			for (int i = 0; i < arr.length; i++) {
				out.append(arr[i]);
			}
			out.append("\n");
		}		
		out.flush();
	}
	public static void gen(int a,int b,char[] arr)
	{
		while(a<b)
		{
			char temp = arr[b];
			arr[b] = arr[a];
			arr[a] = temp;
			a++;b--;
		}
	}
}
