package com.minicode;

import java.util.ArrayList;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * 
 * @author yizhou
 *
 */
public class WordBreakTest extends TestCase{
	
	@Test
	public void testExample() {
		String dict2[]= {"i","like","sam","sung","mobile","icecream","man go","mango"};
		String str="ilikesamsungmobile";
		ArrayList<String[]> dictArrayList=new ArrayList();
		dictArrayList.add(dict2);
		Dictionary dict=new Dictionary(dictArrayList,1);
		
		Wordbreak wb=new Wordbreak();
		wb.doWordBreak(str, dict);
	}
	
	@Test
	public void testStage2() {
		String dict2[]= {"i","like","sam","sung","mobile","icecream","man go","mango"};
		String str="ilikeicecreammango";
		ArrayList<String[]> dictArrayList=new ArrayList();
		dictArrayList.add(dict2);
		Dictionary dict=new Dictionary(dictArrayList,2);
		
		Wordbreak wb=new Wordbreak();
		wb.doWordBreak(str, dict);
	}
	
	@Test
	public void testStage3() {
		String dict2[]= {"i","like","sam","sung","mobile","icecream","man go","mango"};
		String str="ilikeicecreammango";
		ArrayList<String[]> dictArrayList=new ArrayList();
		dictArrayList.add(dict2);
		Dictionary dict=new Dictionary(dictArrayList,3);
		
		Wordbreak wb=new Wordbreak();
		wb.doWordBreak(str, dict);
	}

}
