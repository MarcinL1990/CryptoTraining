package eu.szestkam.cryptotraining.cesar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CesarCipherTest {

    public static final String SAMPLE_PHRASE = "sample";
    private CesarCipher cipherNoArg;
    private CesarCipher cipherPhrase;

    @BeforeEach
    void setUp() {
        cipherNoArg = new CesarCipher();
        cipherPhrase = new CesarCipher(SAMPLE_PHRASE);
    }

    @DisplayName("Correct cipher instance with no args")
    @Test
    public void testCezarExist() {
        CesarCipher cipher = cipherNoArg;
        assertNotNull(cipher);
    }

    @DisplayName("Correct cipher instance with no phrase")
    @Test
    public void testPassStringToConstructor() {
        CesarCipher cipher = cipherNoArg;
        assertNotNull(cipher);
    }

    @Test
    public void testEncrypWhenNoTextThenEnptyString() {
        CesarCipher cipher = cipherNoArg;
        String encoded = cipher.encode();

        assertNotNull(encoded);
        assertEquals("", encoded);
    }

    @Test
    public void testEncryptWhenTextSameLengthOfString() {
        CesarCipher cipher = cipherPhrase;
        String encoded = cipher.encode();

        assertNotNull(encoded);
        assertEquals(SAMPLE_PHRASE.length(),encoded.length());
    }

    @Test
    public void testSimpleEncodeLowerCase() {
        CesarCipher cipher = new CesarCipher("abc");
        String code = "def";
        String encoded = cipher.encode();

        assertEquals(code, encoded);

        cipher = new CesarCipher("xyz");
        code = "abc";
        encoded = cipher.encode();
        assertEquals(code, encoded);
    }

    @Test
    public void testSimpleEncodeMixedCase() {
        CesarCipher cipher = new CesarCipher("abC");
        String code = "deF";
        String encoded = cipher.encode();

        assertEquals(code, encoded);

        cipher = new CesarCipher("XYz");
        code = "ABc";
        encoded = cipher.encode();
        assertEquals(code, encoded);
    }
}