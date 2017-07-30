import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		final long I = 1l<<32;
		while(br.ready())
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			long n = Long.parseLong(st.nextToken());
			long l = Long.parseLong(st.nextToken());
			long u = Long.parseLong(st.nextToken());
						
			long ans = 0;
			for (long i = I; i > 0; i >>= 1)
			{
				if((i&n)==0)
				{
					if((ans|i)<=u)
						ans |= i;
				}
				else
				{
					long trial = (i&n) - 1;
					if((ans|trial) < l)
						ans |= (i&n);
				}
			}
			sb.append(ans+"\n");
		}
		System.out.print(sb);
	}
}
