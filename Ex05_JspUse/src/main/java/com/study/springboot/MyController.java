package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <pre>
 * application.properties 파일에 JSP 설정 추가
 * 1. spring.mvc.view.prefix=/WEB-INF/views/
 * 2. spring.mvc.view.suffix=.jsp
 * </pre>
 * @ResponseBody 해당 어노테이션이 없는 @RequestMapping 메서드는 'prefix + 메서드 String 반환값 + suffix'로 조합된 파일을 찾아 실행하고 그 결과를 리턴하도록 한다.
 *               해당 어노테이션이 메서드에 적용되어 있으면, 리턴되는 String 값 자체만 웹 브라우저로 전달한다.
 * @author mat65
 *
 */
@Controller
public class MyController {

	@RequestMapping("/")
	public @ResponseBody String root() throws Exception {  // @ResponseBody 어노테이션이 적용되어 있으므로, String 값 자체를 그대로 웹 브라우저로 전달한다.
		return "JSP in Gradle";
	}
	
	@RequestMapping("/test1")			// localhost:8081/test1
	public String test1() {
		return "test1";					// 실제 호출 : /WEB-INF/views/test1.jsp
	}
	
	@RequestMapping("/test2")			// localhost:8081/test2
	public String test2() {
		return "sub/test2";				// 실제 호출 : /WEB-INF/views/sub/test2.jsp
	}
}
