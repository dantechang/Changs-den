package test;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;
import org.apache.commons.lang3.StringUtils;

public class StringUtilTests {
	
	//Tests for join(List<?> list, String separator, int startIndex, int endIndex)
	//combines substrings into single array
	@Test
	public void testJoin_Normal() {
		List<String> lst = Arrays.asList("a", "e", "f", "h");
		assertEquals("a,e,f", StringUtils.join(lst,",", 0,3));
	}
	@Test
	public void testJoin_EmptyRange() {
		//4 is the index after h so nothing o join
		List<String> lst = Arrays.asList("a", "e", "f", "h");
		assertEquals("", StringUtils.join(lst,",", 4,1));
		}
	@Test
	public void testJoin_Null() {
		assertNull(StringUtils.join((Object[]) null, ','));
	}
	@Test
	public void testJoin_WithNulls() {
		//null values are skipped over and the separator is added
		List<String> lst = Arrays.asList("a", null, "f", null);
		assertEquals("a,,f,", StringUtils.join(lst,",", 0,4));
		
	}
	
	
	//Tests for lastIndexOf(CharSequence seq, int searchChar)
	//gets the last index the char searchChar appears at
	@Test
	public void testLastIndexOf_Normal() {
		assertEquals(2,StringUtils.lastIndexOf("apple", 'p'));
		
	}
	@Test
	public void testLastIndexOf_EmptyStr() {
			assertEquals(-1,StringUtils.lastIndexOf("", 'p'));
		}
	@Test
	public void testLastIndexOf_NotFound() {
		assertEquals(-1,StringUtils.lastIndexOf("dominos", 'p'));
	}
	@Test
	public void testLastIndexOf_NullStr() {
		//when the char isnt found -1 returned 
		assertEquals(-1, StringUtils.lastIndexOf(null, 'w'));
	}
	
	//Tests for leftPad(String str, int size, char padChar)
	//pads the string on the left side with padChar ensuring string has size 
	@Test
	public void testLeftPad_Normal() {
		assertEquals("00000boom", StringUtils.leftPad("boom", 9, '0'));
	}
	@Test
	public void testLeftPad_NoPadding() {
		assertEquals("boomboomm", StringUtils.leftPad("boomboomm", 9, '0'));
		}
	@Test
	public void testLeftPad_EmptyStr() {
		//empty string is padded with 9 zeroes
		assertEquals("000000000", StringUtils.leftPad("", 9, '0'));
	}
	@Test
	public void testLeftPad_Null() {
		assertNull(StringUtils.leftPad(null, 9, '0'));
	}
	
	//Tests for repeat(String str, int repeat)
	//repeats a string repeat times
	@Test
	public void testRepeat_Normal() {
		assertEquals("bambambambam", StringUtils.repeat("bam", 4));
	}
	@Test
	public void testRepeat_ZeroRepeats() {
		//repeating 0 times leaves empty
		assertEquals("", StringUtils.repeat("bam", 0));
	}
		
	@Test
	public void testRepeat_EmpptyStr() {
		//repeating empty always gives empty
		assertEquals("", StringUtils.repeat("", 10));
	}
	
	@Test
	public void testRepeat_Null() {
		assertNull(StringUtils.repeat(null, 4));
	}
	
	
	//Tests for reverse(String str)
	//reverses string
	
	@Test
	public void testReverse_Normal() {
		assertEquals("retep", StringUtils.reverse("peter"));
	}
	
	@Test
	public void testReverse_EmptyStr() {
		assertEquals("", StringUtils.reverse(""));
	}
	
	@Test
	public void testReverse_Null() {
		assertNull( StringUtils.reverse(null));
	}
	
	@Test
	public void testReverse_OneChar() {
		assertEquals("p", StringUtils.reverse("p"));
	}
	
	//Tests for split(String str, char separatorChar)
	//separates a string into an array of strings separated by separatorChar
	
	@Test
	public void testSplit_Normal() {
		String[] tst = new String[]{"a", "b", "c"};
		assertArrayEquals(tst, StringUtils.split("a,b,c", ','));
	}
	
	@Test
	public void testSplit_null() {
		assertNull(StringUtils.split(null, ','));
	}
	
	@Test
	public void testSplit_EmptySegment() {
		//no elements between separators dd so it skips over it
		assertArrayEquals(new String[] {"a", "c"},StringUtils.split("addc",'d'));
	}
	
	@Test
	public void testSplit_NoSeperator() {
		//separator not found, string same length 1 array
		assertArrayEquals(new String[] {"ordinary"}, StringUtils.split("ordinary", ','));
	}
	
	//Tests startsWith(CharSequence str, CharSequence prefix)
	//returns boolean for if prefix starts the string str
	
	@Test
	public void testStartsWith_Normal() {
		assertTrue(StringUtils.startsWith("apricot", "apr"));
	}
	
	@Test
	public void testStartsWith_NoMatch() {
		//false case
		assertFalse(StringUtils.startsWith("banana", "apr"));
	}
	
	@Test
	public void testStartsWith_Null() {
		//null gives false and not error
		assertFalse(StringUtils.startsWith(null, "a"));
	}
	
	@Test
	public void testStartsWith_NullPrefix() {
		//string cannot start with null 
		assertFalse(StringUtils.startsWith("rabbit", null));
	}
	
	//Tests substring(String str, int start)
	//gets substring starting from start 
	
	@Test
	public void testSubstring_Normal() {
		assertEquals("currency", StringUtils.substring("Cryptocurrency", 6));
	}
	
	@Test
	public void testSubstring_PastStr() {
		assertEquals("", StringUtils.substring("Cryptocurrency", 14));
		//the length of str is 14 so he 14th index is empty which is why the substring is ""
	}
	
	@Test
	public void testSubstring_Null() {
		assertNull(StringUtils.substring(null, 6));
	}
	
	@Test
	public void testSubstring_EntireStr() {
		//substring from 0 is = str
		assertEquals("currency", StringUtils.substring("currency", 0));
	}
	
	//Tests trim(String str)
	//removes trailing and leading whitespaces
	
	@Test
	public void testTrim_Normal() {
		assertEquals("blank", StringUtils.trim("    blank    "));
	}
	
	@Test
	public void testTrim_Null() {
		assertNull(StringUtils.trim(null));
	}
	
	@Test
	public void testTrim_AllSpaces() {
		assertEquals("", StringUtils.trim("          "));
		//all white spaces, once removed is empty str
	}
	
	@Test
	public void testTrim_NoSpaces() {
		assertEquals("blank", StringUtils.trim("blank"));
	}
	
	//Tests for upperCase(String str)
	//turns all letters into uppercase
	
	@Test
	public void testUpperCase_Normal() {
		assertEquals("UPPERCASE", StringUtils.upperCase("uppercase"));
	}
	
	@Test
	public void testUpperCase_MixedCases() {
		//mix of lowercase, numbers and uppercase
		assertEquals("100LOOPED", StringUtils.upperCase("100loOPed"));
	}
	
	@Test
	public void testUpperCase_EmptyStr() {
		assertEquals("", StringUtils.upperCase(""));
	}
	
	@Test
	public void testUpperCase_Null() {
		assertNull(StringUtils.upperCase(null));
		
	}
}

