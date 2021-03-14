package com.yue.design.single;

/**
 * 静态内部类的单例
 * 静态内部类无法传参
 */
public class StaticClassSingle {
    private static class Single {
        private static final StaticClassSingle INSTANCE = new StaticClassSingle();
    }

    public static StaticClassSingle getInstance() {
        return Single.INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(StaticClassSingle.getInstance().hashCode());
            }).start();
        }
    }
}
