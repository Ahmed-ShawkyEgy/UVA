import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int cases = 1;
		while(true)
		{
			String s = br.readLine();
			if(s.equals("#"))
				break;
			out.append("Case "+cases++ +": ");
			switch (s) {
			case "HELLO": out.append("ENGLISH\n");break;
			case "HOLA":out.append("SPANISH\n");break;
			case "HALLO":out.append("GERMAN\n");break;
			case "BONJOUR":out.append("FRENCH\n");break;
			case "CIAO":out.append("ITALIAN\n");break;
			case "ZDRAVSTVUJTE":out.append("RUSSIAN\n");break;
			default:out.append("UNKNOWN\n");break;
			}		
			
		}
		out.flush();
	}
}
