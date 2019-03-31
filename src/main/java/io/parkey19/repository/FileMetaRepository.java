package io.parkey19.repository;

import io.parkey19.model.FileMeta;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by parkey19 on 2018. 11. 19..
 */
public interface FileMetaRepository extends MongoRepository<FileMeta, String> {
}
