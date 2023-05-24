package com.sap.training.repository;

import com.sap.training.model.Scholar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScholarRepository extends JpaRepository<Scholar, Long> {

    @Query(value = "SELECT * FROM Scholar s WHERE s.BATCH = ?1", nativeQuery = true)
    List<Scholar> findByBatch(String batch);

    @Query(value = "SELECT * FROM Scholar s WHERE s.INUMBER = ?1", nativeQuery = true)
    List<Scholar> findByInumber(String inum);
}
