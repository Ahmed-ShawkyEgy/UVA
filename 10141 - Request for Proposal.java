import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int cases = 1;
		boolean first = true;
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if(n==0 && m==0)
				break;
			for (int i = 0; i < n; i++) {
				br.readLine();
			}
			Proposal [] arr = new Proposal[m];
			for (int i = 0; i < m; i++)
			{
				String s = br.readLine();
				st = new StringTokenizer(br.readLine());
				double p = Double.parseDouble(st.nextToken());
				int met = Integer.parseInt(st.nextToken());
				Proposal x = new Proposal(i, met, p, s);
				arr[i] = x;
				for (int j = 0; j < met; j++)
				{
					br.readLine();
				}
			}
			Arrays.sort(arr);
			if(!first)
				out.append("\n");
			first = false;
			out.append("RFP #"+cases++ +"\n");
			out.append(arr[0].name+"\n");
		}
		out.flush();
	}
	static class Proposal implements Comparable<Proposal>
	{
		int ind;
		int compliance;
		double price;
		String name;
		public Proposal(int i,int met,double p,String s)
		{
			ind = i;
			price = p;
			compliance = met;
			name = s;
		}
		@Override
		public int compareTo(Proposal o) {
			if(this.compliance!=o.compliance)
				return  o.compliance-this.compliance;
			if(this.price!=o.price)
				return (int) ( this.price-o.price);
			return this.ind - o.ind;
		}
		public String toString()
		{
			return name + " price: " +price + " comp: "+compliance+"\n"; 
		}
	}
}
