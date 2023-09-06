package com.abc.controller;

import com.abc.entity.CsvEntity;
import com.abc.entity.SortField;
import com.abc.service.CsvParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
public class CsvController {

    @Autowired
    private CsvParser csvParser;

    @GetMapping("/insert")
    public void jpaBatchInsert() throws FileNotFoundException {
        csvParser.parseCsv();
    }

    @GetMapping("/getByPagination")
    public ResponseEntity<Page<CsvEntity>> getRecordsByPagination(
            @RequestParam(defaultValue = "0", required = false) Integer page,
            @RequestParam(defaultValue = "10", required = false) Integer pageSize,
            @RequestParam String sortDirection,
            @RequestParam String sortField
    ){
//        Sort sort = Sort.by("id").descending();
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name())?
                Sort.by(sortField).ascending(): Sort.by(sortField).descending();

//        System.out.println(sortField.getDatabaseFieldName());
        Pageable pageable  = PageRequest.of(page, pageSize,sort);
        return new ResponseEntity<>(csvParser.getRecordsByPagination(pageable), HttpStatus.ACCEPTED);
    }
}
//for multisort
//    Sort nameSort = Sort.by("id");
//    Sort emailSort = Sort.by("field1")
//    Sort multiSort = emailSort.and(nameSort);



