package study.java8;

import java.util.Optional;

/**
 * Created by chunmei on 1/12/2018.
 */
public class MyOptional {
    public void test()
    {
        Optional<String> fullName = Optional.ofNullable(null);
        System.out.println(fullName.orElse("None"));

        System.out.println( "Full Name is set? " + fullName.isPresent() );
        System.out.println( "Full Name: " + fullName.orElseGet( () -> "[none]" ) );
        System.out.println( fullName.map( s -> "Hey " + s + "!" ).orElse( "Hey Stranger!" ) );
    }
}
