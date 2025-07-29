package site.Spring.assessment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContentService {

    private final ContentRepository contentRepository;
    private final ExamRepository examRepository;

    @Autowired
    ContentService(ContentRepository contentRepository,
                   ExamRepository examRepository){
        this.contentRepository = contentRepository;
        this.examRepository = examRepository;
    }

    public List<Content> gelAllContents(){
        return contentRepository.findAll();
    }

    public Content createContent(Content content) {
        Optional<Exam> contentExamOptional =
                examRepository.findById(content.getExamId());
        if (contentExamOptional.isPresent())
            content.setExam(contentExamOptional.get());
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
