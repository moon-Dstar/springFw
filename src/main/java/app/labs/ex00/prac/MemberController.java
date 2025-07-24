package app.labs.ex00.prac;

public class MemberController {
	
	IMemberService memberService = new MemberService();
	
	public void printInfo() {
		Member member = memberService.getMemberInfo();
		System.out.println(member);
	}
}
