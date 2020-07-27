import com.jiadong.Array.*;
import org.junit.Test;

import java.util.ArrayList;

public class JunitTestForArray {

    @Test
    public void test1() {
        int[] arrays1 = new int[]{1,2,3,4,6,7};
        int[] arrays2 = new int[]{1,2,3,4,5,6,7,8,9};

        MissingNumberInArray1 missingNumberInArray = new MissingNumberInArray1();
        System.out.println(missingNumberInArray.getMissingNum(arrays1, 7));
        System.out.println(missingNumberInArray.getMissingNum(arrays2, 10));

    }

    @Test
    public void test2(){
        int[] arrays1 = new int[]{1,2,3,3,4,6,7};
        int[] arrays2 = new int[]{1,8,2,3,4,5,5,6,7,8,9};

        FindingDublicatesNum2 findingDublicatesNum2 = new FindingDublicatesNum2();
        ArrayList dubNums1 = findingDublicatesNum2.findDubNum(arrays1);
        ArrayList dubNums2 = findingDublicatesNum2.findDubNum(arrays2);

        for (int i = 0; i < dubNums1.size(); i++) {
            System.out.println(dubNums1.get(i));
        }

        for (int i = 0; i < dubNums2.size(); i++) {
            System.out.println(dubNums2.get(i));
        }
    }

    @Test
    public void test3(){
        int[] arrays1 = new int[]{1,22,3,3,4,6,7};
        int[] arrays2 = new int[]{1,8,2,3,4,50,5,6,7,8,9};

        MaximumMinimumArray3 maximumMinimumArray3 = new MaximumMinimumArray3();
        System.out.println(maximumMinimumArray3.largetAndSmallest(arrays1));
        System.out.println(maximumMinimumArray3.largetAndSmallest(arrays2));


    }

    @Test
    public void test4() {
        int[] arrays1 = new int[]{1, 22, 3, 3, 4, 6, 7};
        int[] arrays2 = new int[]{1, 8, 2, 3, 4, 50, 5, 6, 7, 8, 9};

        FindPairs4 findPairs4 = new FindPairs4();
        System.out.println(findPairs4.findPair(arrays1, 23));
        System.out.println(findPairs4.findPair(arrays2, 17));
    }

    @Test
    public void test5() {
        int[] arrays1 = new int[]{15, 22, 3, 10, 4, 6, 7};
        int[] arrays2 = new int[]{1, 8, 2, 3, 4, 50, 5, 6, 2, 8, 9};

        QuickSor7 quickSor7 = new QuickSor7() ;
        quickSor7.sort(arrays2, 0, arrays2.length -1);

        for (int array : arrays2) {
            System.out.print(array + ", ");
        }
    }


    @Test
    public void test6() {
        int[] arrays1 = new int[]{15, 22, 3, 10, 4, 6, 7};
        int[] arrays2 = new int[]{1, 8, 2, 3, 4, 50, 5, 6, 2, 8, 9};

        ReverseArray9 reverseArray9 = new ReverseArray9();
        reverseArray9.reverse(arrays1);

        for (int i : arrays1) {
            System.out.print(i + ",");
        }


    }
}
