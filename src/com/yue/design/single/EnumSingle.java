package com.yue.design.single;

/**
 * 枚举类单例
 */
public enum EnumSingle {
    INSTANCE;

    public EnumSingle getInstance() {
        return INSTANCE;
    }
}
