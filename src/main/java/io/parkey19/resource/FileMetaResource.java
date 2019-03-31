package io.parkey19.resource;

import io.parkey19.model.FileMeta;
import io.parkey19.web.VideoController;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * Created by parkey19 on 2019. 3. 31..
 */
public class FileMetaResource extends Resource<FileMeta> {
    public FileMetaResource(FileMeta fileMeta, Link... links) {
        super(fileMeta, links);
        add(linkTo(VideoController.class).slash(fileMeta.get_id()).withSelfRel());
    }
}
