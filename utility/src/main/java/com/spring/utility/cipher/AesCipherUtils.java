package com.spring.utility.cipher;


import com.spring.utility.exception.SuddenException;
import lombok.experimental.UtilityClass;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


@UtilityClass
public class AesCipherUtils {

    private static final String KEY = "7E545B89ADABEA7E";
    private final byte[] biv = {0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x0A, 0x0B, 0x0C, 0x0D, 0x0E, 0x0F, 0x10};
    private final IvParameterSpec iv = new IvParameterSpec(biv);
    private final SecretKeySpec secureKey;

    static {
        try {
            secureKey = new SecretKeySpec(KEY.getBytes("UTF-8"), "AES");
        } catch (UnsupportedEncodingException e) {
            throw new SuddenException(e);
        }
    }

    private byte[] encrypt(String str) {
        Cipher cipher;
        try {
            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secureKey, iv);
            return cipher.doFinal(str.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException | UnsupportedEncodingException e) {
            throw new CipherException(e);
        }
    }


    public String encryptHex(String str) {
        return new String(Hex.encodeHex(encrypt(str))).toUpperCase();
    }


    public String encryptBase64(String str) {
        return Base64.encodeBase64URLSafeString(encrypt(str));
    }


    public String decrypt(String str) {
        return decrypt(new java.math.BigInteger(str, 16).toByteArray());
    }


    public String decrypt(byte[] b) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secureKey, iv);
            return new String(cipher.doFinal(b), "UTF-8");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException | UnsupportedEncodingException e) {
            throw new CipherException(e);
        }
    }


    public String decryptBase64(String str) {
        return decrypt(Base64.decodeBase64(str));
    }


    public String decriptHex(String str) {
        try {
            return decrypt(Hex.decodeHex(str.toCharArray()));
        } catch (DecoderException e) {
            throw new CipherException(e);
        }
    }

}
