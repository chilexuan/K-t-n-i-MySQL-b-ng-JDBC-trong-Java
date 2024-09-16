package Chi.dev.data.model;
import java.sql.Timestamp;
import Chi.dev.data.dao.DatabaseDao;
public class Order {
	  private int id;
	    private String code;
	    private String status;
	    private int userId;
	    private Timestamp createdAt;
	    public static final String PENDING = "pending";
	    public static final String FINISHED = "finish";
	    public Order(String code, String status, int userId) {
	        super();
	        this.code = code;
	        this.status = status;
	        this.userId = userId;
	    }
	    public Order(int id, String code, String status, int userId, Timestamp createdAt) {
	        super();
	        this.id = id;
	        this.code = code;
	        this.status = status;
	        this.userId = userId;
	        this.createdAt = createdAt;
	    }
	    public int getId() {
	        return id;
	    }
	    public void setId(int id) {
	        this.id = id;
	    }
	    public String getCode() {
	        return code;
	    }
	    public void setCode(String code) {
	        this.code = code;
	    }
	    public String getStatus() {
	        return status;
	    }
	    public void setStatus(String status) {
	        this.status = status;
	    }
	    public int getUserId() {
	        return userId;
	    }
	    public void setUserId(int userId) {
	        this.userId = userId;
	    }
	    public Timestamp getCreatedAt() {
	        return createdAt;
	    }
	    public void setCreatedAt(Timestamp createdAt) {
	        this.createdAt = createdAt;
	    }
	    
	    public User getUser(){
	        return DatabaseDao.getInstance().getUserDao().find(this.userId);
	    }
	    
	    
	}