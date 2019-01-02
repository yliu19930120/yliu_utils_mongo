package com.yliu.utils;

import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;

public class JsonUtil {
	
	private final static String DATE_FORMATE = "yyyy-MM-dd HH:mm:ss";
	
	private static SerializeConfig config;
	static{
		config = new SerializeConfig();
		config.put(Date.class, new SimpleDateFormatSerializer(DATE_FORMATE));  
	}
	public static String toJson(Object obj){
		return JSON.toJSONString(obj, config);
	}
	
	public static <T> T toJava(String json,Class<T> clazz){
		return JSON.parseObject(json,clazz);
	}
	
	
}
