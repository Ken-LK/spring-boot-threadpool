package com.ken.utils;

import com.ken.pojo.Person;
import lombok.experimental.UtilityClass;

import java.util.*;
import java.util.function.Function;

/**
 * @author Ken
 * @date 2022-01-24 16:33
 * @since v1.0
 */
@UtilityClass
public class ConvertUtil {


    /**
     * 将List映射为List，比如List<Person> personList 转为List<String> nameList
     *
     * @param originList 原数据
     * @param mapper     映射规则
     * @param <T>        原数据的元素类型
     * @param <R>        新数据的元素类型
     * @return List
     */

    public <T, R> List<R> resultToList(List<T> originList, Function<T, R> mapper) {
        if (originList == null) {
            return Collections.emptyList();
        }

        List<R> newList = new ArrayList<>(originList.size());

        for (T t : originList) {
            R newT = mapper.apply(t);
            if (newT == null) {
                continue;
            }
            newList.add(newT);
        }
        return newList;
    }


    /**
     * 将List转为Map
     *
     * @param list         原数据
     * @param keyExtractor Key抽取规则
     * @param <K>          Key
     * @param <V>          Value
     * @return map
     */
    public <K, V> Map<K, V> listToMap(List<V> list, Function<V, K> keyExtractor) {
        if (list == null || list.isEmpty()) {
            return new HashMap<>();
        }

        Map<K, V> map = new HashMap<>(list.size());
        for (V v : list) {
            K key = keyExtractor.apply(v);
            if (key == null) {
                continue;
            }
            map.put(key, v);
        }
        return map;
    }


    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

        Person p1 = Person.builder().name("张一").age(1).build();
        Person p2 = Person.builder().name("张二").age(2).build();
        Person p3 = Person.builder().name("张三").age(3).build();

        persons.add(p1);
        persons.add(p2);
        persons.add(p3);

        Map<String, Person> personMap = listToMap(persons, Person::getName);

        List<Integer> integerList = resultToList(new ArrayList<Person>(), person -> person.getAge());

        integerList.forEach(System.out::println);

        Set<Map.Entry<String, Person>> entries = personMap.entrySet();
        for (Map.Entry<String, Person> entry : entries) {
            System.out.println(entry.getKey() + " ===>" + entry.getValue());
        }


    }


}
