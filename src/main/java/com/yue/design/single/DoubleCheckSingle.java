package com.yue.design.single;

/**
 * 双重锁检查的单例，没有线程安全问题
 * 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
 */
public class DoubleCheckSingle {
    /**
     * 双重锁检查的单例，需要加上volatile禁止指令重排序
     */
    private static volatile DoubleCheckSingle INSTANCE;

    private DoubleCheckSingle() {
    }

    public static DoubleCheckSingle getInstance() {
        if (INSTANCE == null) {
            synchronized (DoubleCheckSingle.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DoubleCheckSingle();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(getInstance().hashCode());
            }).start();
        }
    }
}
