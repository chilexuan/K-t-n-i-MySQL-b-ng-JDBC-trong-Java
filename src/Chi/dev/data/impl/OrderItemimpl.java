package Chi.dev.data.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Chi.dev.data.dao.OrderItemDao;
import Chi.dev.data.driver.MySQLDriver;
import Chi.dev.data.model.OrderItem;
public class OrderItemimpl implements OrderItemDao{
	Connection con = MySQLDriver.getInstance().getConnection();
	@Override
	public boolean insert(OrderItem orderItem) {
		// TODO Auto-generated method stub
        String sql = "INSERT INTO ORDER_ITEMS(ID, QUANTITY, PRICE, ORDER_ID, PRODUCT_ID) VALUES(NULL, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, orderItem.getQuantity());
            stmt.setDouble(2, orderItem.getPrice());
            stmt.setInt(3, orderItem.getOrderId());
            stmt.setInt(4, orderItem.getProductId());
            
            stmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return false;
	}

	@Override
	public boolean update(OrderItem orderItem) {
		// TODO Auto-generated method stub
        String sql = "UPDATE ORDER_ITEMS SET quantity = ?, price = ?, order_id = ?, product_id = ? WHERE id = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1,orderItem.getQuantity());
            stmt.setDouble(2, orderItem.getPrice());
            stmt.setInt(3, orderItem.getOrderId());
            stmt.setInt(4, orderItem.getProductId());
            stmt.setInt(5, orderItem.getId());
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
        String sql = "DELETE FROM ORDER_ITEMS WHERE ID = ?";
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
	public OrderItem find(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM ORDER_ITEMS WHERE ID = ?" ;
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
            	
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                int orderId = rs.getInt("order_id");
                int productId = rs.getInt("product_id");
                
                return new OrderItem(id, quantity, price, orderId, productId);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return null;
	}

	@Override
	public List<OrderItem> findAll() {
		// TODO Auto-generated method stub
        List<OrderItem> orList = new ArrayList<>();
        String sql = "SELECT * FROM ORDER_ITEMS" ;
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
            	int id = rs.getInt("id");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                int orderId = rs.getInt("order_id");
                int productId = rs.getInt("product_id");
                
                orList.add(new OrderItem(id, quantity, price, orderId, productId));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return orList;
	}

	@Override
	public List<OrderItem> findByOder(int orderId) {
		// TODO Auto-generated method stub
	    List<OrderItem> orderItemList = new ArrayList<>();
        String sql = "SELECT * FROM ORDER_ITEMS WHERE order_id = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, orderId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                int productId = rs.getInt("product_id");
                orderItemList.add( new OrderItem(id, quantity, price, orderId, productId));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return orderItemList;
	}

	@Override
	public List<OrderItem> findByProduct(int prodId) {
		// TODO Auto-generated method stub
		return null;
	}

}
