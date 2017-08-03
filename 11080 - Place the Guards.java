import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static ArrayList<Integer>[] adj;
	static int[] color;
	static boolean isBiColorable;
	static int[] num_of_color;
	static void biColor(int cur)
	{
		if(!isBiColorable)
			return;		
		num_of_color[2-color[cur]]++;
		for(int i:adj[cur])
		{
			if(color[i]==color[cur])
				isBiColorable = false;
			if(color[i]==0)
			{
				color[i] = 3-color[cur];
				biColor(i);
			}
		}
	}
	static int solve()
	{
		color = new int[n];
		isBiColorable = true;
		int ans = 0;
		for(int i =0;i<n;i++)
			if(color[i]==0)
			{
				num_of_color = new int[2];
				color[i] = 1;
				biColor(i);
				if(num_of_color[0] + num_of_color[1]>1)
					ans += Math.min(num_of_color[0], num_of_color[1]);
				else
					ans++;
			}
		return ans;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0)
		{
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			adj = new ArrayList[n];
			for (int i = 0; i < adj.length; i++) 
				adj[i] = new ArrayList<Integer>();
			
			while(m-->0)
			{
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adj[a].add(b);
				adj[b].add(a);
			}
			int ans = solve();
			if(!isBiColorable)
				sb.append(-1+"\n");
			else
				sb.append(ans+"\n");
		}
		System.out.print(sb);
	}
}
