package emp.engine.parser;

import emp.engine.parser.tokenizers.Tokenizer;
import java.util.List;

/**
 * A {@code Parser} is used to parse a sequence of {@link Token}s.
 * It is implemented using generics for flexibility. It converts a sequence of input tokens to a sequence of output tokens.
 * 
 * A {@code Parser} must have the fields:
 * -    an input buffer
 * -    a {@link Tokenizer} to tokenize the input buffer
 * -	an output buffer
 * 
 * @param <T> the type of {@link Token} to parse
 * @param <Q> the type of the {@link Token} to be generated
 */
public interface Parser<T, Q> {
	/**
	 * Parses the input buffer and returns the output buffer.
	 * 
	 * @return the output buffer
	 */
	List<Q> parse();

	/**
	 * Returns the input buffer.
	 * 
	 * @return the input buffer
	 */
	String getInputBuffer();

	/**
	 * Returns the output buffer.
	 * 
	 * @return the output buffer
	 */
	List<Q> getOutputBuffer();

	/**
	 * Returns the {@link Tokenizer} used by this {@code Parser}.
	 * 
	 * @return the {@link Tokenizer}
	 */
	Tokenizer getTokenizer();
}
