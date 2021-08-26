package com.spring5.demoreactor.reactor8;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author lichuang
 * @create 2021-08-26 21:59
 * @project_name spring5
 */
public class TestReactor {
    public static void main(String[] args) {

        // just方法直接声明相关的元素
        Flux.just(1,2,3,4).subscribe(System.out::print); // 声明并订阅
        System.out.println();
        Mono.just(1).subscribe(System.out::print);

        // 其他方法
        Integer[] array = {1,2,3,4};
        Flux.fromArray(array);

        List<Integer> list = Arrays.asList(array);
        Flux.fromIterable(list);

        Stream<Integer> stream = list.stream();
        Flux.fromStream(stream);

//        Flux.error(new RuntimeException()); // 错误信号
    }
}
