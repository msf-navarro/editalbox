package com.editalbox.service;

import com.editalbox.model.Content;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ContentServiceATest {

    private final ContentService contentService;


    @Autowired
    public ContentServiceATest(ContentService contentService) {
        this.contentService = contentService;
    }

    @Test
    public void testGetContent() {
        // Asserts that a content with the expected properties () exists.

        contentService.getContent(3L);

        Optional<Content> contentOptional = Optional.ofNullable(contentService.getContent(3L));

        assertThat(contentOptional).isPresent();
        if (contentOptional.isPresent()) {
            Content content = contentOptional.get();
            assertThat(content.getExamId()).isEqualTo(2L);
            assertThat(content.getExamName()).isEqualTo("ExampleB (2007)");
            assertThat(content.getSubject()).isEqualTo("mathematics");
            assertThat(content.getText()).isEqualTo("linear algebra");
        }
    }

    @Test
    public void testGetAllContentsFromExamId() {
        /* Asserts that the function retrieves all contents containing
        the same value of examId and with their correct properties. */
        Optional<Content> contentOptional1 = Optional.ofNullable(
                contentService.getAllContentsFromExamId(1L).get(0)
        );
        Optional<Content> contentOptional2 = Optional.ofNullable(
                contentService.getAllContentsFromExamId(1L).get(1)
        );

        assertThat(contentOptional1).isPresent();
        assertThat(contentOptional2).isPresent();

        if (contentOptional1.isPresent()) {
            Content content1 = contentOptional1.get();
            assertThat(content1.getExamId()).isEqualTo(1L);
            assertThat(content1.getExamName()).isEqualTo("ExampleA (2009)");
            assertThat(content1.getSubject()).isEqualTo("statistics");
            assertThat(content1.getText()).isEqualTo("simple probability");
        }

        if (contentOptional2.isPresent()) {
            Content content2 = contentOptional2.get();
            assertThat(content2.getExamId()).isEqualTo(1L);
            assertThat(content2.getExamName()).isEqualTo("ExampleA (2009)");
            assertThat(content2.getSubject()).isEqualTo("statistics");
            assertThat(content2.getText()).isEqualTo("conditional probability");
        }
    }

    @Test
    public void testGetAllContents() {
        /* Asserts that the method will retrieve all existing contents and their correct
        properties. It expects three contents as it was defined in the ContentConfig class. */

        Optional<Content> contentOptional1 = Optional.ofNullable(
                contentService.getAllContents().get(0)
        );
        Optional<Content> contentOptional2 = Optional.ofNullable(
                contentService.getAllContents().get(1)
        );
        Optional<Content> contentOptional3 = Optional.ofNullable(
                contentService.getAllContents().get(2)
        );

        assertThat(contentOptional1).isPresent();
        assertThat(contentOptional2).isPresent();
        assertThat(contentOptional3).isPresent();

        if (contentOptional1.isPresent()) {
            Content content1 = contentOptional1.get();
            assertThat(content1.getExamId()).isEqualTo(1L);
            assertThat(content1.getExamName()).isEqualTo("ExampleA (2009)");
            assertThat(content1.getSubject()).isEqualTo("statistics");
            assertThat(content1.getText()).isEqualTo("simple probability");
        }

        if (contentOptional2.isPresent()) {
            Content content2 = contentOptional2.get();
            assertThat(content2.getExamId()).isEqualTo(1L);
            assertThat(content2.getExamName()).isEqualTo("ExampleA (2009)");
            assertThat(content2.getSubject()).isEqualTo("statistics");
            assertThat(content2.getText()).isEqualTo("conditional probability");
        }

        if (contentOptional3.isPresent()) {
            Content content3 = contentOptional3.get();
            assertThat(content3.getExamId()).isEqualTo(2L);
            assertThat(content3.getExamName()).isEqualTo("ExampleB (2007)");
            assertThat(content3.getSubject()).isEqualTo("mathematics");
            assertThat(content3.getText()).isEqualTo("linear algebra");
        }
    }

    @Test
    public void testCreateContent() {
        /* Asserts that the content doesn't exist prior to the method
        and that it is created after it with its correct properties. */

        Optional<Content> contentOptional = Optional.ofNullable(contentService.getContent(4L));
        assertThat(contentOptional).isNotPresent();

        Content createdContent = new Content(2L, "example subject", "example text");
        contentService.createContent(createdContent);

        // contentOptional is reassigned to receive the updated value of content.
        contentOptional = Optional.ofNullable(contentService.getContent(4L));

        assertThat(contentOptional).isPresent();
        if (contentOptional.isPresent()) {
            Content requestedContent = contentOptional.get();
            assertThat(requestedContent.getExamId()).isEqualTo(2L);
            assertThat(requestedContent.getSubject()).isEqualTo("example subject");
            assertThat(requestedContent.getText()).isEqualTo("example text");
        }
    }
}
//    @Test
//    public void testUpdateContent() {
//        /* Asserts that the content has previous properties prior to the method,
//        and that said properties have their expected value after the method. */
//
//        Optional<Content> contentOptional = Optional.ofNullable(contentService.getContent(1L));
//
//        if (contentOptional.isPresent()) {
//            Content content = contentOptional.get();
//            assertThat(content.getExamId()).isEqualTo(1L);
//            assertThat(content.getExamName()).isEqualTo("ExampleA (2009)");
//            assertThat(content.getSubject()).isEqualTo("statistics");
//            assertThat(content.getText()).isEqualTo("simple probability");
//        }
//
//        contentService.updateContent(
//                1L,
//                2L,
//                "something",
//                null
//        );
//
//        // contentOptional is reassigned to receive the updated value of content.
//        contentOptional = Optional.ofNullable(contentService.getContent(1L));
//
//        assertThat(contentOptional).isPresent();
//        if (contentOptional.isPresent()) {
//            Content content = contentOptional.get();
//            assertThat(content.getExamId()).isEqualTo(2L);
//            assertThat(content.getExamName()).isEqualTo("ExampleB (2007)");
//            assertThat(content.getSubject()).isEqualTo("something");
//            /* text remains unchanged and does NOT receive null, since
//            the attributes should only change when the input is not null. */
//            assertThat(content.getText()).isEqualTo("simple probability");
//        }
//    }
//
//    @Test
//    public void testDeleteContent() {
//
//        Optional<Content> contentOptional = Optional.ofNullable(contentService.getContent(3L));
//
//        assertThat(contentOptional).isPresent();
//        if (contentOptional.isPresent()) {
//            contentService.deleteContent(3L);
//            /* examOptional is reassigned to receive the updated value of exam. Otherwise,
//            it would retain the old value, resulting in .isNotPresent() to return false. */
//            contentOptional = Optional.ofNullable(contentService.getContent(3L));
//            assertThat(contentOptional).isNotPresent();
//        }
//    }