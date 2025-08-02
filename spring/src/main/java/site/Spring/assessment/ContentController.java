package site.Spring.assessment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContentController {

    private final ContentService contentService;

    @Autowired
    ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @GetMapping(path = "/admin/resources/contents/{id}")
    public Content getContent(@PathVariable("id") Long id) {
        return contentService.getContent(id);
    }

    @GetMapping(path = "/admin/resources/contents")
    public List<Content> getAllContents(){
        return contentService.gelAllContents();
    }

    @GetMapping(path = "/exams/{id}/contents")
    public List<Content> getAllContentsfromExamId(@PathVariable("id") Long requestedExamId){
        return contentService.gelAllContentsFromExamId(requestedExamId);
    }

    @PostMapping(path = "/admin/resources/contents")
    public Content createContent(@RequestBody Content content){
        return contentService.createContent(content);
    }

    @PutMapping(path = "/admin/resources/contents/{id}")
    public void updateContent(@PathVariable("id") Long contentId,
                              @RequestParam(required = false, name = "exam_id") Long contentExamId,
                              @RequestParam(required = false, name = "subject") String contentSubject,
                              @RequestParam(required = false, name = "text") String contentText){
        contentService.updateContent(contentId, contentExamId, contentSubject, contentText);
    }

    @DeleteMapping(path = "/admin/resources/contents/{id}")
    public void deleteContent(@PathVariable("id") Long contentId){
        contentService.deleteContent(contentId);
    }
}