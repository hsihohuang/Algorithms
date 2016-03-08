import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author HsiHo Huang
 * @version 1.1
 */
public class Mergesort {
	//將數列一直對半切割, 切到最小單位(單一元素), 再左右合併回去, 合併的同時做排序
	public static List<Integer> mergesort(List<Integer> numbers) {
        if (numbers.size() < 2) { 
            return numbers;
        }
        //分成兩半, 左半邊和右半邊
        List<Integer> leftHalf = numbers.subList(0, numbers.size() / 2);
        List<Integer> rightHalf = numbers.subList(numbers.size() / 2, numbers.size());

        return merge(mergesort(leftHalf), mergesort(rightHalf));
    }

    private static List<Integer> merge(List<Integer> left, List<Integer> right) {
        int leftPtr = 0;
        int rightPtr = 0;

        List<Integer> merged = new ArrayList<>(left.size() + right.size());
        
        //將左和右半邊的數, 一一比較, 把比較小的放進合併後的list(merged list), 直到左或右其中之一的數列已全部放完
        while (leftPtr < left.size() && rightPtr < right.size()) {
            if (left.get(leftPtr) < right.get(rightPtr)) {
                merged.add(left.get(leftPtr));
                leftPtr++;
            } else {
                merged.add(right.get(rightPtr));
                rightPtr++;
            }
        }//end-while 迴圈結束, 會有左 or 右其一的數列, 尚未把數放入merged
        
        
        /* 以下是將 左 or 右其一尚未放入merged的數加入（兩個迴圈只會執行其中一個）
         * 由於左右各半原先都是"由更小的數列合併完且已經排序好的數列", 所以只要依序放入即可*/
        while (leftPtr < left.size()) {
            merged.add(left.get(leftPtr));
            leftPtr++;
        }

        while (rightPtr < right.size()) {
            merged.add(right.get(rightPtr));
            rightPtr++;
        }

        return merged;
    }

    @Test
    public void testMergesort() {
        List<Integer> numbers = Arrays.asList(3, 2, 7, 4, 12, 8, 5);
        List<Integer> expected = Arrays.asList(2, 3, 4, 5, 7, 8, 12);

        List<Integer> result = mergesort(numbers);
        assertEquals(expected, result);
    }

}
