package com.editalbox.service;

import com.editalbox.model.Content;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/* Created to run testUpdateContent and testDeleteContent
separately, since it was causing error in other tests. */
@SpringBootTest
public class ContentServiceBTest {

    /*Note: the expected results written in the tests are
    based on the values provided in the ContentConfig class.*/

    private final ContentService contentService;

    @Autowired
    public ContentServiceBTest(ContentService contentService) {
        this.contentService = contentService;
    }

    @Test
    public void testUpdateContent() {
        /* Asserts that the content has previous properties prior to the method,
        and that said properties have their expected value after the method. */

        Optional<Content> contentOptional = Optional.ofNullable(contentService.getContent(1L));

        if (contentOptional.isPresent()) {
            Content content = contentOptional.get();
            assertThat(content.getExamId()).isEqualTo(1L);
            assertThat(content.getExamName()).isEqualTo("ExampleA (2009)");
            assertThat(content.getSubject()).isEqualTo("statistics");
            assertThat(content.getText()).isEqualTo("simple probability");
        }

        contentService.updateContent(
                1L,
                2L,
                "something",
                null
        );

        // contentOptional is reassigned to receive the updated value of content.
        contentOptional = Optional.ofNullable(contentService.getContent(1L));

        assertThat(contentOptional).isPresent();
        if (contentOptional.isPresent()) {
            Content content = contentOptional.get();
            assertThat(content.getExamId()).isEqualTo(2L);
            assertThat(content.getExamName()).isEqualTo("ExampleB (2007)");
            assertThat(content.getSubject()).isEqualTo("something");
            /* text remains unchanged and does NOT receive null, since
            the attributes should only change when the input is not null. */
            assertThat(content.getText()).isEqualTo("simple probability");
        }
    }

    @Test
    public void testDeleteContent() {
        /* Asserts that the content existed prior to the method, and
        that said content was successfully deleted after the method. */

        Optional<Content> contentOptional = Optional.ofNullable(contentService.getContent(3L));

        assertThat(contentOptional).isPresent();
        if (contentOptional.isPresent()) {
            contentService.deleteContent(3L);
            /* examOptional is reassigned to receive the updated value of exam. Otherwise,
            it would retain the old value, resulting in .isNotPresent() to return false. */
            contentOptional = Optional.ofNullable(contentService.getContent(3L));
            assertThat(contentOptional).isNotPresent();
        }
    }
}
