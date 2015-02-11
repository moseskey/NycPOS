package com.openbravo.pos.util;

import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.binary.Base64;

public class Base64Encoder {

    public static byte[] decode(String base64) {

        try {
            return Base64.decodeBase64(base64.getBytes("ASCII"));
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    public static String encode(byte[] raw) {
        try {
            return new String(Base64.encodeBase64(raw), "ASCII");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    public static String encodeChunked(byte[] raw) {
        try {
            return new String(Base64.encodeBase64Chunked(raw), "ASCII");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }
}
