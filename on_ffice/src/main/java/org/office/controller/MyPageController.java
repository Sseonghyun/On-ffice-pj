/*
*	작성자 : 고광훈
*	진행상황 : src/main/java 패키지 생성, office페이지 컨트롤러, Mapper, Service, VO 생성 
*	변수정리 : 
*	테스트 성공 유무 :  9/21 main페이지 테스트 성공
*	오류사항 : 
*	etc...
*	
*/
package org.office.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.office.domain.MealVO;
import org.office.domain.TodoVO;
import org.office.domain.UserVO;
import org.office.service.MyPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller // 컴포넌트스캔
@Log4j
@RequestMapping("/mypage/*") // 이 클래스를 사용하는 메서드이 들어오는 주소 앞 /mypage로 명명
@AllArgsConstructor // 의존성 주입
public class MyPageController {

	@Autowired
	private MyPageService service;

	@GetMapping("/main")
	public String getInfo(String uid, String dailymeal, Model model, HttpServletRequest request) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyyMMdd");
		HttpSession session = request.getSession();
		String login_session_id = (String) session.getAttribute("login_session");
		String login_session_name = (String) session.getAttribute("name_session");
		String login_time = formatter.format(session.getCreationTime()); //특정 세션만 골라서 출력하는법 찾아보기.
		dailymeal = formatter2.format(new Date());
		 
		log.info("유저 메인페이지 접속");
		log.info("세션 아이디 : " + login_session_id);
		UserVO uservo = service.getInfo("test1"); //테스트를 위해 test1삽입 추후 login_session_uid로 변경
		log.info("받아온 정보 : " + uservo);
		List<TodoVO> todoList = service.getTodo("test1");
		log.info("받아온 할일 : " +todoList);
		MealVO mealvo = service.getMeal(dailymeal);
		log.info("받아온 정보 : " + mealvo);
		
		
		model.addAttribute("info", uservo);
		model.addAttribute("login_time", login_time);
		model.addAttribute("meal", mealvo);
		model.addAttribute("todoList",todoList);
		return "mypage/main";
	}
	
}
