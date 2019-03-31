package io.parkey19.web;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

/**
 * Created by parkey19 on 2018. 12. 4..
 */
@Controller
public class FileUploadController {

    @Autowired
    GridFsTemplate gridFsTemplate;

    @PostMapping("/video/save")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        DBObject metaData = new BasicDBObject();
        metaData.put("user", "park");
        try {
            gridFsTemplate.store(file.getInputStream(), file.getOriginalFilename(), file.getContentType(), metaData).toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/video/list";
    }


}
