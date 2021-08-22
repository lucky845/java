package com.json.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.json.pojo.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lichuang
 * @create 2021-08-21 15:13
 * @project_name javaWEB
 */
public class JsonTest {



    // 1.2.1、javaBean和json互转
    @Test
    public void test1() {

        Person person = new Person(1,"小明");
        // 创建Gson对象实例
        Gson gson = new Gson();
        String json = gson.toJson(person);
        System.out.println(json); // {"id":1,"name":"小明"}
        // fromJson把json字符串转为java对象
        // 第一个参数是json字符串
        // 第二个是转换回去的类型
        Person person1 = gson.fromJson(json, Person.class);
        System.out.println(person1); // Person{id=1, name='小明'}
    }

    // 1.2.2、List和json互转
    @Test
    public void test2(){

        List<Person> PersonList = new ArrayList<>();

        PersonList.add(new Person(1,"小强"));
        PersonList.add(new Person(2,"小王"));

        Gson gson = new Gson();
        String json = gson.toJson(PersonList);
        System.out.println(json); // [{"id":1,"name":"小强"},{"id":2,"name":"小王"}]

        List<Person> list = gson.fromJson(json, List.class);
        System.out.println(list); // [{id=1.0, name=小强}, {id=2.0, name=小王}]
//        Person person = list.get(0);
//        System.out.println(person); // ClassCastException

        List<Person> list1 = gson.fromJson(json, new PersonListType().getType());
        System.out.println(list1); // [Person{id=1, name='小强'}, Person{id=2, name='小王'}]
        System.out.println(list1.get(0)); // Person{id=1, name='小强'}
    }

    // 1.2.3、map和json互转
    @Test
    public void test3(){
        Map<Integer,Person> personMap = new HashMap<>();

        personMap.put(1,new Person(1,"小明"));
        personMap.put(2,new Person(2,"小强"));

        Gson gson = new Gson();
        // 把map集合转换为json字符串
        String json = gson.toJson(personMap);
        System.out.println(json); // {"1":{"id":1,"name":"小明"},"2":{"id":2,"name":"小强"}}

//        Map< Integer,Person> fromJson = gson.fromJson(json, new PersonMapType().getType());
        Map< Integer,Person> fromJson = gson.fromJson(json, new TypeToken<Map<Integer,Person>>(){}.getType()); // 匿名内部类
        System.out.println(fromJson); // {1=Person{id=1, name='小明'}, 2=Person{id=2, name='小强'}}
        Person person = fromJson.get(1);
        System.out.println(person); // Person{id=1, name='小明'}

    }

}
