package com.zhong.utils;

import org.junit.Test;

import java.util.UUID;

public class IdUtils {
    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

}
