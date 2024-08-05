package emp.engine.primitives.token;

/**
 * The {@code Token} interface is a marker interface that all tokens must implement.
 * A Token is primarily:
 * 	-	String, a value;
 *  -	TokenType, a type (enum);
 *  
 *  The TokenType is used to determine the type of the token.
 *  The value is used to store the actual value of the token.
 *  
 *  Every token must implement
 *  - {@code TokenType getType()} method, which returns the type of the token.
 *  - {@code String getValue()} method, which returns the value of the token.
 *  - {@code String toString()} method, which returns the string representation of the token.
 *  - {@code boolean equals(Object obj)} method, which returns true if the object is equal to the token.
 */
public interface Token {
	TokenType getType();

	String getValue();

	@Override
	String toString();

	@Override
	boolean equals(Object obj);
};
