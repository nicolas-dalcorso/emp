package emp.engine.primitives;

import emp.engine.primitives.token.TokenType;

public class MusicalTokenType extends TokenType {
	public final static MusicalTokenType NOTE 				= new MusicalTokenType("note");
	public final static MusicalTokenType RANDOM_NOTE 		= new MusicalTokenType("random note");
	public final static MusicalTokenType REST 				= new MusicalTokenType("rest");
	public final static MusicalTokenType DOUBLE_VOLUME 		= new MusicalTokenType("double volume");
	public final static MusicalTokenType DEFAULT_VOLUME 	= new MusicalTokenType("half volume");
	public final static MusicalTokenType PHONE_RINGING 		= new MusicalTokenType("phone ringing");
	public final static MusicalTokenType INC_OCTAVE 		= new MusicalTokenType("increase octave");
	public final static MusicalTokenType DEC_OCTAVE 		= new MusicalTokenType("decrease octave");
	public final static MusicalTokenType INC_TEMPO 			= new MusicalTokenType("increase tempo");
	public final static MusicalTokenType RANDOM_TEMPO 		= new MusicalTokenType("random tempo");
	public final static MusicalTokenType INSTRUMENT_CHANGE 	= new MusicalTokenType("instrument change");
	private final String type;
	/**
	 * Constructs a new {@code MusicalTokenType} with the specified type.
	 * 
	 * @param type the type of the token
	 */
	public MusicalTokenType(String type) {
		if (type == null) {
			throw new IllegalArgumentException("type cannot be null");
		};
		if (isValid(type)) {
			this.type = type;
		} else {
			throw new IllegalArgumentException("Invalid type");
		};
	};
	
	
	
	/**
	 * Returns the string representation of the {@code MusicalTokenType}.
	 * 
	 * @return the string representation of the {@code MusicalTokenType}
	 */
	@Override
	public String toString() {
		return type;
	};

	
	@Override
	public TokenType getType(char c) {
		return this.type;
	}

	@Override
	public TokenType getType(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TokenType newInstance() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public boolean isValid(String type) {
		String[] values  = { "note", "random note", "rest", "double volume", "half volume", "phone ringing", "increase octave", "decrease octave", "increase tempo", "random tempo", "instrument change" };
		for (String t : values) {
			if (t.equals(type)) {
				return true;
			};
		};
		return false;
	};
}
