package io.parkey19.web;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;

import static org.junit.Assert.*;
import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName;
import static org.springframework.restdocs.headers.HeaderDocumentation.responseHeaders;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.linkWithRel;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.links;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.relaxedLinks;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.relaxedResponseFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by parkey19 on 2019. 4. 1..
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs
@ActiveProfiles("test")
public class VideoControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    GridFsTemplate gridFsTemplate;

    @Test
    public void list() throws Exception {
        //when
        DBObject metaData = new BasicDBObject();
        metaData.put("user", "park");

        File file = new File("videos/bulb.mp4");

        InputStream targetStream = new FileInputStream(file);
        gridFsTemplate.store(targetStream, "1.mp4", "mp4", metaData).toString();
        gridFsTemplate.store(targetStream, "2.mp4", "mp4", metaData).toString();
        gridFsTemplate.store(targetStream, "3.mp4", "mp4", metaData).toString();
        gridFsTemplate.store(targetStream, "4.mp4", "mp4", metaData).toString();

        //http://localhost:8080/video/list?page=0&size=2&sort=uploadDate,DESC
        mockMvc.perform(get("/video/list")
                .contentType(MediaType.APPLICATION_JSON_UTF8) //요청타입
                .accept(MediaTypes.HAL_JSON)
                .param("page", "0")
                .param("size", "2")
                .param("sort", "uploadDate,DESC"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("_embedded.fileMetaList[0].filename").exists())
                .andExpect(jsonPath("_embedded.fileMetaList[0].chunkSize").exists())
                .andExpect(jsonPath("_embedded.fileMetaList[0].metadata.user").exists())
                .andDo(document("video-lists",
                        links(
                                linkWithRel("first").description("link to first page"),
                                linkWithRel("self").description("link to self"),
                                linkWithRel("next").description("link to next page"),
                                linkWithRel("last").description("link to last page"),
                                linkWithRel("profile").description("link to profile")
                        ),
                        requestParameters( //요청 필드 문서화
                                parameterWithName("page").description("page 0부터 시작"),
                                parameterWithName("size").description("한번에 보여줄 리스트 개수"),
                                parameterWithName("sort").description("정렬 컬럼")
                        ),
                        responseHeaders( //응답 헤더 문서화
                                headerWithName(HttpHeaders.CONTENT_TYPE).description("Content type")
                        ),
                        relaxedResponseFields(
                                fieldWithPath("_embedded.fileMetaList[0]._id").description("identifier of new event"),
                                fieldWithPath("_embedded.fileMetaList[0].filename").description("file name"),
                                fieldWithPath("_embedded.fileMetaList[0].chunkSize").description("file size"),
                                fieldWithPath("_embedded.fileMetaList[0].uploadDate").description("file update date"),
                                fieldWithPath("_embedded.fileMetaList[0].md5").description("md5"),
                                fieldWithPath("_embedded.fileMetaList[0].metadata.user").description("file upload user"),
                                fieldWithPath("_embedded.fileMetaList[0].metadata._contentType").description("file extention"),
                                fieldWithPath("_links.self.href").description("link to self"),
                                fieldWithPath("page.size").description("page size"),
                                fieldWithPath("page.totalElements").description("page total elements"),
                                fieldWithPath("page.totalPages").description("total page size"),
                                fieldWithPath("page.number").description("page number")
                        )
                ))
        ;
    }

    @Test
    public void stream() throws Exception {
        //when
        DBObject metaData = new BasicDBObject();
        metaData.put("user", "park");

        File file = new File("videos/bulb.mp4");

        InputStream targetStream = new FileInputStream(file);
        ObjectId mp4 = gridFsTemplate.store(targetStream, "1.mp4", "mp4", metaData);

        System.out.println(mp4.toString());

        mockMvc.perform(get("/video/" + mp4.toString()))
                .andDo(print())
                .andExpect(status().isOk())
        ;


    }

}