package study.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by chunmei on 1/18/2018.
 */
public class FindK {
    public static LinkedList<Integer> findK(List<Integer> list, int k)
    {
        LinkedList<Integer> subArray = new LinkedList<Integer>();
        int maxOfSub = list.get(0);
        for (Integer num:
             list) {
            if ( subArray.size() < k || num < maxOfSub)
            {
                maxOfSub = insertInto(subArray, k, num);
            }
        }
        return subArray;
    }

    private static int insertInto(LinkedList<Integer> subArray, Integer k, Integer num) {
        subArray.add(num);
        subArray.sort(Integer::compareTo);
        if (subArray.size() > k) {
            subArray.removeLast();
        }
        return subArray.getLast();
    }

    public static void test()
    {
        int a[] = {1,2, 3, 4};
        List<Integer> list = Arrays.asList(1, 2, 5, 8, 9,3,4);
        LinkedList<Integer> subArray = findK(list, 3);
        subArray.forEach(System.out::println);
    }
}
