
/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple �substitution cipher� where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * @author Farnaz Eivazi
 * @version 7/16/2022
 */
public class CryptoManager {
	
	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String plainText) {
		for(int i = 0; i < plainText.length(); i++) {
			if((int) plainText.charAt(i) < LOWER_RANGE || (int) plainText.charAt(i) > UPPER_RANGE)   //checks if character is outside range
				return false;
		}
		return true;   //no characters are outside of range so string is in bounds
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {
		
		if(plainText != plainText.toUpperCase())   //if passed text is not all capitalized, then error will be returned, but this should not occur during runtime
			return "The selected string is not in bounds, Try again.";
		
		char tempChar;   //stores selected character of the string to be shifted
		String encryptedString = "";   //stores the end result
		
		int shortKey = key;   //shortens the key so encryption doesn't span the entire range
		if(key > RANGE)
			shortKey = key % RANGE;
		
		for(int i = 0; i < plainText.length(); i++) {   //loops through every character in the string
			if(((int) plainText.charAt(i) + shortKey) > UPPER_RANGE)   //if the character after being shifted is passed the upper bound
				tempChar = (char) (((plainText.charAt(i) + shortKey) % UPPER_RANGE) + (LOWER_RANGE - 1));   //remainder will be added to the lower range
			else   //character is shifted accordingly
				tempChar = (char) (plainText.charAt(i) + shortKey);
			encryptedString += tempChar;   //character is concatenated to the end result
		}
		return encryptedString;   //encryption complete
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption (String plainText, String bellasoStr) {
		char tempChar;   //stores selected character of the string to be shifted
		String encryptedString = "";   //stores the end result
		
		int shortKey;   //stores shortened key
		
		for(int i = 0, j = 0; i < plainText.length(); i++, j++) {   //loops through every character in the string
			shortKey = bellasoStr.charAt(j);
			if(bellasoStr.charAt(j) > RANGE)   //shortens the bellaso string character so encryption doesn't span the entire range
				shortKey = bellasoStr.charAt(j) % RANGE;
			
			if((plainText.charAt(i) + shortKey) > UPPER_RANGE)   //if the character after being shifted is passed the upper bound
				tempChar = (char) (((plainText.charAt(i) + shortKey) % UPPER_RANGE) + (LOWER_RANGE - 1));   //remainder will be added to the lower range
			else   //character is shifted accordingly
				tempChar = 	(char) (plainText.charAt(i) + shortKey);
			
			if(j == bellasoStr.length() - 1)   //if selected bellaso string character is at the end
				j = -1;   //character is set back to the beginning
			
			encryptedString += tempChar;   //character is concatenated to the end result
		}
		return encryptedString;   //encryption complete
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption (String encryptedText, int key) {
		char tempChar;   //stores selected character of the string to be shifted
		String decryptedString = "";   //stores the end result
		
		int shortKey = key;   //shortens the key so encryption doesn't span the entire range
		if(key > RANGE)
			shortKey = key % RANGE;
		
		for(int i = 0; i < encryptedText.length(); i++) {   //loops through every character in the string
			if(((int) encryptedText.charAt(i) - shortKey) < LOWER_RANGE)   //if the character after being shifted back is passed the lower bound
				tempChar = (char) ((UPPER_RANGE + 1) - (LOWER_RANGE - (encryptedText.charAt(i) - shortKey)));   //the difference between the shifted character and the lower bound is subtracted from the upper range
			else   //character is shifted accordingly
				tempChar = (char) (encryptedText.charAt(i) - shortKey);
			decryptedString += tempChar;   //character is concatenated to the end result
		}
		return decryptedString;   //encryption complete
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
		char tempChar;   //stores selected character of the string to be shifted
		String decryptedString = "";   //stores the end result
		
		int shortKey;   //stores shortened key
		
		for(int i = 0, j = 0; i < encryptedText.length(); i++, j++) {   //loops through every character in the string
			shortKey = bellasoStr.charAt(j);
			if(bellasoStr.charAt(j) > RANGE)   //shortens the bellaso string character so encryption doesn't span the entire range
				shortKey = bellasoStr.charAt(j) % RANGE;
			
			if((encryptedText.charAt(i) - shortKey) < LOWER_RANGE)   //if the character after being shifted back is passed the lower bound
				tempChar = (char) ((UPPER_RANGE + 1) - (LOWER_RANGE - (encryptedText.charAt(i) - shortKey)));   //the difference between the shifted character and the lower bound is subtracted from the upper range
			else   //character is shifted accordingly
				tempChar = 	(char) (encryptedText.charAt(i) - shortKey);
			
			if(j == bellasoStr.length() - 1)   //if selected bellaso string character is at the end
				j = -1;   //character is set back to the beginning
			
			decryptedString += tempChar;   //character is concatenated to the end result
		}
		return decryptedString;   //encryption complete
	}
}
