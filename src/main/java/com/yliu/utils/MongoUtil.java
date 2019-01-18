package com.yliu.utils;


import org.bson.Document;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;



public class MongoUtil {
	
	private static MongoClient client;
	
	private final static String DB_HOST = "127.0.0.1";
	
	static{
		client = new MongoClient(DB_HOST);
		//关闭驱动日志
		Logger log = (ch.qos.logback.classic.Logger)LoggerFactory
				.getLogger("org.mongodb.driver");
		log.setLevel(Level.OFF);
	}
	
	public static MongoCollection<Document> getCollection(String dbName,String collName){
		return client.getDatabase(dbName).getCollection(collName);
	}
	
	public static Document adaptToDocument(Object t){
		JSONObject json = (JSONObject)JSON.toJSON(t);
		Document doc = new Document(json);
		return doc;
	}
	
	public static<T> T adaptToJava(Document doc,Class<T> clazz){
		JSONObject json = new JSONObject(doc);
		T t = json.toJavaObject(clazz);
		return t;
	}
}
