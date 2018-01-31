import static org.junit.jupiter.api.Assertions.*;
import java.lang.Math;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import junit.framework.TestCase;

class ArrayOperationsTestRandom extends TestCase {
	int[] randArr;
	int range = 10000; // Randomises integers in the range [-range, range]
	
	@BeforeEach
	protected void setUp() throws Exception {
		randArr = new int[20];
		for (int i = 0; i < randArr.length; i++){
			randArr[i] = (int)(Math.random() * range * 2) - range/2; 
		}
	}
	
	@AfterEach
	protected void tearDown() throws Exception {
		randArr = new int[20];
	}
	
	@Test
	void testSort() {
		ArrayOperations.sort(randArr);
		boolean sorted = true;
		for (int i = 0; i < randArr.length-1; i++) {
			if (randArr[i] > randArr[i+1]) {
				sorted = false;
				break;
			}
		} assertTrue(sorted);
	}
	
	@Test
	void testSearchSunny0() {
		ArrayOperations.sort(randArr);
		int key = randArr[(int)randArr.length/2];
		assertEquals((int)randArr.length/2, ArrayOperations.search(randArr, key));
	}
	
	@Test
	void testSearchRainy() {
		ArrayOperations.sort(randArr);
		int key = range+1; // This value can not exist in the array
		assertEquals(-1, ArrayOperations.search(randArr, key));
	}
	
	@Test
	void testSearchSunny1() {
		ArrayOperations.sort(randArr);
		int key = randArr[0];
		assertEquals(0, ArrayOperations.search(randArr, key));
	}
		
	@Test
	void testSearchSunny2() {
		ArrayOperations.sort(randArr);
		int key = randArr[randArr.length-1];
		assertEquals(randArr.length-1, ArrayOperations.search(randArr, key));
	}
	
	@Test
	void testMembershipUnsortedSunny() {
		int key = randArr[0];
		assertTrue(ArrayOperations.membershipUnsorted(randArr, key));
	}
	
	@Test
	void testMembershipUnsortedRainy() {
		int key = range + 1;
		assertFalse(ArrayOperations.membershipUnsorted(randArr, key));
	}
}