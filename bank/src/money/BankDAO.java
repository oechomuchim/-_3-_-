package money;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;

public class BankDAO {
	String url="jdbc:mysql://localhost:3306/bank";
	String user="root";
	String password="1234";
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	// 삽입
	public BankDTO insert(BankDTO dto) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			String sql = "insert into member values(?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getName());
			ps.setString(3, dto.getAge());
			ps.setString(4, dto.getTel());
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	// 검색
	public BankDTO select(String inputId) {
		BankDTO dto = null;
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			con = DriverManager.getConnection(url, user, password);
			String sql = "select * from member where id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, inputId);
			rs = ps.executeQuery();
			
			if (rs.next()) { 
				dto = new BankDTO();
				
				String id = rs.getString(1);  
				String name = rs.getString(2);  
				String age = rs.getString(3);  
				String tel = rs.getString(4);  
				
				dto.setId(id);
				dto.setName(name);
				dto.setAge(age);
				dto.setTel(tel);
			} else {
				System.out.println("검색 결과가 없습니다:(");
			}
		} catch (Exception e) {
			System.out.println("DB처리 중 에러 발생!X/");
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				rs.close();   
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("자원 해제 중 에러 방생!X/");
			} 
		}
		return dto; 
	}
	
	// 수정
	public void update(BankDTO dto) {
		  try {
		  Class.forName("com.mysql.jdbc.Driver");
		  con = DriverManager.getConnection(url,user,password);
		  String sql = "update member set tel =? where id = ?";
		  ps = con.prepareStatement(sql);
		  ps.setString(1, dto.getTel());
		  ps.setString(2, dto.getId());
		  ps.executeUpdate();
		  } catch (Exception e) {
		  e.printStackTrace();
		  }
			}
	
	// 삭제
	public void delete(BankDTO dto) {
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			con = DriverManager.getConnection(url, user, password);
			String sql = "delete from member where id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	// 전체 검색
	public ArrayList selectAll() {
		ArrayList list = new ArrayList();
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			con = DriverManager.getConnection(url, user, password); 
			String sql = "select * from member";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) { 
				BankDTO dto = new BankDTO();
				
				String id = rs.getString(1);  
				String name = rs.getString(2);  
				String age = rs.getString(3);  
				String tel = rs.getString(4); 
				
				dto.setId(id);
				dto.setName(name);
				dto.setAge(age);
				dto.setTel(tel);
				
				list.add(dto);
			} 			
		} catch (Exception e) {
			System.out.println("DB처리 중 에러 발생!X/");
			System.out.println(e.getMessage());
			e.printStackTrace();
			
		} finally {
			try {
				rs.close();   
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("자원 해제 중 에러 방생!X/");
			} 
		} 
		return list;
	}
}
