package one;


import org.junit.Test;

/**
 * Class主动使用与被动使用说明
 */
public class ClassUsageDeclare {

    @Test
    public void testParentStatic() {
        /**
         * 包含被调用静态变量或方法的直接类会被初始化
         * ====输出为====
         * this is Parent class static block
         * 1
         * ========
         */
        System.out.println(Child.parent);
    }

    @Test
    public void testChildStatic() {
        /**
         * 初始化子类,也意味着父类的主动调用.
         * ====输出为====
         * this is Parent class static block
         * this is Child class static block
         * 1
         * ========
         */
        System.out.println(Child.child);
    }

    @Test
    public void testParentFinal() {
        /**
         * static final常量会被存入调用该常量所在方法的类的常量池中，
         * 即ClassUsageDeclare类中,本质上未主动调用Parent类
         * 不会使其初始化
         *  ====输出为====
         *  hello world
         *  ========
         */
        System.out.println(Child.str);
    }

    @Test
    public void testNodeSign() {
        System.out.println(Constant.INT_SIX);
        System.out.println(Constant.INT_ONE);
        System.out.println(Constant.INT_THREE);
        System.out.println(Constant.INT_TWO);
        System.out.println(Constant.INT_FOUR);
        System.out.println(Constant.INT_FIVE);
        System.out.println(Constant.H_W);
        System.out.println(Constant.FLOAT_TWO);
        System.out.println(Constant.BYTE_TWO);
        System.out.println(Constant.BYTE_THREE);
        System.out.println(Constant.SHORT_TWO);
        System.out.println(Constant.SHORT_THREE);
    }
}

class Parent {
    static {
        System.out.println("this is Parent class static block");
    }

    protected static int parent = 1;
    public static final String str = "hello world";

}

class Child extends Parent {
    static {
        System.out.println("this is Child class static block");
    }

    protected static int child = 2;

}

class Constant {
    public static final String H_W = "hello world";
    public static final int INT_ONE = 1;
    public static final int INT_TWO = 2;
    public static final int INT_THREE = 3;
    public static final int INT_FOUR = 4;
    public static final int INT_FIVE = 5;
    public static final int INT_SIX = 6;
    public static final byte BYTE_TWO = 55;
    public static final byte BYTE_THREE = 3;
    public static final float FLOAT_TWO = 2;
    public static final short SHORT_TWO = 6;
    public static final short SHORT_THREE= 3;

}