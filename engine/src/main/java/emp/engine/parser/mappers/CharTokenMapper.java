package emp.engine.parser.mappers;

import java.util.HashMap;
import java.util.Map;

import emp.engine.primitives.CharTokenType;
import emp.engine.primitives.token.TokenType;

/**
 * A {@code CharTokenMapper} is a mapper that maps characters to {@code CharTokenType} objects. It is a implementation of the {@code TokenMapper} interface.
 * It is implemented as a Singleton class. The first time the class is instantiated, the default mappings are added to the mapper.
 * 
 * @see TokenMapper
 * @see CharTokenType
 * @see CharToken
 * 
 */
public class CharTokenMapper<Char, CharToken> implements TokenMapper{
	private static final Map<Character, CharTokenType> mappings = new HashMap<>();
	
	/**
	 * The instance of the {@code CharTokenMapper} class.
	 */
	public static CharTokenMapper INSTANCE;
	
	/**
	 * Public instantiator for the {@code CharTokenMapper} class.
	 * 
	 * @return the instance of the {@code CharTokenMapper} class
	 */
	public static CharTokenMapper getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CharTokenMapper();
		}
		
		setDefault();
		return INSTANCE;
	};
	
	/**
	 * Constructs a new {@code CharTokenMapper} with the default mappings.
	 */
	private CharTokenMapper() {
		setDefault();
	};
	
	private static void setDefault() {
		String lowercase = "abcdefghijklmnopqrstuvwxyz";
		String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String digits = "0123456789";
		String special = "!@#$%^&*()-_=+[]{}|;':\",.<>/?`~";
		String punctuation = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
		String whitespace = " \t\n\r";
		String control = "\b\f";
		
		for (char c : lowercase.toCharArray()) {
			mappings.put(c, CharTokenType.LOWERCASE_LETTER);
		};
		
		for (char c : uppercase.toCharArray()) {
			mappings.put(c, CharTokenType.UPPERCASE_LETTER);
		};
		
		for (char c : digits.toCharArray()) {
			mappings.put(c, CharTokenType.DIGIT);
		};
		
		for (char c : special.toCharArray()) {
			mappings.put(c, CharTokenType.SPECIAL_CHARACTER);
		};
		
		for (char c : punctuation.toCharArray()) {
			mappings.put(c, CharTokenType.PUNCTUATION_CHARACTER);
		};
		
		for (char c : whitespace.toCharArray()) {
			mappings.put(c, CharTokenType.WHITESPACE_CHARACTER);
		};
		
		for (char c : control.toCharArray()) {
            mappings.put(c, CharTokenType.CONTROL_CHARACTER);
		};
	}

	@Override
	public TokenType map(Object value) {
		if (value instanceof Character && mappings.containsKey(value)) {
			return mappings.get(value);
		} else {
			throw new IllegalArgumentException("Invalid mapping");
		}
	};

	@Override
	public void addMapping(Object value, Object type) {
		if (value instanceof Character && type instanceof CharTokenType) {
			mappings.put((Character) value, (CharTokenType) type);
		} else {
			throw new IllegalArgumentException("Invalid mapping");
		};
	}

	@Override
	public void removeMapping(Object value) {
		if(value instanceof Character && mappings.containsKey(value)) {
            mappings.remove(value);
        } else {
            throw new IllegalArgumentException("Invalid mapping");
        }
	};

	@Override
	public TokenType getMapping(Object value) {
		if (value instanceof Character && mappings.containsKey(value)) {
			return mappings.get(value);
		} else {
			throw new IllegalArgumentException("Invalid mapping");
		}
	};

	@Override
	public boolean hasMapping(Object value) {
		if (value instanceof Character) {
			return mappings.containsKey(value);
		} else {
			throw new IllegalArgumentException("Invalid mapping");
		}
	};

	@Override
	public void clear() {
		mappings.clear();
	};
	
	
};
