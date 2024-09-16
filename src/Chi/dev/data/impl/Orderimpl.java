package Chi.dev.data.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Chi.dev.data.dao.OrderDao;
import Chi.dev.data.driver.MySQLDriver;
import Chi.dev.data.model.Order;
public class Orderimpl implements OrderDao{
	Connection con = MySQLDriver.getInstance().getConnection();
	@Override
	public boolean insert(Order order) {
		// TODO Auto-generated method stub
        String sql = "INSERT INTO ORDERS(ID, CODE, STATUS, USER_ID) VALUES(NULL, ?, ?, ?)";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, order.getCode());
            stmt.setString(2, order.getStatus());
            stmt.setInt(3, order.getUserId());
            stmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return false;
	}

	@Override
	public boolean update(Order order) {
		// TODO Auto-generated method stub
        String sql = "UPDATE ORDERS SET code = ?, status = ?, user_id = ?, created_at = ? WHERE id = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, order.getCode());
            stmt.setString(2, order.getStatus());
            stmt.setInt(3, order.getUserId());
            stmt.setTimestamp(4, order.getCreatedAt());
            stmt.setInt(5, order.getId());
            return stmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
        String sql = "DELETE FROM ORDERS WHERE ID = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            return stmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return false;
	}

	@Override
	public Order find(int id) {
		// TODO Auto-generated method stub
        String sql = "SELECT * FROM ORDERS WHERE ID = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String code = rs.getString("code");
                String status = rs.getString("status");
                int userId = rs.getInt("user_id");
                Timestamp created_at = rs.getTimestamp("created_at");
                return new Order(id, code, status, userId, created_at);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return null;
	}

	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM ORDERS";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String code = rs.getString("code");
                String status = rs.getString("status");
                int userId = rs.getInt("user_id");
                Timestamp created_at = rs.getTimestamp("created_at");
                orders.add(new Order(id, code, status, userId, created_at));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return orders;
	}

	@Override
	public List<Order> findByUser(int userId) {
		// TODO Auto-generated method stub
        List<Order> orderList = new ArrayList<>();
        String sql = "SELECT * FROM ORDERS WHERE user_id = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String code = rs.getString("code");
                String status = rs.getString("status");
                Timestamp createdAt = rs.getTimestamp("created_at");
                orderList.add(new Order(id, code, status, userId, createdAt));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return orderList;
	}

	@Override
	public Order findByCode(String code) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM ORDERS WHERE CODE= ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, code);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String status = rs.getString("status");
                int userId = rs.getInt("user_id");
                Timestamp createdAt = rs.getTimestamp("created_at");
                return new Order(id, code, status, userId, createdAt);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
	}

	@Override
	public List<Order> findByStatus(String status) {
		// TODO Auto-generated method stub
        List<Order> orderList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM ORDERS WHERE STATUS = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, status);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String code = rs.getString("code");
                int userId = rs.getInt("user_id");
                Timestamp createdAt = rs.getTimestamp("created_at");
                orderList.add(new Order(id, code, status, userId, createdAt));
            }
        } catch (SQLException ex) {
        }
        return orderList;
	}

	@Override
	public int countOrderByDay(String date) {
		// TODO Auto-generated method stub
        int count = 0;
        String sql = "SELECT COUNT(*) AS count FROM orders where date(created_at)=?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, date);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Userimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
	}

	@Override
	public double earningOrderByDay(String date) {
		// TODO Auto-generated method stub
		double total = 0;
        String sql = "SELECT * FROM orders where date(created_at)=?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, date);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String code = rs.getString("code");
                String status = rs.getString("status");
                int userId = rs.getInt("user_id");
                Timestamp createdAt = rs.getTimestamp("created_at");
                Order order = new Order(id, code, status, userId, createdAt);
//                total += order.getTotal();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Userimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
	}

}
