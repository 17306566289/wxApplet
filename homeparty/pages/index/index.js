
Page({
  
  /**
   * 页面的初始数据
   */
  data: {
    homePartyList:null,

    indexlist:[{imgurl:'../../images/index-list-0.jpg',name:"绍兴一店（越都名府店）",id:0},
      { imgurl: '../../images/index-list-1.jpg', name: "绍兴一店（越都名府店）", id: 1},
      { imgurl: '../../images/index-list-2.jpg', name: "绍兴一店（越都名府店）", id: 2}]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that=this
    // 请求主页数据
    wx.request({
      url: 'http://localhost/servlet.Index',
      // 回调成功 
      success:function(res){
        // 把回传的数据放入homePartyList
        that.setData({homePartyList:res.data});
      }
    })
  },
  /**
   * 单击了一个轰趴馆 页面跳转
   */
  onClick:function(opt){
    wx.navigateTo({
      url: '../detail/detail?id=' + opt.currentTarget.dataset.id
    })
  },
  onShow: function (options) {
    //购物车清空
    getApp().data.cart = null
   getApp().data.productList=null
   getApp().data.cartPrice=0
  },

})