var app = getApp()
var Util = require('../../utils/util.js')
Page({

  data: {
    basePrice:null,
    packagePrice: null,
    cartPrice: null,
    total: null,
    homeParty: null,
    reserveDay: null,
    myPackage: null,
    cart: null
  },
  // 点击套餐按钮
  packageBtnClick: function () {
    wx.navigateTo({
      url: '../packagelist/packagelist?id=' + app.data.myPackage.id,
    })

  },
  // 点击额外消费
  cartBtnClick: function () {
    wx.navigateTo({
      url: '../shop/shop',
    })

  },
  // 初始化函数
  init: function () {
    console.log(app.data.basePrice)
    this.setData({
      basePrice: app.data.basePrice,
      packagePrice: app.data.packagePrice,
      cartPrice: app.data.cartPrice,
      total: app.data.total,
      homeParty: app.data.homeParty,
      reserveDay: app.data.reserveDay,
      myPackage: app.data.myPackage,
      cart: app.data.cart
    })
  },
 /**
  * 输入验证
  */
  inputValid:function(value){
   
    //判断用户输入的是否为11位手机号码
    var regPhoneNum = new RegExp('^1[0-9]{10}$','g')
    //测试数据，不为11位手机号码则返回null
    var rsPhoneNum = regPhoneNum.exec(value.phoneNum);

      var missingValue=null
      if(!value.peopleNum)
        missingValue ="请输入入驻人数"
      else if (!parseInt(value.peopleNum))
        missingValue = "入驻人数格式错误"
    else  if (!value.name)
        missingValue = "请输入您的姓名"
      else if (!value.phoneNum)
        missingValue = "请输入手机号码"
      else if (!rsPhoneNum)
        missingValue = "手机号码格式错误"
      else if (!value.idCard)
        missingValue = "请输入身份证号码"
      // else if (!rsIdCard)
      //   missingValue = "身份证号码格式错误"
      if (missingValue)
      { 
        wx.showToast({
          title: missingValue,
          image:"../../images/delete.png"
        })
         return false;
      } 
        return true;
        
  },
   /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },
  onShow: function () {
    this.init()
  },
  // 点击支付按钮
  orderSubmit: function (e) {
    var that=this
    // 输入验证
  if(this. inputValid(e.detail.value)) 
    // 向服务器发送请求
    wx.request({
      url: 'http://localhost/servlet.CreateOrder',
      method:'POST',
      data: {
        wxId:null,
        year: that.data.reserveDay.year,
        month: that.data.reserveDay.month,
        day: that.data.reserveDay.day,
        dayOrNight: that.data.reserveDay.dayOrNight,
        cutPrice:0,
        peopleNum: e.detail.value.peopleNum,
        name: e.detail.value.name,
        phoneNum: e.detail.value.phoneNum,
        idCard: e.detail.value.idCard,
        visitedNum: e.detail.value.visitedNum,
        studentId: e.detail.value.studentId,
        cutId:0,
        remark: e.detail.value.remark,
        deposit:1000,
        basePrice: that.data.basePrice,
        packagePrice: that.data.packagePrice,
        cartPrice: that.data.cartPrice,
        total: that.data.total,
        homePartyId: that.data.homeParty.id,
        reserveDay: that.data.reserveDay,
        packageId: that.data.myPackage.id,
        myPackage: that.data.myPackage,
        cart:that.data.cart
      },
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      success:function(e){
        console.log(e)
      },
      fail: function () { }
    })
  }
  ,
  // 订单提交



})