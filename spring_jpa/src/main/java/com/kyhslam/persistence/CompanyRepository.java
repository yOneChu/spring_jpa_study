package com.kyhslam.persistence;

import org.springframework.data.repository.CrudRepository;

import com.kyhslam.domain.Company;

public interface CompanyRepository extends CrudRepository<Company, Long> {

}
