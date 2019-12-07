package net.frank.commons.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public final class EncryptUtils {

    private static transient Logger log = LoggerFactory.getLogger(EncryptUtils.class);

    private static final String DEFAULT_KEY="net.frank.f3ew2k";

    private static final char MASK = '#';
    private static final int _MASK = (int) MASK;

    private EncryptUtils(){

    }

    public static String encodeAES(String input){
        return encodeAES(input, DEFAULT_KEY);
    }

    public static String encodeAES(String input, String aesKey ){
        return AesEncryptImplUtils.getInstance().encode(input,aesKey);
    }

    public static String decodeAES(String input){
        return decodeAES(input, DEFAULT_KEY);
    }

    public static String decodeAES(String input, String aesKey ){
        return AesEncryptImplUtils.getInstance().decode(input,aesKey);
    }

    public static String encodeDES(String input) {
        return encodeDES(input, DEFAULT_KEY);
    }

    public static String encodeDES(String input, String desKey) {
        int len = input.length();
        input = len % 8 > 0 ? fillMask(MASK, 8 * (len / 8 + 1), input) : input;
        try {
            return DesEncryptImplUtils.getInstance().encrypt(input, desKey);
        } catch (Exception e) {
            log.error("encode error", e);
        }
        return null;
    }

    public static String decodeDES(String input) {
        return decodeDES(input, DEFAULT_KEY);
    }

    public static String decodeDES(String input, String desKey) {
        try {
            String s = DesEncryptImplUtils.getInstance().decrypt(input, desKey);
            byte[] tk = s.getBytes();
            int len = tk.length;
            StringBuilder sb = new StringBuilder();
            boolean isBegin = false;
            for (int i = 0; i < len; i++) {
                if (!isBegin && tk[i] != _MASK) {
                    isBegin = true;
                }
                if (isBegin) {
                    sb.append((char) tk[i]);
                }
            }
            return sb.toString();
        } catch (Exception e) {
            log.error("decode error", e);
        }
        return null;
    }

    public static String fillMask(char mask, int length, String input) {
        final int inputLen = input.length();
        if (inputLen >= length) {
            return input;
        }
        int maskLen = length - inputLen;
        char[] chars = new char[maskLen];
        for (int i = 0; i < maskLen; i++) {
            chars[i] = mask;
        }
        return new String(chars) + input;
    }

    interface KEY_ALGORITHM{
        String DES = "DES";
        String AES = "AES";
    }

    interface SECURE_RANDOM{
        String AES = "SHA1PRNG";
    }

    interface CIPHER_ALGORITHM{
        String DES = "DES/ECB/NoPadding";
        String AES = "AES/ECB/PKCS5Padding";
    }



    private static final class DesEncryptImplUtils {
        private static DesEncryptImplUtils des;

        private DesEncryptImplUtils(){}

        static DesEncryptImplUtils getInstance() {
            if (null == des) {
                des = new DesEncryptImplUtils();
            }
            return des;
        }

        private SecretKey keyGenerator(String keyStr) throws Exception {
            byte input[] = HexString2Bytes(keyStr);
            DESKeySpec desKey = new DESKeySpec(input);
            // 创建一个密匙工厂，然后用它把DESKeySpec转换成
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_ALGORITHM.DES);
            return  keyFactory.generateSecret(desKey);
        }

        private int parse(char c) {
            if (c >= 'a')
                return (c - 'a' + 10) & 0x0f;
            if (c >= 'A')
                return (c - 'A' + 10) & 0x0f;
            return (c - '0') & 0x0f;
        }

        private byte[] HexString2Bytes(String hexstr) {
            byte[] b = new byte[hexstr.length() / 2];
            int j = 0;
            for (int i = 0; i < b.length; i++) {
                char c0 = hexstr.charAt(j++);
                char c1 = hexstr.charAt(j++);
                b[i] = (byte) ((parse(c0) << 4) | parse(c1));
            }
            return b;
        }


        String encrypt(String data, String key) throws Exception {
            Key D3e9s7Key = keyGenerator(key);
            // 实例化Cipher对象，它用于完成实际的加密操作
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM.DES);
            SecureRandom random = new SecureRandom();
            // 初始化Cipher对象，设置为加密模式
            cipher.init(Cipher.ENCRYPT_MODE, D3e9s7Key, random);
            byte[] results = cipher.doFinal(data.getBytes());
            // 执行加密操作。加密后的结果通常都会用Base64编码进行传输
            return new String(Base64.getEncoder().encode(results), StandardCharsets.ISO_8859_1);
        }

        String decrypt(String data, String key) throws Exception {
            Key D3e9s7Key = keyGenerator(key);
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM.DES);
            // 初始化Cipher对象，设置为解密模式
            cipher.init(Cipher.DECRYPT_MODE, D3e9s7Key);
            // 执行解密操作
            return new String(cipher.doFinal(Base64.getDecoder().decode(data)));
        }
    }

    private static final class AesEncryptImplUtils {
        private static AesEncryptImplUtils aes;

        private AesEncryptImplUtils(){}
        static AesEncryptImplUtils getInstance() {
            if (null == aes) {
                aes = new AesEncryptImplUtils();
            }
            return aes;
        }

        private byte[] execute(int execMode,byte[] content,String encodeRules){
            try {
                KeyGenerator keygen = KeyGenerator.getInstance(KEY_ALGORITHM.AES);
                SecureRandom random = SecureRandom.getInstance(SECURE_RANDOM.AES);
                random.setSeed(encodeRules.getBytes());
                keygen.init(128, random);
                SecretKey originalKey = keygen.generateKey();
                byte[] raw = originalKey.getEncoded();
                SecretKey key = new SecretKeySpec(raw, KEY_ALGORITHM.AES);
                Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM.AES);
                cipher.init(execMode, key);
                return  cipher.doFinal(content);
            }catch (NoSuchAlgorithmException | NoSuchPaddingException |InvalidKeyException |BadPaddingException |IllegalBlockSizeException  e) {
                e.printStackTrace();
            }
            return null;
        }

        String encode(String content,String encodeRules) {

            byte[] result = execute(Cipher.ENCRYPT_MODE,
                    content.getBytes(StandardCharsets.UTF_8),encodeRules);
            if(result!=null){
                return new String(Base64.getEncoder().encode(result));
            }
            return null;
        }

        String decode(String content,String encodeRules){
            byte[] decodeBase64 = Base64.getDecoder().decode(content);
            byte[] result = execute(Cipher.DECRYPT_MODE,decodeBase64,encodeRules);
            if(result!=null){
                return new String(result,StandardCharsets.UTF_8);
            }
            return null;
        }

    }
}