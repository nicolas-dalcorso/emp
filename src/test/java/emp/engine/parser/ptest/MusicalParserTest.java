package emp.engine.parser.ptest;

import static org.junit.Assert.*;
import org.junit.Test;

import emp.engine.parser.MusicalParser;
import emp.engine.primitives.MusicalToken;
import emp.engine.primitives.MusicalTokenType;

public class MusicalParserTest {
	/**
	 * Initialization
	 */
	@Test
	public void testInitialization() {
		MusicalParser parser = new MusicalParser("a");
        assertEquals("a", parser.getInputBuffer());
        assertEquals(1, parser.getInputBuffer().length());
        assertEquals(1, parser.getOutputBuffer().size());
    };
    
	/**
	 * Test parsing
	 */
    @Test
	public void testParse() {
		MusicalParser parser = new MusicalParser("abcdefg");
		assertEquals(7, parser.getOutputBuffer().size());
		
		//	Notes
		for (MusicalToken token : parser.getOutputBuffer()) {
			assertEquals(MusicalTokenType.NOTE, token.getType());
			System.out.println(token.getValue());
		};

		//	Note repetition
		parser = new MusicalParser("AiBOcii");
		assertEquals(6, parser.getOutputBuffer().size());
		
		for (MusicalToken token : parser.getOutputBuffer()) {
            System.out.println(token.getType());
        };
    
        //	Octave increase and decrease
        parser = new MusicalParser("R+R-");
        assertEquals(2, parser.getOutputBuffer().size());
        
        for (MusicalToken token : parser.getOutputBuffer()) {
            System.out.println(token.getType());
        };
        
    };
    
    

}
