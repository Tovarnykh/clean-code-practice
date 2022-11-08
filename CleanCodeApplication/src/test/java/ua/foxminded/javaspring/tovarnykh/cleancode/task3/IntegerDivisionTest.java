package ua.foxminded.javaspring.tovarnykh.cleancode.task3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ua.foxminded.javaspring.tovarnykh.cleancode.task1.Anagrams;
import ua.foxminded.javaspring.tovarnykh.cleancode.task3.IntegerDivision;

class IntegerDivisionTest {

	@Test
   void makeDivision_CommonDivision_True() {
       String expected =   "_78945|4\n" + 
                           " 4    |-----\n"+
                           " -    |19736\n" + 
                           "_38\n" + 
                           " 36\n" + 
                           " --\n"+
                           " _29\n"+
                           "  28\n" + 
                           "  --\n" + 
                           "  _14\n" + 
                           "   12\n" + 
                           "   --\n"+
                           "   _25\n"+
                           "    24\n"+
                           "    --\n"+
                           "     1\n";
       assertEquals(expected, IntegerDivision.makeDivision(78945, 4));
   }
	
	@Test
   void makeDivision_DivisionWithNegativeArgument_True() {
       String expected =   "_78945|4\n" + 
                           " 4    |------\n"+
                           " -    |-19736\n" + 
                           "_38\n" + 
                           " 36\n" + 
                           " --\n"+
                           " _29\n"+
                           "  28\n" + 
                           "  --\n" + 
                           "  _14\n" + 
                           "   12\n" + 
                           "   --\n"+
                           "   _25\n"+
                           "    24\n"+
                           "    --\n"+
                           "     1\n";
       assertEquals(expected, IntegerDivision.makeDivision(78945, -4));
   }
	
	@Test
   void makeDivision_DivisionWithNegativeDivisor_True() {
       String expected =   "_78945|4\n" + 
                           " 4    |------\n"+
                           " -    |-19736\n" + 
                           "_38\n" + 
                           " 36\n" + 
                           " --\n"+
                           " _29\n"+
                           "  28\n" + 
                           "  --\n" + 
                           "  _14\n" + 
                           "   12\n" + 
                           "   --\n"+
                           "   _25\n"+
                           "    24\n"+
                           "    --\n"+
                           "     1\n";
       assertEquals(expected, IntegerDivision.makeDivision(78945, -4));
   }
	
	@Test
   void makeDivision_DivisionWithNegativeDividend_True() {
       String expected =   "_78945|4\n" + 
                           " 4    |------\n"+
                           " -    |-19736\n" + 
                           "_38\n" + 
                           " 36\n" + 
                           " --\n"+
                           " _29\n"+
                           "  28\n" + 
                           "  --\n" + 
                           "  _14\n" + 
                           "   12\n" + 
                           "   --\n"+
                           "   _25\n"+
                           "    24\n"+
                           "    --\n"+
                           "     1\n";
       assertEquals(expected, IntegerDivision.makeDivision(-78945, 4));
   }
	
	@Test
   void makeDivision_NonZeroRremnant_True() {
       String expected =   "_33|2\n" + 
                           " 2 |--\n"+
                           " - |16\n" + 
                           "_13\n" + 
                           " 12\n" + 
                           " --\n"+
                           "  1\n";
       assertEquals(expected, IntegerDivision.makeDivision(33, 2));
   }
	
	@Test
   void makeDivision_DivisionWithZeroArgument_ExceptionThrown() {
 		assertEquals("Divisor cannot be 0, division by zero", IntegerDivision.makeDivision(33, 0));
   }

}