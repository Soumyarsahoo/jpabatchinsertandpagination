package com.abc.service;

import com.abc.entity.CsvEntity;
import com.abc.repository.CsvRepo;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Service
public class CsvParser {

    @Value("${spring.jpa.properties.hibernate.jdbc.batch_size}")
    private int batchSize;

    @Autowired
    private CsvRepo repository;

    public void parseCsv() throws FileNotFoundException {

        File file = ResourceUtils.getFile("classpath:Sample-Spreadsheet-10000-rows.csv");

        List<CsvEntity> beans = new CsvToBeanBuilder<CsvEntity>(new FileReader(file))
                .withType(CsvEntity.class)
                .build()
                .parse();

//        System.out.println("CSV BEAN::: "+beans);

        int totalObjects = beans.size();

        for (int i = 0; i < totalObjects; i = i + batchSize) {
            if( i+ batchSize > totalObjects){
                List<CsvEntity> bean1 = beans.subList(i, totalObjects - 1);
                repository.saveAll(bean1);
                break;
            }
            List<CsvEntity> bean1 = beans.subList(i, i + batchSize);
            System.out.println("bean1.size() = " + bean1.size());
            repository.saveAll(bean1);
        }
    }
}
