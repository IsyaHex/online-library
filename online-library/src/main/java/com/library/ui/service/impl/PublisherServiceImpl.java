package com.library.ui.service.impl;

import com.library.ui.domain.Publisher;
import com.library.ui.dto.PublisherSaveDto;
import com.library.ui.repository.PublisherRepository;
import com.library.ui.service.PublisherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Service
@Slf4j
public class PublisherServiceImpl implements PublisherService {
    private final PublisherRepository publisherRepository;

    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher save(PublisherSaveDto model) {
        Publisher publisher = new Publisher();
        addNewPublisher(model, publisher);
        return publisherRepository.save(publisher);
    }

    private void addNewPublisher(PublisherSaveDto model, Publisher publisher) {
        publisher.setPublisherName(model.getPublisherName());
        publisher.setLocation(model.getLocation());
        publisher.setTranslatedLanguages(model.getTranslatedLanguages());
        publisher.setPublishedQuantity(model.getPublishedQuantity());
        publisher.setAvgPrice(model.getAvgPrice());
        publisher.setAbout(model.getAbout());
        publisher.setCreatedAt(ZonedDateTime.now());
    }
}
