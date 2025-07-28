package site.Spring.assessment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContentController {

    private final ContentService contentService;

    @Autowired
    ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @GetMapping(path = "/contents")
    public List<Content> getAllContents(){
        return contentService.gelAllContents();
    }

    @PostMapping(path = "/add_content")
    public Content addContent(@RequestBody Content content){
        return contentService.addContent(content);
    }
}