package com.djh.dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import com.djh.beans.User;
import com.djh.utils.UserUtils;

public class XMLUserDAO {

	private String URI = "com.djh.beans.userMapper";

	public User getUserById(int id) throws IOException {
		SqlSession session = UserUtils.getSqlSession();
		User user = session.selectOne(URI + ".selectUser", id);
		return user;
	}

	public List<User> getAllUser() throws IOException {
		List<User> users = UserUtils.getSqlSession().selectList(URI + ".selectAllUser");
		return users;
	}

	public int insertUser(User user) throws IOException {
		int count = UserUtils.getSqlSession().insert(URI + ".insertUser", user);
		return count;
	}

	public int deleteUser(Integer id) throws IOException {
		int count = UserUtils.getSqlSession().delete(URI + ".deleteUser", id);
		return count;
	}

	public int updateUser(User user) throws IOException {
		int count = UserUtils.getSqlSession().update(URI + ".updateUser", user);
		return count;
	}

}
