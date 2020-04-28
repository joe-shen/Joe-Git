package com.minicode;

import java.util.ArrayList;

/**
 * 
 * @author yizhou
 *
 */
public class Wordbreak {
	
	//��ֲ����
	public void doWordBreak(String str,Dictionary dict) {
		String result="";
		ArrayList<String> resultList=new ArrayList();
		resultList=new WordbreakUtil().getResultsFromStr(str, dict,result, resultList);
		if(resultList!=null) {
			for(int i=0;i<resultList.size();i++) {
				String temp=resultList.get(i);
				System.out.println(temp);
			}
		} 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dict2[]= {"i","like","sam","sung","mobile","icecream","man go","mango"};
		String str1="ilikesamsungmobile";
		String str2="ilikeicecreammango";
		
		ArrayList<String[]> dictArrayList=new ArrayList();
		dictArrayList.add(dict2);
		Dictionary dict=new Dictionary(dictArrayList,1);
		
		Wordbreak wb=new Wordbreak();
		wb.doWordBreak(str1, dict);
	    
		//hhgggggh
		
	}

}
