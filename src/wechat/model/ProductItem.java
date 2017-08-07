package wechat.model;

/**
 * 商品对象 包括商品数量
 */
public class ProductItem {
    private Product product;//商品
    private int quantity;//商品数量

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
