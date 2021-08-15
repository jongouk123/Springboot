import java.util.Date;

class Member {
	String name;
	String nickname;
//	private Member() {}
	public Member() {}
}

public class UnderstandIDI {

	public static void main( String[] args ) {	
		// 날짜를 구하기 위해서는 Date 클래스에 의존해야 한다.
		Date date = new Date();
		System.out.println( date );
	}
	
	public static void getDate( Date d ) {
		Date date = d;
		System.out.println( date );
	}
	
	public static void memberUse1() {
		// 강한 결합 : 직접 생성
		Member m1 = new Member();
	}
	
	public static void memberUse2( Member m ) {
		// 약한 결합 : 생성된 것을 주입 받음 - 의존 주입 (Dependency Injection)
		// 다른 클래스의 변화에 더욱 안전하고 유연하게 대처할 수 있는 프로그래밍이 될 수 있다.
		Member m2 = m;
	}
}
