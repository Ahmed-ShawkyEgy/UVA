import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Main {
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		HashMap<Character, Integer>map = new HashMap<Character, Integer>();
		map.put('B',1);map.put('F', 1);map.put('P', 1);map.put('V', 1);
		map.put('C', 2);map.put('G', 2);map.put('J', 2);map.put('K', 2);map.put('Q', 2);map.put('S', 2);map.put('X', 2);map.put('Z', 2);
		map.put('D', 3);map.put('T', 3);
		map.put('L', 4);
		map.put('M', 5);map.put('N', 5);
		map.put('R', 6);
		while(br.ready())
		{
			String s = br.readLine();
			StringBuilder ans = new StringBuilder();
			int last = 0;
			for (int i = 0; i < s.length(); i++) {
				char x = s.charAt(i);
				if(map.containsKey(x) && map.get(x)!=last)
				{
					ans.append(map.get(x));
				}
				if(!map.containsKey(x))
					last=0;
				else
					last = map.get(x);
			}
			out.append(ans+"\n");
		}		
		out.flush();
	}
}
