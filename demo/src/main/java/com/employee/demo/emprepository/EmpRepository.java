package com.employee.demo.emprepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.employee.demo.empentity.EmpEntity;
@EnableJpaRepositories
@Repository
public interface EmpRepository extends JpaRepository<EmpEntity, Integer> {

}
