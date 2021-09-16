package com.library.ui.service;

import com.library.ui.domain.Publisher;
import com.library.ui.dto.PublisherSaveDto;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import java.util.List;

public interface PublisherService {
    List<Publisher> findAll();
    Publisher save(PublisherSaveDto model);
}
