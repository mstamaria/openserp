package org.openserp.service.impl;

import java.util.List;

import org.openserp.dao.StudentDao;
import org.openserp.entity.Student;
import org.openserp.service.StudentService;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class StudentServiceImpl implements StudentService {

	private StudentDao studentDao;

	@Required
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	@Override
	public List<Student> getStudentList(int firstResult, int maxResults){
		List<Student> resultList = studentDao.findAllByPage(firstResult, maxResults);
		return resultList;
	}

}
