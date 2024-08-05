package emp.engine.primitives;

import emp.engine.primitives.token.Token;
import emp.engine.primitives.token.TokenType;

/**
 * A {@code CharToken} is a token that represents a single character. It implements the {@code Token} interface
 * and uses {@code UTFTokenType} as its types. The value of the token is a single character.
 * 
 * @see Token
 * @see UTFTokenType
 * 
 * @author nrdc
 * @version 2.0.0
 * @since 2.0.0
 */
public class CharToken implements Token{
	private final TokenType		type;
	private final String 		value;
	
	/**
	 * Constructs a new {@code CharToken} with the specified type and value.
	 * 
	 * @param type  the type of the token
	 * @param value the value of the token
	 */
	public CharToken(CharTokenType type, String value) {
		this.type 	= type;
		this.value 	= value;
	};
	
	/**
	 * Returns the type of the token.
	 * 
	 * @return UTFTokenType, the type of the token
	 */
	@Override
	public TokenType getType() {
		return type;
	};

	@Override
	public String getValue() {
		return value;
    };
    
    @Override
	public String toString() {
		return "CharToken{" + "type=" + type + ", value='" + value + '\'' + '}';
	};
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		CharToken token = (CharToken) obj;
		return type == token.type && value.equals(token.value);
	};

}
