
Page({

  /**
   * 页面的初始数据
   */
  data: {
    map: false,
    id: null,
    home_party: null,
    phone_number: null,
    markers: [{
      id: 0,
      latitude: null,
      longitude: null,
      width: 40,
      height: 40,
      iconPath: "../../images/map-marker.png"
    }],
    icons: [{ imgurl: '../../images/icons-vr.png', text: "VR" },
    { imgurl: '../../images/icons-vr.png', text: "VR" },
    { imgurl: '../../images/icons-vr.png', text: "VR" },
    { imgurl: '../../images/icons-bed.png', text: "大床" },
    { imgurl: '../../images/icons-bed.png', text: "大床" },
    { imgurl: '../../images/icons-vr.png', text: "VR" },
    { imgurl: '../../images/icons-bed.png', text: "大床" },
    { imgurl: '../../images/icons-bed.png', text: "大床" },
    { imgurl: '../../images/icons-bed.png', text: "大床" },
    { imgurl: '../../images/icons-bed.png', text: "大床" }]
  },
  //向服务器发送请求 根据id获取homeParty对象
  init: function (id) {
    var that = this
    wx.request({
      // 8061
      url: 'http://localhost/servlet.Detail?id=' + id,
      success: function (opt) {
        console.log(opt.data.phoneNumber);

        that.setData({
          home_party: opt.data,
          'markers[0].latitude': opt.data.latitude,
          'markers[0].longitude': opt.data.longitude,
          'phone_number': opt.data.phoneNumber
        })
        that.setData({ map: true })
        //全局的起价 赋值
        getApp().data.basePrice = opt.data.price
        getApp().data.homeParty = opt.data
      }
    })
  },

  // 界面加载时  初始化数据
  onLoad: function (opt) {
    console.log(opt);
    this.setData({ id: opt.id });
    this.init(opt.id);
  },

  onShow: function () {
    console.log("show")
    //套餐价格清零
    getApp().data.packagePrice = 0
    getApp().calculatePrice()


  },

  // 点击地图后 跳转到地图界面
  mapClick: function () {
    var that = this
    console.log(that.data.home_party.latitude)
    wx.navigateTo({
      url: '../map/map?pid=1&latitude=' + that.data.home_party.latitude + '&longitude=' + that.data.home_party.longitude + '&address=' + that.data.home_party.address
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onShareAppMessage: function (res) {
    if (res.from === 'button') {
      // 来自页面内转发按钮
      console.log(res.target)
    }
    return {
      title: '绍兴一店',
      path: '/pages/detail?id=1',
      success: function (res) {
        // 转发成功
      },
      fail: function (res) {
        // 转发失败
      }
    }
  }
  ,
  //  联系电话按钮点击后 拨打电话
  phone: function () {
    var phone_number = this.data.phone_number
    console.log(phone_number);
    wx.showActionSheet({
      itemList: ["拨打电话：" + phone_number],
      success: function (res) {

        if (res.tapIndex == 0) {
          wx.makePhoneCall({
            phoneNumber: phone_number,
          })
        }
      }
    })
  }


})