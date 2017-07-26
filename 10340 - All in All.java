import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(br.ready())
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			String t = st.nextToken();
			int ind = 0;
			for(int i = 0;i<t.length() && ind<s.length();i++)
				if(t.charAt(i) == s.charAt(ind))
					ind++;
			sb.append((ind==s.length())?"Yes":"No");
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
