import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

/**
 * @author HsiHo Huang
 * @version 1.1
 * @see {@link <a href="http://blog.hsihohuang.info/2016/03/07/2016-2016-03-07-Bubblesort/">My blog</a>}
 */
public class Bubblesort {
	public static void bubblesort(int[] arr){
        /**外層迴圈控制內層迴圈的遍歷範圍，
         * 由於每跑一次內層迴圈，會把該次遍歷範圍中最大的數移到該次範圍的最右邊(也就是排序好了)
         * 所以，每跑完一次內層迴圈，下次的遍歷範圍會減少1*/
        for (int i = arr.length - 1; i > 0; i--){  //由於內層迴圈有讀取到j+1的值，固初始遍歷範圍是長度-1
            //記錄下面迴圈中是否有做交換數值的動作，若都沒有交換，代表該數列已經排序完成
            boolean swapped = false;
        	
            /**兩兩數值做比較，若發現順序上應該相反就會做交換(swap)*/
            for (int j = 0; j < i; j++){
                if (arr[j] > arr[j + 1]){
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            if(!swapped)//若都沒有交換數值，代表該數列已經排序完成，可提早結束迴圈
                break;
        }
    }
 
    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
	
	@Test
    public void testBubblesort() {        
        int[] arrNumbers =  {1, 14, 3, 5, 7, 15, 2, 12};
		int[] arrExpected =  {1, 2, 3, 5, 7, 12, 14, 15};
		bubblesort(arrNumbers);
		assertArrayEquals(arrExpected,arrNumbers);
    }

	
}
