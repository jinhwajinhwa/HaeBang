package net.haebang.member.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import net.haebang.vo.MemberVo;
import net.haebang.vo.NoticeBoardVo;

public interface MemberDao {

	List<MemberVo> selectAll();
	int insert(MemberVo Member) throws Exception;
	MemberVo selectOne(String m_id);
	void logout(HttpSession session);
	MemberVo login(MemberVo member);
	MemberVo selectById(String m_id);
	MemberVo blogin(MemberVo member);
	MemberVo mainLogin(MemberVo member);
	void updateMember(MemberVo member);
	MemberVo loginModal(MemberVo member);
	
	
	/******************************** 공지사항 *************************************************/
    List<NoticeBoardVo> getNoticeList(Map<String, Object> map);
    double selectTotalCount(Map<String, Object> map);
    NoticeBoardVo getNoticeBoardByNo(NoticeBoardVo noticeBoardVo);
	/*************************************************************************************************/
    
    MemberVo getMyPageInfo(String m_id);
    void changeMyInfo(Map<String,Object> map);
    
    /*************************************************************************************************/
    List<HashMap<String, Object>> getReservListByMId(String m_id);
	Map<String, Object> myReservDetail(Map<String, Object> map);
	void cancleServiceByOdNo(String mo_orderNo);
	// 일정 변경
	void changeDate(Map<String, Object> map);
	String getMoCallFlag(int mo_no);
	/*************************************************************************************************/
	int approval_member(MemberVo member) throws Exception;
    
}