package com.minicode;

import java.util.ArrayList;

/**
 * 
 * @author yizhou
 *
 */
public class WordbreakUtil {
	
	public String breakStr(String str,Dictionary dict) {
		String result="";
		
		if(str!=null&&!"".equals(str)) {
			int n=str.length();
			System.out.println(str+" "+n);
			for(int i=1;i<=n;i++) {
				String temp=str.substring(0,i);
				if(dict.containsWord(temp)) {
					System.out.println("temp="+temp);
					System.out.println("str="+str);
					if(temp.equals(str)) {
						result+=temp;
						break;
					}else {
						result+=temp+" ";
						String newStr=str.substring(i,str.length());
						System.out.println("newStr="+newStr+" i="+i);
						result+=breakStr(newStr,dict);	
						break;
					}							
				}
			}
		}
		
		return result;
	}
	
	/**
	 * 从字符串中解析出包含的单词
	 * @return
	 */
	public ArrayList<String> getWordsFromStr(String str,Dictionary dict) {
		ArrayList resultList=new ArrayList();
		if(str!=null&&!"".equals(str)) {
			int n=str.length();
			//System.out.println(str+" "+n);
			for(int i=1;i<=n;i++) {
				String temp=str.substring(0,i);
				if(dict.containsWord(temp)) {
					resultList.add(temp);
				}
			}
		}
		
		return resultList;
	}
	
	/**
	 * 根据字符串获取结果集
	 * @return
	 */
	public ArrayList<String> getResultsFromStr(String str,Dictionary dict,String result,ArrayList<String> resultList) {
		WordbreakUtil wbUtil=new WordbreakUtil();
		ArrayList<String> wordsList=wbUtil.getWordsFromStr(str, dict);
		//System.out.println("wordsList.size()=="+wordsList.size()+" str="+str);
		if(wordsList!=null) {
			String resultTmp=result;//临时变量
			for(int i=0;i<wordsList.size();i++) {
				String temp=wordsList.get(i);
				result=resultTmp;
				if(temp.length()==str.length()) {
					result+=temp;
					resultList.add(result);
					result="";
				}else {					
					String newStr=str.substring(temp.length(), str.length());
					ArrayList<String> wordsListTemp=wbUtil.getWordsFromStr(newStr, dict);
					if(wordsListTemp.size()==0) {
						String resulttemp=result+temp+" "+newStr;
						//resultList.add(resulttemp);
						//result="";
					}else {
						result+=temp+" ";
						resultList=getResultsFromStr(newStr,dict,result,resultList);
					}					
				}				
			}
		}
		
		return resultList;		
	}

}
