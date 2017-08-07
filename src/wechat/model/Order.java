package wechat.model;

import java.util.List;

/**
 * 订单类
 */
public class Order {
    private int id;
    private String createTime;//订单生成时间
    private int homePartyId;//预定的轰趴馆的id
    private String wxId;//微信id
    private int year;//预定年份
    private int month;//预定的月
    private int day;//预定日期
    private String dayOrNight;//预定的日场还是夜场
    private int basePrice;//轰趴馆起价 基础价
    private int packagePrice;//套餐价格
    private int cartPrice;//套餐外消费
    private List<OrderCartItem> orderCartItemList;//购物车里额外购买的商品的列表
    private int cutPrice;//优惠额度
    private int packageId;//选择的套餐编号
    private int peopleNum;//入驻人数
    private String name;//入住人姓名
    private String phoneNum;//手机号码
    private String idCard;//身份证
    private String visitedNum;//邀请码
    private String studentId;//学生证
    private int cutId;//优惠券id
    private String remark;//备注
    private int deposit;//押金
    private int total;//最后需要支付的金额

    public String getDayOrNight() {
        return dayOrNight;
    }

    public void setDayOrNight(String dayOrNight) {
        this.dayOrNight = dayOrNight;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getHomePartyId() {
        return homePartyId;
    }

    public void setHomePartyId(int homePartyId) {
        this.homePartyId = homePartyId;
    }

    public String getWxId() {
        return wxId;
    }

    public void setWxId(String wxId) {
        this.wxId = wxId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }



    public int getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public int getPackagePrice() {
        return packagePrice;
    }

    public void setPackagePrice(int packagePrice) {
        this.packagePrice = packagePrice;
    }

    public int getCartPrice() {
        return cartPrice;
    }

    public void setCartPrice(int cartPrice) {
        this.cartPrice = cartPrice;
    }

    public List<OrderCartItem> getOrderCartItemList() {
        return orderCartItemList;
    }

    public void setOrderCartItemList(List<OrderCartItem> orderCartItemList) {
        this.orderCartItemList = orderCartItemList;
    }

    public int getCutPrice() {
        return cutPrice;
    }

    public void setCutPrice(int cutPrice) {
        this.cutPrice = cutPrice;
    }

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public int getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(int peopleNum) {
        this.peopleNum = peopleNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getVisitedNum() {
        return visitedNum;
    }

    public void setVisitedNum(String visitedNum) {
        this.visitedNum = visitedNum;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getCutId() {
        return cutId;
    }

    public void setCutId(int cutId) {
        this.cutId = cutId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Order(String createTime, int homePartyId, String wxId, int year, int month, int day, String dayOrNight, int basePrice, int packagePrice, int cartPrice, List<OrderCartItem> orderCartItemList, int cutPrice, int packageId, int peopleNum, String name, String phoneNum, String idCard, String visitedNum, String studentId, int cutId, String remark, int deposit, int total) {
        this.createTime = createTime;
        this.homePartyId = homePartyId;
        this.wxId = wxId;
        this.year = year;
        this.month = month;
        this.day = day;
        this.dayOrNight = dayOrNight;
        this.basePrice = basePrice;
        this.packagePrice = packagePrice;
        this.cartPrice = cartPrice;
        this.orderCartItemList = orderCartItemList;
        this.cutPrice = cutPrice;
        this.packageId = packageId;
        this.peopleNum = peopleNum;
        this.name = name;
        this.phoneNum = phoneNum;
        this.idCard = idCard;
        this.visitedNum = visitedNum;
        this.studentId = studentId;
        this.cutId = cutId;
        this.remark = remark;
        this.deposit = deposit;
        this.total = total;
    }
}
