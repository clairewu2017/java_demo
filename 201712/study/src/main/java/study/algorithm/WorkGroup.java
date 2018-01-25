package study.algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by chunmei on 1/19/2018.
 */
public class WorkGroup {
    int cases = 0;
    HashSet<Integer> curAssignSet = new HashSet<>();
    public int groups(List<String> stringList, int index)
    {
        if(curAssignSet.size() == stringList.size())
        {
            return ++cases;
        }
        if(stringList.size() <= index)
        {
            return cases;
        }


        String curStr = stringList.get(index);
        for(int i = 0; i < curStr.length(); i ++)
        {
            int newAssign = curStr.charAt(i) - '0';
            if (!curAssignSet.contains(newAssign))
            {
                curAssignSet.add(newAssign);
                groups(stringList, ++index);
                curAssignSet.remove(newAssign);
            }
        }
        if(curAssignSet.size() == stringList.size())
        {
            return ++cases;
        }
        return cases;
    }


    public void test()
    {
        List<String> stringList = Arrays.asList("12345", "12345", "12345", "12345", "12345");
        int groups = groups(stringList, 0);
        System.out.println(groups);
    }
}
