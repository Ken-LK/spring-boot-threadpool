package com.ken;

import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 取出两个大数据量的List中差异的数据
 *
 * @author Ken
 * @date 2022-02-08 14:57
 * @since v1.0
 */
public class BigDataListTest {

    /**
     * 构建list数据
     */
    private static List<String> dataList(int size) {
        List<String> dataList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            dataList.add("" + i);
        }
        return dataList;
    }

    /**
     * 打印不同元素
     */
    private static void traverse(List<String> list) {
        list.forEach(str -> {
            System.out.println(str + "");
        });
    }


    public static void main(String[] args) {

        // 构建AList 10w条
        List<String> listA = dataList(10000000);
        // 构建BList 10w + 10条
        List<String> listB = dataList(10000010);

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        // 基础方式：B集合与A集合的不同元素
//        listB.removeAll(listA);
        // 使用Map
        List<String> differentListByMap = getDifferentListByMap(listA, listB);
        stopWatch.stop();
//        traverse(listB);
        traverse(differentListByMap);
        System.out.println(stopWatch.getTotalTimeSeconds());

    }

    /**
     * 借助Map来获取两个list不同元素集合
     */
    public static List<String> getDifferentListByMap(List<String> listA, List<String> listB) {
        System.out.println("数量级为 " + listA.size() + "集合的不同元素为");
        List<String> differList = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String strA : listA) {
            map.put(strA, 1);
        }
        for (String strB : listB) {
            Integer value = map.get(strB);
            if (value != null) {
                map.put(strB, ++value);
                continue;
            }
            map.put(strB, 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                differList.add(entry.getKey());
            }
        }

        return differList;

    }


}
