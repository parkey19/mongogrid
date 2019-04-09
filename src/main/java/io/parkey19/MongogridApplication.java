package io.parkey19;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.MongoDatabase;
import io.parkey19.model.UserRole;
import io.parkey19.model.Users;
import io.parkey19.repository.UsersRepository;
import io.parkey19.service.UsersService;
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
import java.util.Arrays;

@SpringBootApplication
public class MongogridApplication {

	@Autowired
	private UsersService usersService;

	public static void main(String[] args) {
		SpringApplication.run(MongogridApplication.class, args);
	}

	@Bean
	public ApplicationRunner applicationRunner() {
		return args -> {
//			Users user = new Users();
//			user.setUsername("k@mail.com");
//			user.setPassword("welcome1");
//			user.setRoles(Arrays.asList(UserRole.ADMIN,UserRole.USER));
//			usersService.saveAccount(user);
		};
	}
}
