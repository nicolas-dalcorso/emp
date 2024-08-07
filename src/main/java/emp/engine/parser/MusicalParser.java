package emp.engine.parser;

import emp.engine.parser.tokenizers.Tokenizer;
import emp.engine.primitives.CharToken;
import emp.engine.primitives.CharTokenType;
import emp.engine.primitives.MusicalToken;
import emp.engine.primitives.token.Token;
import emp.engine.parser.tokenizers.CharTokenizer;
import emp.engine.parser.mappers.MusicalRuleset;
import java.util.List;
import java.util.ArrayList;

public class MusicalParser implements Parser<CharToken, MusicalToken>{
	private String input_buffer;
	private ArrayList<CharToken> tokens;
	private CharTokenizer tokenizer;
	private ArrayList<MusicalToken> output_buffer;
	
	/**
	 * Constructs a new {@code MusicalParser} with the specified input buffer.
	 * 
	 * @param input_buffer the input buffer to parse
	 */
	public MusicalParser(String input_buffer) {
		this.input_buffer 	= input_buffer;
		this.tokenizer 		= new CharTokenizer(input_buffer);
		this.tokens 		= new ArrayList<CharToken>();
		this.output_buffer 	= new ArrayList<MusicalToken>();
	};
	

	@Override
	public ArrayList<MusicalToken> parse() {
		ArrayList<CharToken> tokens 	= new ArrayList<CharToken>();
		MusicalRuleset ruleset 			= MusicalRuleset.getInstance();
		
		//	Tokenizes the input if necessary
		if(this.tokens.isEmpty()) {
			this.tokens = this.tokenizer.tokenize();
		};
		
		//	Copy tokens
		for (CharToken token : this.tokens) {
			tokens.add(token);
		};
		
		//    Match tokens
		while(tokens.size() > 0) {
			ruleset.match(tokens, this.output_buffer);
			System.out.println(tokens.size());
		};
		
		return this.output_buffer;
	};
	
	

	@Override
	public String getInputBuffer() {
		return this.input_buffer;
	};

	@Override
	public ArrayList<MusicalToken> getOutputBuffer() {
		if (this.output_buffer.isEmpty()) {
			this.parse();
		};
		
		return this.output_buffer;
	};

	@Override
	@Deprecated
	public Tokenizer getTokenizer() {
		return (Tokenizer) this.tokenizer;
    };

}
