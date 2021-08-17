package mytest;

import java.util.HashMap;
import java.util.Map;

public class ModelUse {

	/**
	 * main 메소드를 톰캣 컨테이너로 가정한다.
	 * 메서드 내부 지역변수의 한계를 model이라는 참조형 변수를 이용하여 해결한다.
	 * 이는 여러 값을 리턴하는 데에도 용이하게 활용할 수 있다.
	 * @param args
	 */
	public static void main( String[] args ) {
		Map<String, String> model = new HashMap<>();    // 요청이 오면 Map 변수를 만든다.
		String sReturn = root( model );                 // @RequestMapping에 의해 메서드를 호출하면서 Map 변수를 넘겨준다.
														// 호출된 메서드는 파라미터로 넘겨받은 Model(Map)에 데이터를 put 하고 JSP 페이지명을 리턴한다.
		printData( sReturn, model );                    // 리턴받은 정보를 이용하여 뷰를 출력하는 메서드를 호출한다.
	}
	
	public static String root( Map model ) {
		model.put( "name1", "홍길동" );
		model.put( "name2", "전우치" );
		return "Hello";
	}
	
	public static void printData( String s, Map model ) {
		String str1 = (String)model.get( "name1" );
		System.out.println( str1 );
		System.out.println( "WEB-INF/views/" + s + ".jsp" );
	}
}
