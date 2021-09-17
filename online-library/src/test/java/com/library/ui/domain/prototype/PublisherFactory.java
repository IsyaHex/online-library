package com.library.ui.domain.prototype;

import com.library.ui.constant.LanguagesListEnum;
import com.library.ui.domain.Publisher;

import java.time.ZonedDateTime;

public class PublisherFactory {

    public static Publisher getPublisher() {
        Publisher publisher = new Publisher();
        publisher.setId(1L);
        publisher.setPublisherName("Publisher Name");
        publisher.setLocation("Your current Location");
        publisher.setTranslatedLanguages(LanguagesListEnum.CHINESE.name());
        publisher.setPublishedQuantity(25);
        publisher.setAvgPrice(30.00);
        publisher.setAbout("Info about Publisher");
        publisher.setCreatedAt(ZonedDateTime.now());
        publisher.setUpdatedAt(ZonedDateTime.now());

        return publisher;
    }
}
