package com.yliu.base;

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
}
