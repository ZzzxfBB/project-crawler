package com.iskeen.project.crawler.common.util;

import com.google.common.base.Strings;
import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.util.ObjectUtils;

public class AESUtil {

  private static String KEY = "aVbR9&os0j1@pcLm";

  private static String VI = "qM&3z#4梵de!l)X";

  // "算法/模式/补码方式"
  private static String TRANSFORMAT = "AES/CBC/PKCS5Padding";

  // 加密
  public static String encrypt(byte[] str) throws Exception {
    if (ObjectUtils.isEmpty(str)) {
      return "";
    }
    SecretKeySpec keySpec = new SecretKeySpec(KEY.getBytes(StandardCharsets.UTF_8), "AES");
    IvParameterSpec iv = new IvParameterSpec(VI.getBytes(StandardCharsets.UTF_8));
    Cipher cipher = Cipher.getInstance(TRANSFORMAT);
    cipher.init(Cipher.ENCRYPT_MODE, keySpec, iv);
    byte[] encrypted = cipher.doFinal(str);
    StringBuilder sb = new StringBuilder(encrypted.length);
    for (byte b : encrypted) {
      sb.append(String.format("%02x", b));
    }
    return sb.toString();
  }

  // 加密
  public static String encrypt(String str) throws Exception {
    if (Strings.isNullOrEmpty(str)) {
      return "";
    }
    SecretKeySpec keySpec = new SecretKeySpec(KEY.getBytes(StandardCharsets.UTF_8), "AES");
    IvParameterSpec iv = new IvParameterSpec(VI.getBytes(StandardCharsets.UTF_8));
    Cipher cipher = Cipher.getInstance(TRANSFORMAT);
    cipher.init(Cipher.ENCRYPT_MODE, keySpec, iv);
    byte[] encrypted = cipher.doFinal(str.getBytes(StandardCharsets.UTF_8));
    StringBuilder sb = new StringBuilder(encrypted.length);
    for (byte b : encrypted) {
      sb.append(String.format("%02x", b));
    }
    return sb.toString();
  }

  // 解密
  public static byte[] decryptToByte(String str) throws Exception {
    if (Strings.isNullOrEmpty(str)) {
      return new byte[0];
    }

    SecretKeySpec keySpec = new SecretKeySpec(KEY.getBytes(StandardCharsets.UTF_8), "AES");
    IvParameterSpec iv = new IvParameterSpec(VI.getBytes(StandardCharsets.UTF_8));
    Cipher cipher = Cipher.getInstance(TRANSFORMAT);
    cipher.init(Cipher.DECRYPT_MODE, keySpec, iv);
    byte[] original = cipher.doFinal(hexStrToByte(str));
    return original;
  }

  // 解密
  public static String decrypt(String str) throws Exception {
    if (Strings.isNullOrEmpty(str)) {
      return "";
    }

    SecretKeySpec keySpec = new SecretKeySpec(KEY.getBytes(StandardCharsets.UTF_8), "AES");
    IvParameterSpec iv = new IvParameterSpec(VI.getBytes(StandardCharsets.UTF_8));
    Cipher cipher = Cipher.getInstance(TRANSFORMAT);
    cipher.init(Cipher.DECRYPT_MODE, keySpec, iv);
    byte[] original = cipher.doFinal(hexStrToByte(str));
    return new String(original, StandardCharsets.UTF_8);
  }

  /**
   * 将16进制转换为二进制
   *
   * @param hexStr
   * @return
   */
  public static byte[] hexStrToByte(String hexStr) {
    if (hexStr == null || hexStr.length() == 0) {
      return null;
    }
    byte[] result = new byte[hexStr.length() / 2];
    for (int i = 0; i < hexStr.length() / 2; i++) {
      int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
      int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
      result[i] = (byte) (high * 16 + low);
    }
    return result;
  }
}
