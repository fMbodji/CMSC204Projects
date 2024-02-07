/*
 * Class: CMSC204
 * Instructor: Huseyin Aygun       
 * Description: Project 1 - Test Student
 * Due: 02/06/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
 * 
   Print your Name here: Fatima Mbodji
*/

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Fatima Mbodji
 *
 */
public class PasswordCheckerTest_STUDENT {
	private ArrayList<String> passwords;

	@Before
	public void setUp() throws Exception {
		String[] p = {"abcde", "ABC123", "aabbccdd", "abcABC123#", "123abc", "0001ABC"};
	    passwords = new ArrayList<>(Arrays.asList(p));	
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
	        try {
	        	assertFalse(PasswordCheckerUtility.isValidPassword("abcde")); 
	        } catch (LengthException e) {
	            assertTrue(true); // Passes
	        } catch(Exception e){
				System.out.println(e.getMessage());
				assertFalse("Threw some other exception besides LengthException", true);
			}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
	     try {
	    	 assertFalse(PasswordCheckerUtility.isValidPassword("abcde")); 
	     } catch (NoUpperAlphaException e) {
	            assertTrue(true); 
	     }catch(Exception e){
			System.out.println(e.getMessage());
			assertFalse("Threw some other exception besides LengthException", true);
	     }
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try {
	    	 assertFalse(PasswordCheckerUtility.isValidPassword("123abc")); 
	     } catch (NoLowerAlphaException e) {
	            assertTrue(true); 
	     }catch(Exception e){
			System.out.println(e.getMessage());
			assertFalse("Threw some other exception besides LengthException", true);
	     }
	}
	
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try {
	        assertFalse(PasswordCheckerUtility.isWeakPassword("abcdeA")); // Valid password, not weak
	    } catch (WeakPasswordException e) {
	        
	    }
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
        try {
        	assertFalse(PasswordCheckerUtility.isValidPassword("abcde"));
            PasswordCheckerUtility.isValidPassword("aaabbb");
        } catch (InvalidSequenceException e) {
            assertTrue(true); 
        }catch(Exception e){
			System.out.println(e.getMessage());
			assertFalse("Threw some other exception besides LengthException", true);
        }
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try {
	    	 assertFalse(PasswordCheckerUtility.isValidPassword("ABCabc")); 
	     } catch (NoDigitException e) {
	            assertTrue(true); 
	     } catch(Exception e){
			System.out.println(e.getMessage());
			assertFalse("Threw some other exception besides LengthException", true);
	     }
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("abcABC123#"));
		} catch (Exception e) {
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	 @Test public void testInvalidPasswords() 
	 {
		 ArrayList<String> invalidPasswords = PasswordCheckerUtility.getInvalidPasswords(passwords);
	     assertEquals(5, invalidPasswords.size());
	     assertTrue(invalidPasswords.contains("abcde - The password must be at least 6 characters long")); 
	     assertTrue(invalidPasswords.contains("ABC123 - The password must contain at least one lowercase alphabetic character")); 
	     assertTrue(invalidPasswords.contains("aabbccdd - The password cannot contain more than two of the same character in sequence")); 
	 }
	 
	
	
}
