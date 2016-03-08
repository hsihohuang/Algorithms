import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class BinarySearch {
	public boolean binarySearchIterative(int[] arr, int target){
		int left = 0, right = arr.length - 1;
		
		while(left <= right){
			int middle = (left + right)/2;
			if(target < arr[middle])
				right = middle - 1;
			else if(target > arr[middle])
				left = middle + 1;
			else return true;
		}
		return false;
	}
	
	public boolean binarySearchRecursive(int[] arr, int target){
		return binarySearchRecursive(arr, 0, arr.length - 1 , target);
	}
	
	public boolean binarySearchRecursive(int[] arr,int left,int right,int target){
		if(left > right)
			return false;
		
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
