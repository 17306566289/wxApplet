// packagelist.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    myPackage:null,
  list:['','','','','']
  },
  //向服务器发送请求 根据id获取package对象
  init: function (packageId) {
    var that = this
    if (packageId!=-1)
    // 获取套餐集合
    wx.request({
      url: 'http://localhost/servlet.PackageList?id=' + packageId,
      success: function (opt) {
        that.setData({
          list: opt.data.products,
          myPackage:opt.data.package
        })
      }
    })
    else
    // packageId==-1 是从订单界面跳转来的
      that.setData({
        list: getApp().data.myPackage.products,
        myPackage: getApp().data.myPackage.package
      })
    
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
  this.init(options.id)
  }

  
})