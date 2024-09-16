package Chi.dev.data.model;
import java.sql.Timestamp;
public class Product {
		 private int id;
		    private String name;
		    private String description;
		    private String thumbnail;
		    private double price;
		    private int quantity;
		    private int categoryId;
		    private Timestamp createdAt;
	
		    // Constructor không tham số
		    public Product(String name, String description, String thumbnail, double price, int quantity, int categoryId) {
		    	this.name = name;
		        this.description = description;
		        this.thumbnail = thumbnail;
		        this.price = price;
		        this.quantity = quantity;
		        this.categoryId = categoryId;
		    }
	
		    // Constructor đầy đủ tham số
		    public Product(int id, String name, String description, String thumbnail, double price, int quantity, int categoryId, Timestamp createdAt) {
		        this.id = id;
		        this.name = name;
		        this.description = description;
		        this.thumbnail = thumbnail;
		        this.price = price;
		        this.quantity = quantity;
		        this.categoryId = categoryId;
		        this.createdAt = createdAt;
		    }
	
		    // Getters and setters cho các trường
		    public int getId() {
		        return id;
		    }
	
		    public void setId(int id) {
		        this.id = id;
		    }
	
		    public String getName() {
		        return name;
		    }
	
		    public void setName(String name) {
		        this.name = name;
		    }
	
		    public String getDescription() {
		        return description;
		    }
	
		    public void setDescription(String description) {
		        this.description = description;
		    }
	
		    public String getThumbnail() {
		        return thumbnail;
		    }
	
		    public void setThumbnail(String thumbnail) {
		        this.thumbnail = thumbnail;
		    }
	
		    public double getPrice() {
		        return price;
		    }
	
		    public void setPrice(double price) {
		        this.price = price;
		    }
	
		    public int getQuantity() {
		        return quantity;
		    }
	
		    public void setQuantity(int quantity) {
		        this.quantity = quantity;
		    }
	
		    public int getCategoryId() {
		        return categoryId;
		    }
	
		    public void setCategoryId(int categoryId) {
		        this.categoryId = categoryId;
		    }
	
		    public Timestamp getCreatedAt() {
		        return createdAt;
		    }
	
		    public void setCreatedAt(Timestamp createdAt) {
		        this.createdAt = createdAt;
		    }
		    public Product() {
		    }
	}

