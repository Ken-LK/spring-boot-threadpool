package com.ken;

/**
 * String 不可变量
 * @author Ken
 * @date 2022-02-09 10:41
 * @since v1.0
 */
public class StringTest {

    private static String appendStr(String str){
        str += "bbb";
        return str;
    }


    private static StringBuilder appendSb(StringBuilder sb){
        return sb.append("bbb");
    }

    public static void main(String[] args) {
        String ss = "aaa";

        String sss = appendStr(ss);

        StringBuilder sb=new StringBuilder("aaa");
        StringBuilder ssb = appendSb(sb);

        System.out.println("ss==="+ss);
        System.out.println("sb==="+ sb);

        stringByStr();
    }

    /**
     * 帮助理解 String和new String()
     */
    private static void stringByStr(){
        // situation 1
        String a = "a1";
        String a1 = "a" + 1;
        //在编译期值是确定的就是a2。只有编译期变量a与变量a2值相等他们才相等
        // true
        System.out.println("a==a1-->" + (a == a1));

        // situation 2
        String b = "b2";
        int bb = 2;
        String b2 = "b" + bb;
        //在编译期变量b2的值不是确定的，因为bb是变量，变量在运行期才能确定值.所以b与b2不等
        // false
        System.out.println("b==b2-->" + (b == b2));

        // situation 3
        String c = "c3";
        final int cc = 3;
        String c2 = "c" + cc;

        //在编译期c2的值是确定的，因为cc是个常量，值为2
        // true
        System.out.println("c==c2-->" + (c == c2));

        // situation 4
        String d = "d4";
        final int dd = getD();
        String d2 = "d" + dd;

        //在编译器d2的值是不确定的，因为dd还没有确定，因为dd的值是靠方法返回来的，但是方法的结果是在运行期才能得到的
        // false
        System.out.println("d==d2-->" + (d == d2));
    }

    private static int getD(){
        return 4;
    }






}
