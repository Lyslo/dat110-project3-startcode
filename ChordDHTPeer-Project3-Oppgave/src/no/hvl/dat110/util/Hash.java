package no.hvl.dat110.util;

/**
 * project 3
 *
 * @author tdoy
 */

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

    private static BigInteger hashint;

    public static BigInteger hashOf(String entity) {

        // Task: Hash a given string using MD5 and return the result as a BigInteger.

		String digest = null;

        // we use MD5 with 128 bits digest

        // compute the hash of the input 'entity'

        byte[] bytesOfMessage = new byte[0];
        try {
            bytesOfMessage = entity.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] theMD5digest = md.digest(bytesOfMessage);

        // convert the hash into hex format

		StringBuilder sb = new StringBuilder(2*theMD5digest.length);
		for (byte b : theMD5digest){
			sb.append(String.format("%02x", b&0xff));
		}

		digest = sb.toString();

        // convert the hex into BigInteger

		hashint = new BigInteger(digest, 16);

        // return the BigInteger

        return hashint;
    }

    public static BigInteger addressSize() {

        // Task: compute the address size of MD5

        // get the digest length

        // compute the number of bits = digest length * 8

        // compute the address size = 2 ^ number of bits

        // return the address size

        return null;
    }

    public static int bitSize() {

        int digestlen = 0;

        // find the digest length

        return digestlen * 8;
    }

    public static String toHex(byte[] digest) {
        StringBuilder strbuilder = new StringBuilder();
        for (byte b : digest) {
            strbuilder.append(String.format("%02x", b & 0xff));
        }
        return strbuilder.toString();
    }

}
