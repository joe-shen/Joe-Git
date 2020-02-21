package com.minicode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * �ֵ���
 * @author yizhou
 * 2020-2-20
 */
public class Dictionary {
	private  Set<String> dictionarySet = new HashSet<>();
	private String dictArray[]= {"i","like","sam","sung","samsung","mobile","ice","cream","man go","mango"};
	//{"i","like","sam","sung","mobile","icecream","man go","mango"}
	
	//��ʼ���ֵ�
	//flag=1 ֻ��ʼ�������ֵ�;flag=2 ֻ��ʼ���ⲿ�����ֵ�;flag=3 �ϲ������ֵ���ⲿ�����ֵ�
	public Dictionary(ArrayList<String[]> dictArrayList,int flag) {
		if(flag==1||flag==3) {
			for(String temp1:dictArray){
				dictionarySet.add(temp1);
			}
		}
		
		if(flag==2||flag==3) {
			if(dictArrayList!=null) {//�ⲿ������ֵ䲻Ϊ�գ������ӽ������ֵ�
				for(String tempArray[]:dictArrayList) {
					for(String temp2:tempArray) {
						dictionarySet.add(temp2);
					}
				}
			}
		}
	}
	
	//����ֵ����Ƿ�����������
	public boolean containsWord(String word) {
		boolean result=false;
		if(word!=null&&!"".equals(word)) {
			if(dictionarySet.contains(word))
				result=true;
		}
		
		return result;
	}

}
