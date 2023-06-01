import java.util.List;

public class gettersSetters {
    private String userEmail;
    private String userPassword;
    private List<Order> orders;
    private String BaseUri;
    private String productCategory;
    private String productSubCategory;
    private String productName;
    private Integer productPrice;
    private String productDescription;
    private String productFor;
    private String productImage;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductSubCategory() {
        return productSubCategory;
    }

    public void setProductSubCategory(String productSubCategory) {
        this.productSubCategory = productSubCategory;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductFor() {
        return productFor;
    }

    public void setProductFor(String productFor) {
        this.productFor = productFor;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getBaseUri() {
        return BaseUri;
    }

    public void setBaseUri(String baseUri) {
        BaseUri = baseUri;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}



