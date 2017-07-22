package com.search;

public class SearchWords {

	public String highlight(String highLight, String input, String searchKeyword) {
		String[] searchKeys = searchKeyword.split(" ");
		String[] inputArray = input.split(" ");

		for(int i = 0; i < searchKeys.length; i++){
			String key = searchKeys[i];
			String newKey = highLight + key + highLight;
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

}
