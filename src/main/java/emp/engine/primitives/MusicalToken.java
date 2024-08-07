package emp.engine.primitives;

import emp.engine.primitives.token.Token;
import emp.engine.primitives.token.TokenType;

public class MusicalToken implements Token{
	private final MusicalTokenType type;
	private final String value;
	
	/**
	 * Constructs a new {@code MusicalToken} with the specified type and value.
	 * 
	 * @param type  the type of the token
	 * @param value the value of the token
	 */
	public MusicalToken(MusicalTokenType type, String value) {
		this.type = type;
		this.value = value;
	};
	
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
    	return "MusicalToken{" + "type=" + type + ", value='" + value + '\'' + '}';
    };
    
    @Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		MusicalToken token = (MusicalToken) obj;
		return type == token.type && value.equals(token.value);
	};
}
