package io.parkey19.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


/**
 * Created by parkey19 on 2018. 11. 19..
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "_id")
@Document(collection="fs.files")
public class FileMeta {
    @Id
    public String _id;
    public String filename;
    public Long chunkSize;
    public Date uploadDate;
    public String md5;
    public Metadata metadata;

    private static class Metadata {
        public String user;
        public String _contentType;
    }

}
