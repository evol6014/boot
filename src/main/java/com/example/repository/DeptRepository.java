package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.example.domain.DeptVO;

public interface DeptRepository extends JpaRepository<DeptVO, Integer>, QuerydslPredicateExecutor<DeptVO>{

	
	
}
