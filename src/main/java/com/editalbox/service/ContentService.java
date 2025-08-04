package com.editalbox.service;

import com.editalbox.model.Content;
import com.editalbox.model.Exam;
import com.editalbox.repository.ContentRepository;
import com.editalbox.repository.ExamRepository;
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

    public Content getContent(Long id) {
        Optional<Content> contentOptional = contentRepository.findById(id);
        if (contentOptional.isPresent())
            return contentOptional.get();
        else return null;
    }

    public List<Content> gelAllContentsFromExamId(Long requestedExamId) {
        return contentRepository.findContentByExamId(requestedExamId);
    }

    public List<Content> gelAllContents(){
        return contentRepository.findAll();
    }

    public Content createContent(Content content) {
        Optional<Exam> contentExamOptional =
                examRepository.findById(content.getExamId());
        if (contentExamOptional.isPresent()) {
            content.setExam(contentExamOptional.get());
            return contentRepository.save(content);
        }
        else return null;
    }

    public void updateContent(Long contentId, Long contentExamId, String contentSubject, String contentText){
        Optional<Content> contentOptional = contentRepository.findById(contentId);
        if (contentOptional.isPresent()){
            Content content = contentOptional.get();
            if (contentExamId != null) {
                Optional<Exam> examOptional = examRepository.findById(contentExamId);
                if (examOptional.isPresent()) {
                    content.setExam(examOptional.get());
                }
            }
            if (contentSubject != null)
                content.setSubject(contentSubject);
            if (contentText != null)
                content.setText(contentText);
            contentRepository.save(content);
        }
    }

    public void deleteContent(Long contentId) {
        Optional<Content> contentOptional = contentRepository.findById(contentId);
        if (contentOptional.isPresent())
            contentRepository.delete(contentOptional.get());
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
