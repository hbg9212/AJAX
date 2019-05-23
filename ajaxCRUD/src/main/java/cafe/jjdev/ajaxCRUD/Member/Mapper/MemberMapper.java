package cafe.jjdev.ajaxCRUD.Member.Mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cafe.jjdev.ajaxCRUD.vo.Member;

@Mapper
public interface MemberMapper {
	//회원리스트 select
	public List<Member> selectMemberList(Map<String, Object> map);
	//회원리스트 select
	
	//회원리스트 페이징을 위한 select*count(*)
	public int selectCountMemberList();
	//회원리스트 페이징을 위한 select*count(*)
	
	//회원추가 insert
	public void insertMember(Member member);
	//회원추가 insert
	
	//회원수정 update
	public void updateMember(Member member);
	//회원수정 update
	
	//회원삭제 delete
	public void deleteMember(Member member);
	//회원삭제 delete
}
