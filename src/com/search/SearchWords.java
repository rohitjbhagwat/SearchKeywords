package com.search;

public class SearchWords {

	public String highlight(String color, String input, String searchKeyword) {
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
	}

	public String highlight(String searchKeywordWithColor, String input){
		String[] searchWithColorArray = searchKeywordWithColor.split(" ");
		for(int i = 0; i < searchWithColorArray.length; i++){
			String[] searchAndColor = searchWithColorArray[i].split(":");
			String search = searchAndColor[0];
			String color = "["+searchAndColor[1]+"]";
			input = highlight(color, input, search);
		}
		return input;
	}

}
