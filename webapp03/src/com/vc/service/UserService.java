package com.vc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.vc.entity.Employee;
import com.vc.factory.ConFactory;

public class UserService {
	private static final String SELECT_USERS_QUERY = "SELECT * FROM USERS WHERE USERNAME=? AND PASSWORD=?";
	private static final String INSERT_EMPLOYEE_QUERY = "INSERT INTO EMPLOYEE VALUES(?,?,?,?,?,?,?)";
	private static final String UPDATE_EMPLOYEE_QUERY = "UPDATE EMPLOYEE SET ENAME=?, ESAL=?, EADDR=?, GENDER=?, QUALIFICATION=?, DESG=? WHERE EID=?";
	private static final String DELETE_EMPLOYEE_QEURY = "DELETE FROM EMPLOYEE WHERE EID=?";
	private static final String SELECT_EMPLOYEE_QEURY = "SELECT * FROM EMPLOYEE";
	private static final String SELECT_EMPLOYEE_COUNT_QEURY = "SELECT COUNT(*) FROM EMPLOYEE";
	private static final String SELECT_EMPLOYEE_EID_QEURY = "SELECT * FROM EMPLOYEE WHERE EID=?";
	private static final String SELECT_EMPLOYEE_COL_QEURY = "SELECT * FROM EMPLOYEE WHERE ?=?";

	public String checkLogin(String user, String pass) {
		String status = "";
		try (Connection con = ConFactory.getConnection();
				PreparedStatement pst = con.prepareStatement(SELECT_USERS_QUERY);) {
			pst.setString(1, user);
			pst.setString(2, pass);
			try (ResultSet rs = pst.executeQuery()) {
				status = rs.next() == true ? "success" : "fail";
			} catch (Exception e) {
				status = "fail";
				e.printStackTrace();
			}

		} catch (Exception e) {
			status = "fail";
			e.printStackTrace();
		}
		return status;
	}

	public String register(Employee e) {
		String status = "";
		try (Connection con = ConFactory.getConnection();
				PreparedStatement pst = con.prepareStatement(INSERT_EMPLOYEE_QUERY);) {
			pst.setInt(1, e.getEid());
			pst.setString(2, e.getEname());
			pst.setFloat(3, e.getEsal());
			pst.setString(4, e.getEaddr());
			pst.setString(5, e.getGender());
			pst.setString(6, e.getQualification());
			pst.setString(7, e.getDesg());
			int count = pst.executeUpdate();
			status = count > 0 ? "success" : "fail";
		} catch (Exception e1) {
			status = "fail";
			e1.printStackTrace();
		}
		return status;
	}

	public ArrayList<Employee> getAllEmployee(int size) {
		ArrayList<Employee> list = new ArrayList<Employee>(size);
		try (Connection con = ConFactory.getConnection();
				PreparedStatement pst = con.prepareStatement(SELECT_EMPLOYEE_QEURY);) {
			try (ResultSet rs = pst.executeQuery()) {
				if (rs != null) {
					while (rs.next()) {
						Employee e = new Employee();
						e.setEid(rs.getInt(1));
						e.setEname(rs.getString(2));
						e.setEsal(rs.getFloat(3));
						e.setEaddr(rs.getString(4));
						e.setGender(rs.getString(5));
						e.setQualification(rs.getString(6));
						e.setDesg(rs.getString(7));
						list.add(e);
					}
				}
			} catch (Exception e) {
				list = null;
				e.printStackTrace();
			}
		} catch (Exception e1) {
			list = null;
			e1.printStackTrace();
		}
		return list;
	}

	public Employee getEmployee(int eid) {
		Employee e = null;
		try (Connection con = ConFactory.getConnection();
				PreparedStatement pst = con.prepareStatement(SELECT_EMPLOYEE_EID_QEURY);) {
			pst.setInt(1, eid);
			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					e = new Employee();
					e.setEid(rs.getInt(1));
					e.setEname(rs.getString(2));
					e.setEsal(rs.getFloat(3));
					e.setEaddr(rs.getString(4));
					e.setGender(rs.getString(5));
					e.setQualification(rs.getString(6));
					e.setDesg(rs.getString(7));
				} else {
					e = null;
				}
			}
		} catch (Exception e1) {
			e = null;
			e1.printStackTrace();
		}
		return e;
	}

	public String updateEmp(Employee e) {
		String status = "";
		try (Connection con = ConFactory.getConnection();
				PreparedStatement pst = con.prepareStatement(UPDATE_EMPLOYEE_QUERY);) {

			pst.setString(1, e.getEname());
			pst.setFloat(2, e.getEsal());
			pst.setString(3, e.getEaddr());
			pst.setString(4, e.getGender());
			pst.setString(5, e.getQualification());
			pst.setString(6, e.getDesg());
			pst.setInt(7, e.getEid());
			int count = pst.executeUpdate();
			status = count > 0 ? "success" : "fail";
		} catch (Exception e1) {
			status = "fail";
			e1.printStackTrace();
		}
		return status;
	}

	public String deleteEmp(int id) {
		String status = "";
		try (Connection con = ConFactory.getConnection();
				PreparedStatement pst = con.prepareStatement(DELETE_EMPLOYEE_QEURY);) {
			pst.setInt(1, id);
			int count = pst.executeUpdate();
			status = count > 0 ? "success" : "fail";
		} catch (Exception e1) {
			status = "fail";
			e1.printStackTrace();
		}
		return status;

	}

	public int getEmployeeCount() {
		int count = 0;
		try (Connection con = ConFactory.getConnection();
				PreparedStatement pst = con.prepareStatement(SELECT_EMPLOYEE_COUNT_QEURY);) {
			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next())
					count = rs.getInt(1);
			} catch (Exception e) {
				count = 0;
				e.printStackTrace();
			}
		} catch (Exception e) {
			count = 0;
			e.printStackTrace();
		}

		return count;
	}

	public List<Employee> getSpecificEmp(String colName, String searchKey) {		
		ArrayList<Employee> list = new ArrayList<Employee>();		
		//String strSQLQuery=String.format("SELECT * FROM EMPLOYEE WHERE %s=?",colName);
		String strSQLQuery=String.format("SELECT * FROM EMPLOYEE WHERE %s LIKE '%%"+searchKey+"%%'",colName);
		try (Connection con = ConFactory.getConnection();
				PreparedStatement pst = con.prepareStatement(strSQLQuery);) {
			/*if (colName.equals("eid")) {
				pst.setInt(1, Integer.parseInt(searchKey));
			} else if (colName.equals("esal")) {
				pst.setFloat(1, Float.parseFloat(searchKey));
			}else {
				pst.setString(1, searchKey);
			}
			*/
			
			try (ResultSet rs = pst.executeQuery()) {
				if (rs != null) {
					while (rs.next()) {
						Employee e = new Employee();
						e.setEid(rs.getInt(1));
						e.setEname(rs.getString(2));
						e.setEsal(rs.getFloat(3));
						e.setEaddr(rs.getString(4));
						e.setGender(rs.getString(5));
						e.setQualification(rs.getString(6));
						e.setDesg(rs.getString(7));
						list.add(e);
					}
				}
			} catch (Exception e) {
				list = null;
				e.printStackTrace();
			}
		} catch (Exception e1) {
			list = null;
			e1.printStackTrace();
		}
		return list;
	}
}
