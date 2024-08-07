package emp.engine.parser.mappers;

import static org.junit.Assert.*;
import org.junit.Test;

import emp.engine.primitives.CharToken;
import emp.engine.primitives.CharTokenType;
import emp.engine.primitives.token.TokenType;

/**
 * The {@code CharTokenMapperTest} class is a test class for the {@code CharTokenMapper} class.
 * 
 * @see CharToken
 * @see CharTokenMapper
 * @see CharTokenType
 * 
 * @author nrdc
 * @version 2.0.0
 * @since 2.0.0
 */
public class CharTokenMapperTest {
	/**
     * Test method for {@link emp.engine.parser.mappers.CharTokenMapper#getInstance()}.
     */
    @Test
    public void testGetInstance() {
        CharTokenMapper instance = CharTokenMapper.getInstance();
        assertNotNull(instance);
    }

    /**
     * Test method for {@link emp.engine.parser.mappers.CharTokenMapper#map(java.lang.Character)}.
     */
    @Test
    public void testMap() {
        CharTokenMapper instance = CharTokenMapper.getInstance();
        CharTokenType type = (CharTokenType) instance.map('a');
        assertEquals(CharTokenType.LOWERCASE_LETTER, type);
    }

    /**
     * Test method for {@link emp.engine.parser.mappers.CharTokenMapper#addMapping(java.lang.Character, emp.engine.primitives.token.TokenType)}.
     */
    @Test
    public void testAddMapping() {
        CharTokenMapper instance = CharTokenMapper.getInstance();
        instance.clear();
        instance.addMapping('a', CharTokenType.LOWERCASE_LETTER);
        CharTokenType type = (CharTokenType) instance.map('a');
        assertEquals(CharTokenType.LOWERCASE_LETTER, type);
    }

    /**
     * Test method for {@link emp.engine.parser.mappers.CharTokenMapper#removeMapping(java.lang.Character)}.
     */
    @Test
    public void testRemoveMapping() {
        CharTokenMapper instance = CharTokenMapper.getInstance();
        instance.clear();
        instance.addMapping('a', CharTokenType.LOWERCASE_LETTER);
        instance.removeMapping('a');
		assertThrows(IllegalArgumentException.class, () -> {
			instance.map('a');
		});
    }

    /**
     * Test method for {@link emp.engine.parser.mappers.CharTokenMapper#getMapping(java.lang.Character)}.
     */
    @Test
    public void testGetMapping() {
        CharTokenMapper instance = CharTokenMapper.getInstance();
        instance.addMapping('a', CharTokenType.LOWERCASE_LETTER);
        CharTokenType type = (CharTokenType) instance.getMapping('a');
        assertEquals(CharTokenType.LOWERCASE_LETTER, type);
    }

    /**
     * Test method for {@link emp.engine.parser.mappers.CharTokenMapper#hasMapping(java.lang.Character)}.
     */
    @Test
    public void testHasMapping() {
        CharTokenMapper instance = CharTokenMapper.getInstance();
        instance.clear();
        instance.addMapping('a', CharTokenType.LOWERCASE_LETTER);
        boolean hasMapping = instance.hasMapping('a');
        assertTrue(hasMapping);
    }

    /**
	 * Test method for {@link emp.engine.parser.mappers.CharTokenMapper#clear()}.
	 */
    @Test
	public void testClear() {
		CharTokenMapper instance = CharTokenMapper.getInstance();
		instance.clear();
		assertThrows(IllegalArgumentException.class, () -> {
			instance.map('a');
		});
	};
	
	/**
	 * Test method for
	 * {@link emp.engine.parser.mappers.CharTokenMapper#map(java.lang.Object)}.
	 */
	@Test
	public void testMapObject() {
		CharTokenMapper instance = CharTokenMapper.getInstance();
		CharTokenType type = (CharTokenType) instance.map('a');
		assertEquals(CharTokenType.LOWERCASE_LETTER, type);
	};
	
	
	/**
	 * Tests each possible UTF-8 character to ensure that the mapping is correct.
	 */
	@Test
	public void testAllCharacters() {
		String lowerCase = "baabcdefghijklmnopqrstuvwxyz";
		String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String digits = "0123456789";
		String special = "!@#$%^&*()-_=+[]{}|;':\",.<>/?`~";
		String punctuation = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
		String whitespace = " \t\n\r";
		String control = "\b\f";
		
        CharTokenMapper instance = CharTokenMapper.getInstance();
        
		for (char c : lowerCase.toCharArray()) {
			CharTokenType type = (CharTokenType) instance.map(c);
			System.out.println(c);
			System.out.println(type);
			assertEquals(CharTokenType.LOWERCASE_LETTER, type);
		};
		
		for (char c : upperCase.toCharArray()) {
			CharTokenType type = (CharTokenType) instance.map(c);
			assertEquals(CharTokenType.UPPERCASE_LETTER, type);
		};
		
		for (char c : digits.toCharArray()) {
			CharTokenType type = (CharTokenType) instance.map(c);
			assertEquals(CharTokenType.DIGIT, type);
		};
		
		for (char c : special.toCharArray()) {
			CharTokenType type = (CharTokenType) instance.map(c);
			assertEquals(CharTokenType.SPECIAL_CHARACTER, type);
		};
		
		for (char c : punctuation.toCharArray()) {
			CharTokenType type = (CharTokenType) instance.map(c);
			assertEquals(CharTokenType.PUNCTUATION_CHARACTER, type);
		};
		
		for (char c : whitespace.toCharArray()) {
			CharTokenType type = (CharTokenType) instance.map(c);
			assertEquals(CharTokenType.WHITESPACE_CHARACTER, type);
		};
		
		for (char c : control.toCharArray()) {
			CharTokenType type = (CharTokenType) instance.map(c);
			assertEquals(CharTokenType.CONTROL_CHARACTER, type);
		};
	};
};
