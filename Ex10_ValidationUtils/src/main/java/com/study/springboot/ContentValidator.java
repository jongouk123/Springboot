package com.study.springboot;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ContentValidator implements Validator {

	@Override
	public boolean supports( Class<?> clazz ) {
		return ContentDto.class.isAssignableFrom( clazz ); // 검증할 객체의 클래스 타입 정보
	}

	@Override
	public void validate( Object target, Errors errors ) {
		
		// 커맨드 객체(ContentDto)를 target으로 받아들여 ContentDto로 형변환
		ContentDto dto = (ContentDto)target;
		
//		String sWriter = dto.getWriter();
//		if ( sWriter == null | sWriter.trim().isEmpty() ) {
//			System.out.println( "Writer is null or empty" );
//			// sWriter의 값이 null 또는 공백이라면, errors 객체 변수에 에러 내용을 담는다.
//			errors.rejectValue( "writer", "trouble" );
//		}
		ValidationUtils.rejectIfEmptyOrWhitespace( errors, "writer", "writer is empty." );
		
//		String sContent = dto.getContent();
//		if ( sContent == null | sContent.trim().isEmpty() ) {
//			System.out.println( "Content is null or empty" );
//			// sContent의 값이 null 또는 공백이라면, errors 객체 변수에 에러 내용을 담는다.
//			errors.rejectValue( "content", "trouble" );
//		}
		ValidationUtils.rejectIfEmptyOrWhitespace( errors, "content", "content is empty." );
	}

}
