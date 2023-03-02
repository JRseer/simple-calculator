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
        System.out.println("欢迎使用简单的计算器,目前仅支持加减乘除");
        CalculatorStrategyFactory calucatorStrategyFactory = new CalculatorStrategyFactory();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            //获取数字与运算符号
            if (!systemIn(scanner)){
                continue;
            }
            //计算与结果
            String result = calucatorStrategyFactory.doOperate(new BigDecimal(allHashMap.get("num1")), new BigDecimal(allHashMap.get("num2")), allHashMap.get(CALCULATOR));
            System.out.println("退出程序请输入#, 重新计算请随意输入一个字符");
            String tempStr = scanner.next();
            if (tempStr.equals("#")) {
                return;
            }
        }
    }

    /**
     * 获取数字与运算符号
     *
     * @return
     */
    public static boolean systemIn(Scanner scanner) {
        //todo 未完成对输入数字、运算符号合法校验, 不合法会报错
        System.out.println("请输入第一个数字");
        BigDecimal num1 = scanner.nextBigDecimal();
        System.out.println("请输入运算符号（+ - * / ）");
        String calculator = scanner.next();
        System.out.println("请输入第二个数字");
        BigDecimal num2 = scanner.nextBigDecimal();
        allHashMap.put("num1", num1.toString());
        allHashMap.put(CALCULATOR, calculator);
        allHashMap.put("num2", num2.toString());
        display();
        System.out.println("继续执行请输入y,回退请输入任意一个字符");
        String tempStr = scanner.next();
        if (tempStr.equals("y")) {
            return true;
        }
        return false;
    }

    /**
     * 显示运算表达式
     */
    public static void display() {
        System.out.println("计算:" + allHashMap.get("num1") + allHashMap.get(CALCULATOR) + allHashMap.get("num2"));
    }
}
