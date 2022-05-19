package analyse;



/*
ArrayList源码分析
 */

import java.util.ArrayList;
import java.util.List;

public class ArrayListAnalyse extends ArrayList{

    public static void main(String[] args) {


        // 例子 1

        // 如果有时候我们只需要一个固定的值，可以去使用默认参数的情况
        // 初始就进行了精确的扩容，可以优化程序，不要滥用 0
        List<String> list = new ArrayList<>(0);
        // 添加了10个元素
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        // list 会执行几次扩容？
        // 7
//        0 1
//        1 2
//        2 3
//        3 4
//        4 6
//        6 9
//        9 13


        // 例子 2
        // asList 用在固定的多个值的情况，不进行修改的情况下使用。
        // 不能删除或者增加，可以修改值
        // 确保任何情况下都不能对这个list进行size的修改
//        List<String> list1 = Arrays.asList();
//        list1.add("a");

        // 例子 3
        // 代码中的一个if或者else 需要返回空list时，使用这个
        // 如果直接使用 new ArrayList 的话，会有对象的创建
        // Collections.emptyList() 无需进行创建
        // Arrays.asList() 也会创建对象，浪费一定的空间  不建议使用（不是不能用）
//        List<String> list2 = Collections.emptyList();
//        list2.add("a");


        // 例子 4
//        List<String> list4 = new ArrayList<>();
//        list.add("a");
//        System.out.println(list.set(0,"b"));

        // 例子5
//        List<String> list5 = new ArrayList<>();
//        list5.add("1");
//        list5.clear();
//        list5.add("1");
        // 扩容几次？

//         例子6
//        List<String> list6 = new ArrayList<>();
//        List<String> list7 = new ArrayList<>();
//         输出的是？
//        System.out.println(list6.addAll(list7));

        // 例子 7
//        ArrayList list8 = new ArrayList();
//        list8.add(new Object());
//        list8.add(new Object());

        /*
        发送list给server端（过网络）
        list 序列化 （writeObject）
           transient Object[] elementData
        server 端接收到list
        list 反序列化 （readObject）
         */
        /*
        假如有1w个元素，则 list size 大约为1.5w
        如果直接序列化 elementData 数组
        则会有5k个空元素序列化
        所以使用for 循环逐个遍历list中的元素，
        优点
        避免浪费序列化次数
        不需要考虑null序列化问题
         */

        // 一切业务上的list的修改，级别高于序列化

    }
}
