package emp.engine.parser.mappers;

import emp.engine.primitives.CharToken;
import emp.engine.primitives.MusicalToken;
import emp.engine.primitives.token.TokenType;

/**
 * A {@code TokenMapper} is a mapper that maps values (String, char, numbers) to {@code TokenType} implementations.
 * A {@code TokenMapper} is used to map tokens to their types. It must implement the methods:
 *     - {@code TokenType map(<T> value)}, which maps the value to a {@code TokenType} implementation.
 *     - {@code void addMapping(<T> value, TokenType type)}, which adds a new mapping to the mapper.
 *     - {@code void removeMapping(<T> value)}, which removes a mapping from the mapper.
 *     - {@code TokenType getMapping(<T> value)}, which returns the mapping for the value.
 *     - {@code boolean hasMapping(<T> value)}, which returns true if the mapper has a mapping for the value.
 *     - {@code void clear()}, which removes all mappings from the mapper.
 * 
 */
public interface TokenMapper<T,Q> {
	<T> TokenType map(T value);

	<T> void addMapping(T value, Q type);

	<T> void removeMapping(T value);

	<T> TokenType getMapping(T value);

	<T> boolean hasMapping(T value);

	void clear();
}
