package eu.szestkam.cryptotraining.rot_13;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

    public class Rot13CipherTest {

        private static final String SAMPLE_PHRASE = "sample";
        private Rot13Cipher cipherNoArg;
        private Rot13Cipher cipherPhrase;

        @BeforeEach
        void setUp() {
            cipherNoArg = new Rot13Cipher();
            cipherPhrase = new Rot13Cipher(SAMPLE_PHRASE);
        }

        @DisplayName("Correct cipher instance with no args")
        @Test
        public void testIfCesarExist() {
            Rot13Cipher cipher = cipherNoArg;
            assertNotNull(cipher);
        }

        @DisplayName("Correct cipher instance with phrase")
        @Test
        public void testPassStringToConstructor() {
            Rot13Cipher cipher = cipherPhrase;
            assertNotNull(cipher);
        }

        @Test
        public void testEncrypWhenNoTextThenEmptyString() {
            Rot13Cipher cipher = cipherNoArg;
            String encoded = cipher.encode();

            assertNotNull(encoded);
            assertEquals("", encoded);
        }

        @Test
        public void testEncrypWhenTextThenSameLenghtOfString() {
            Rot13Cipher cipher = cipherPhrase;
            String encoded = cipher.encode();

            assertNotNull(encoded);
            assertEquals(SAMPLE_PHRASE.length(), encoded.length());
        }

        @Test
        public void testSimpleEncodeLowerCase() {
            Rot13Cipher cipher = new Rot13Cipher("abc");
            String code = "nop";
            String encoded = cipher.encode();
            assertEquals(code, encoded);

            cipher = new Rot13Cipher("xyz");
            code = "klm";
            encoded = cipher.encode();
            assertEquals(code, encoded);
        }

        @Test
        public void testSimpleEncodeMixedCase() {
            Rot13Cipher cipher = new Rot13Cipher("abC");
            String code = "noP";
            String encoded = cipher.encode();
            assertEquals(code, encoded);

            cipher = new Rot13Cipher("XYz");
            code = "KLm";
            encoded = cipher.encode();
            assertEquals(code, encoded);
        }

        @Test
        public void testDecrypWhenNoTextThenEmptyString() {
            Rot13Cipher cipher = cipherNoArg;
            String decoded = cipher.decrypt();

            assertNotNull(decoded);
            assertEquals("", decoded);
        }
        @Test
        public void testSimpleDecodeMixedCase() {
            Rot13Cipher cipher = new Rot13Cipher("deF");
            String code = "qrS";
            String encoded = cipher.encode();
            assertEquals(code, encoded);

            cipher = new Rot13Cipher("ABc");
            code = "NOp";
            encoded = cipher.encode();
            assertEquals(code, encoded);

            cipher = new Rot13Cipher("ABza");
            code = "NOmn";
            encoded = cipher.encode();
            assertEquals(code, encoded);
        }
}