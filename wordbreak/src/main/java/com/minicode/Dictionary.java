package com.minicode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * 字典类
 * @author yizhou
 * 2020-2-20
 */
public class Dictionary {
	private  Set<String> dictionarySet = new HashSet<>();
	private String dictArray[]= {"i","like","sam","sung","samsung","mobile","ice","cream","man go","mango"};
	//{"i","like","sam","sung","mobile","icecream","man go","mango"}
	
	//初始化字典
	//flag=1 只初始化已有字典;flag=2 只初始化外部输入字典;flag=3 合并已有字典和外部输入字典
	public Dictionary(ArrayList<String[]> dictArrayList,int flag) {
		if(flag==1||flag==3) {
			for(String temp1:dictArray){
				dictionarySet.add(temp1);
			}
		}
		
		if(flag==2||flag==3) {
			if(dictArrayList!=null) {//外部输入的字典不为空，则增加进已有字典
				for(String tempArray[]:dictArrayList) {
					for(String temp2:tempArray) {
						dictionarySet.add(temp2);
					}
				}
			}
		}
	}
	
	//检查字典里是否存在这个单词
	public boolean containsWord(String word) {
		boolean result=false;
		if(word!=null&&!"".equals(word)) {
			if(dictionarySet.contains(word))
				result=true;
		}
		
		return result;
	}

}
