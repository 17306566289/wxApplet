package wechat.model;

/**
 * 订单里的购物车清单
 */
public class OrderCartItem {
    private int productId;//商品id
    private int quantity;//商品数量

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
