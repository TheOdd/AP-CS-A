package lecture17.standard.substrings;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Substrings {
	private String val;
	private HashMap<String, Integer> subs = null; 
	private int subLength;
	
	Substrings(String s) {
		val = s == null ? "" : s;
	}
	
	public HashMap<String, Integer> uniqueSubstringOccurrences(int length) throws IllegalArgumentException {
		if (length <= 0)
			throw new IllegalArgumentException("length must be positive");
		if (subs == null || length != subLength) {
			HashMap<String, Integer> strings = new HashMap<String, Integer>();
			for (int i = 0; i <= val.length() - length; i++) {
				String sub = val.substring(i, i + length);
				Integer curVal = strings.getOrDefault(sub, 0);
				strings.put(sub, curVal + 1);
			}
			subs = strings
					.entrySet()
					.stream()
					.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
					.collect(
							Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
									LinkedHashMap::new));
			subLength = length;
		}
		return subs;
	}
}
