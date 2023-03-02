package main.java.com.hrj.strategy;

import java.math.BigDecimal;

/**
 * 运算strategy
 *
 * @author HRJ
 * @date 2023/03/02
 */
public interface CalculatorStrategy {

    /**
     * 两数运算
     * @param num1
     * @param num2
     * @return
     */
    public String doOperation(BigDecimal num1, BigDecimal num2);
}
