package wechat.model;

/**
 * 商品的实体对象
 */
public class Product {
    private int id;//编号
    private String name;//商品名
    private short price;//价格
    private String description;//商品描述
    private int classId;//商品类别编号
    private String imgPath;//图片路径

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

    public short getPrice() {
        return price;
    }

    public void setPrice(short price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
}
