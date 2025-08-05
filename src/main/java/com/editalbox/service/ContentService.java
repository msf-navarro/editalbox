package com.editalbox.service;

import com.editalbox.model.Content;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContentService {

    public Content getContent(Long id);

    public List<Content> gelAllContentsFromExamId(Long requestedExamId);

    public List<Content> gelAllContents();

    public Content createContent(Content content);

    public void updateContent(Long contentId,
                              Long contentExamId,
                              String contentSubject,
                              String contentText);

    public void deleteContent(Long contentId);
}