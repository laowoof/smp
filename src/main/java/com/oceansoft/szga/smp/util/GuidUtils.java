package com.oceansoft.szga.smp.util;

import java.util.UUID;


public class GuidUtils {
    public static String newUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 外网GUID生成方法
     *
     * @return
     */
    public static String newOuterGuid() {
        return newGuid("o");
    }

    /**
     * 内网GUID生成方法
     *
     * @return
     */
    public static String newInnerGuid() {
        return newGuid("i");
    }

    /**
     * GUID 生成方法
     *
     * @param prefix
     * @return
     */
    public static String newGuid(String prefix) {
        return prefix + "_" + newUUID();
    }
}
