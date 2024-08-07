package emp.engine.primitives;

import emp.engine.primitives.token.TokenType;

/**
 * The {@code CharTokenType} is used to determine the type of a CharToken.
 * The types are those possible for UTF-8 encoding:
 *     -	lowercase letter
 *     -	uppercase letter
 *     -	digit
 *     -	special character
 *     -	punctuation character
 *     -	whitespace character
 *     -	control character
 *     -	invalid character
 *     
 */
public class CharTokenType extends TokenType {
	/**
	 * The lowercase letter type.
	 */
	public static final CharTokenType LOWERCASE_LETTER = new CharTokenType("lowercase letter");

	/**
	 * The uppercase letter type.
	 */
	public static final CharTokenType UPPERCASE_LETTER = new CharTokenType("uppercase letter");

	/**
	 * The digit type.
	 */
	public static final CharTokenType DIGIT = new CharTokenType("digit");

	/**
	 * The special character type.
	 */
	public static final CharTokenType SPECIAL_CHARACTER = new CharTokenType("special character");

	/**
	 * The punctuation character type.
	 */
	public static final CharTokenType PUNCTUATION_CHARACTER = new CharTokenType("punctuation character");

	/**
	 * The whitespace character type.
	 */
	public static final CharTokenType WHITESPACE_CHARACTER = new CharTokenType("whitespace character");

	/**
	 * The control character type.
	 */
	public static final CharTokenType CONTROL_CHARACTER = new CharTokenType("control character");

	/**
	 * The invalid character type.
	 */
	public static final CharTokenType INVALID_CHARACTER = new CharTokenType("invalid character");

	private final String type;

	/**
	 * Constructs a new {@code CharTokenType} with the specified type.
	 * 
	 * @param type the type of the token
	 */
	private CharTokenType(String type) {
		this.type = type;
	}

	/**
	 * Returns the string representation of the CharTokenType.
	 * 
	 * @return String, the string representation of the CharTokenType
	 */
	@Override
	public String toString() {
		return type;
	}

	/**
     * Returns the CharTokenType of the specified character.
     * 
     * @param c the character to determine the type of
     * @return CharTokenType, the type of the character
     */
    public CharTokenType getType(char c) {
        if (Character.isLowerCase(c)) {
            return LOWERCASE_LETTER;
        } else if (Character.isUpperCase(c)) {
            return UPPERCASE_LETTER;
        } else if (Character.isDigit(c)) {
            return DIGIT;
        } else if (Character.isWhitespace(c)) {
            return WHITESPACE_CHARACTER;
        } else if (Character.isISOControl(c)) {
            return CONTROL_CHARACTER;
        } else if (Character.isLetter(c)) {
            return SPECIAL_CHARACTER;
        } else if (Character.isDigit(c)) {
            return PUNCTUATION_CHARACTER;
        } else {
            return INVALID_CHARACTER;
        }
    }

	@Override
	public TokenType getType(String s) {
		if (s.length() == 1) {
			return getType(s.charAt(0));
		} else {
			return INVALID_CHARACTER;
		}
	};

	@Override
	public TokenType newInstance() {
		return new CharTokenType("");
	};
}
