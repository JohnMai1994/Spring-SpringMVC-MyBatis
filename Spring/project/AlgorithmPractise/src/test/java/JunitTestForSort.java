import com.jiadong.Sort.BubbleSort;
import com.jiadong.Sort.InsertionSort;
import com.jiadong.Sort.QuickSort;
import com.jiadong.String.*;
import org.junit.Test;

public class JunitTestForSort {

   @Test
    public void test1() {
       int[] arrays = new int[]{4,3,2,5,1,6,7};
       BubbleSort bubbleSort = new BubbleSort();
       bubbleSort.sort(arrays);
       for (int array : arrays) {
           System.out.print(array+ ", ");
       }

   }

    @Test
    public void test2() {

        int[] arrays = new int[]{4, 3, 2, 5, 1, 6, 7};

        QuickSort quickSort = new QuickSort();
        quickSort.sort(arrays, 0, arrays.length -1);
        for (int array : arrays) {
            System.out.print(array+ ", ");
        }
    }

    @Test
    public void test3() {
        int[] arrays = new int[]{4, 3, 2, 5, 1, 6, 7};

        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(arrays);
        for (int array : arrays) {
            System.out.print(array+ ", ");
        }
    }
}
