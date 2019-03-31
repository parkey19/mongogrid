package io.parkey19.web;

import java.io.*;
import java.util.List;

import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSFile;
import io.parkey19.model.FileMeta;
import io.parkey19.repository.FileMetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

/**
 * Created by parkey19 on 2018. 11. 19..
 */
@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    FileMetaRepository videoRepository;

    @Autowired
    GridFsTemplate gridFsTemplate;

    @Autowired
    GridFSBucket gridFSBucket;

    @GetMapping("/list")
    public ResponseEntity<?> list() {
        List<FileMeta> list = videoRepository.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public StreamingResponseBody stream(@PathVariable String id) throws FileNotFoundException {
        // read file from MongoDB
        GridFSFile gridFsdbFile = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(id)));
        GridFSDownloadStream gridFSDownloadStream = gridFSBucket.openDownloadStream(gridFsdbFile.getObjectId());

        return (os) -> {
            readAndWrite(gridFSDownloadStream, os);
        };
    }

    private void readAndWrite(final InputStream is, OutputStream os)
            throws IOException {
        byte[] data = new byte[2048];
        int read = 0;
        while ((read = is.read(data)) > 0) {
            os.write(data, 0, read);
        }
        os.flush();
    }

}
