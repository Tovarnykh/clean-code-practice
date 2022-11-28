package ua.foxminded.javaspring.tovarnykh.cleancode.task3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ua.foxminded.javaspring.tovarnykh.cleancode.task1.Anagrams;
import ua.foxminded.javaspring.tovarnykh.cleancode.task3.IntegerDivision;

class IntegerDivisionTest {

    @Test
    void makeDivision_CommonDivision_True() {
	String expected = """
		_78945|4
		 4    |-----
		 -    |19736
		_38
		 36
		 --
		 _29
		  28
		  --
		  _14
		   12
		   --
		   _25
		    24
		    --
		     1
		""";
	assertEquals(expected, IntegerDivision.makeDivision(78945, 4));
    }

    @Test
    void makeDivision_DivisionWithNegativeDivisor_True() {
	String expected = """
		_78945|4
		 4    |------
		 -    |-19736
		_38
		 36
		 --
		 _29
		  28
		  --
		  _14
		   12
		   --
		   _25
		    24
		    --
		     1
		""";
	assertEquals(expected, IntegerDivision.makeDivision(78945, -4));
    }

    @Test
    void makeDivision_DivisionWithNegativeDividend_True() {
	String expected = """
		_78945|4
		 4    |------
		 -    |-19736
		_38
		 36
		 --
		 _29
		  28
		  --
		  _14
		   12
		   --
		   _25
		    24
		    --
		     1
		""";
	assertEquals(expected, IntegerDivision.makeDivision(-78945, 4));
    }

    @Test
    void makeDivision_NonZeroRremnant_True() {
	String expected = """
		_33|2
		 2 |--
		 - |16
		_13
		 12
		 --
		  1
		""";
	assertEquals(expected, IntegerDivision.makeDivision(33, 2));
    }

    @Test
    void makeDivision_DivisionWithZeroArgument_ExceptionThrown() {
	assertEquals("Divisor cannot be 0, division by zero", IntegerDivision.makeDivision(33, 0));
    }

}