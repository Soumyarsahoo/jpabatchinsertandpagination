package com.abc.controller;

import com.abc.service.CsvParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
public class CsvController {

    @Autowired
    private CsvParser csvParser;

    @GetMapping("/insert")
    public void jpaBatchInsert() throws FileNotFoundException {
        csvParser.parseCsv();
    }
}
