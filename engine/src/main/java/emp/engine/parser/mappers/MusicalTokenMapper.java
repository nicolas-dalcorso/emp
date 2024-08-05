package emp.engine.parser.mappers;

import java.util.HashMap;
import java.util.Map;

import emp.engine.primitives.CharTokenType;
import emp.engine.primitives.CharToken;
import emp.engine.primitives.token.TokenType;
import emp.engine.primitives.MusicalTokenType;
import emp.engine.primitives.MusicalToken;

/**
 * Maps {@code CharToken} tokens to {@code MusicalToken} tokens.
 */
public class MusicalTokenMapper implements TokenMapper<CharToken, MusicalToken>{
	private static final Map<CharToken, MusicalToken> mappings 		= new HashMap<>();
	public static final MusicalTokenMapper INSTANCE 				= new MusicalTokenMapper();
	
	/**
	 * Public instantiator for the {@code MusicalTokenMapper} class.
	 */
	public static MusicalTokenMapper getInstance() {
		return INSTANCE;
	}

	@Override
	public <T> TokenType map(T value) {
		if (value instanceof CharToken && mappings.containsKey(value)) {
			return mappings.get(value).getType();
		} else {
			throw new IllegalArgumentException("Invalid mapping");
		}
	};

	@Override
	public <T> void addMapping(T value, MusicalToken type) {
		if (value instanceof CharToken && type instanceof MusicalToken) {
			mappings.put((CharToken) value, type);
		}	else {
				throw new IllegalArgumentException("Invalid mapping");
		};
	}

	@Override
	public <T> void removeMapping(T value) {
		if (value instanceof CharToken && mappings.containsKey(value)) {
			mappings.remove(value);
		} else {
			throw new IllegalArgumentException("Invalid mapping");
		};
	}

	@Override
	public <T> TokenType getMapping(T value) {
		if (value instanceof CharToken && mappings.containsKey(value)) {
            return mappings.get(value).getType();
        } else {
            throw new IllegalArgumentException("Invalid mapping");
        }
	};

	@Override
	public <T> boolean hasMapping(T value) {
		if (value instanceof CharToken) {
			return mappings.containsKey(value);
		} else {
			throw new IllegalArgumentException("Invalid mapping");
		}
	};

	@Override
	public void clear() {
		mappings.clear();
	};
	
}
