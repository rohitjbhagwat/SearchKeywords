package com.search;

public class Formatter {

	private String color;

	private String capitalize;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCapitalize() {
		return capitalize;
	}

	public void setCapitalize(String capitalize) {
		this.capitalize = capitalize;
	}

	public String format(String input){
		if("Capital".equalsIgnoreCase(capitalize)){
			input = input.toUpperCase();
		}else{
			input = input.toLowerCase();
		}
		String colorCode = "["+color+"]";
		return colorCode+input+colorCode;
	}
}
