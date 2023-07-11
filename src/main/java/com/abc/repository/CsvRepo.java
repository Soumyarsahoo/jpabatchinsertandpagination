package com.abc.repository;

import com.abc.entity.CsvEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CsvRepo extends JpaRepository<CsvEntity,Integer> {

}
