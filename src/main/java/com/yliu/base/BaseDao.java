package com.yliu.base;

import java.util.List;
import java.util.stream.Collectors;

import org.bson.Document;
import org.slf4j.Logger;

import com.mongodb.client.MongoCollection;
import com.yliu.utils.MongoUtil;

public abstract class BaseDao<T> {

	public abstract String getDbName();
	
	public abstract String getCollName();
	
	public abstract Logger getLog();
	
	public int save(T t){
		MongoCollection<Document> collection = 
				MongoUtil.getCollection(getDbName(), getCollName());
		Document doc = MongoUtil.adaptToDocument(t);
		collection.insertOne(doc);
		return 1;
	}
	
	public int save(List<T> list){
		MongoCollection<Document> collection = 
				MongoUtil.getCollection(getDbName(), getCollName());
		List<Document> docs = list.stream().map(t->MongoUtil.adaptToDocument(t)).collect(Collectors.toList());
		collection.insertMany(docs);
		return list.size();
	}
	
	public MongoCollection<Document> getColection(){
		MongoCollection<Document> collection = 
				MongoUtil.getCollection(getDbName(), getCollName());
		return collection;
	}
}
