package com.zrxjuly.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.zrxjuly.demo.model.User;

/**
 * 继承JdbcDaoSupport，所有dao继承这个类，就会自动获得JDBCTemplate，前提是注入dataSource.
 * @author zhangrongxiang
 *
 */
public class UserDAOImpl extends JdbcDaoSupport implements IUserDAO {

	public void addUser(User user) {
		String sql = "insert into temp values(?,?,?)";
		this.getJdbcTemplate().update(sql, user.getId(), user.getUsername(), user.getPassword());
	}

	public void deleteUser(int id) {
		String sql = "delete from temp where id=?";
		this.getJdbcTemplate().update(sql, id);
	}

	public void updateUser(User user) {
		String sql = "update temp set name='xiang' where id=?";
		this.getJdbcTemplate().update(sql, user.getId());
	}

	public User selectUserById(int id) {
		String sql = "select * from temp where id=?";
		return this.getJdbcTemplate().queryForObject(sql, new UserRowMapper(), id);
	}

	public List<User> selectAllUser() {
		String sql = "select * from temp";
		return  this.getJdbcTemplate().query(sql, new UserRowMapper());
	}
	
	class UserRowMapper implements RowMapper<User> {
		// rs 为返回的结果集，以每行为单位封装.
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setUsername(rs.getString("name"));
			user.setPassword(rs.getString("password"));
			
			return user;
		}
		
	}

}
