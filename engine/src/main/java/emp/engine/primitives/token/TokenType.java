package emp.engine.primitives.token;

/**
 * A {@code TokenType} is an abstract class that represents the type of a token. It is used to determine the type of the token.
 * It is used by the {@code Token} interface to determine the type of the token.
 * 
 * @see Token
 * 
 * @author nrdc
 * @version 2.0.0
 * @since 2.0.0
 */
public abstract class TokenType {
	/**
	 * Returns the string representation of the TokenType.
	 * 
	 * @return String, the string representation of the TokenType
	 */
	@Override
	public abstract String toString();

	/**
	 * Returns the TokenType of the specified character.
	 * 
	 * @param c the character to determine the type of
	 * @return TokenType, the type of the character
	 */
	public abstract TokenType getType(char c);
	
	/**
	 * Returns the TokenType of the specified string.
	 * 
	 * @param s the string to determine the type of
	 * @return TokenType, the type of the string
	 */
	public abstract TokenType getType(String s);
	
	/**
	 * Returns a new instance of the TokenType.
	 * 
	 * @return TokenType, a new instance of the TokenType
	 */
	public abstract TokenType newInstance();
}
