package com.example.controller;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.EmpVO;
import com.example.repository.EmpsRepository;
import com.example.vo.PageMaker;
import com.example.vo.PageVO;

import lombok.extern.java.Log;

@Controller
@RequestMapping("/emp")
@Log
public class EmpController {

	@Inject
	EmpsRepository repo;
	
	@GetMapping("/list")
	public String list(@ModelAttribute("pageVO") PageVO vo, Model model) {
		
		Pageable page = vo.makePageable(0, "empno");
		
		Page<EmpVO> result = repo.findAll(
									repo.makePredicate(vo.getType(), vo.getKeyword()), page);
		
		log.info("" + page);
		log.info("" + result);

		log.info("TOTAL PAGE NUMBER: " + result.getTotalPages());
		
		model.addAttribute("pageMaker", new PageMaker<EmpVO>(result));
		
		return "jsp/emp/list";
	}
	
	@GetMapping("/register")
	public String registerGET(@ModelAttribute("vo") EmpVO vo) {
		log.info("register get");

		
		return "jsp/emp/register";
	}
	
	@PostMapping("/register")
	public String registerPOST(@ModelAttribute("vo") EmpVO vo, 
													RedirectAttributes rttr) {
		log.info("register post");
		log.info("" +  vo);
		
		repo.save(vo);
		rttr.addFlashAttribute("msg", "success");
		
		return "redirect:/emp/list";
	}
	
	@GetMapping("/view")
	public String view(Integer empno, @ModelAttribute("pageVO") PageVO vo, Model model){
		
		log.info("EMPNO: "+ empno);
		
		repo.findById(empno).ifPresent(emp -> model.addAttribute("vo", emp));
		
		return "jsp/emp/view";
	}
	
	@GetMapping("/modify")
	public String modify(Integer empno, @ModelAttribute("pageVO") PageVO vo, Model model){
		
		log.info("MODIFY Emp: "+ empno);
		
		repo.findById(empno).ifPresent(emp -> model.addAttribute("vo", emp));
		
		return "jsp/emp/modify";
	}
	
	@PostMapping("/modify")
	public String modifyPost(EmpVO emp, PageVO vo, RedirectAttributes rttr ){
		
		log.info("Modify Emp: " + emp);
		
		repo.findById(emp.getEmpno()).ifPresent( origin ->{
		 
			origin.setEmpno(emp.getEmpno());;
			origin.setEname(emp.getEname());
			origin.setGender(emp.getGender());
			origin.setJob(emp.getJob());
			origin.setJob(emp.getJob());
			origin.setMgr(emp.getMgr());
			origin.setHiredate(emp.getHiredate());
			origin.setSal(emp.getSal());
			origin.setComm(emp.getComm());
			origin.setDept(emp.getDept());
			
			repo.save(origin);
			rttr.addFlashAttribute("msg", "success");
			rttr.addAttribute("deptno", origin.getEmpno());
		});
		
		log.info("emp = " + emp);
		log.info("empno = "+ emp.getEmpno());
		
		//페이징과 검색했던 결과로 이동하는 경우 
		
		rttr.addAttribute("empno", emp.getEmpno());
		rttr.addAttribute("page", vo.getPage());
		rttr.addAttribute("size", vo.getSize());
		rttr.addAttribute("type", vo.getType());
		rttr.addAttribute("keyword", vo.getKeyword());

		return "redirect:/emp/view";
	}
	
	@PostMapping("/delete")
	public String delete(Integer empno, PageVO vo, RedirectAttributes rttr ){
		
		log.info("DELETE Deptno: " + empno);
		
		repo.deleteById(empno);
		
		rttr.addFlashAttribute("msg", "success");

		//페이징과 검색했던 결과로 이동하는 경우 
		rttr.addAttribute("page", vo.getPage());
		rttr.addAttribute("size", vo.getSize());
		rttr.addAttribute("type", vo.getType());
		rttr.addAttribute("keyword", vo.getKeyword());

		return "redirect:/emp/list";
	}
}


