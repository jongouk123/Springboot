package com.study.springboot;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	
	@RequestMapping("/")
	public @ResponseBody String root() throws Exception {
		return "Valid_Annotation (4)";
	}
	
	@RequestMapping("/insertForm")
	public String insert1() {
		return "createPage";
	}
	
	@RequestMapping("/create")
	public String insert2( @ModelAttribute("dto") @Valid ContentDto contentDto, BindingResult result ) {
		// @ModelAttribute : 지정한 변수명으로 커맨드 객체를 새로 생성해 준다. 
		// @Valid : contentDto 객체 변수에 대한 유효성 검증을 지정한다. 파라미터로 객체 변수가 들어오면 
		//          binder 변수에 저장된 contentValidator 객체를 통해서 즉시 유효성 검사를 실시하고, 에러가 있다면 result 변수에 담아 둔다.
		//          Validator의 약한 결합 사용 시, 직접 내부에서 생성하여 검증 진행할 필요 없이 어노테이션만 추가로 간단하게 유효성 검사를 수행할 수 있다.
		// @BindingResult : validator 수행 후, 유효성 검증에 대한 오류 정보가 반환된다. 이를 통해 오류 존재 여부에 따른 분기 처리가 가능하다.
		String page = "createDonePage";
		System.out.println( contentDto );
		
//		ContentValidator validator = new ContentValidator();
//		validator.validate( contentDto, result );
		
		// 유효성 검증을 위해 result 변수는 그대로 사용한다.
		if ( result.hasErrors() ) {
//			System.out.println( "getAllErrors : " + result.getAllErrors() );
			
//			if ( result.getFieldError( "writer" ) != null ) {
//				System.out.println( "1:" + result.getFieldError( "writer" ).getCode() );
//			}
//			
//			if ( result.getFieldError( "content" ) != null ) {
//				System.out.println( "2:" + result.getFieldError( "content" ).getCode() );
//			}
			
			// 어노테이션을 통한 유효성 검증을 하게 되면, 에러 내용을 가져올 때, getDefaultMessage() 메서드를 사용한다.
			if ( result.getFieldError( "writer" ) != null ) {
			System.out.println( "1:" + result.getFieldError( "writer" ).getDefaultMessage() );
			}
		
			if ( result.getFieldError( "content" ) != null ) {
				System.out.println( "2:" + result.getFieldError( "content" ).getDefaultMessage() );
			}
			
			page = "createPage";
		}
		
		return page;
	}
	
//	@InitBinder
//	protected void initBinder( WebDataBinder binder ) {
//		// @InitBinder : 프로젝트가 시작할 때 해당 어노테이션을 먼저 실행시킨다.
//		//               WebDataBinder 타입 변수에 우리가 사용할 유효성 검증 클래스(ContentValidator)가 프로젝트 시작 시 설정된다.
//		//               유효성 검증이 필요하면 binder 변수에서 꺼내어 사용하면 된다. 매번 new로 만들 필요 없이 약한 결합으로 사용할 수 있다.
//		binder.setValidator( new ContentValidator() );
//	}
}
