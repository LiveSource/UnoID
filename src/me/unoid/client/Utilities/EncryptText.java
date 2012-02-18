package me.unoid.client.Utilities;

import com.googlecode.gwt.crypto.bouncycastle.DataLengthException;
import com.googlecode.gwt.crypto.bouncycastle.InvalidCipherTextException;
import com.googlecode.gwt.crypto.client.TripleDesCipher;

public class EncryptText {

	public static String encrypt(final String text) {

		String encryptedText = null;

		TripleDesCipher cipher = new TripleDesCipher();

		cipher.setKey("GWT_DES_KEY_16_BYTES".getBytes());

		try {

			encryptedText = cipher.encrypt(String.valueOf(text));

		} catch (DataLengthException e1) {
			e1.printStackTrace();
		} catch (IllegalStateException e1) {
			e1.printStackTrace();
		} catch (InvalidCipherTextException e1) {
			e1.printStackTrace();
		}

		return encryptedText;
	}

	public static String decrypt(final String encryptedText) {

		String decryptedtext = null;

		if (encryptedText != null) {

			TripleDesCipher cipher = new TripleDesCipher();

			cipher.setKey("GWT_DES_KEY_16_BYTES".getBytes());

			try {

				decryptedtext = cipher.decrypt(encryptedText);

			} catch (DataLengthException e1) {
				e1.printStackTrace();
			} catch (IllegalStateException e1) {
				e1.printStackTrace();
			} catch (InvalidCipherTextException e1) {
				e1.printStackTrace();
			}
		}

		return decryptedtext;
	}

}
