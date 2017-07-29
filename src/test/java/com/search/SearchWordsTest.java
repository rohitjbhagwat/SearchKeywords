package com.search;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;


public class SearchWordsTest {

	@Test
	public void shouldSearchGivenWord(){
		String input = "This is a standard text";
		SearchWords searchWords = new SearchWords();
		Map<String, Formatter> map = new HashMap<String,Formatter>();
		searchWords.setKeywordFormatterMap(map);
		searchWords.setInputLine(input);
		Formatter formatter = new Formatter();
		formatter.setColor("red");
		map.put("is", formatter);
		formatter = new Formatter();
		formatter.setColor("red");
		map.put("a", formatter);
		formatter = new Formatter();
		formatter.setColor("red");
		map.put("text", formatter);
		String newString = searchWords.highlight();
		Assert.assertTrue(newString.indexOf("[red]") > -1 );
	}

	@Test
	public void shouldCannotSearchGivenWord(){
		String input = "This is a standard text";
		SearchWords searchWords = new SearchWords();
		Map<String, Formatter> map = new HashMap<String,Formatter>();
		searchWords.setKeywordFormatterMap(map);
		searchWords.setInputLine(input);
		Formatter formatter = new Formatter();
		formatter.setColor("red");
		map.put("xyz", formatter);
		String newString = searchWords.highlight();
		Assert.assertTrue(newString.indexOf("[red]") == -1 );
	}

	@Test
	public void shouldHighlightSearchWord(){
		String input = "This is a standard text";
		SearchWords searchWords = new SearchWords();
		Map<String, Formatter> map = new HashMap<String,Formatter>();
		searchWords.setKeywordFormatterMap(map);
		searchWords.setInputLine(input);
		Formatter formatter = new Formatter();
		formatter.setColor("blue");
		map.put("is", formatter);
		formatter = new Formatter();
		formatter.setColor("blue");
		map.put("standard", formatter);
		String newString = searchWords.highlight();
		System.out.println(newString);
		Assert.assertTrue(newString.contains("[blue]"));
	}

	@Test
	public void shouldHighlightSearchWordWithFormatter(){
		String input = "This is a standard text";
		SearchWords searchWords = new SearchWords();
		Map<String, Formatter> map = new HashMap<String,Formatter>();
		searchWords.setKeywordFormatterMap(map);
		searchWords.setInputLine(input);
		Formatter formatter = new Formatter();
		formatter.setColor("red");
		formatter.setCapitalize("Capital");
		formatter.setFontStyle("bold");
		map.put("is", formatter);
		String newString = searchWords.highlight();
		System.out.println(newString);
		Assert.assertTrue(newString.contains("[red][bold]IS[bold][red]"));
	}
}
