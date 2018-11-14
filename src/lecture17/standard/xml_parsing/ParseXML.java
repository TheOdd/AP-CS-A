package lecture17.standard.xml_parsing;

import java.util.Deque;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class ParseXML {
	public static boolean isValid(String xml) {
		Pattern p = Pattern.compile("<(\\w+)>|<\\/(\\w+)>");
		Matcher m = p.matcher(xml);
		
		Deque<String> d = new LinkedList<String>();
		
		while (m.find()) {
			String open = m.group(1);
			String close = m.group(2);
			if (open != null)
				d.push(open);
			else if (d.isEmpty() || !d.pop().equals(close))
					return false;
		}
		
		return d.isEmpty();
	}
}
