package main.java.com.hrj.strategy;

import main.java.com.hrj.contants.enums.CalculatorEnum;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class CalculatorStrategyFactory {

    public CalculatorStrategyFactory() {
    }

    /**
     * 根据运算符号进行对应的运算
     *
     * @param num1
     * @param num2
     * @param calculator 运算符号（仅支持加减乘除)
     * @return
     */
    public String doOperate(BigDecimal num1, BigDecimal num2,String calculator) {
        if (calculator == null || calculator.length() == 0 || "null".equals(calculator)) {
            throw new IllegalArgumentException("非法运算符合," + calculator);
        }
        CalculatorEnum ce = CalculatorEnum.getEnum(calculator);
        if (ce == null) {
            throw new IllegalArgumentException("非法运算符合, 目前仅支持加减乘除");
        }
        CalculatorStrategy strategy = ce.getStrategy();
        String result = strategy.doOperation(num1, num2);
        return result;
    }

}
