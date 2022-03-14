package no.hvl.dat110.unit.tests;



import static org.junit.jupiter.api.Assertions.*;

import java.math.BigInteger;
import java.rmi.RemoteException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat110.util.Hash;

class DHTTestHashFunction {
	
	@BeforeEach
	void setUp() throws Exception {
		

	}

	@Test
	void test() throws InterruptedException, RemoteException {
		
		// actual
		BigInteger hash1 = Hash.hashOf("process1");
		BigInteger hash2 = Hash.hashOf("process2");
		BigInteger hash3 = Hash.hashOf("process3"); 
		BigInteger hash4 = Hash.hashOf("process4"); 
		BigInteger hash5 = Hash.hashOf("process5"); 
		
		// expected
		BigInteger hash1expected = new BigInteger("53937554629190552131995290006614509577");
		BigInteger hash2expected = new BigInteger("15618062003214643351512781541041391612");
		BigInteger hash3expected = new BigInteger("66910184482037901621933403444034052414");
		BigInteger hash4expected = new BigInteger("210821560651360572675896360671414673172");
		BigInteger hash5expected = new BigInteger("121411138451101288395601026024677976156");

		
		assertEquals(hash1, hash1expected);
		assertEquals(hash2, hash2expected);
		assertEquals(hash3, hash3expected);
		assertEquals(hash4, hash4expected);
		assertEquals(hash5, hash5expected);
		
	}

}
