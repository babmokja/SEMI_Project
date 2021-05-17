package com.BoB.mvc.customer.model.service;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.close;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.commit;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.rollback;
import static com.BoB.mvc.common.jdbc.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.BoB.mvc.customer.model.dao.EmployeeDAO;
import com.BoB.mvc.customer.model.dto.EmployeeDTO;

public class EmployeeService {

	/* Connection 객체 생성, 결과에 따른 트랜잭션 처리, [Connection 객체 소멸]*/ 
	
	/* EmployeeDAO와 연결할 필드 변수 */
	private EmployeeDAO empDAO = new EmployeeDAO();
	
	/**
	 * 사원번호를 이용해서 사용자 정보 조회
	 * @param empId 사원번호
	 * @return 사원정보
	 */
	public EmployeeDTO selectOneEmpById(String empId) {
	
		/* Connection 생성 */
		Connection con = getConnection();
		
		/* Connection과 함께 정보를 전달하여 조회를 한다. */
		EmployeeDTO selectedEmp = empDAO.selectEmpById(con, empId);
		
		/* 생각 : 트랜잭션 처리(commit,rollback)가 필요한 상황인가????*/
		
		System.out.println(selectedEmp);
		
		/* Connection을 닫는다. */
		close(con);
		
		return selectedEmp;
	}

	/* 직원 정보 전체 조회용 메소드*/
	public List<EmployeeDTO> selectAllEmp() {
		
		/* Connection 생성*/
		Connection con = getConnection();
		
		/* 비지니스 로직 */
		/* 1. dao 호출하여 조회 */
		List<EmployeeDTO> empList = empDAO.selectAllEmpList(con);
		
		/* Connection 닫기*/
		close(con);
		
		/* 수행 결과 반환*/
		return empList;
	}
	
	public int insertEmp(EmployeeDTO empDTO) {
		
		Connection con = getConnection();
		
		int insertEmp = empDAO.insertEmp(con, empDTO);
		
		if(insertEmp > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return insertEmp;
	}
	
	public int updateEmp(EmployeeDTO empDTO) {
		
		Connection con = getConnection();
		
		int updateEmp = empDAO.updateEmp(con, empDTO);
		
		if(updateEmp > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return updateEmp;
	}

}
