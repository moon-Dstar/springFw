package app.labs.ex00.prac;

public class MemberService implements IMemberService {

	@Override
	public Member getMemberInfo() {
		Member member = new Member();
		member.setMemberId("1234");
		member.setName("숫자");
		
		return member;
	}

}
