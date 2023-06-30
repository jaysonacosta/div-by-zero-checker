import org.checkerframework.checker.dividebyzero.qual.*;

// A simple test case for your divide-by-zero checker.
// The file contains "// ::" comments to indicate expected
// errors and warnings.
//
// Passing this test does not guarantee a perfect grade on this assignment,
// but it is an important start. You should always write your own test cases,
// in addition to using those provided to you.
class Foo {

    public static void f() {
        int one = 1;
        int zero = 0;
        // :: error: divide.by.zero
        int x = one / zero;
        int y = zero / one;
        // :: error: divide.by.zero
        int z = x / y;
        String s = "hello";
    }

    public static void g(int y) {
        if (y == 0) {
            // :: error: divide.by.zero
            int x = 1 / y;
        } else {
            int x = 1 / y;
        }

        if (y != 0) {
            int x = 1 / y;
        } else {
            // :: error: divide.by.zero
            int x = 1 / y;
        }

        if (!(y == 0)) {
            int x = 1 / y;
        } else {
            // :: error: divide.by.zero
            int x = 1 / y;
        }

        if (!(y != 0)) {
            // :: error: divide.by.zero
            int x = 1 / y;
        } else {
            int x = 1 / y;
        }

        if (y < 0) {
            int x = 1 / y;
        }

        if (y <= 0) {
            // :: error: divide.by.zero
            int x = 1 / y;
        }

        if (y > 0) {
            int x = 1 / y;
        }

        if (y >= 0) {
            // :: error: divide.by.zero
            int x = 1 / y;
        }
    }

    public static void h() {
        int zero_the_hard_way = 0 + 0 - 0 * 0;
        // :: error: divide.by.zero
        int x = 1 / zero_the_hard_way;

        int one_the_hard_way = 0 * 1 + 1;
        int y = 1 / one_the_hard_way;
    }

    public static void l() {
        // :: error: divide.by.zero
        int a = 1 / (1 - 1);
        int y = 1;
        // :: error: divide.by.zero
        int x = 1 / (y - y);
        int z = y - y;
        // :: error: divide.by.zero
        int k = 1 / z;
    }

    public static void j() {
        int a = 0;
        a += 1;
        int b = 1 / a;

        int c = 1;
        c -= 1;
        // :: error: divide.by.zero
        int d = 1 / c;

        int f = 1;
        // :: error: divide.by.zero
        f /= 0;

        int h = 1;
        h *= 0;
        // :: error: divide.by.zero
        int j = 1 / h;
    }

    public static void k() {
        int a = 1;

        // These should not fail because we know that a = 1
        if (a >= 0) {
            int a1 = 1 / a;
        } else {
            int a1 = 1 / a;
        }

        // These should not fail because we know that a = 1
        if (a <= 0) {
            int a1 = 1 / a;
        } else {
            int a1 = 1 / a;
        }

        // These should not fail because we know that a = 1
        if (a > 0) {
            int a1 = 1 / a;
        } else {
            int a1 = 1 / a;
        }

        // These should not fail because we know that a = 1
        if (a < 0) {
            int a1 = 1 / a;
        } else {
            int a1 = 1 / a;
        }

        int b = 0;

        // These should fail because we know that b = 0
        if (b >= 0) {
            // :: error: divide.by.zero
            int b1 = 1 / b;
        } else {
            int b1 = 1 / b;
        }

        // These should fail because we know that b = 0
        if (b <= 0) {
            // :: error: divide.by.zero
            int b1 = 1 / b;
        } else {
            int b1 = 1 / b;
        }

        // These should fail because we know that b = 0
        if (b > 0) {
            int b1 = 1 / b;
        } else {
            // :: error: divide.by.zero
            int b1 = 1 / b;
        }

        // These should fail because we know that b = 0
        if (b < 0) {
            int b1 = 1 / b;
        } else {
            // :: error: divide.by.zero
            int b1 = 1 / b;
        }
    }

    public static void g_strict_divide_largeconstants(int y) {
        if (y > (100 * 100)) {
            // Can't catch this because analysis doesn't have lattice points for positive
            // and negative values
            int a = 1 / y;
            // :: error: divide.by.zero
            int c = 1 / a;
        } else {
            // :: error: divide.by.zero
            int b = 10 / y;
        }
    }
}
