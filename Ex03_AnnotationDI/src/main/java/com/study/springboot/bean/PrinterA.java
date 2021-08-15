package com.study.springboot.bean;

import org.springframework.stereotype.Component;

@Component( "printerA" ) // 빈 등록 + 이름 지정
public class PrinterA implements Printer {

	@Override
	public void print( String message ) {
		System.out.println( "Printer A : " + message );
	}
	
}
