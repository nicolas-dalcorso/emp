package emp.engine.parser.tokenizers;

import org.junit.Test;
import static org.junit.Assert.*;

import emp.engine.parser.tokenizers.CharTokenizer;
import emp.engine.parser.tokenizers.Tokenizer;
import emp.engine.primitives.token.Token;
import emp.engine.primitives.token.TokenType;
import emp.engine.primitives.CharTokenType;
import emp.engine.primitives.CharToken;

import java.util.List;
import java.util.ArrayList;

public class CharTokenizerTest {
	
	/**
	 * Initialization test.
     */
	@Test
	public void testInitialization() {
        CharTokenizer tokenizer = CharTokenizer("Hello, World!");
        assertNotNull(tokenizer);
	};
	
	private CharTokenizer CharTokenizer(String string) {
		return new CharTokenizer(string);
	};

	@Test
	public void testTokenize() {
		CharTokenizer tokenizer = new CharTokenizer("Hello, World!");
		ArrayList<CharToken> tokens = tokenizer.tokenize();
		ArrayList<CharToken> expected = new ArrayList<>();
		expected.add(new CharToken(CharTokenType.UPPERCASE_LETTER, "H"));
		expected.add(new CharToken(CharTokenType.LOWERCASE_LETTER, "e"));
		expected.add(new CharToken(CharTokenType.LOWERCASE_LETTER, "l"));
		expected.add(new CharToken(CharTokenType.LOWERCASE_LETTER, "l"));
		expected.add(new CharToken(CharTokenType.LOWERCASE_LETTER, "o"));
		expected.add(new CharToken(CharTokenType.PUNCTUATION_CHARACTER, ","));
		expected.add(new CharToken(CharTokenType.WHITESPACE_CHARACTER, " "));
		expected.add(new CharToken(CharTokenType.UPPERCASE_LETTER, "W"));
		expected.add(new CharToken(CharTokenType.LOWERCASE_LETTER, "o"));
		expected.add(new CharToken(CharTokenType.LOWERCASE_LETTER, "r"));
		expected.add(new CharToken(CharTokenType.LOWERCASE_LETTER, "l"));
		expected.add(new CharToken(CharTokenType.LOWERCASE_LETTER, "d"));
		expected.add(new CharToken(CharTokenType.PUNCTUATION_CHARACTER, "!"));

		assertEquals(expected, tokens);
		
		for (CharToken token : tokens) {
			System.out.println(token);
		}
	}
}
