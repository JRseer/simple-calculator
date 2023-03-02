package main.java.com.hrj.demo;

/**
 * 抽象命令类
 */
public abstract class Command {

    /**
     * 执行
     */
    public abstract void execute();
    public abstract void unexecute();

}
