/*
 * Class: CMSC204
 * Instructor: Huseyin Aygun       
 * Description: Project 1 - Utility class
 * Due: 02/06/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
 * 
   Print your Name here: Fatima Mbodji
*/


import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;


/**
* Utilty class to check the validity of a password
* @author Fatima Mbodji
*
*/
public class PasswordCheckerUtility {
	
	/**
	 * Compare the equality of two passwords
	 * @param password - password string to be checked for
	 * @param passwordConfirm - passwordConfirm string to be checked against password for
	 * @throws UnmatchedException
	 */
	public static void comparePasswords​(String password,String passwordConfirm) throws UnmatchedException{
		if( !(password.equals(passwordConfirm)) )
			throw new UnmatchedException("Passwords do not match");
	}
	
	/**
	 * Compare the equality of two password with a return value
	 * @param password- password string to be checked for
	 * @param passwordConfirm - passwordConfirm string to be checked against password for
	 * @return true if the both are the same
	 */
	public static boolean comparePasswordsWithReturn​(String password,String passwordConfirm){
		if( password.equals(passwordConfirm) )
			return true;
		return false;
	}
	
	
	/**
	 * Check the validity of the passowrd's length
	 * A valid length should be at least 6 characters long
	 * @param password - password string to be checked for
	 * @return true if meets minimum length requirement
	 * @throws LengthException
	 */
	public static boolean isValidLength(String password)throws LengthException {
		if(password.length()<6)
			throw new LengthException("The password must be at least 6 characters long");
		return true;
	}
	
	
	/**
	 * Check if the password has an upper case letter
	 * @param password - password string to be checked for
	 * @return true if meets the upper case requirement
	 * @throws NoUpperAlphaException
	 */
	public static boolean hasUpperAlpha(String password)throws NoUpperAlphaException{
		boolean hasUpperAlpha = false;
		for(int i=0; i<password.length(); i++)
		{
			if( Character.isUpperCase(password.charAt(i)) )
			{
				hasUpperAlpha=true;
				break;
			}			
		}
		if (hasUpperAlpha == false)
			throw new NoUpperAlphaException ("The password must contain at least one uppercase alphabetic character");
		return hasUpperAlpha;
	}
	
	
	/**
	 * Check if the password has a lower case letter
	 * @param password - password string to be checked for
	 * @return true if meets the lower case requirement
	 * @throws NoLowerAlphaException
	 */
	public static boolean hasLowerAlpha(String password )throws NoLowerAlphaException{
		boolean hasLowerAlpha = false;
		for(int i=0; i<password.length(); i++)
		{
			if( Character.isLowerCase(password.charAt(i)) )
			{
				hasLowerAlpha=true;
				break;
			}	
		}
		if (hasLowerAlpha == false)
			throw new NoLowerAlphaException ("The password must contain at least one lowercase alphabetic character");
		return hasLowerAlpha;
	}
	
