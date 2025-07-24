package app.labs.ex05.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EmpRepository implements IEmpRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	// table column과 vo seter Mapping class
	// 행 마다 실행되는 mapRow 메서드 사용 가능
    private class EmpMapper implements RowMapper<EmpVO> {
        @Override
        public EmpVO mapRow(ResultSet rs, int rowNum) throws SQLException {
            EmpVO emp = new EmpVO();
            emp.setEmployeeId(rs.getInt("employee_id"));
            emp.setFirstName(rs.getString("first_name"));
            emp.setLastName(rs.getString("last_name"));
            emp.setEmail(rs.getString("email"));
            emp.setPhoneNumber(rs.getString("phone_number"));
            emp.setHireDate(rs.getDate("hire_date"));
            emp.setJobId(rs.getString("job_id"));
            emp.setSalary(rs.getDouble("salary"));
            emp.setCommissionPct(rs.getDouble("commission_pct"));
            emp.setManagerId(rs.getInt("manager_id"));
            emp.setDepartmentId(rs.getInt("department_id"));
            return emp;
        }            
    }

	@Override
	public int getEmpCount() {
		String sql = "select count(*) from employees";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public int getEmpCount(int deptId) {
		String sql = "select count(*) from employees where department_id=?";
		return jdbcTemplate.queryForObject(sql, Integer.class, deptId);
	}

	@Override
	public List<EmpVO> getEmpList() {
		String sql = "select * from employees";
		return jdbcTemplate.query(sql, new EmpMapper()); // EmpMapper: 행 단위로 실행
	}

	@Override
	public EmpVO getEmpInfo(int empId) {
		String sql = "select * from employees where employee_id=?";
		return jdbcTemplate.queryForObject(sql, new EmpMapper(), empId);
	}

	@Override
	public void insertEmp(EmpVO emp) {
		String sql = "insert into employees "
				+ "(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id)\r\n"
				+ "values "
				+ "(1000, 'first_name', 'last_name', 'email', 'phone_number', sysdate, 'SA_REP', 90000, 0.1, 100, 30)";

	}

	@Override
	public void updateEmp(EmpVO emp) {
		// TODO Auto-generated method stub

	}

	@Override
	public int deleteEmp(int empId, String email) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteJobHistory(int empId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Map<String, Object>> getAllDeptId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> getAllJobId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> getAllManagerId() {
		// TODO Auto-generated method stub
		return null;
	}

}
