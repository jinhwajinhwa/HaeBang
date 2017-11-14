package net.haebang.employee.service;

<<<<<<< HEAD


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import net.haebang.employee.dao.EmployeeDao;
import net.haebang.exception.IdPasswordNotMatchingException;
import net.haebang.vo.EmployeeVo;
import net.haebang.vo.MapVo;
=======
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import net.haebang.employee.controller.CommonUtils;
import net.haebang.employee.dao.EmployeeDao;
import net.haebang.exception.AlreadyExistingMemberException;
import net.haebang.vo.EmployeeVo;
import net.haebang.vo.JoinEmployeeVo;
>>>>>>> 37a0fd44336ef7f0d9fa90cc45c1bb9a48984247

@Service
public class EmployeeServiceImpl implements EmployeeService {

<<<<<<< HEAD
	
	@Autowired
	private EmployeeDao employeeDao;
	
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}	
=======
	private static final String filePath = "/Users/apple/Documents/workspace/HaeBangPicture/";

	@Autowired
	public EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Transactional
	public void registerEmployee(JoinEmployeeVo joinEmployeeVo, MultipartHttpServletRequest request) {

		EmployeeVo employeeVo = employeeDao.selectById(joinEmployeeVo.getE_id());
		if (employeeVo != null) {
			throw new AlreadyExistingMemberException("중복" + joinEmployeeVo.getE_id());
		}

		Iterator<String> iterator = request.getFileNames();

		MultipartFile multipartFile = null;

		String oriName = null;
		String originalFileExtension = null;
		String saveName = null;

		File file = new File(filePath);
		if (file.exists() == false) {
			file.mkdirs();
		}

		while (iterator.hasNext()) {

			multipartFile = request.getFile(iterator.next());
			if (multipartFile.isEmpty() == false) {

				oriName = multipartFile.getOriginalFilename();
				originalFileExtension = oriName.substring(oriName.lastIndexOf("."));
				saveName = CommonUtils.getRandomString() + originalFileExtension;

				file = new File(filePath + saveName);
				try {

					multipartFile.transferTo(file);

				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

				joinEmployeeVo.setC_oriName(oriName);
				joinEmployeeVo.setC_saveName(saveName);
				System.out.println("-------------- file start --------------\n");
				System.out.println("oriName : " + oriName);
				System.out.println("saveName : " + saveName);
				System.out.println("filename : " + multipartFile.getOriginalFilename());
				System.out.println("size : " + multipartFile.getSize());
				System.out.println("-------------- file end --------------\n");

			}
		}
>>>>>>> 37a0fd44336ef7f0d9fa90cc45c1bb9a48984247

		employeeDao.insertCompany(joinEmployeeVo);
		employeeDao.insertEmployee(joinEmployeeVo);

	}

	public void modifyEmployee(EmployeeVo employee) {

	}

	
	public EmployeeVo authenticate(EmployeeVo employeeVo) {
		System.out.println("authenticate");
		EmployeeVo employeevo = employeeDao.selectById(employeeVo);
		System.out.println(employeeVo);
		if (employeeVo == null) {
			throw new IdPasswordNotMatchingException();
		}
		
		return employeevo;
	}
	

	public List<MapVo> selectAllmap(EmployeeVo employeeVo) {
		List<MapVo> maplist = employeeDao.selectAllmap(employeeVo);
		return maplist;
	}

}

