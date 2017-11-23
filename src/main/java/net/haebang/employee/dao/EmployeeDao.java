package net.haebang.employee.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.haebang.vo.CompanyVo;
import net.haebang.vo.EmployeeVo;
import net.haebang.vo.JoinEmployeeVo;
import net.haebang.vo.MapVo;
import net.haebang.vo.NoticeBoardVo;


public interface EmployeeDao {

	//진화
        EmployeeVo selectById(EmployeeVo employeeVo);
        List<MapVo> selectAllmap(EmployeeVo employeeVo);
        
    /*************************공지*******************************************/
        List<NoticeBoardVo> getNoticeList(Map<String, Object> map);
        double selectTotalCount(Map<String, Object> map);
        NoticeBoardVo getNoticeBoardByNo(NoticeBoardVo noticeBoardVo);
        List<NoticeBoardVo> getMainnoticelist();
   /**********************************************************************/
        
        EmployeeVo getIdByPhone(Map<String, Object> map);
        EmployeeVo getIdByBizNo(Map<String, Object> map);
        EmployeeVo getIdbyId(EmployeeVo employeeVo);
        void changePassword(EmployeeVo employeeVo);
        
	 // -------------------------------------- 창대 ----------------------------------------
    EmployeeVo selectById(String e_id);
    	CompanyVo selectByBizNo1(String c_bizNo);
    	CompanyVo selectByCode(String c_code);
    	CompanyVo selectByNo(int c_no);
    	List<EmployeeVo> selectByCNo(int c_no);
    	
    	void insertEmployeeAnd(JoinEmployeeVo joinEmployeeVo);
    	void insertEmployee(JoinEmployeeVo joinEmployeeVo);
    	void insertCompany(JoinEmployeeVo joinEmployeeVo);
    	
    	void updateEoC(HashMap<String,String> updateMap);
    	void updateEmployeeCntP(JoinEmployeeVo joinEmployeeVo);   // 증가 플러스
    	void updateEmployeeCntM(EmployeeVo employeeVo);	// 감소 마이너스
    	void deleteEmployeeByNo(int e_no);
    	CompanyVo selectByBizNo2(CompanyVo companyVo);
    	void updateCompanyBizNo(CompanyVo companyVo);
    	void updateEmpPicture(EmployeeVo employeeVo);

}
