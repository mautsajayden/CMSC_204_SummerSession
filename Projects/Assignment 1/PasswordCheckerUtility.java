import java.util.ArrayList;

public class PasswordCheckerUtility {

	public PasswordCheckerUtility() {

	}

	/*
	 * Compare equality of two passwords
	 * 
	 * Parameters: password - password string to be checked for passwordConfirm -
	 * passwordConfirm string to be checked against password for Throws:
	 * UnmatchedException - thrown if not same (case sensitive)
	 */

	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {

		if (!(password.equals(passwordConfirm))) {

			throw new UnmatchedException("Passwords do not match");
		}
	}

	/*
	 * Compare equality of two passwords
	 * 
	 * Parameters: password - password string to be checked for passwordConfirm -
	 * passwordConfirm string to be checked against password for Returns: true if
	 * both same (case sensitive), false otherwise
	 */
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {

		return password.equals(passwordConfirm);
	}

	/*
	 * Checks the password length requirement - The password must be at least 6
	 * characters long
	 * 
	 * Parameters: password - password string to be checked for length Returns: true
	 * if meets minimum length requirement Throws: LengthException - thrown if does
	 * not meet minimum length requirement
	 */
	public static boolean isValidLength​(String password) throws LengthException {

		int passwordLength = password.length();

		boolean isCheck = passwordLength >= 6;

		if (!(isCheck)) {
			throw new LengthException();
		}

		return isCheck;
	}

	/*
	 * Checks the password alpha character requirement - Password must contain an
	 * uppercase alpha character
	 * 
	 * Parameters: password - password string to be checked for alpha character
	 * requirement Returns: true if meet alpha character requirement Throws:
	 * NoUpperAlphaException - thrown if does not meet alpha character requirement
	 */
	public static boolean hasUpperAlpha​(java.lang.String password) throws NoUpperAlphaException {

		boolean isCheck = false;

		for (int i = 0; i < password.length(); i++) {

			if (Character.isUpperCase(password.charAt(i))) {
				isCheck = true;
				break;
			}
		}

		if (!(isCheck)) {
			throw new NoUpperAlphaException();
		}

		return isCheck;
	}

	/*
	 * Checks the password lowercase requirement - Password must contain at least
	 * one lowercase alpha character
	 * 
	 * Parameters: password - password string to be checked for lowercase
	 * requirement Returns: true if meets lowercase requirement Throws:
	 * NoLowerAlphaException - thrown if does not meet lowercase requirement
	 */
	public static boolean hasLowerAlpha​(java.lang.String password) throws NoLowerAlphaException {

		boolean isCheck = false;

		for (int i = 0; i < password.length(); i++) {

			if ((Character.isLowerCase(password.charAt(i)))) {
				isCheck = true;
				break;
			}
		}
		if (!(isCheck)) {
			throw new NoLowerAlphaException();
		}

		return isCheck;
	}

	/*
	 * Checks the password Digit requirement - Password must contain a numeric
	 * character
	 * 
	 * Parameters: password - password string to be checked for Digit requirement
	 * Returns: true if meet Digit requirement Throws: NoDigitException - thrown if
	 * does not meet Digit requirement
	 */
	public static boolean hasDigit​(java.lang.String password) throws NoDigitException {

		boolean isCheck = false;

		for (int i = 0; i < password.length(); i++) {
			if (password.charAt(i) >= '0' && password.charAt(i) <= '9') {
				isCheck = true;
				break;
			}
		}

		if (!isCheck) {
			throw new NoDigitException();
		}

		return true;
	}

	/*
	 * Checks the password SpecialCharacter requirement - Password must contain a
	 * Special Character
	 * 
	 * Parameters: password - password string to be checked for SpecialCharacter
	 * requirement Returns: true if meets SpecialCharacter requirement Throws:
	 * NoSpecialCharacterException - thrown if does not meet SpecialCharacter
	 * requirement
	 */
	public static boolean hasSpecialChar​(java.lang.String password) throws NoSpecialCharacterException {

		boolean isCheck = false;

		for (int i = 0; i < password.length(); i++) {
			if (password.charAt(i) == '!' || password.charAt(i) == '@' || password.charAt(i) == '#'
					|| password.charAt(i) == '$' || password.charAt(i) == '%' || password.charAt(i) == '^'
					|| password.charAt(i) == '&' || password.charAt(i) == '*') {
				isCheck = true;
				break;
			}
		}
		if (!(isCheck)) {
			throw new NoSpecialCharacterException();
		}

		return true;
	}

