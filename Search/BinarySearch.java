import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

/**
 * @author HsiHo Huang
 * @version 1.1
 */
public class BinarySearch {
	/**
	 * Iterative version of binary search algorithm
	 * @param arr 要被搜尋的陣列，必須是已排序好的
	 * @param target 要被搜尋的目標值
	 * @return boolean 是否有找到。也可改成回傳int 該目標值的index，否則回傳-1
	 */
	public boolean binarySearchIterative(int[] arr, int target){
		//設定搜尋範圍
		int left = 0, right = arr.length - 1;
		
		while(left <= right){
			//選中間的值來做比對，每比對一次就縮小搜尋範圍，縮小為中間值的左半邊或右半邊
			int middle = (left + right)/2;
			if(target < arr[middle])
				right = middle - 1;
			else if(target > arr[middle])
				left = middle + 1;
			else return true;
		}
		return false;
	}
	
	/**
	 * Recursive version of binary search algorithm(沒有自訂搜尋範圍)
	 * @param arr 要被搜尋的陣列，必須是已排序好的
	 * @param target 要被搜尋的目標值
	 * @return boolean 是否有找到。也可改成回傳int 該目標值的index，否則回傳-1
	 */
	public boolean binarySearchRecursive(int[] arr, int target){
		return binarySearchRecursive(arr, 0, arr.length - 1 , target);
	}
	
	/**
	 * Recursive version of binary search algorithm(自訂搜尋範圍)
	 * @param arr 要被搜尋的陣列，必須是已排序好的
	 * @param left 要被搜尋的範圍之開始的index
	 * @param right  要被搜尋的範圍之結束的index
	 * @param target 要被搜尋的目標值
	 * @return boolean 是否有找到。也可改成回傳int 該目標值的index，否則回傳-1
	 */
	public boolean binarySearchRecursive(int[] arr,int left,int right,int target){
		//搜尋範圍開始的index大於結束的index -- 可能輸入錯誤或找不到目標值 -> 結束搜尋
		if(left > right) 
			return false;
		
		//選中間的值來做比對，每比對一次就縮小搜尋範圍，縮小為中間值的左半邊或右半邊
		int middle = (left + right)/2;
		if(target < arr[middle])
			return binarySearchRecursive(arr, left, middle-1, target);
		else if (target > arr[middle])
			return binarySearchRecursive(arr, middle+1, right, target);
		else 
			return true;
	}
	
	@Test
    public void testBinarySearch() {        
        int[] arr =  {1, 2, 3, 5, 7, 14, 16, 20};
		assertTrue(binarySearchIterative(arr, 14));
        assertFalse(binarySearchIterative(arr, 4));
        assertFalse(binarySearchIterative(arr, -1));
        
        assertTrue(binarySearchRecursive(arr, 14));
        assertFalse(binarySearchRecursive(arr, 4));
        assertFalse(binarySearchRecursive(arr, -1));
    }

}
