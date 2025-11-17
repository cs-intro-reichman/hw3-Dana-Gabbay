/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	public static boolean isAnagram(String str1, String str2) {
		String s1 = preProcess(str1);
		String s2 = preProcess(str2);
		if (s1.length()!= s2.length())
			return false;
		for (int i=0; i<s1.length(); i++)
		{
			char c= s1.charAt(i);
			boolean found = false;
			for (int j=0; j<s2.length(); j++)
			{
				if (s2.charAt(j) == c)
				{
					String newS2 = "";
					for (int k=0; k< s2.length(); k++)
					{
						if (k!=j)
						newS2 = newS2 + s2.charAt(k);
					}
					s2 = newS2;
					found = true;
					break;
				}
			}
			if (found==false)
				return false;
		}
		return true;
	}
	   
	public static String preProcess(String str) {
		String result = "";
		for (int i=0; i<str.length(); i++)
		{
			char c = str.charAt(i);
			if (Character.isLetter(c))
			result = result+ Character.toLowerCase(c);
							
		}
	
		return result;
	} 
	   
	public static String randomAnagram(String str) {
		String remaining = str;
		String result = "";
		while (remaining.length()>0)
		{
			int index = (int) (Math.random()*remaining.length());
			char c = remaining.charAt(index);
			result = result+ c;
			String newRemaining= "";
			for (int i=0; i<remaining.length(); i++)
			{
				if (i!= index)
				newRemaining = newRemaining + remaining.charAt(i);
			}
			remaining = newRemaining;
		}
		return result;
	}
}
