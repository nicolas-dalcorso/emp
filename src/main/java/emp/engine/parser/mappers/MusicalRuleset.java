package emp.engine.parser.mappers;

import emp.engine.primitives.CharToken;
import emp.engine.primitives.CharTokenType;
import emp.engine.primitives.MusicalToken;
import emp.engine.primitives.MusicalTokenType;


import java.util.ArrayList;
import java.util.HashMap;


/**
 * A {@code MusicalRuleset} is a set of rules that (should) implement the {@code Ruleset} interface.
 * 
 * It maps CharToken values to MusicalToken values.
 */
public class MusicalRuleset {
	private HashMap<CharTokenType, MusicalTokenType> token_map;
	
	/**
	 * The instance of the {@code MusicalRuleset}.
	 */
	private static MusicalRuleset instance = null;

	/**
	 * Constructs a new {@code MusicalRuleset}.
	 */
	private MusicalRuleset() {
		// Empty constructor
	};

	/**
	 * Returns the instance of the {@code MusicalRuleset}.
	 * 
	 * @return the instance of the {@code MusicalRuleset}
	 */
	public static MusicalRuleset getInstance() {
		if (instance == null) {
			instance = new MusicalRuleset();
		};
		return instance;
	};
	
	public int match(ArrayList<CharToken> tokens, ArrayList<MusicalToken> output_buffer) {
		CharToken current_token = tokens.get(0);
		int counter = 0;
		
		
		if(current_token.getType() == CharTokenType.LOWERCASE_LETTER) {
			if(current_token.getValue().matches("[a-g]")) {
				MusicalToken token = new MusicalToken(MusicalTokenType.NOTE, current_token.getValue());
                output_buffer.add(token);
                tokens.remove(0);
                counter++;
            
                
                //	Repeats?
                while(tokens.size() > 0) {
                    current_token = tokens.get(0);
                    if (current_token.getValue().matches("[iIoOuU]")) {
                    	counter++;
                    	tokens.remove(0);
                    	output_buffer.add(token);
                    } else {
        				return counter;
                    };
                };
			}	else if (current_token.getValue().matches("[iIoOuU]")) {
						counter++;
						tokens.remove(0);
						MusicalToken token = new MusicalToken(MusicalTokenType.PHONE_RINGING, "");
						output_buffer.add(token);
						return counter;
			}
			
			else {
				tokens.remove(0);
				MusicalToken token = new MusicalToken(MusicalTokenType.REST, "");
				output_buffer.add(token);
				return counter;
			};
		
			
		} else if(current_token.getType() == CharTokenType.UPPERCASE_LETTER) {
						if(current_token.getValue().matches("[ACDEFG]")) {
                            MusicalToken token = new MusicalToken(MusicalTokenType.NOTE, current_token.getValue());
                            output_buffer.add(token);
                            tokens.remove(0);
                            
                            //	Repeats?
                            while(tokens.size() > 0) {
                                current_token = tokens.get(0);
                                if (current_token.getValue().matches("[iIoOuU]")) {
                                	
                                	System.out.println("Repeats");
                                	
                                    counter++;
                                    tokens.remove(0);
                                    output_buffer.add(token);
								} else {
									return counter;
								};
                            };
                            
                            
                            return counter;
                        }
                        
                        else if(current_token.getValue().matches("R")){
                        	// checks next for +
                        	if(tokens.size() > 0) {
                        		tokens.remove(0);
                        		current_token = tokens.get(0);
                        		if(current_token.getValue().equals("+")) {
                        			counter++;
                        			tokens.remove(0);
                        			MusicalToken token = new MusicalToken(MusicalTokenType.INC_OCTAVE, "R+");
                        			output_buffer.add(token);
                        			return counter;
                        		} else if(current_token.getValue().equals("-")) {
	                        			counter++;
	                        			tokens.remove(0);
	                        			MusicalToken token = new MusicalToken(MusicalTokenType.DEC_OCTAVE, "R+");
	                        			output_buffer.add(token);
	                        			return counter;
                        		} else {
                        			MusicalToken token = new MusicalToken(MusicalTokenType.REST, "");
                        			output_buffer.add(token);
                        			return counter;
                        		}
                        	};
                        }
						
                        else if(current_token.getValue().equals("B")) {
                        	//	check next for P
                        	tokens.remove(0);
                        	current_token = tokens.get(0);
                        	
                        	if(current_token.getValue().equals("P")) {
                        		tokens.remove(0);
                        		current_token = tokens.get(0);
                        		if(current_token.getValue().equals("M")) {
                        			tokens.remove(0);
                        			current_token = tokens.get(0);
                        			if(current_token.getValue().equals("+")) {
                        				counter++;
                        				tokens.remove(0);
                        				MusicalToken token = new MusicalToken(MusicalTokenType.INC_TEMPO, "BPM+");
                        				output_buffer.add(token);
                        				return counter;
                        			} else {
                        				MusicalToken token = new MusicalToken(MusicalTokenType.REST, "");
                        				output_buffer.add(token);
                        				return counter;
                        			}
                        			} else {
                        				MusicalToken token = new MusicalToken(MusicalTokenType.REST, "");
                        				output_buffer.add(token);
                        				return counter;
                        			}
                        		} else {
                        			MusicalToken token = new MusicalToken(MusicalTokenType.NOTE, "B");
                        			output_buffer.add(token);
                        			tokens.remove(0);
                        			counter++;
                        			return counter;
                        		}
                        };
		}  else if(current_token.getType() == CharTokenType.WHITESPACE_CHARACTER) {
                //	Ignore whitespace
            } else if(current_token.getType() == CharTokenType.CONTROL_CHARACTER) {
                //	Ignore control characters
            } else if(current_token.getType() == CharTokenType.SPECIAL_CHARACTER) {
                //	Ignore special characters
            } else if(current_token.getType() == CharTokenType.PUNCTUATION_CHARACTER) {
                //	Ignore punctuation characters
            } else if(current_token.getType() == CharTokenType.INVALID_CHARACTER) {
                //	Ignore invalid characters
            } else {
                //	Ignore all other characters
            };
		return counter;
	};
	
	
	// main
	public static void main(String[] args) {
		MusicalRuleset ruleset = MusicalRuleset.getInstance();
		ArrayList<CharToken> tokens = new ArrayList<CharToken>();
		ArrayList<MusicalToken> output_buffer = new ArrayList<MusicalToken>();
		
		tokens.add(new CharToken(CharTokenType.UPPERCASE_LETTER, "B"));
		tokens.add(new CharToken(CharTokenType.UPPERCASE_LETTER, "P"));
		tokens.add(new CharToken(CharTokenType.UPPERCASE_LETTER, "M"));
		tokens.add(new CharToken(CharTokenType.UPPERCASE_LETTER, "+"));
		tokens.add(new CharToken(CharTokenType.UPPERCASE_LETTER, "C"));
		
		int counter = 0;
		while (tokens.size() > 0) {
			counter = ruleset.match(tokens, output_buffer);
		};
		
		for (MusicalToken token : output_buffer) {
			System.out.println(token.getType() + " " + token.getValue());
		};

		
		
	};
			

}
