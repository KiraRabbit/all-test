package GuavaDemo;

import com.google.common.collect.*;

import java.util.*;

public class GuavaCollectionDemo1 {
    public static void main(String[] args) {
        /*普通集合创建*/
        List<String> list = Lists.newArrayList();
        list.add("1");
        list.add("0");
        System.out.println(list);
        System.out.println("----------------");
        Set<String> set = Sets.newHashSet();
        set.add("3");
        set.add("2");
        set.add("2");
        set.add("3");
        set.add("1");
        System.out.println(set);
        System.out.println("----------------");
        Map<Integer, String> map = Maps.newHashMap();
        map.put(1, "2");
        map.put(2, "3");
        map.put(3, "4");
        map.put(1, "3");
        System.out.println(map);

        /*复合集合创建*/
        //方式一
        Map<String,List<Integer>> map1 = new HashMap<String,List<Integer>>();
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        map1.put("aa", list1);
        System.out.println(map1);
        System.out.println(map1.get("aa"));//[1, 2]

        Multimap<String,Integer> map3 = ArrayListMultimap.create();
        map3.put("aa", 1);
        map3.put("aa", 2);
        System.out.println(map3.get("aa"));  //[1, 2]



    }
}
