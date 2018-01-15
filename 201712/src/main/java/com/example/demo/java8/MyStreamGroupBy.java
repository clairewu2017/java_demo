package com.example.demo.java8;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by chunmei on 1/10/2018.
 */
public class MyStreamGroupBy {

    private enum Status {
        OPEN, CLOSED
    };

    public void test()
    {
        final Collection< Task > tasks = Arrays.asList(
                new Task( Status.OPEN, 5 ),
                new Task( Status.OPEN, 13 ),
                new Task( Status.CLOSED, 8 )
        );

        //在这个task集合中一共有多少个OPEN状态的点
        long totalPoints = tasks.stream().filter((task) -> (task.getStatus() == Status.OPEN)).mapToInt(task -> task.getPoints()).sum();
        System.out.println(totalPoints);


        // Calculate total points of all tasks
        totalPoints = tasks
                .stream()
                .parallel()
                .mapToInt( task -> task.getPoints() ) // or map( Task::getPoints )
                .sum();
                //.reduce( 0, Integer::sum );
        System.out.println(totalPoints);

        //元素分组,但不合并相同状态的记录
        Map<Status, List<Task>> grouped = tasks.parallelStream().collect(Collectors.groupingBy(Task::getStatus));
        System.out.println(grouped);

        //总和
        totalPoints = tasks.parallelStream().mapToInt(task -> task.getPoints()).sum();


        //计算集合中每个任务的点数在集合中所占的比
        long finalTotalPoints = totalPoints;
        List<String> list = tasks.parallelStream().mapToDouble(task -> (task.getPoints() * 100 / finalTotalPoints)).mapToObj(number -> number + "%").collect(Collectors.toList());
        System.out.println(list);

    }

    @Data
    @AllArgsConstructor
    private static final class Task {
        private final Status status;
        private final Integer points;

        @Override
        public String toString() {
            return String.format( "[%s, %d]", status, points );
        }
    }




}
