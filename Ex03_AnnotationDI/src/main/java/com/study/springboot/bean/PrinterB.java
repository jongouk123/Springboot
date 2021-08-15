package com.study.springboot.bean;

import org.springframework.stereotype.Component;

@Component( "printerB" ) // 빈 등록 + 이름 지정
public class PrinterB implements Printer {

	@Override
	public void print( String message ) {
		System.out.println( "Printer B : " + message );
	}

}
