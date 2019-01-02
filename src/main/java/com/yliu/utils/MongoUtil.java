package com.yliu.utils;


import org.bson.Document;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;


public class MongoUtil {
	
	private static MongoClient client;
	
	private final static String DB_HOST = "127.0.0.1";
	
	static{
		client = new MongoClient(DB_HOST);
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
