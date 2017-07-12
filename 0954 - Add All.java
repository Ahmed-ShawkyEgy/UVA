import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Throwable 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true)
		{
			int n = Integer.parseInt(br.readLine().trim());
			if(n==0)break;
			PriorityQueue<Integer> q = new PriorityQueue<Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				q.add(Integer.parseInt(st.nextToken()));
			}
			long ans = 0;
			while(q.size()>1)
			{
				int a = q.poll();
				int b = q.poll();
				int res = a + b;
				ans += res;
				q.add(res);
			}
			sb.append(ans+"\n");
		}
		System.out.print(sb);
	}
}
