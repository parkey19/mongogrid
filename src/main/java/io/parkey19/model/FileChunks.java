package io.parkey19.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


/**
 * Created by parkey19 on 2018. 11. 19..
 */
@Data
@Document(collection="fs.chunks")
public class FileChunks {
    @Id
    public String _id;
    public String filesId;
    public Long n;
    public Object data;

}
