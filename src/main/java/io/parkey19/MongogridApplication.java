package io.parkey19;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import java.io.FileInputStream;
import java.io.InputStream;

@SpringBootApplication
public class MongogridApplication {


	public static void main(String[] args) {
		SpringApplication.run(MongogridApplication.class, args);
	}

	@Bean
	public ApplicationRunner applicationRunner() {
		return args -> {
//			DBObject metaData = new BasicDBObject();
//			metaData.put("user", "park");
//
//			GridFsTemplate gridFsTemplate = new GridFsTemplate(mongoDbFactory, mappingMongoConverter);
//
//			InputStream inputStream = new FileInputStream("videos/bulb.mp4");
//			gridFsTemplate.store(inputStream, "bulb.mp4", "video/mp4", metaData).toString();

//			MongoDatabase db = mongoDbFactory.getDb();
//			db.createCollection("news");
//
//			db.getCollection("news").insertOne(
//					new Document()
//						.append("title", "new ")
//						.append("contents", "some..")
//			);
		};
	}
}