	/*
	 * Checks the password Sequence requirement - Password should not contain more
	 * than 2 of the same character in sequence
	 * 
	 * Parameters: password - password string to be checked for Sequence requirement
	 * Returns: false if does NOT meet Sequence requirement Throws:
	 * InvalidSequenceException - thrown if meets Sequence requirement
	 */
	public static boolean NoSameCharInSequence​(java.lang.String password) throws InvalidSequenceException {

		int num = 1;

		boolean isCheck = false;

		for (int i = 0; i < password.length(); i++) {
			char n = password.charAt(i);
			num = 1;

			for (int j = i + 1; j < password.length(); j++) {
				if (n == password.charAt(j)) {
					isCheck = true;
				} else {
					isCheck = false;
				}
				if (isCheck) {
					num++;
				} else {
					num = 1;
				}
				if (num >= 3) {
					throw new InvalidSequenceException();
				}
			}
		}

		return false;
	}

	/*
	 * Return true if valid password (follows all the following rules), returns
	 * false if an invalid password 1. At least 6 characters long - 2. At least 1
	 * numeric character- 3. At least 1 uppercase alphabetic character - 4. At least
	 * 1 lowercase alphabetic character - 5. At least 1 special character - 6. No
	 * more than 2 of the same character in a sequence - Hello@123 – OK AAAbb@123 –
	 * not OK Aaabb@123 – OK
	 * 
	 * Parameters: password - - string to be checked for validity Returns: true if
	 * valid password (follows all rules from above), false if an invalid password
	 * Throws: LengthException - thrown if length is less than 6 characters
	 * NoUpperAlphaException - thrown if no uppercase alphabetic
	 * NoLowerAlphaException - thrown if no lowercase alphabetic NoDigitException -
	 * thrown if no digit NoSpecialCharacterException - thrown if does not meet
	 * SpecialCharacter requirement InvalidSequenceException - thrown if more than 2
	 * of same character.
	 */
	public static boolean isValidPassword​(java.lang.String password) throws LengthException, NoUpperAlphaException,
			NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {

		return (isValidLength​(password) && hasUpperAlpha​(password) && hasLowerAlpha​(password) && hasDigit​(password)
				&& hasSpecialChar​(password) && NoSameCharInSequence​(password));
	}

	/*
	 * checks if the password contains 6 to 9 characters
	 * 
	 * Parameters: password - password string to be checked for Returns: true if
	 * password contains 6 to 9 characters, false otherwise
	 */
	public static boolean hasBetweenSixAndNineChars​(java.lang.String password) {

		int numLength = password.length();

		return (numLength >= 6 && numLength <= 9);
	}

	/*
	 * Checks if password is VALID and the length is NOT between 6-9 characters
	 * 
	 * Parameters: password - string to be checked if weak password Returns: false
	 * if the password is valid and the length of password is NOT between 6 and 9
	 * (inclusive). Throws: WeakPasswordException - if length of password is between
	 * 6 and 9 (inclusive), ALTHOUGH the password may be VALID.
	 */
	public static boolean isWeakPassword​(String password) throws WeakPasswordException {

		if (!(hasBetweenSixAndNineChars​(password)))
			return false;
		else
			throw new WeakPasswordException();
	}

	/*
	 * This method will accept an ArrayList of passwords as the parameter and return
	 * an ArrayList with the status of any invalid passwords (weak passwords are not
	 * considered invalid). The ArrayList of invalid passwords will be of the
	 * following format: password BLANK message of the exception thrown
	 * 
	 * Parameters: passwords - list of passwords Returns: ArrayList of invalid
	 * passwords in the correct format
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {

		ArrayList<String> invalidPasswords = new ArrayList<>();

		for (int i = 0; i < passwords.size(); i++) {
			String goodPassword = passwords.get(i);
			try {
				if (isValidPassword​(goodPassword)) {
					passwords.remove(i);
					i--;
				}
			} catch (Exception e) {
				invalidPasswords.add(goodPassword + " " + e.getMessage());
			}
		}

		return invalidPasswords;
	}

}