	/**
	 * Check if the password has a digit
	 * @param password - password string to be checked for
	 * @return true if meets the digit requirement
	 * @throws NoDigitException
	 */
	public static boolean hasDigit(String password)throws NoDigitException {
		boolean hasDigit = false;
		for(int i=0; i<password.length(); i++)
		{
			if( Character.isDigit(password.charAt(i)) )
			{
				hasDigit=true;
				break;
			}
		}
		if (hasDigit == false)
			throw new NoDigitException ("The password must contain at least one digit");
		return hasDigit;
	}
	
	
	/**
	 * Check if the password has a special character
	 * @param password - password string to be checked for
	 * @return true if meets the special character requirement
	 * @throws NoSpecialCharacterException
	 */
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException{
		boolean result=false;
		String regex = "\\W"; // \W for no-word character (special character)
		String text="";
		Pattern pt = Pattern.compile(regex);
		for(int i=0; i<password.length(); i++)
		{
			text = password.substring(i, i+1);
			Matcher mt = pt.matcher(text);
			if( mt.matches())
			{
				result = true;
				break;
			}
		}
		if(result == false)
			throw new NoSpecialCharacterException("The password must contain at least one special character ");	
		return result;
	}
	
	
	/**
	 * Check  if the password has more than two of the same character in a sequence
	 * @param password - password string to be checked for
	 * @return false if does NOT meet the sequence requirement
	 * @throws InvalidSequenceException
	 */
	public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException{
		boolean validSequence = true;
		for (int i = 0; i < password.length() - 2; i++) 
		{
	        char firstChar = password.charAt(i);
	        char secondChar = password.charAt(i + 1);
	        char thirdChar = password.charAt(i + 2);
	        if (firstChar == secondChar  && secondChar == thirdChar) 
	        {
	            validSequence = false;
	            break; 
	        }
		}
		if(validSequence == false)
			throw new InvalidSequenceException("The password cannot contain more than two of the same character in sequence.");
		return validSequence;
	}
	
	
	/**
	 * Check the validity of a password
	 * A password is valid if follows all the following rules: 
	 * 	1. At least 6 characters long -
	 *  2. At least 1 numeric character-
	 *  3. At least 1 upper case alphabetic character - 
	 *  4. At least 1 lower case alphabetic character - 
	 *  5. At least 1 special character - 
	 *  6. No more than 2 of the same character in a sequence 
	 * @param password - password string to be checked for
	 * @return false if invalid password
	 * @throws LengthException
	 * @throws NoUpperAlphaException
	 * @throws NoLowerAlphaException
	 * @throws NoDigitException
	 * @throws NoSpecialCharacterException
	 * @throws InvalidSequenceException
	 */
	public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException, 
			NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException{
		boolean isLengthValid= true, 
				hasUpperAlpha= true, 
				hasLowerAlpha= true, 
				hasDigit= true, 
				hasSpecialChar= true, 
				isSequenceValid = true;
		
		try {
			isLengthValid = isValidLength(password);
			hasUpperAlpha = hasUpperAlpha(password);
			hasLowerAlpha = hasLowerAlpha(password);
			hasDigit = hasDigit(password);
			hasSpecialChar = hasSpecialChar(password);
			isSequenceValid = NoSameCharInSequence(password);
		}catch(LengthException e) {
			isLengthValid = false;
		}catch(NoUpperAlphaException e) {
			hasUpperAlpha = false;
		}catch(NoLowerAlphaException e) {
			hasLowerAlpha = false;
		}catch(NoDigitException e) {
			hasDigit = false;
		}catch(NoSpecialCharacterException e) {
			hasSpecialChar = false;
		}catch(InvalidSequenceException e) {
			isSequenceValid = false; 
		}
		
		return isLengthValid && hasUpperAlpha && hasLowerAlpha && hasDigit &&
				hasSpecialChar && isSequenceValid ;
		
	}
	
	
	/**
	 * checks if the password contains 6 to 9 characters
	 * @param password - password string to be checked for
	 * @return true if the password contains 6 to 9 characters
	 */
	public static boolean hasBetweenSixAndNineChars(String password){
		if (password.length() >= 6 && password.length() <= 9)
			return true;
		return false;
	} 
	
	
	/**
	 * Check if it is a weak password (is VALID and the length is NOT between 6-9 character)
	 * @param password - password string to be checked for
	 * @return false if the password is valid and the length of password is NOT between 6 and 9.
	 * @throws WeakPasswordException
	 */
	public static boolean isWeakPassword(String password) throws WeakPasswordException {
	    boolean isWeakPassword = false;
	    try {
	        if (isValidPassword(password) && !hasBetweenSixAndNineChars(password)) {
	            isWeakPassword = true;
	            throw new WeakPasswordException("The password is OK but weak - it contains fewer than 10 characters");
	        }
	    } catch (Exception e) {
	    }
	    return isWeakPassword;
	}

	
	/**
	 * This method accept an ArrayList of passwords as the parameter
	 *  and return an ArrayList with the status of any invalid passwords (weak passwords are not considered invalid). 
	 *  The ArrayList of invalid passwords will be of the following format: password BLANK message of the exception thrown
	 * @param passwords - list of string passwords to be checked for
	 * @return an ArrayList of invalid passwords in the correct format
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords){
		ArrayList<String> listInvaliPasswords = new ArrayList<>();
		for(String password : passwords)
		{
			try {
				isValidPassword(password);
			}catch(LengthException | NoUpperAlphaException | NoLowerAlphaException | 
					NoDigitException | NoSpecialCharacterException |
					InvalidSequenceException  e){
				listInvaliPasswords.add(password + " " + e.getMessage());
			}
		}
		return listInvaliPasswords;
	}


}
