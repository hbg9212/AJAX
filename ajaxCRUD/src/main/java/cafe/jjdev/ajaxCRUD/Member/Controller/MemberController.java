package cafe.jjdev.ajaxCRUD.Member.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cafe.jjdev.ajaxCRUD.Member.Service.MemberService;
import cafe.jjdev.ajaxCRUD.vo.Member;

@RestController
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	//회원리스트 컨트롤러 시작
	@GetMapping("/getMembers")
	public Map<String, Object> getMembers(@RequestParam(value="currentPage", required = false, defaultValue = "1") int currentPage) {
		//컨트롤러 요청에 의한 단위테스트 시작
		System.out.println("[MemberController] getMembers요청");
		System.out.println("[MemberController] currnetPage : " + currentPage);
		//컨트롤러 요청에 의한 단위테스트 종료
		
		//회원리스트 서비스 요청 시작
		Map<String, Object> map = memberService.getMembers(currentPage);
		//회원리스트 서비스 요청 종료
		return map;
	}
	//회원리스트 컨트롤러 종료
	
	//회원추가 컨트롤러 시작
	@PostMapping("/addMember")
	public void addMember(Member member) {
		//컨트롤러 요청에 의한 단위테스트 시작
		System.out.println("[MemberController] add요청");
		System.out.println("[MemberController] member : " + member);
		//컨트롤러 요청에 의한 단위테스트 종료
		
		//회원추가 서비스 요청 시작
		memberService.addMember(member);
		//회원추가 서비스 요청 종료
	}
	//회원추가 컨트롤러 종료
	
	//회원삭제 컨트롤러 시작
	@PostMapping("/removeMember")
	public void removeMember(@RequestParam(value="ck[]") String[] ck) {
		//컨트롤러 요청에 의한 단위테스트 시작
		System.out.println("[MemberController] remove요청");
		System.out.println("[MemberController] ck.length : " + ck.length);
		//컨트롤러 요청에 의한 단위테스트 종료
		
		//회원삭제 서비스 요청 시작
		memberService.removeMember(ck);
		//회원삭제 서비스 요청 종료
	}
	//회원삭제 컨트롤러 종료
	
	//회원수정 컨트롤러 시작
	@PostMapping("/modifyMember")
	public void modifyMember(Member member) {
		//컨트롤러 요청에 의한 단위테스트 시작
		System.out.println("[MemberController] modify요청");
		System.out.println("[MemberController] member : " + member);
		//컨트롤러 요청에 의한 단위테스트 종료
		
		//회원수정 서비스 요청 시작
		memberService.modifyMember(member);
		//회원수정 서비스 요청 종료
	}
	//회원수정 컨트롤러 종료
}
