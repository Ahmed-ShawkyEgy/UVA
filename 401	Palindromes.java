import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.Map.Entry;

public class Main {
	static char[] arr1 = {'A','E','H','I','J','L','M','O','S','T','U','V','W','X','Y','Z','1','2','3','5','8'};
	static char[] arr2 = {'A','3','H','I','L','J','M','O','2','T','U','V','W','X','Y','5','1','S','E','Z','8'};
	public static boolean isPal(String s)
	{
		for (int i = 0; i < s.length(); i++) 
		{
			if(s.charAt(i)!=s.charAt(s.length()-1-i))
				return false;
		}
		return true;
	}
	public static boolean isMir(String s)
	{
		for (int i = 0; i < s.length(); i++) 
		{
			char a = s.charAt(i);
			char b = s.charAt(s.length()-1-i);
			boolean isValid = false;
			for (int j = 0; j < arr1.length; j++) 
			{
				if(a==arr1[j] && b==arr2[j])
				{
					isValid = true;
					break;
				}
			}
			if(!isValid)
				return false;
		}
		return true;
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(br.ready())
		{
			String s = br.readLine();
			boolean pal = isPal(s);
			boolean mir = isMir(s);
			if(pal && mir)
				System.out.println(s+" -- is a mirrored palindrome.");
			else
			{
				if(pal && !mir)
					System.out.println(s+" -- is a regular palindrome.");
				else
				{
					if(!pal && mir)
						System.out.println(s+" -- is a mirrored string.");
					else
						System.out.println(s+" -- is not a palindrome.");
				}
			}
			System.out.println();
		}
	}
}
