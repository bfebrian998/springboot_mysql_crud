package com.example.app.rest.repository;

import com.example.app.rest.model.CrudModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CrudRepo extends JpaRepository<CrudModel, Long> {

}
