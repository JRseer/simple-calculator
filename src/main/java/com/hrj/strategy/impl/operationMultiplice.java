package main.java.com.hrj.strategy.impl;

import main.java.com.hrj.strategy.CalculatorStrategy;

import java.math.BigDecimal;

/**
 * 两数相乘
 *
 * @author HRJ
 * @date 2023/03/02
 */
public class operationMultiplice implements CalculatorStrategy {
    @Override
    public String doOperation(BigDecimal num1, BigDecimal num2) {
        if (num1 == null || num2 == null) {
            throw new IllegalArgumentException("入参为null,num1:" + num1 + ",num2:" + num2);
        }
        String result = num1.multiply(num2).toString();
        System.out.println("两数相乘,结果为" + result);
        return result;
    }
}
