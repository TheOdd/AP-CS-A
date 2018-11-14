package lecture17.standard.substrings;

import java.util.HashMap;

public class Substrings {
	private String val;
	private HashMap<String, Integer> subs = null; 
	
	Substrings(String s) {
		val = s == null ? "" : s;
	}
	
	public HashMap<String, Integer> uniqueSubstringOccurances(int length) {
		if (subs == null) {
			HashMap<String, Integer> strings = new HashMap<String, Integer>();
			for (int i = 0; i < val.length() - length; i++) {
				String sub = val.substring(i, i + length);
				Integer curVal = strings.getOrDefault(sub, 0);
				strings.putIfAbsent(sub, curVal + 1);
			}
			subs = strings;
		}
		return subs;
	}
	
	// TODO: Return sorted HashMap
}
