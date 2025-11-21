package assign1;

import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Set;
import java.util.HashSet;

/* */

public class A11 {
	
	static boolean isLetter(int character) {
		return (character >= 'a' && character <= 'z') || (character >= 'A' && character <= 'Z');
	}
	
	static boolean isLetterOrDigit(int character) {
	 	return isLetter(character) || (character >= '0' && character <= '9');
	}
	
	static boolean isDigit(int character) {
		return (character >= '0' && character <= '9');
	}
	
	public static Set<String> getIdentifiers(String filename) throws Exception{
		String[] keywordsArray = { "IF", "WRITE", "READ", "RETURN", "BEGIN", "END", "MAIN", "INT", "REAL","ELSE", "STRING"};
				
		Set<String> keywords = new HashSet();
		Set<String> identifiers = new HashSet();
		
		for(String s : keywordsArray) {
			keywords.add(s);
		}
		
		String state = "INIT";
		
		StringBuilder code = new StringBuilder();
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line;
		
		while((line = br.readLine()) != null) {
			code = code.append(line + "\n");
		}
		
		code = code.append("$"); //end of file
		
		int len = code.length();
		
		boolean isComment = false;
		
		
		
		String token = "";
		
		
		for(int i =0; i< len; i++) {
			char next_char = code.charAt(i);
			
			
			if (isComment == false  && next_char == '/' && i+1 < len && code.charAt(i+1) == '*' ) {
				isComment = true;
				i++; //skip over the *
				continue;
			}
			
			if (isComment == true && next_char == '*' && i +1 < len && code.charAt(i+1) == '/' ) {
				isComment = false;
				i++; //skip over */ 
				continue;
			}
			
			if (isComment == false && next_char == '"' ) {
				isComment = true;
				continue;
				
			}
			
			if(isComment == true && next_char == '"') {
				isComment = false;
				continue;
			}
			
			if (isComment) {
				continue; // if were in the middle of a comment skip cuz the values do not matter
			}
				
				
			if(state.contentEquals("INIT")) {
				if (isLetter(next_char)) {
					state = "ID";
					token = token + next_char;
				}
				
				else if(isDigit(next_char)) { //it is a number since it begins with a digit it is not an id
					continue;
					
				}
				
			}
			
			else if (state.contentEquals("ID")) {
				if(isLetterOrDigit(next_char)) {
					token = token + next_char;
				}
				else {
					if(!keywords.contains(token)) { //it is not a keyword but an identifier
						identifiers.add(token);
					}
					token = ""; //reset the current token whether or not its an identifier or not
					state = "INIT";
				}
			}
		}
		
		return identifiers;
		
		
	}
	
	public static void main(String[] args) throws Exception{
		Set<String> ids = getIdentifiers("test.txt");
		
		for(String id : ids) System.out.println(id);
		
	}
}
