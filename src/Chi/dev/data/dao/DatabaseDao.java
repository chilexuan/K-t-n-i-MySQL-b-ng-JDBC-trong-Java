package Chi.dev.data.dao;

public abstract class DatabaseDao {
    private static DatabaseDao instance;
    public static void init(DatabaseDao inst) {
        instance = inst;
    }
    public static DatabaseDao getInstance() {
        return instance;
    }
    
    public abstract CategoryDao getCategoryDao();
    public abstract OrderItemDao getOrderItemDao();
    public abstract OrderDao getOrderDao();
    public abstract UserDao getUserDao();
    public abstract ProductDao getProductDao();
}