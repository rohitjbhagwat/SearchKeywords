package com.search;

public class Formatter {

	private String color;

	private String capitalize;

	private String fontStyle;

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
		String fontCode = "["+fontStyle+"]";
		String output = colorCode+input+colorCode;
		if(fontStyle != null){
			output = colorCode+fontCode+input+fontCode+colorCode;
		}
		return output;
	}

	public String getFontStyle() {
		return fontStyle;
	}

	public void setFontStyle(String fontStyle) {
		this.fontStyle = fontStyle;
	}
}
