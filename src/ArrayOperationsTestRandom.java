import static org.junit.jupiter.api.Assertions.*;
import java.lang.Math;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import junit.framework.TestCase;

public class ArrayOperationsTestRandom extends TestCase {
	int[] randArr;
	int range = 10000; // Randomises integers in the range [-range, range]
	int arrSize;
	int nrTestRuns = 100; // # of times every test should be run
	int nrTestCases = 7; // # of tests in the class
	static int testsort = 0;
	
	@BeforeEach
	protected void setUp() throws Exception {
		arrSize = (int)(Math.random()*20);
		randArr = new int[arrSize];
		for (int i = 0; i < randArr.length; i++){
			randArr[i] = (int)(Math.random() * range * 2) - range; 
		}
	}
	
	@AfterEach
	protected void tearDown() throws Exception {
		randArr = new int[20];
		arrSize = 0;
	}
	
	@Test
	public void testAll() throws Exception {
		for (int i = 0; i < nrTestRuns - nrTestCases; i++) {
			setUp();
			subTest(i);
			tearDown();
		}
	}
	
	public void subTest(int i) {
		switch (i % nrTestCases) {
		case 0: testSort(); break;
		case 1: testSearchSunny0(); break;
		case 2: testSearchRainy(); break;
		case 3: testSearchSunny1(); break;
		case 4: testSearchSunny2(); break;
		case 5: testMembershipUnsortedSunny(); break;
		case 6: testMembershipUnsortedRainy(); break;
		default: break;
		}
	}
	
	@Test
	public void testSort() {
		testsort++;
		System.out.println("testsort: " + testsort);
		try {
			ArrayOperations.sort(randArr);
			boolean sorted = true;
			for (int i = 0; i < randArr.length-1; i++) {
				if (randArr[i] > randArr[i+1]) {
					sorted = false;
					break;
				}
			} assertTrue(sorted);
		} catch (IllegalArgumentException e) {
			// We randomised an array with size 0. 
		}
	}
	
	@Test
	public void testSearchSunny0() {
		try {
			ArrayOperations.sort(randArr);
			int key = randArr[(int)randArr.length/2];
			assertEquals((int)randArr.length/2, ArrayOperations.search(randArr, key));
		} catch (IllegalArgumentException e) {
			// We randomised an array with size 0. 
		}
	}
	
	@Test
	public void testSearchRainy() {
		try {
			ArrayOperations.sort(randArr);
			int key = range+1; // This value can not exist in the array
			assertEquals(-1, ArrayOperations.search(randArr, key));
		} catch (IllegalArgumentException e) {
			// We randomised an array with size 0.
		}
	}
	
	@Test
	public void testSearchSunny1() {
		try {
			ArrayOperations.sort(randArr);
			int key = randArr[0];
			assertEquals(0, ArrayOperations.search(randArr, key));
		} catch (IllegalArgumentException e) {
			// We randomised an array with size 0.
		} catch (ArrayIndexOutOfBoundsException e) {
			// We randomised an array with size 0.
		}
	}
		
	@Test
	public void testSearchSunny2() {
		try {
			ArrayOperations.sort(randArr);
			int key = randArr[randArr.length-1];
			assertEquals(randArr.length-1, ArrayOperations.search(randArr, key));
		} catch (IllegalArgumentException e) {
			// We randomised an array with size 0.
		}
	}
	
	@Test
	public void testMembershipUnsortedSunny() {
		try {
			int key = randArr[0];
			if (ArrayOperations.membershipUnsorted(randArr, key) == true) {
				assertTrue(ArrayOperations.membershipUnsorted(randArr, key));
			} else {
				System.out.println("length: " + randArr.length);
				System.out.println("key: " + key);
				System.out.print("RandArr: ");
				for (int i = 0; i < randArr.length; i++) {
					System.out.print(randArr[i] + ", ");
				}
				fail();
			}
		} catch (IllegalArgumentException e) {
			// We randomised an array with size 0.
		} catch (ArrayIndexOutOfBoundsException e) {
			// We randomised an array with size 0.
		}
	}
	
	@Test
	public void testMembershipUnsortedRainy() {
		try {
			int key = range + 1;
			assertFalse(ArrayOperations.membershipUnsorted(randArr, key));
		} catch (IllegalArgumentException e) {
			// We randomised an array with size 0.
		}
	}
}