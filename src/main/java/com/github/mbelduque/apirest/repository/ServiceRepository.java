package com.github.mbelduque.apirest.repository;

import com.github.mbelduque.apirest.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
    Service findById(long id);
}
