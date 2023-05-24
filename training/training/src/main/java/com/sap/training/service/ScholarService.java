package com.sap.training.service;

import com.sap.training.model.Scholar;
import com.sap.training.repository.ScholarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScholarService {
    Logger logger = LoggerFactory.getLogger(ScholarService.class);

    @Autowired
    public ScholarRepository scholarRepository;

    public boolean addScholar(Scholar scholar) {
        try {
            scholarRepository.save(scholar);
            return true;
        } catch (Exception e) {
            logger.error("Something went wrong: ", e);
            return false;
        }
    }

    public List<Scholar> getAllScholars() {
        List<Scholar> list;
        try {
            list = scholarRepository.findAll();
        } catch (Exception e) {
            logger.error("Something went wrong: ", e);
            list = new ArrayList<>();
        }
        return list;
    }

    public List<Scholar> getScholarByBatch(String batch) {
        List<Scholar> list;
        try {
            list = scholarRepository.findByBatch(batch);
        } catch (Exception e) {
            logger.error("Something went wrong: ", e);
            list = new ArrayList<>();
        }
        return list;
    }

    public List<Scholar> getScholarByINumber(String inumber) {
        List<Scholar> list;
        try {
            list = scholarRepository.findByInumber(inumber);
        } catch (Exception e) {
            logger.error("Something went wrong: ", e);
            list = new ArrayList<>();
        }
        return list;
    }

    public boolean deleteScholar(long id) {
        try {
            scholarRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            logger.error("Something went wrong: ", e);
            return false;
        }
    }


}
