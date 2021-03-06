package net.haebang.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.haebang.vo.CompanyVo;
import net.haebang.vo.MemberVo;
import net.haebang.vo.NoticeBoardVo;

/**
 * 	관리자 서비스
 * @author LEEJUHO
 *
 */
public interface AdminService {
	
	// 회원조회 서비스
	List<MemberVo> memberList();
	List<MemberVo> nMemberList();
	List<MemberVo> memberSelected(MemberVo memberVo);
	
	// 업체 조회 서비스
		List<HashMap<String, Object>> hbComList(int page);
		List<HashMap<String, Object>> nComList(int page);
		List<HashMap<String, Object>> searchHbComList(CompanyVo companyVo);
		List<HashMap<String, Object>> searchNComList(CompanyVo companyVo);
		int getLastPage();
	// 공지사항 서비스
	List<NoticeBoardVo> getOwnerNoticeList(String n_type ,int page, String word, String searchCondition); 
	int getLastPage(String n_type ,String word, String searchCondition);
	
	NoticeBoardVo getNoticeBoardByNo(int no);
	NoticeBoardVo getNoticeBoardByNo(NoticeBoardVo noticeBoardVo);
	void insertNotice(NoticeBoardVo noticeBoardVo);
	void updateNotice(NoticeBoardVo noticeBoardVo);
	void noticeDelete(int no);
	
	//스케쥴 관리 서비스
	List<HashMap<String, Object>> getScheduleList(int page, String word, String searchSchedule, String startDate, String endDate);
	int selectTotalCountSchedule(String word, String searchSchedule, String startDate, String endDate);
	HashMap<String, Object> getScheduleByMONo(int mo_no);
	String getMtypebyMONo(int mo_no);
	HashMap<String, Object> getScheduleByMONoByHB(int mo_no);
	
	//관리자 로그인
	MemberVo loginAdmin(Map<String, Object> map);
	
	// 메인 전체 정보
	List<Map<String, Object>> getMainInfo();
	
	// 조건검색 - 오늘기준 서비스 진행 될 구별 정보 가져오기
	List<Map<String, Object>> searchGuInfo(Map<String, Object> map);
	
}
