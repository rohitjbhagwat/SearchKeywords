package com.search;

import java.util.Iterator;
import java.util.Map;

public class SearchWords {

	private String inputLine;

	private Map<String, Formatter> keywordFormatterMap;

	/*public String highlight(String color, String input, String searchKeyword, String capital) {
		String[] searchKeys = searchKeyword.split(" ");
		String[] inputArray = input.split(" ");

		for(int i = 0; i < searchKeys.length; i++){
			String key = searchKeys[i];
			String newKey = color + key + color;
			for(int j = 0; j < inputArray.length; j++){
				if(key.equals(inputArray[j])){
					inputArray[j] = newKey;
				}
			}
		}
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < inputArray.length; i++) {
			sb.append(inputArray[i]+" ");
		}
		return sb.toString().trim();
	}*/

	public String highlight(String input){
		Iterator<String> it = keywordFormatterMap.keySet().iterator();
		String[] inputArray = input.split(" ");
		while(it.hasNext()){
			String key = it.next();
			Formatter formatter = keywordFormatterMap.get(key);
			for(int j = 0; j < inputArray.length; j++){
				if(key.equals(inputArray[j])){
					inputArray[j] = formatter.format(key);
				}
			}
		}
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < inputArray.length; i++) {
			sb.append(inputArray[i]+" ");
		}
		return sb.toString().trim();
	}

	public String getInputLine() {
		return inputLine;
	}

	public void setInputLine(String inputLine) {
		this.inputLine = inputLine;
	}

	public Map<String, Formatter> getKeywordFormatterMap() {
		return keywordFormatterMap;
	}

	public void setKeywordFormatterMap(Map<String, Formatter> keywordFormatterMap) {
		this.keywordFormatterMap = keywordFormatterMap;
	}

}
