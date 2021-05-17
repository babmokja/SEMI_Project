package com.BoB.mvc.customer.model.dao;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.BoB.mvc.common.config.ConfigLocation;
import com.BoB.mvc.customer.model.dto.EmployeeDTO;;

public class EmployeeDAO {
	
	/* Properties 객체를 이용해서 쿼리문을 조회해서 사용한다. 
	 * 기본생성자를 통해서 쿼리문을 조회해온다.
	 * */
	
	private Properties prop = new Properties();
	
	public EmployeeDAO() {
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION+"employee-mapper.xml"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public EmployeeDTO selectEmpById(Connection con, String empId) {
		
		/* Statement를 사용할까? 아님 PreparedStatement를 사용할까 */
		PreparedStatement pstmt = null;
		/* 결과값을 뭘로 받을까??를 고민한다. 
		 * 1. select를 요청헀을 떄 -> ResultSet
		 * 2. insert,update,delete를 요청했을 때 -> int
		 * */
		ResultSet rset = null;
		
		/* 반환시킬 변수를 지정하자-> 위의 결과값을 잘~~~생각해보면 나오지않을까 싶네요 */
		EmployeeDTO selectedEmp = null;
		
		String query = prop.getProperty("selectEmpById");
		
		System.out.println(query);
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, empId); // <- 위치홀더의 시작인덱스값은 1부터 시작한다.
			
			rset = pstmt.executeQuery(); // 위에서 만든 쿼리문을 이용해서 데이터베이스에 질의하여 데이터 정보를 리턴받음
			
			if(rset.next()) {
				selectedEmp = new EmployeeDTO();
				//     setEmpId -> DTO의 필드의 setter, rset.getString("데이터베이스컬럼명")     
				selectedEmp.setEmpId(rset.getString("EMP_ID"));
				selectedEmp.setEmpName(rset.getString("EMP_NAME"));
				selectedEmp.setDeptCode(rset.getString("DEPT_CODE"));
				selectedEmp.setJobCode(rset.getString("JOB_CODE"));
				selectedEmp.setSalary(rset.getInt("SALARY"));
			}
			
			System.out.println(selectedEmp);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return selectedEmp;
	}
	
	/* employee 테이블의 전체 목록 조회*/
	public List<EmployeeDTO> selectAllEmpList(Connection con) {
		
		Statement stmt = null;
		ResultSet rset = null;
		
		List<EmployeeDTO> empList = null;
		
		String query = prop.getProperty("selectAllEmpList");
		
		System.out.println(query);
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			empList = new ArrayList<>();
			while(rset.next()) {
				EmployeeDTO emp = new EmployeeDTO();
				
				emp.setEmpId(rset.getString("EMP_ID"));
				emp.setEmpName(rset.getString("EMP_NAME"));
				emp.setEmail(rset.getString("EMAIL"));
				emp.setEmpNo(rset.getString("EMP_NO"));
				emp.setPhone(rset.getString("PHONE"));
				emp.setDeptCode(rset.getString("DEPT_CODE"));
				emp.setJobCode(rset.getString("JOB_CODE"));
				emp.setSalLevel(rset.getString("SAL_LEVEL"));
				emp.setSalary(rset.getInt("SALARY"));
				emp.setBonus(rset.getDouble("BONUS"));
				emp.setManagerId(rset.getString("MANAGER_ID"));
				emp.setHireDate(rset.getDate("HIRE_DATE"));
				emp.setEntDate(rset.getDate("ENT_DATE"));
				emp.setEntYn(rset.getString("ENT_YN"));
				
				empList.add(emp);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return empList;
	}

	public int insertEmp(Connection con, EmployeeDTO empDTO) {
		
		PreparedStatement pstmt = null;
		
		int insert = 0;

		String query = prop.getProperty("insertEmp");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, empDTO.getEmpName());
			pstmt.setString(2, empDTO.getEmpNo());
			pstmt.setString(3, empDTO.getEmail());
			pstmt.setString(4, empDTO.getPhone());
			pstmt.setString(5, empDTO.getDeptCode());
			pstmt.setString(6, empDTO.getJobCode());
			pstmt.setString(7, empDTO.getSalLevel());
			pstmt.setInt(8, empDTO.getSalary());
			pstmt.setDouble(9, empDTO.getBonus());
			pstmt.setString(10, empDTO.getManagerId());
			pstmt.setDate(11, empDTO.getHireDate());
			
			insert = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return insert;
	}

	public int updateEmp(Connection con, EmployeeDTO empDTO) {
	
		PreparedStatement pstmt = null;
		
		int updateEmp = 0;
		
		String query = prop.getProperty("updateEmp");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setDate(1, empDTO.getEntDate());
			pstmt.setString(2, empDTO.getEmpId());

			
			updateEmp = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return updateEmp;
	}


	
}
