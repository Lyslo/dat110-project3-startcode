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
        
        digest = toHex(theMD5digest).toString();

        // convert the hex into BigInteger

        hashint = new BigInteger(digest, 16);

        // return the BigInteger

        return hashint;
    }

    public static BigInteger addressSize() {

        // Task: compute the address size of MD5

        // get the digest length
        // compute the number of bits = digest length * 8(*8 siden digest length
        // returner i bytes-vilde)
        int nrBits = bitSize();
        // compute the address size = 2 ^ number of bits
        int Str = (int) Math.pow(2, nrBits);
        // return the address size
//		BigInteger addressSize = BigInteger.valueOf(Str);
        BigInteger addressSize = (BigInteger.ONE.add(BigInteger.ONE)).pow(nrBits);
        return addressSize;
    }

    public static int bitSize() {

        int digestlen = 0;

        try {
            digestlen = MessageDigest.getInstance("MD5").getDigestLength();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

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
