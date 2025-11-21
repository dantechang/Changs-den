package assign1;

import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Set;
import java.util.HashSet;
import java.util.regex.*;


public class A12
{
	public static Set<String> getIdRegex(String filename) throws Exception{
		String[] keywordsArray = { "IF", "WRITE", "READ", "RETURN", "BEGIN","END", "MAIN", "INT", "REAL", "ELSE", "STRING" }; 	Set<String> keywords = new HashSet();
		Set<String> identifiers = new HashSet();
		
		for (String s : keywordsArray) 
			keywords.add(s);

		FileReader reader = new FileReader(filename);
		BufferedReader br = new BufferedReader(reader);
		String line;
		
		
		String idExpr = "[A-Za-z][a-zA-Z0-9]*"; 
		Pattern idPattern = Pattern.compile(idExpr);
		String quotedStringExpr = "\".*\"";
	    Pattern quotedStringPattern = Pattern.compile(quotedStringExpr);
	    
		while ((line = br.readLine()) != null) {
			Matcher m_quotedString = quotedStringPattern.matcher(line);
			String lineWithoutQuotedStrings = m_quotedString.replaceAll("");
			Matcher m = idPattern.matcher(lineWithoutQuotedStrings);
			while (m.find()) {
				String id = line.substring(m.start(), m.end()); // this line is wrong. you need to modify it. 
				if (!keywords.contains(id))
					identifiers.add(id);
			}
		}
		return identifiers;
	}	
	
	public static void main(String[] args) throws Exception{
		Set<String> ids = getIdRegex("test.txt");
		for(String id : ids) System.out.println(id);
		
	}
}




