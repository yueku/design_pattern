package com.yue.design.single;

/**
 * 懒汉式单例
 * 此单例模式有现成安全问题
 */
public class LazySingle {
    private static LazySingle INSTANCE;

    private LazySingle() {}

    public static LazySingle getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new LazySingle();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(LazySingle.getInstance().hashCode());
            }).start();
        }
    }
}
