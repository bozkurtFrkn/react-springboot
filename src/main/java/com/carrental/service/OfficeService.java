package com.carrental.service;

import com.carrental.entity.Office;
import com.carrental.repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OfficeService {

    @Autowired
    private OfficeRepository officeRepository;

    public List<Office> getAllOffice() {
        return officeRepository.findAllByStatus(1L);
    }

    public Office getOffice(Long officeId) {
        return officeRepository.findByOfficeId(officeId);
    }

    public Office save(Office office) {
        office.setStatus(1L);
        office.setCreatedBy("admin");
        office.setCreationDate(LocalDateTime.now());
        office.setUpdatedBy("admin");
        office.setUpdatedDate(LocalDateTime.now());
        return officeRepository.save(office);
    }

    public Office update(Office office) {
        office.setUpdatedBy("admin");
        office.setUpdatedDate(LocalDateTime.now());
        return officeRepository.save(office);
    }

    public void delete(Office office) {
        office.setStatus(0L);
        officeRepository.save(office);
    }
}
