package edu.westga.comp4420.junit_sample.test.model.telephone_checker;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;

import edu.westga.comp4420.junit_sample.model.TelephoneChecker;

class TestIdentifySpam {
	
	@ParameterizedTest
	@CsvSource({"9991234567,true","9001234567,true","8881234567,true","8001234567,true","9111234567,true","4111234567,true"})
	void testSpamNumbers(long number, boolean expectedResult) {
		TelephoneChecker checker = new TelephoneChecker();
		
		boolean result = checker.identifySpam(number);
		
		assertEquals(expectedResult, result, "checking if number(" + number + ") was reported as spam");
	};
	
	@ParameterizedTest
	@CsvSource({"9981234567,false", "8991234567,false", "9011234567, false", "8891234567, false", "8871234567, false",
	"8011234567,false", "7991234567, false", "4121234567,false", "4101234567, false"})
	void testNonSpamNumbers(long number, boolean expectedResult) {
		TelephoneChecker checker = new TelephoneChecker();
		
		boolean result = checker.identifySpam(number);
		
		assertEquals(expectedResult, result, "checking if number(" + number + ") was reported as spam");
	};
	
	@ParameterizedTest
	@CsvSource({"999999","10012345", "999999999", "999123456"})
	void testSpamPrecondition(long number) {
		TelephoneChecker checker = new TelephoneChecker();

		assertThrows(IllegalArgumentException.class, () -> checker.identifySpam(number));

	};
	

}
