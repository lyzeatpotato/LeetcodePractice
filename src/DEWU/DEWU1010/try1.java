package DEWU.DEWU1010;

import java.lang.reflect.Field;

/**
 * @ClassName: try1
 * @Description:
 * @author: lyz
 * @date: 2023 10 2023/10/10 10:13
 */
class Outer {
    static int a = 0;
    class Inner {
        int a = 1;
        void function() {
            int a = 2;
            System.out.println("a = " + a);
        }
    }
}

public class try1 {
    public static void main(String[] args) {
        Outer.Inner on = new Outer().new Inner();
        on.function();
    }


}


