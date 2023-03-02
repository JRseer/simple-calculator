package main.java.com.hrj.demo;

import main.java.com.hrj.strategy.CalculatorStrategyFactory;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 实现输入两数的加减乘除
 *
 * @author HRJ
 * @date 2023/03/02
 */
public class CalculatorDemo {

    //全局hashMap
    private static ConcurrentHashMap<String, String> allHashMap = new ConcurrentHashMap<>();
    //ConcurrentHashMap中运算符号标识
    private static String CALCULATOR = "calculator";

    /**
     * 输入两数 实现加减乘除，两数输入、运算符号以回车为输入
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("欢迎使用简单的计算器");
        //获取数字与运算符号
        systemIn();
        //计算与结果
        CalculatorStrategyFactory calucatorStrategyFactory = new CalculatorStrategyFactory();
        String result = calucatorStrategyFactory.doOperate(new BigDecimal(allHashMap.get("num1")), new BigDecimal(allHashMap.get("num2")), allHashMap.get(CALCULATOR));
        StringBuilder sb = new StringBuilder();
//        sb.append(num1.toString()).append(calculator).append(num2.toString()).append("=");
        System.out.println("计算结果:" + sb.toString() + result);
    }

    /**
     * 获取数字与运算符号
     *
     * @return
     */
    public static void systemIn() {
        //todo 未完成对输入数字、运算符号合法校验, 不合法会报错
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个数字");
        BigDecimal num1 = scanner.nextBigDecimal();
        System.out.println("请输入运算符号（+ - * / ）");
        String calculator = scanner.next();
        System.out.println("请输入第二个数字");
        BigDecimal num2 = scanner.nextBigDecimal();
        allHashMap.put("num1", num1.toString());
        allHashMap.put(CALCULATOR, calculator);
        allHashMap.put("num2", num2.toString());
    }
}