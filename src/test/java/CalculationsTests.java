import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculationsTests {

    RoundingMode roundingMode = RoundingMode.CEILING;

    double a = 0.1;
    double b = 0.2;
    double c = 1.0;
    double d = 3.0;

    @Test
    void test1() {
        //Чем дабл плох
        System.out.println(a + b);
        System.out.println(c / d);
        System.out.println(0.7 * 0.1);
    }

    @Test
    void test2() {
        //Сложение
        BigDecimal abigDec = BigDecimal.valueOf(a);
        BigDecimal bbigDec = BigDecimal.valueOf(b);
        System.out.println(abigDec.add(bbigDec));
    }

    @Test
    void test3() {
        //Вычитание
        BigDecimal abigDec = BigDecimal.valueOf(a);
        BigDecimal bbigDec = BigDecimal.valueOf(b);
        System.out.println(abigDec.subtract(bbigDec));
    }

    @Test
    void test4() {
        //Умножение
        BigDecimal dbigDec = BigDecimal.valueOf(0.33);
        BigDecimal bbigDec = BigDecimal.valueOf(0.44);
        BigDecimal bigDecimal = dbigDec.multiply(bbigDec).setScale(2, roundingMode);
        System.out.println(bigDecimal);

    }

    @Test
    void test5() {
        //Деление без округления
        BigDecimal abigDec = BigDecimal.valueOf(3);
        BigDecimal bbigDec = BigDecimal.valueOf(1);
        BigDecimal bigDecimal = abigDec.divide(bbigDec);
        System.out.println(bigDecimal);

    }

    @Test
    void test6() {
        //Деление c округлением
        BigDecimal abigDec = BigDecimal.valueOf(1);
        BigDecimal bbigDec = BigDecimal.valueOf(3);
        BigDecimal bigDecimal = abigDec.divide(bbigDec, 2, roundingMode);
        System.out.println(bigDecimal);

    }

    @Test
    void test7() {
        //Получение строки
        String a = "1111";
        BigDecimal abigDec = new BigDecimal(a);

    }

    @Test
    void test8() {
        //Сравнение
        String a = "1";
        BigDecimal abigDec = new BigDecimal(a);
        BigDecimal bbigDec = BigDecimal.valueOf(1.00);
        int aX = abigDec.compareTo(bbigDec);
        assertThat(aX).isEqualTo(0);

    }

    @Test
    void test9() {
        //Сравнение
        String a = "1";
        BigDecimal abigDec = new BigDecimal(a);
        BigDecimal bbigDec = BigDecimal.valueOf(2.00);
        int aX = abigDec.compareTo(bbigDec);
        assertThat(aX).withFailMessage(abigDec + " не равно " + bbigDec).isEqualTo(0);

    }

    @Test
    void testWrapper() {
        //Wrapper

        String a = "4";
        double b = 4.0;
        int c = 4;

        getBigDecimal(a);
        getBigDecimal(b);
        getBigDecimal(c);
        getBigDecimal(10.01f);
    }

//    public BigDecimal getBigDecimal(Object o) {
//        BigDecimal bigDecimal = null;
//        var type = o.getClass();
//
//        if (type.equals(String.class)) {
//            bigDecimal = new BigDecimal(o.toString());
//        } else if (type.equals(Double.class)) {
//            bigDecimal = BigDecimal.valueOf((double) o);
//        } else if (type.equals(Integer.class)) {
//            bigDecimal = BigDecimal.valueOf((int) o);
//        }
//
//        return bigDecimal;
//    }

    public BigDecimal getBigDecimal(Object o) {
        switch (o.getClass().getSimpleName()) {
            case "String":
                return new BigDecimal(o.toString());
            case "Integer":
                return new BigDecimal((Integer) o);
            case "Double":
                return new BigDecimal((Double) o);
            case "Float":
                return new BigDecimal((Float) o);
            default:
                throw new IllegalArgumentException("Неизвестный тип: " + o.getClass().getSimpleName());
        }
    }

    @Test
    void test10() {
        BigDecimal a = getBigDecimal("1");
        BigDecimal b = getBigDecimal(1.00);
        int aX = a.compareTo(b);
        assertThat(aX).withFailMessage(a + " не равно " + b).isEqualTo(0);

    }

    @Test
    void testComperison() {

        String a = "2";
        int b = 2;

        compereBigDecimal(a, b);
    }

    public void compereBigDecimal(Object o1, Object o2) {
        var b1 = getBigDecimal(o1);
        var b2 = getBigDecimal(o2);
        assertThat(b1.compareTo(b2)).withFailMessage(b1 + " не равно " + b2).isEqualTo(0);

    }
}
