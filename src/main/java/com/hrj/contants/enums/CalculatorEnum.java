package main.java.com.hrj.contants.enums;


import main.java.com.hrj.strategy.CalculatorStrategy;
import main.java.com.hrj.strategy.impl.operationAdd;
import main.java.com.hrj.strategy.impl.operationDivide;
import main.java.com.hrj.strategy.impl.operationMultiplice;
import main.java.com.hrj.strategy.impl.operationSubtract;

public enum CalculatorEnum {
    /**
     * 加
     */
    ADD("+", new operationAdd()),
    /**
     * 减
     */
    SUBTRACTION("-", new operationSubtract()),
    /**
     * 乘
     */
    MULTIPLICATION("*", new operationMultiplice()),
    /**
     * 除
     */
    DIVISION("/", new operationDivide()),

    ;
    private String key;
    private CalculatorStrategy strategy;

    CalculatorEnum(String key, CalculatorStrategy strategy) {
        this.key = key;
        this.strategy = strategy;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public CalculatorStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(CalculatorStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 根据运算符号获取运算方式
     */
    public static CalculatorEnum getEnum(String calculator) {
        if (null == calculator || calculator.length() == 0 || "null".equals(calculator)) {
            return null;
        }
        for (CalculatorEnum e : CalculatorEnum.values()) {
            if (e.key.equals(calculator)) {
                return e;
            }
        }
        return null;
    }
}
