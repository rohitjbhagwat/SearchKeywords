package com.search;
import org.junit.Assert;
import org.junit.Test;


public class SearchWordsTest {


	@Test
	public void shouldSearchGivenWord(){
		String input = "This is a standard text";
		String searchKeyword = "is a text";
		SearchWords searchWords = new SearchWords();
		String newString = searchWords.highlight("[red]", input, searchKeyword);
		Assert.assertTrue(newString.indexOf("[red]") > -1 );
	}

	@Test
	public void shouldCannotSearchGivenWord(){
		String input = "This is a standard text";
		String searchKeyword = "xyz";
		SearchWords searchWords = new SearchWords();
		String newString = searchWords.highlight("[red]", input, searchKeyword);
		Assert.assertTrue(newString.indexOf("[red]") == -1 );
	}

	@Test
	public void shouldHighlightSearchWord(){
		String input = "This is a standard text";
		String searchKeyword = "is standard";
		SearchWords searchWords = new SearchWords();
		String newString = searchWords.highlight("[blue]", input, searchKeyword);
		System.out.println(newString);
		Assert.assertTrue(newString.contains("[blue]"));
	}

	@Test
	public void shouldHighlightSearchWordWithColor(){
		String input = "This is a standard text";
		String searchKeyword = "is:blue standard:red";
		SearchWords searchWords = new SearchWords();
		String newString = searchWords.highlight(searchKeyword, input);
		System.out.println(newString);
		Assert.assertTrue(newString.contains("[blue]"));
	}
}
