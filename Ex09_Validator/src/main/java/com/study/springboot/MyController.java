package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	
	@RequestMapping("/")
	public @ResponseBody String root() throws Exception {
		return "Validator (1)";
	}
	
	@RequestMapping("/insertForm")
	public String insert1() {
		return "createPage";
	}
	
	@RequestMapping("/create")
	public String insert2( @ModelAttribute("dto") ContentDto contentDto, BindingResult result ) {
		// @ModelAttribute : 지정한 변수명으로 커맨드 객체를 새로 생성해 준다. 
		// @BindingResult : validator 수행 후, 유효성 검증에 대한 오류 정보가 반환된다. 이를 통해 오류 존재 여부에 따른 분기 처리가 가능하다.
		String page = "createDonePage";
		System.out.println( contentDto );
		
		ContentValidator validator = new ContentValidator();
		validator.validate( contentDto, result );
		
		if ( result.hasErrors() ) {
			page = "createPage";
		}
		
		return page;
	}
}
