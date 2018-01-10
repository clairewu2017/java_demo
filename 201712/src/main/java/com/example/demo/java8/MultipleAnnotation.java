package com.example.demo.java8;

import java.lang.annotation.Repeatable;

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

    }
}
