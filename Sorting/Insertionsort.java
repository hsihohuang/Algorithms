import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

/**
 * @author HsiHo Huang
 * @version 1.1
 */
public class Insertionsort {	
	/**
	 * In-place version of insertionsort
	 * 
	 * 實作的概念，要被排序的陣列arr會被分成三部分：
	 * (1)要被插入的值:insertValue (2)insertValue的左半邊:已經排序好的部分 (3)insertValue的右半邊:未排序好的部分
	 * (雖然insertValue也算是尚未排序的那一部份，但為了方便說明，把它拆開來說)<br>
	 * 而insertValue從arr位置1的值開始(第0個因為只有一個元素，代表已排序好)一一被插入已經排序好的部分，
	 * 插入之後，再從右半邊未排序的部分拿出值當作insertValue繼續插入左半邊排序好的部分，重複此步驟直到最後完成排序。
	 * 
	 * @param arr 要被排序的陣列
	 */
	public static void insertionsortInPalce(int[] arr){
        int length = arr.length;
        for (int i = 1, j; i < length; ++i){ 	//從位置1的值開始
            int insertValue = arr[i]; 			//insertValue是要被插入的值
            
            /**一一檢查左半邊排序好的部分，看insertValue要被插入哪個位置
             * 由後向前掃描過程中，需要反覆把"比insertValue大"的元素逐步向後挪位，為insertValue提供插入空間。*/
            for (j = i - 1; j >= 0 && arr[j] > insertValue; --j)
                arr[j + 1] = arr[j];
            
            /**找到insertValue適合的位置，即插入
             * 由於在上面的迴圈結束時，j是指在比insertValue小的值的位置，所以j+1才是插入insertValue的地方*/
            arr[j + 1] = insertValue;
        }
    }
	
	
	@Test
    public void testInsertsort() {        
        int[] arrNumbers =  {1, 14, 3, 5, 7, 15, 2, 12};
		int[] arrExpected =  {1, 2, 3, 5, 7, 12, 14, 15};
		insertionsortInPalce(arrNumbers);
		assertArrayEquals(arrExpected,arrNumbers);
    }
	
}
