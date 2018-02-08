import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayOperationsTestPairwise {
	int[] pairwiseArr1;
	int[] pairwiseArr2;
	int[] pairwiseArr3;
	int key1;
	int key2;
	int arrLen = 20;

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("--------------------");
		pairwiseArr1 = new int[arrLen];
		pairwiseArr2 = new int[0];
		pairwiseArr3 = new int[arrLen];
		pairwiseArr3 = new int[]{-1568, 10, 6083, 10569, 9670, 7901, 8454, 1584, 5549, -1103, 5479, 14022, 13242, -1848, -332, 10463, 4517, 999, 9583, -1359};
		for (int i = 0; i < arrLen; i++) {
			pairwiseArr1[i] = i;
		}
		key1 = 10;
		key2 = 200;
	}

	@AfterEach
	void tearDown() throws Exception {
		pairwiseArr1 = new int[arrLen];
		pairwiseArr2 = new int[0];
		pairwiseArr3 = new int[arrLen];
		key1 = 0;
		key2 = 0;
	}

	@Test
	void testSortSunny0() {
		ArrayOperations.sort(pairwiseArr1);
		boolean sorted = true;
		for (int i = 0; i < arrLen - 1; i++) {
			if (pairwiseArr1[i] > pairwiseArr1[i+1]) {
				sorted = false;
				break;
			}
		} assertTrue(sorted);
	}
	
	@Test
	void testSortSunny1() {
		ArrayOperations.sort(pairwiseArr3);
		boolean sorted = true;
		for (int i = 0; i < arrLen - 1; i++) {
			if (pairwiseArr3[i] > pairwiseArr3[i+1]) {
				sorted = false;
				break;
			}
		} assertTrue(sorted);
	}
	
	@Test
	void testSortRainy() {
		try {
			ArrayOperations.sort(pairwiseArr2);
			fail("Exception not thrown"); // Fail if an exception has not been caught"
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().equals("Array must not be empty"));
			return;
		}
		fail ("Wrong exception thrown");
	}
	
	@Test
	void testSearchSunny0() {
		ArrayOperations.sort(pairwiseArr1);
		assertTrue(ArrayOperations.search(pairwiseArr1, key1) >= 0); // The key has been found
	}
	
	@Test
	void testSearchSunny1() {
		ArrayOperations.sort(pairwiseArr3);
		assertTrue(ArrayOperations.search(pairwiseArr3, key1) >= 0); // The key has been found
	}
	
	@Test
	void testSearchRainy0() {
		ArrayOperations.sort(pairwiseArr1);
		assertEquals(ArrayOperations.search(pairwiseArr1, key2), -1);
	}
	
	@Test
	void testSearchRainy1() {
		try {
			ArrayOperations.sort(pairwiseArr2);
			ArrayOperations.search(pairwiseArr2, key1);
			fail("Exception not thrown"); // Fail if an exception has not been caught"
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().equals("Array must not be empty"));
			return;
		}
		fail ("Wrong exception thrown");
	}
	
	@Test
	void testSearchRainy2() {
		try {
			ArrayOperations.sort(pairwiseArr2);
			ArrayOperations.search(pairwiseArr2, key2);
			fail("Exception not thrown"); // Fail if an exception has not been caught"
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().equals("Array must not be empty"));
			return;
		} 
		fail ("Wrong exception thrown");
	}
	
	@Test
	void testSearchRainy3() {
		ArrayOperations.sort(pairwiseArr3);
		assertEquals(ArrayOperations.search(pairwiseArr3, key2), -1);
	}
	
	@Test
	void testMembershipUnsortedSunny0() {
		assertTrue(ArrayOperations.membershipUnsorted(pairwiseArr1, key1));
	}
	
	@Test
	void testMembershipUnsortedSunny1() {
		assertTrue(ArrayOperations.membershipUnsorted(pairwiseArr3, key1));
	}
	
	@Test
	void testMembershipUnsortedRainy0() {
		assertFalse(ArrayOperations.membershipUnsorted(pairwiseArr1, key2));
	}
	
	@Test
	void testMembershipUnsortedRainy1() {
		try {
			ArrayOperations.membershipUnsorted(pairwiseArr2, key1);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().equals("Array must not be empty"));
			return;
		}
		fail ("Wrong exception thrown");
	}
	
	@Test
	void testMembershipUnsortedRainy2() {
		try {
			ArrayOperations.membershipUnsorted(pairwiseArr2, key2);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().equals("Array must not be empty"));
			return;
		}
		fail ("Wrong exception thrown");
	}
	
	@Test
	void testMembershipUnsortedRainy3() {
		assertFalse(ArrayOperations.membershipUnsorted(pairwiseArr3, key2));
	}
}
