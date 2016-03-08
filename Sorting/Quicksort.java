import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author HsiHo Huang
 * @version 1.3
 */
public class Quicksort {
	
	
	/**
	 * In-place version of quicksort
	 */
	public static void quicksortInPlace(int[] arr) {
		quicksortInPlace(arr, 0, arr.length-1);
	}
	
	public static void quicksortInPlace(int[] arr, int left, int right) {
		int index = partition(arr, left, right);
		if (left < index - 1)
			quicksortInPlace(arr,left, index - 1);//排序左半邊
		if (index < right)
			quicksortInPlace(arr, index, right);//排序右半邊
	}
	
	public static int partition(int[] arr, int left, int right){
		int pivot = arr[(left + right) / 2];//選中間的數當作pivot

		while (left <= right) {
			while (arr[left] < pivot)//在左半邊找到大於pivot的數字, 此數應該被放到右半邊
				left++;
			while (arr[right] > pivot)//在右半邊找到小於pivot的數字, 此數應該被放到左半邊
				right--;
			if (left <= right) {//交換該被放到另一邊的值, 交換完再繼續找 
				swap(arr, left, right);

				left++;
				right--;
			}
		};
		return left;
	}

	public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
	
	
	/**
	 * Not-in-place version of quicksort
	 */
	public List<Integer> quicksortNotInPlace(List<Integer> numbers){
		if (numbers.size() < 2) {
			return numbers;
		}

		Integer pivot = numbers.get(0);//選第一個數當作pivot
		List<Integer> lower = new ArrayList<>();
		List<Integer> higher = new ArrayList<>();

		//一個一個做檢查, 比pivot小放lower list, 比pivot大放higher list
		for (int i = 1; i < numbers.size(); i++) {	
			if (numbers.get(i) < pivot) {	
				lower.add(numbers.get(i));
			} else {
				higher.add(numbers.get(i));
			}
		}

		//排序lower list, 再依序放入pivot, 排序完成的higher list
		List<Integer> sorted = quicksortNotInPlace(lower);
		sorted.add(pivot);
		sorted.addAll(quicksortNotInPlace(higher));

		return sorted;
	}
	
	
	@Test
	public void testQuicksort() {
		int[] arrNumbers =  {4, 1, 5, 7, 15, 12};
		int[] arrExpected =  {1, 4, 5, 7, 12, 15};
		quicksortInPlace(arrNumbers);
		assertArrayEquals(arrExpected,arrNumbers);
		
		List<Integer> listNumbers = Arrays.asList(4, 1, 5, 7, 15, 12);
		List<Integer> listExpected = Arrays.asList(1, 4, 5, 7, 12, 15);
		List<Integer> result = quicksortNotInPlace(listNumbers);
		assertEquals(listExpected, result);
	}

}
