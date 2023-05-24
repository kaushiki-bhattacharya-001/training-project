package com.sap.training.web;

import com.sap.training.dto.ScholarDto;
import com.sap.training.model.Scholar;
import com.sap.training.service.ScholarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/scholar")
public class ScholarController {
    Logger logger = LoggerFactory.getLogger(ScholarController.class);

    @Autowired
    public ScholarService scholarService;

    @PostMapping("/addScholar")
    public HttpEntity<Scholar> addScholar(@RequestBody ScholarDto scholarDto) {
        logger.info("Request body: " + scholarDto);
        HttpStatus status;
        Scholar scholar = new Scholar();
        scholar.setFull_name(scholarDto.getFull_name());
        scholar.setBatch(scholarDto.getBatch());
        scholar.setManager(scholarDto.getManager());
        scholar.setInumber(scholarDto.getInumber());
        if(scholarService.addScholar(scholar)) {
            status = HttpStatus.CREATED;
        } else
            status = HttpStatus.NOT_IMPLEMENTED;
        return new ResponseEntity<>(status);
    }

    @GetMapping("/")
    public HttpEntity<List<Scholar>> listAllScholar() {
        HttpStatus status = HttpStatus.OK;
        List<Scholar> res = scholarService.getAllScholars();
        return new ResponseEntity<>(res, status);
    }

    @GetMapping("/batch/{batch}/")
    public HttpEntity<List<Scholar>> getScholarByBatch (@PathVariable String batch) {
          HttpStatus status = HttpStatus.OK;
          List<Scholar> res = scholarService.getScholarByBatch(batch);
          return new ResponseEntity<>(res, status);
    }

    @GetMapping("/inumber/{inumber}/")
    public HttpEntity<List<Scholar>> getScholarByINumber (@PathVariable String inumber) {
        HttpStatus status = HttpStatus.OK;
        List<Scholar> res = scholarService.getScholarByINumber(inumber);
        return new ResponseEntity<>(res, status);
    }
    @PostMapping("/deleteByInumber")
    public HttpEntity<Scholar> deleteScholarByName (@RequestBody ScholarDto scholarDto) {
        HttpStatus status;
        List<Scholar> res = scholarService.getScholarByINumber(scholarDto.getInumber());
        long id = res.get(0).getId();
        boolean flag = scholarService.deleteScholar(id);
        if(flag)
            status = HttpStatus.OK;
        else
            status = HttpStatus.NOT_MODIFIED;
        return new ResponseEntity<>(status);
    }
}
