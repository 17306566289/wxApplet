package wechat.model;

import java.util.List;

/**
 * 轰趴馆实体对象
 */
public class HomeParty {
    private int id;
    private String name;//轰趴馆名字
    private String price;//起价
    private String address;//轰趴馆的地址
    private double longitude;//纬度
    private double latitude;//经度
    private String description;//环境描述
    private String phoneNumber;//联系电话
    private String iconShow;//别墅设备 图标是否显示 0表示不显示 1表示显示
    private List<Icon> iconList;//图标集合
    private List<ImgPath> imgPathList;//图片路径集合
    private List<Tag> tagList;//标签集合

    public String getIconShow() {
        return iconShow;
    }

    public void setIconShow(String iconShow) {
        this.iconShow = iconShow;
    }

    public List<Icon> getIconList() {
        return iconList;
    }

    public void setIconList(List<Icon> iconList) {
        this.iconList = iconList;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<ImgPath> getImgPathList() {
        return imgPathList;
    }

    public void setImgPathList(List<ImgPath> imgPathList) {
        this.imgPathList = imgPathList;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

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


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
