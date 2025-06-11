import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PasswordCheckerTest_STUDENT {
    ArrayList<String> passwords;
    String password1, password2;

    @Before
    public void setUp() throws Exception {
        passwords = new ArrayList<>();
        passwords.add("abc123"); // Add some test data
        passwords.add("StrongPass1$");
    }

    @After
    public void tearDown() throws Exception {
        passwords = null;
    }

    @Test
    public void testComparePasswords() {
        try {
            PasswordCheckerUtility.comparePasswords("password1", "password1");
            assertTrue("Passwords match, no exception expected.", true);
        } catch (UnmatchedException e) {
            assertTrue("Exception occurred while comparing passwords.", false);
        }
    }

    @Test
    public void testComparePasswordsWithReturn() {
        boolean result = PasswordCheckerUtility.comparePasswordsWithReturn("password123", "password123");
        assertTrue("Passwords should match.", result);

        result = PasswordCheckerUtility.comparePasswordsWithReturn("password123", "password124");
        assertFalse("Passwords should not match.", result);
    }

    @Test
    public void testIsValidLengthTooShort() {
        try {
            assertTrue(PasswordCheckerUtility.isValidLength​("abc12"));
        } catch (LengthException e) {
            assertTrue("Expected LengthException for short password.", true);
        } catch (Exception e) {
            assertTrue("Unexpected exception for short password.", false);
        }
    }

    @Test
    public void testHasUpperAlpha() {
        try {
            assertTrue(PasswordCheckerUtility.hasUpperAlpha​("Password123"));
        } catch (NoUpperAlphaException e) {
            assertTrue("Expected NoUpperAlphaException.", false);
        }
    }

    @Test
    public void testHasLowerAlpha() {
        try {
            assertTrue(PasswordCheckerUtility.hasLowerAlpha​("Password123"));
        } catch (NoLowerAlphaException e) {
            assertTrue("Expected NoLowerAlphaException.", false);
        }
    }

    @Test
    public void testHasDigit() {
        try {
            assertTrue(PasswordCheckerUtility.hasDigit​("Password123"));
        } catch (NoDigitException e) {
            assertTrue("Expected NoDigitException.", false);
        }
    }

    @Test
    public void testHasSpecialChar() {
        try {
            assertTrue(PasswordCheckerUtility.hasSpecialChar​("Password123$"));
        } catch (NoSpecialCharacterException e) {
            assertTrue("Expected NoSpecialCharacterException.", false);
        }
    }

    @Test
    public void testNoSameCharInSequence() {
        try {
            assertTrue(PasswordCheckerUtility.NoSameCharInSequence​("Paaassword123"));
        } catch (InvalidSequenceException e) {
            assertTrue("Expected InvalidSequenceException.", true);
        }
    }

    @Test
    public void testIsValidPasswordSuccess() {
        try {
            assertTrue(PasswordCheckerUtility.isValidPassword​("ValidPassword123$"));
        } catch (Exception e) {
            assertTrue("Unexpected exception for valid password.", false);
        }
    }

    @Test
    public void testIsValidPasswordFailure() {
        try {
            assertFalse(PasswordCheckerUtility.isValidPassword​("short"));
        } catch (Exception e) {
            assertTrue("Expected exception for invalid password.", true);
        }
    }

    @Test
    public void testGetInvalidPasswords() {
        ArrayList<String> invalidPasswords = PasswordCheckerUtility.getInvalidPasswords(passwords);
        assertNotNull("Invalid passwords list should not be null", invalidPasswords);
        assertTrue("List should contain invalid passwords.", invalidPasswords.size() > 0);
    }
}
