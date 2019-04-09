package io.parkey19.repository;

import io.parkey19.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * Created by parkey19 on 2019. 4. 8..
 */
public interface UsersRepository extends MongoRepository<Users,String> {
    Optional<Users> findByUsername(String username);
}
