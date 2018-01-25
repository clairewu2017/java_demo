package study.java8;

import java.lang.annotation.Repeatable;
import java.util.*;

/**
 * Created by chunmei on 1/10/2018.
 */
@interface Hints {
    Hint[] value();
}
@Repeatable(Hints.class)
@interface Hint {
    String value();
}

@Hints({@Hint("hint1"), @Hint("hint2")})
//@Hint("hint1")
//@Hint("hint2")
public class MultipleAnnotation {

    public void test()
    {

        Hashtable<Integer, String> hashtable = new Hashtable<>(20);

        HashMap<Integer, String> hashmap = new HashMap<>(20);

        Map<Integer, String> synchHashmap = Collections.synchronizedMap(hashmap);
        //Collection<Map.Entry<Integer, String>> collection = hashmap;
        //Collection<Map.Entry<Integer, String>> collection = synchHashmap;

    }
}
