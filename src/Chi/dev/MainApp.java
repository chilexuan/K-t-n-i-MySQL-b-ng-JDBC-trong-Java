package Chi.dev;
import java.util.List;
import Chi.dev.data.dao.CategoryDao;
import Chi.dev.data.dao.Database;
import Chi.dev.data.dao.DatabaseDao;
import Chi.dev.data.model.Category;
import Chi.dev.data.model.Order;
import Chi.dev.data.model.OrderItem;
import Chi.dev.data.model.Product;
import Chi.dev.data.model.User;
import Chi.dev.data.dao.UserDao;
import Chi.dev.data.dao.OrderDao;
import Chi.dev.data.dao.OrderItemDao;
import Chi.dev.data.dao.ProductDao;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatabaseDao.init(new Database());

        // Get the UserDao instance via DatabaseDao
		CategoryDao categoryDao = DatabaseDao.getInstance().getCategoryDao();
        UserDao userDao = DatabaseDao.getInstance().getUserDao();
        OrderDao orderDao = DatabaseDao.getInstance().getOrderDao();
        OrderItemDao orderItemDao = DatabaseDao.getInstance().getOrderItemDao();
        ProductDao productDao = DatabaseDao.getInstance().getProductDao();
//		CategoryDao categoryDao = new CategoryImpl();
//		UserDao userDao = new UserImpl();
//		OrderDao orderDao = new OrderImpl();
//		OrderItemDao orderItemDao = new OrderItemImpl();
//		Insert category
//		Category cat = new Category("Ao canh","Mo ta 3");
//		categoryDao.insert(cat);
		//Find category
//        Category findCat = categoryDao.find(1);
//		Category findCat = categoryDao.find(2);
//		System.out.println("Category found: " + findCat.getName());
		//Update category
//		findCat.setName("Ao lua");
//		categoryDao.update(findCat);
		//Delete category
//		categoryDao.delete(4);
		//Find all categories
		List<Category> allCats = categoryDao.findAll();
		for (Category category : allCats) {
            System.out.println("Id: "+category.getId()+"; Ten: "+ category.getName()+"; Mo ta: "+ category.getDescription());
        }
//		Insert user
//		User usr = new User("def@gmail.com","pass2","staff1");
//        userDao.insert(usr);
		//Find user
//		User findUser = userDao.find(3);
//		System.out.println("User found: " + findUser.getEmail());
//		//Update user
//		findUser.setEmail("taixiu@gmail.com");
//		userDao.update(findUser);
		//Delete user
//		userDao.delete(4);
		//Find all users
		List<User> allUsers = userDao.findAll();
        for (User user : allUsers) {
            System.out.println("Id: "+user.getId()+"; Email: "+ user.getEmail()+"; Mat khau: "+ user.getPassword()+"; Quyen: "+ user.getRole());
        }
//        //insert new order
//        Order ordeal = new Order("GfsGV1fgT","finished",1);
//        orderDao.insert(ordeal);
//        //find order
//        Order findOrder = orderDao.find(1);
//        System.out.println("Order found: " + findOrder.getId());
//        //update order
//        findOrder.setStatus("pending");
//        orderDao.update(findOrder);
//        //delete order
//        orderDao.delete(2);
//        //find all orders
        List<Order> allOrders = orderDao.findAll();
        for (Order order : allOrders) {
            System.out.println("Id: "+order.getId()+"; User: "+ order.getUserId()+"; Code: "+ order.getCode()+"; Ngay tao: "+ order.getCreatedAt()+"; Tinh trang: "+ order.getStatus());
        }
        //insert new order item
        
//        OrderItem ordealItem = new OrderItem(5,100000,2,1);
//        orderItemDao.insert(ordealItem);
        //find order item
//        OrderItem findOrderItem = orderItemDao.find(1);
//        System.out.println("Order item found: " + findOrderItem.getId());
////        update order item
//        findOrderItem.setPrice(150000);
//        orderItemDao.update(findOrderItem);
        //delete order item
//        orderItemDao.delete(2);
        //find all order items
        List<OrderItem> allOrderItems = orderItemDao.findAll();
        for (OrderItem orderItem : allOrderItems) {
            System.out.println("Id: "+orderItem.getId()+"; ID Order: "+ orderItem.getOrderId()+"; ID san pham: "+ orderItem.getProductId()+"; So luong: "+ orderItem.getQuantity()+"; Don gia: "+ orderItem.getPrice());
        }
     // Insert new product
//        Product newProduct = new Product("Bose SoundLink Mini","Engine","thumbnail2.jpg",80000,50,2);
//        productDao.insert(newProduct);
        // Find product
//        Product foundProduct = productDao.find(1);
//        System.out.println("Product found: " + foundProduct.getName());

        // Update an existing product
//        foundProduct.setName("Beats Studio Wireless Over-Ear 2");
//        foundProduct.setPrice(30000);
//        productDao.update(foundProduct);

        // Delete a product by ID
//        productDao.delete(2);

        // Find all products
        List<Product> allProducts = productDao.findAll();
        for (Product product : allProducts) {
            System.out.println("Id: " + product.getId() + "; Ten sp: " + product.getName() + "; Gia ban: " + product.getPrice());
        }
	}
	
}