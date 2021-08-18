package com.study.springboot;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * <pre>
 * Validator 클래스를 생성하지 않고, Spring에서 제공하는 @Valid 어노테이션을 사용한다.
 * </pre>
 * @author mat65
 *
 */
@Data
public class ContentDto {
	private int id;
	
	@NotNull(message="writer is null.")
	@NotEmpty(message="writer is empty.")
	@Size(min=3, max=10, message="writer min 3, max 10.")
	private String writer;
	
	@NotNull(message="content is null.")
	@NotEmpty(message="content is empty.")
	private String content;
}
