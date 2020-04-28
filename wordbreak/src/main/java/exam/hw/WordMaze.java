package exam.hw;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author yizhou
 *
 *
 */
public class WordMaze {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();//行数
		int m=sc.nextInt();//列数
		String sFood=sc.next();//单词W
		
		int i=0;
		ArrayList<char[]> nList=new ArrayList();
		while(sc.hasNext()) {
			String sTemp=sc.next();
			nList.add(sTemp.toCharArray());
			i++;
			if(i==n)
				break;
		}
		String result=eatFood(nList,sFood);
		System.out.println(result);
	}
	
	/**
	 * 检查是否能够连成输入的单词
	 * @param nList
	 * @param sFood
	 * @return
	 */
	public static String eatFood(ArrayList<char[]> nList,String sFood) {
		String result="NO";
		char foodArray[]=sFood.toCharArray();
		ArrayList<ArrayList<int[]>> resultList=getAllWordsPosList(nList,sFood);
		ArrayList<ArrayList<int[]>> list=new ArrayList();
		if(resultList.size()==foodArray.length) {
			ArrayList<int[]> posList=resultList.get(0);
			for(int i=1;i<resultList.size();i++) {
				ArrayList<int[]> nextPosList=resultList.get(i);
				for(int[] tempPos:posList) {
					list=getConList(list,nextPosList,tempPos);
				}				
				posList=nextPosList;
			}

			System.out.println("list="+list.size());
			if(isOk(list,sFood))
				result="YES";
		}
		
		return result;
	}
	
	/**
	 * 如果串联坐标长度与字符串长度一致，则表示通过
	 * @param list
	 * @param sFood
	 * @return
	 */
	public static boolean isOk(ArrayList<ArrayList<int[]>> list,String sFood) {
		boolean result=false;
		char[] foodArray=sFood.toCharArray();
		for(ArrayList<int[]> tempList:list) {
			System.out.println("tempList.size()="+tempList.size());
			if(tempList.size()==foodArray.length) {
				result=true;
				break;
			}
		}
		
		return result;
	}
	
	/**
	 * 在下一个坐标列表里查找与当前坐标相邻的坐标，并装进list
	 * @param list
	 * @param nextPosList
	 * @param pos
	 * @return
	 */
	public static ArrayList<ArrayList<int[]>> getConList(ArrayList<ArrayList<int[]>> list,ArrayList<int[]> nextPosList,int[] pos) {
		if(list.size()>0) {			
			for(int temp[]:nextPosList) {
				ArrayList<Integer> iList=getListnumWhereHasPos(list,pos);
				if(temp[0]==pos[0]||temp[1]==pos[1]) {
					for(int iTemp:iList) {
						ArrayList<int[]> tempList=list.get(iTemp);
						tempList.add(temp);
						list.set(iTemp, tempList);
					}
				}
			}
		}else {
			ArrayList<ArrayList<int[]>> resultlist=new ArrayList();
			for(int temp[]:nextPosList) {
				if(temp[0]==pos[0]||temp[1]==pos[1]) {
					ArrayList<int[]> tempList=new ArrayList();
					tempList.add(pos);
					tempList.add(temp);
					resultlist.add(tempList);
				}
			}
			
			list=resultlist;
		}
		
		return list;
	}
	
	/**
	 * 获取列表里最后一个坐标是当前坐标的列表位置
	 * @param list
	 * @param pos
	 * @return
	 */
	public static ArrayList<Integer> getListnumWhereHasPos(ArrayList<ArrayList<int[]>> list,int[] pos) {
		ArrayList<Integer> resultList=new ArrayList();
		for(int i=0;i<list.size();i++) {
			ArrayList<int[]> tempList=list.get(i);
			if(checkLastElementIsPos(tempList,pos)) {
				resultList.add(i);
			}
		}
		
		return resultList;
	}
	
	/**
	 * 判断列表的最后坐标是否是当前坐标
	 * @param tempList
	 * @param pos
	 * @return
	 */
	public static boolean checkLastElementIsPos(ArrayList<int[]> tempList,int[] pos) {
		boolean result=false;
		int size=tempList.size();
		if(size>0) {
			int[] temp=tempList.get(size-1);
			if(temp[0]==pos[0]&&temp[1]==pos[1]) {
				result=true;
			}
		}
			
		return result;
	}
	
	/**
	 * 获取W单词的所有字母坐标列表
	 * @param nList
	 * @param sFood
	 * @return
	 */
	public static ArrayList<ArrayList<int[]>> getAllWordsPosList(ArrayList<char[]> nList,String sFood) {
		ArrayList<ArrayList<int[]>> resultList=new ArrayList();
		char foodArray[]=sFood.toCharArray();
		for(char tempWord:foodArray) {
			ArrayList<int[]> tempList=getWordPosList(nList,tempWord);
			resultList.add(tempList);
		}
		
		return resultList;
	}
	
	/**
	 * 获取单个字母的坐标列表
	 * @param nList
	 * @param c
	 * @return
	 */
	public static ArrayList<int[]> getWordPosList(ArrayList<char[]> nList,char c) {
		ArrayList<int[]> posList=new ArrayList();
		for(int i=0;i<nList.size();i++) {
			char tempArray[]=nList.get(i);
			for(int j=0;j<tempArray.length;j++) {
				if(c==tempArray[j]) {
					int pos[]=new int[2];
					pos[0]=i;
					pos[1]=j;
					posList.add(pos);
				}
			}
		}
		
		return posList;
	}

}
