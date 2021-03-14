package com.yue.design.single;

/**
 * 饿汉式单例，无线程安全问题
 */
public class HungerSingle {
    private static HungerSingle INSTANCE = new HungerSingle();

    private HungerSingle() {}

    public static HungerSingle getInstance() {
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
