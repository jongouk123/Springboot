package com.study.springboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * <pre>
 * application.properties 설정
 * -------------------------------------
 * # JSP
 * spring.mvc.view.prefix=/WEB-INF/views/
 * spring.mvc.view.suffix=.jsp
 * -------------------------------------
 * </pre>
 * @author mat65
 *
 */
@Controller
public class MyController {

	@RequestMapping("/")
	public @ResponseBody String root() throws Exception { 
		//@ResponseBody : 내용 자체만 String으로 리턴한다.
		return "Model & View";
	}
	
	@RequestMapping("/test1")
	public String test1( Model model ) {
		// Model 객체를 이용해서, view로 Data 전달
		// 데이터만 설정이 가능
		// 리턴된 String 값을 View Resolver가 조합하여 test1.jsp를 찾아온다.
		model.addAttribute( "name", "홍길동" );
		
		return "test1";
	}
	
	@RequestMapping("/mv")
	public ModelAndView test2() {
		// 데이터와 뷰를 동시에 설정이 가능
		// String 값을 리턴하지 않고, 데이터 정보와 뷰 정보까지 함께 담은 객체 자체를 리턴한다.
		ModelAndView mv = new ModelAndView();
		
		List<String> list = new ArrayList<>();
		
		list.add( "test1" );
		list.add( "test2" );
		list.add( "test3" );
		
		mv.addObject( "lists", list );						// jstl로 호출
		mv.addObject( "ObjectTest", "테스트입니다." );		// jstl로 호출
		mv.addObject( "name", "홍길동" );					// jstl로 호출
		mv.setViewName( "view/myView" );
		
		return mv;
		
	}
	
}
