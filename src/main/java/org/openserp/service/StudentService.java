package org.openserp.service;

import java.util.List;

import org.openserp.entity.Student;

public interface StudentService {

	/**
	 * Retrieves the student list by pages
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @return
	 */
	List<Student> getStudentList(int firstResult, int maxResults);

}
