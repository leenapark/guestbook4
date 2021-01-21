package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestDao;
import com.javaex.vo.GuestVo;



@Controller
@RequestMapping(value="/guest")
public class GuestBookController {
	
	// 메소드 단위로 기능을 정의하는 spring
	
		// 필드
		@Autowired
		private GuestDao guestDao;
	
		// 생성자
		// 메소드 g/s
		
		/******** 메소드 일반*********/
		// 메소드 마다 기능 1개씩 --> 기능 마다 url 부여

		// Handler mapping
			// test 화면
			@RequestMapping( "/hello")
			public String hello(){
				System.out.println("/hellospring/hello");
				return "index";		// viewResolver 사용 시 양식 간소화
			}
	
		
			// 리스트
			@RequestMapping(value="/list", method = {RequestMethod.GET, RequestMethod.POST})
			public String list(Model model) {
				System.out.println("list");
				
				List<GuestVo> guestList = guestDao.addList();
				model.addAttribute("guestList", guestList);
				
				System.out.println("guestList: " + guestList);
				
				return "addList";
			}
			
			// 등록
			@RequestMapping(value="/add", method = {RequestMethod.GET, RequestMethod.POST})
			public String add(@ModelAttribute GuestVo guestVo) {
				System.out.println("add");
				
				// 파라미터 값 확인
				System.out.println(guestVo.toString());
				
				guestDao.guestInsert(guestVo);
				
				return "redirect:/guest/list";
			}
			
			// 삭제 폼
			@RequestMapping(value="/dForm", method = {RequestMethod.GET, RequestMethod.POST})
			public String dForm() {
				System.out.println("dForm");

				
				return "deleteForm";
			}
			
			// 삭제
			@RequestMapping(value="/delete", method = {RequestMethod.GET, RequestMethod.POST})
			public String delete(@RequestParam("no") int no, @RequestParam("password") String pass) {
				System.out.println("delete");
				
				System.out.println(no + ", " + pass);
				
				int check = guestDao.guestDelete(no, pass);
				
				if (check == 1) {
					
					System.out.println("비밀번호 확인 성공");
					
					return "redirect:/guest/list";
					
				} else {
					
					System.out.println("비밀번호 확인 실패");
					
					return "redirect:/guest/dForm?result=fail&no="+no;
				}
				
			}
}
