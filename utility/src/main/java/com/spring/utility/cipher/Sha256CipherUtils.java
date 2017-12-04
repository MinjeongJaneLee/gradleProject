package com.spring.utility.cipher;


import lombok.experimental.UtilityClass;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;


@UtilityClass
public class Sha256CipherUtils {

    public String encryptBase64(String str) {
        return Base64.encodeBase64URLSafeString(DigestUtils.sha256(str));
    }


    public String encryptHex(String str) {
        return Hex.encodeHexString(DigestUtils.sha256(str));
    }


    public String encrypt(String str) {
        return StringUtils.newStringUtf8(DigestUtils.sha256(str));
    }

}
