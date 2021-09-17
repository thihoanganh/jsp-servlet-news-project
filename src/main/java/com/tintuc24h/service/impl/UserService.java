package com.tintuc24h.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import com.tintuc24h.models.LoginResult;
import com.tintuc24h.models.User;
import com.tintuc24h.services.IUserSerivce;
import com.tintuc24h.utils.DbConnection;

public class UserService implements IUserSerivce {
	private Connection conn = DbConnection.getConnection();

	public Integer isUserExist(String username) {
		try {
			String sql = "select * from users where username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt("id");
			}
		} catch (Exception e) {
			return  -1;
		}
		return -1;
	}

	@Override
	public User create(User user) {
		try {
			String sql = "insert into users(name,username,password,email,gender,block) values(?,?,?,?,?,false)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.Name);
			ps.setString(2, user.Username);
			ps.setString(3, BCrypt.hashpw(user.Password, BCrypt.gensalt(12)));
			ps.setString(4, user.Email);
			ps.setBoolean(5, user.Gender);
			ps.execute();
			return user;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	@Override
	public LoginResult Login(String username, String password) {
		try {
			String sql = "select * from users where username = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String hash = rs.getString("password");
				if (BCrypt.checkpw(password, hash)) {
					LoginResult loginRs = new LoginResult();
					loginRs.Username = rs.getString("username");
					loginRs.Role = rs.getString("role");
					return loginRs;
				}
			}
			return null;
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public Boolean isUserBlock(String username) {
		try {
			String sql = "select * from users where username = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getBoolean("block");
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<User> findAll() {
		try {
			String sql = "select * from users order by id desc ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<User> users = new ArrayList<User>();
			while (rs.next()) {
				User user = new User();
				user.Id = rs.getInt("id");
				user.Block = rs.getBoolean("block");
				user.Name = rs.getString("name");
				user.Username = rs.getString("username");
				user.Email = rs.getString("email");
				user.createDate = rs.getTimestamp("created_date");
				users.add(user);
			}
			return users;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public User findByUsername(String username) {
		try {
			String sql = "select * from users where username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.Id = rs.getInt("id");
				user.Block = rs.getBoolean("block");
				user.Name = rs.getString("name");
				user.Username = rs.getString("username");
				user.Email = rs.getString("email");
				user.createDate = rs.getTimestamp("created_date");
				return user;
			}
			return null;
		} catch (Exception e) {
			return null;
		}
	}

}
