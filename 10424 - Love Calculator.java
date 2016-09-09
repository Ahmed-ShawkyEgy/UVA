import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
public class Main{
	static HashMap<Character, Integer> map;
	public static int getVal(String s)
	{
		int ans = 0;
		s = s.toLowerCase();
		for (int i = 0; i < s.length(); i++)
		{
			char x = s.charAt(i);
			if(map.containsKey(x))
			{
				ans+=map.get(x);
			}
		}
		return ans;
	}
	public static int getFinalValue(int n)
	{
		String s = n+"";
		if(s.length()==1)
			return n;
		int x = 0;
		for (int i = 0; i < s.length(); i++) {
			x += Integer.parseInt(s.charAt(i)+"");
		}
		return getFinalValue(x);
	}
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		char c = 'a';
		int val = 1;
		map = new HashMap<Character, Integer>();
		while(c!='z'+1)
		{
			map.put(c++, val++);
		}
		DecimalFormat f = new DecimalFormat("#0.00");
		while(br.ready())
		{
			String a = br.readLine();
			String b = br.readLine();
			double x = getFinalValue(getVal(a)) * 1.0;
			double y = getFinalValue(getVal(b)) * 1.0;
			double ans = Math.min(x, y) / Math.max(x, y);
			ans*=100;
			out.append(f.format(ans)+" %\n");
		}
		out.flush();
	}
}
