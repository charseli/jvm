package one;

import org.junit.jupiter.api.Test;

/**
 * Class主动使用与被动使用说明
 */
public class ClassUsageDeclare {

    @Test
    public void tP() {
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
    public void tC() {
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


}

class Parent {
    static {
        System.out.println("this is Parent class static block");
    }

    protected static int parent = 1;
}

class Child extends Parent {
    static {
        System.out.println("this is Child class static block");
    }

    protected static int child = 2;
}