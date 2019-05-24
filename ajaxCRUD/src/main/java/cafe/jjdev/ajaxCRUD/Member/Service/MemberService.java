package cafe.jjdev.ajaxCRUD.Member.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafe.jjdev.ajaxCRUD.Member.Mapper.MemberMapper;
import cafe.jjdev.ajaxCRUD.vo.Member;

@Service
public class MemberService {
	@Autowired
	private MemberMapper memberMapper;
	
	//회원리스트 서비스 시작
	public Map<String, Object> getMembers(int currentPage) {
		//서비스 요청에 의한 단위테스트 시작
		System.out.println("[MemberService] getMember요청");
		System.out.println("[MemberService] currentPage : " + currentPage);
		//서비스 요청에 의한 단위테스트 종료
		
		//회원리스트 select를 위한 map 셋팅 시작
		Map<String, Object> map = new HashMap<String, Object>();
		final int ROW_PER_PAGE = 10;
		final int BEGIN_ROW = (currentPage-1)*ROW_PER_PAGE;
		map.put("beginRow", BEGIN_ROW);
		map.put("rowPerPage", ROW_PER_PAGE);
		//회원리스트 select를 위한 map 셋팅 종료
		
		//회원리스트 select와 회원리스트 페이징을 위한 select*count(*) Mapper요청 시작
		List<Member> list = memberMapper.selectMemberList(map);
		final int MEMBER_COUNT = memberMapper.selectCountMemberList();
		//회원리스트 select와 회원리스트 페이징을 위한 select*count(*) Mapper요청 종료
		
		//페이징을 위한 변수 셋팅 시작
		int currentTenPage = currentPage/10;
		if(currentPage%10 == 0) {
			currentTenPage--;
		}
		int lastPage = MEMBER_COUNT/ROW_PER_PAGE;
		if(MEMBER_COUNT%ROW_PER_PAGE !=0) {
			lastPage++;
		}
		int lastTenPage = lastPage/10;
		if(lastPage%10 == 0) {
			lastTenPage--;
		}
		int repetitionPage = 10;
		if((lastPage - currentTenPage*10) < 10) {
			repetitionPage = lastPage % 10 ;
		}	
		//페이징을 위한 변수 셋팅 시작
		
		//리턴을 위한 map 셋팅 시작
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("list", list);
		returnMap.put("lastPage", lastPage);
		returnMap.put("currentPage", currentPage);
		returnMap.put("currentTenPage", currentTenPage);
		returnMap.put("lastTenPage", lastTenPage);
		returnMap.put("repetitionPage", repetitionPage);
		System.out.println("[MemberService] lastPage : " + lastPage);
		System.out.println("[MemberService] currentTenPage : " + currentTenPage);
		System.out.println("[MemberService] lastTenPage : " + lastTenPage);
		System.out.println("[MemberService] repetitionPage : " + repetitionPage);
		//리턴을 위한 map 셋팅 종료
		return returnMap;
	}
	//회원리스트 서비스 종료
	
	//회원추가 서비스 시작
	public void addMember(Member member) {
		//서비스 요청에 의한 단위테스트 시작
		System.out.println("[MemberService] addMember요청");
		System.out.println("[MemberService] Member : " + member);
		//서비스 요청에 의한 단위테스트 종료
		
		//회원추가 insert Mapper 요청 시작
		memberMapper.insertMember(member);
		//회원추가 insert Mapper 요청 종료
	}
	//회원추가 서비스 종료
	
	//회원수정 서비스 시작
	public void modifyMember(Member member) {
		//서비스 요청에 의한 단위테스트 시작
		System.out.println("[MemberService] modifyMember요청");
		System.out.println("[MemberService] Member : " + member);
		//서비스 요청에 의한 단위테스트 종료
		
		//회원추가 insert Mapper 요청 시작
		memberMapper.updateMember(member);
		//회원추가 insert Mapper 요청 종료
	}
	//회원수정 서비스 종료
	
	//회원삭제 서비스 시작
	public void removeMember(String[] ck) {
		//서비스 요청에 의한 단위테스트 시작
		System.out.println("[MemberService] removeMember요청");
		System.out.println("[MemberService] ck.length : " + ck.length);
		//서비스 요청에 의한 단위테스트 종료
		
		//String 배열에 담겨있는 id를 가져와서 회원삭제 delete Mapper를 요청하는 반복문 시작
		for(String id : ck) {
			//반복문 단위테스트 시작
			System.out.println("[MemberService] for(String id : ck)에서 출력되는 id : " +id);
			//반복문 단위테스트 종료
			
			//Mapper 요청을 위한 변수 셋팅 시작
			Member member = new Member();
			member.setId(id);
			//Mapper 요청을 위한 변수 셋팅 종료
			
			//회원삭제 delete Mapper 요청 시작
			memberMapper.deleteMember(member);
			//회원삭제 delete Mapper 요청 종료
		}
		//String 배열에 담겨있는 id를 가져와서 회원삭제 delete Mapper를 요청하는 반복문 시작
	}
	//회원삭제 서비스 종료
}
