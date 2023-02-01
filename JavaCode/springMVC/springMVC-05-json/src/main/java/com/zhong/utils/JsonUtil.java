package com.zhong.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;

public class JsonUtil {

    public static String getJson(Object object) {
        String json = getJson(object, null);
        return json;
    }


    public static String getJson(Object object, String simpleDateFormat) {
        ObjectMapper mapper = new ObjectMapper();

        /*针对日期json的优化*/
        if (simpleDateFormat != null) {
            mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            SimpleDateFormat sdf = new SimpleDateFormat(simpleDateFormat);
            mapper.setDateFormat(sdf);

        }
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
