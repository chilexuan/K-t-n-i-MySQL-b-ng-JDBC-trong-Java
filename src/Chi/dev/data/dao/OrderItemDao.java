package Chi.dev.data.dao;
import java.util.List;

import Chi.dev.data.model.OrderItem;
public interface OrderItemDao {
	 public boolean insert(OrderItem orderItem);
	    public boolean update(OrderItem orderItem);
	    public boolean delete(int id);
	    public OrderItem find(int id);
	    public List<OrderItem> findAll();
	    public List<OrderItem> findByOder(int orderId);
	    public List<OrderItem> findByProduct(int prodId);
	}

