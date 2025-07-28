package site.Spring.assessment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentService {

    private final ContentRepository contentRepository;

    @Autowired
    ContentService(ContentRepository contentRepository){
        this.contentRepository = contentRepository;
    }

    public List<Content> gelAllContents(){
        return contentRepository.findAll();
    }

    public Content addContent(Content content) {
        return contentRepository.save(content);
    }
}

//    public void addContent(Content content) {
//        contents.add(content);
//        content.setExam(this);
//    }
//
//    public void removeContent(Content content) {
//        contents.remove(content);
//        content.setExam(null);
//    }
