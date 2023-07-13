package test;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author: yzy
 **/
public class testBigInteger {
    public static void main(String[] args) throws IOException {
        BigInteger integer = new BigInteger("100");
        BigDecimal bigDecimal = new BigDecimal(integer, 100);
        System.out.println(bigDecimal.intValue());

    }
}
