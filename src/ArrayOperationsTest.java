import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

class ArrayOperationsTest {
    int[] a;
    int index;
    boolean sorted;

    @BeforeEach
    void setUp(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        a = new int[20];
        sorted = true;
        index = repetitionInfo.getCurrentRepetition()-1;;
        System.out.println("Current repetition: " + index);
        a[index] = 1;

        String methodName = testInfo.getTestMethod().get().getName();

        if(methodName.equals("testMembershipUnsortedConstantOneFirstMovingOneFindOne") ||
                methodName.equals("testMembershipUnsortedConstantOneFirstMovingOneFindTwo") ||
                methodName.equals("testSortConstantOneFirstMovingOne")){
            a[0] = 1;
        }

        if(methodName.equals("testMembershipUnsortedAllZerosFindOne")){
            a[0] = 0;
        }

        if(methodName.equals("testSortConstantOneFirstMovingTwo")){
            a[0] = 1;
            a[index] = 2;
        }

        System.out.println("First value in array: " + a[0]);
        System.out.println("Second value in array: " + a[1]);

    }

    // Below are 83 tests of the membershipUnsorted method
    @RepeatedTest(1)
    void testMembershipUnsortedAllZerosFindZero() {
        assertTrue(ArrayOperations.membershipUnsorted(a, 0));
    }

    @RepeatedTest(1)
    void testMembershipUnsortedAllZerosFindOne() {
        assertFalse(ArrayOperations.membershipUnsorted(a, 1));
    }

    @RepeatedTest(1)
    void testMembershipUnsortedEmptyArray() {
        int [] b = new int[0];
        try {
            ArrayOperations.membershipUnsorted(b, 1);
            fail("Exception not thrown"); // Fail if an exception has not been caught"
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().equals("Array must not be empty"));
            return;
        }
        fail ("Wrong exception thrown");
    }

    @RepeatedTest(20)
    void testMembershipUnsortedMovingOneFindOne() {
        assertTrue(ArrayOperations.membershipUnsorted(a, 1));
    }

    @RepeatedTest(20)
    void testMembershipUnsortedMovingOneFindTwo() {
        assertFalse(ArrayOperations.membershipUnsorted(a, 2));
    }

    @RepeatedTest(20)
    void testMembershipUnsortedConstantOneFirstMovingOneFindOne() {
        assertTrue(ArrayOperations.membershipUnsorted(a, 1));
    }

    @RepeatedTest(20)
    void testMembershipUnsortedConstantOneFirstMovingOneFindTwo() {
        assertFalse(ArrayOperations.membershipUnsorted(a, 2));
    }

    // Below are 61 tests of the sort method
    @RepeatedTest(20)
    public void testSortFirstMovingOne() {
        ArrayOperations.sort(a);
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i+1]) {
                sorted = false;
                break;
            }
        } assertTrue(sorted);
    }

    @RepeatedTest(20)
    public void testSortConstantOneFirstMovingOne() {
        ArrayOperations.sort(a);
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i+1]) {
                sorted = false;
                break;
            }
        } assertTrue(sorted);
    }

    @RepeatedTest(20)
    public void testSortConstantOneFirstMovingTwo() {
        ArrayOperations.sort(a);
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i+1]) {
                sorted = false;
                break;
            }
        } assertTrue(sorted);
    }

    @RepeatedTest(1)
    public void testSortEmptyArray() {
        int [] b = new int[0];
        try {
            ArrayOperations.sort(b);
            fail("Exception not thrown"); // Fail if an exception has not been caught"
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().equals("Array must not be empty"));
            return;
        }
        fail ("Wrong exception thrown");
    }

}