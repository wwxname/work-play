package cn.plus.framework.lock.example;

/**
 * @author plus me
 * @date 2018/7/2
 */
class A {
    public String name;
}
public class MyTest {


    public static void main(String args[]) {
        A a = new A();
        a.name="wwx";

        String s1  ="wwx";
        String s3 = "x";
        String s2 = "ww"+s3;
        s2 =s2.intern();



        System.out.println(s1==s2);
        System.out.println(s2.hashCode());
    }
}
