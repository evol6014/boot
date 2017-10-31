package com.example.dept;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.DeptVO;
import com.example.repository.DeptRepository;

import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class DeptRepositoryTest {

	@Inject
	DeptRepository repo;
	
	@Test
	public void insert() {
		
		DeptVO dept = new DeptVO();
		
		dept.setDeptno(11);
		dept.setDname("감찰부");
		dept.setLoc("청주");
		
		repo.save(dept);
	}

}
