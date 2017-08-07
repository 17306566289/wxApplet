const date = new Date()
const years = []
for (let i = date.getFullYear(); i <= date.getFullYear() + 1; i++) {
  years.push(i)
}

Page({

  /**
   * 页面的初始数据
   */
  data: {
    lastSelectedDay: 0,
    week: ["日", "一", "二", "三", "四", "五", "六"],
    cartPrice: 0,
    total: 0,
    homePartyId: -1,
    currentItem: -1,
    packages: [{ id: 1 }, { id: 2 }],
    sunandmoon: ['../../images/sun.png', '../../images/moon.png'],
    years: years,
    year: date.getFullYear(),
    months: [],
    month: date.getMonth() + 1,
    days: null,
    pastDays: null,
    index: 0,
    blank: null,
    mySelect: { year: 0, month: 0, day: 0, dayOrNight: 'day' }
  },
  exshop: function () {
    wx.navigateTo({
      url: '../shop/shop',
    })
  },
  // 改变年份
  yearChange: function (e) {
    var months = new Array()
    // 如果年份是今年 将剩余月份填充
    if (e.detail.value == 0)
      for (let i = date.getMonth() + 1; i <= 12; i++)
        months.push(i)
    // 如果年份是明年 将12个月份填充
    else
      for (let i = 1; i <= 12; i++)
        months.push(i)

    this.setData({
      year: years[e.detail.value],
      months: months
    })
  },
  // 改变月份
  monthChange: function (e) {
    this.setData({
      month: this.data.months[e.detail.value]
    })
  },
  // 获取该月份的预定数据
  getMonth: function () {
    var that = this
    wx.request({
      url: 'http://localhost/servlet.GetMonth',
      success: function (e) {
        var blank = e.data.blank
        var days = e.data.dayList
        var pastDays = e.data.pastDayList
        that.setData({
          pastDays: pastDays,
          days: days,
          blank: blank
        })
      }
    })

  },
  // 选择日期
  dayClick: function (e) {
    var that = this
    // 将这次选择的日期存入data 以备提交
    var mySelect = this.data.mySelect
    mySelect.year = this.data.year
    mySelect.month = this.data.month
    mySelect.day = e.currentTarget.dataset.day
    mySelect.dayOrNight = 'day'
    //  获取选中日期的索引
    var dayIndex = e.currentTarget.dataset.day - this.data.pastDays.length - 1;
    //  将上次的选择清空
    this.data.days[that.data.lastSelectedDay].myReserve = null
    // 选中的日期
    var selectedDay = this.data.days[dayIndex]

    // 将这次选择的日期记录 当下次选择可以将其复原
    this.setData({ lastSelectedDay: dayIndex })
    // 如果日场夜场都没有被预定
    if (!selectedDay.dayIsReserved && !selectedDay.nightIsReserved)
      wx.showModal({
        title: '选择时间段',
        content: '日场: 09:00-17:00 夜场:18:00-8:00(次日)',
        confirmText: '日场',
        cancelColor: "#3CC51F",
        cancelText: '夜场',
        success: function (res) {
          if (res.confirm) {
            selectedDay.myReserve = 'day'
          } else if (res.cancel) {
            selectedDay.myReserve = 'night'
            mySelect.dayOrNight = 'night'
          }
          that.setData({
            days: that.data.days,
            mySelect: that.data.mySelect
          })
        }
      })

    // 如果夜场没有被预定
    else if (selectedDay.dayIsReserved && !selectedDay.nightIsReserved)
      wx.showModal({
        title: '选择时间段',
        content: '日场: 09:00-17:00 夜场:18:00-8:00(次日)',
        confirmText: '夜场',
        showCancel: false,
        success: function (res) {
          if (res.confirm) {
            selectedDay.myReserve = 'night'
            mySelect.dayOrNight = 'night'
            that.setData({
              days: that.data.days
            })
          }
        }
      })
    // 如果日场没有被预定
    else if (!selectedDay.dayIsReserved && selectedDay.nightIsReserved)
      wx.showModal({
        title: '选择时间段',
        content: '日场: 09:00-17:00 夜场:18:00-8:00(次日)',
        confirmText: '日场',
        showCancel: false,
        success: function (res) {
          if (res.confirm) {
            selectedDay.myReserve = 'day'
            that.setData({
              days: that.data.days
            })
          }
        }
      })
    // 渲染数据



  },
  //套餐选择
  tagChoose: function (e) {
    var that = this
    var index = e.currentTarget.dataset.index;
    var packagePrice = e.currentTarget.dataset.price;
    //选中的套餐
    var myPackage = this.data.packages[index]
    // 套餐放入全局变量
    getApp().data.myPackage = myPackage
    // 套餐价格 全局变量
    getApp().data.packagePrice = packagePrice
    // 计算总价
    getApp().calculatePrice()
    //给合计赋初值
    this.setData({
      total: getApp().data.total
    })
    //设置当前样式
    that.setData({
      'currentItem': index
    })
  },

  // 点击了套餐的列表按钮 进入套餐商品页面
  listBtnClick: function (options) {
    // 获取套餐的id
    var packageId = options.currentTarget.dataset.id
    // 跳转 传参
    wx.navigateTo({
      url: '../packagelist/packagelist?id=' + packageId,
    })
  },

  // 日期改变后
  bindChange: function (e) {
    const val = e.detail.value
    // 如果月份是当前月 重新填充months
    console.log(val[1])
    if (this.data.months[val[1]] == date.getMonth() + 1) {
      days.splice(0, 31)
      console.log(date.getMonth() + 1)
      for (let i = date.getDay(); i <= 31; i++) {
        days.push(i)
      }
    }
    this.setData({
      year: this.data.years[val[0]],
      month: this.data.months[val[1]],
      day: this.data.days[val[2]],
      dayornight: this.data.dayornights[val[3]]
    })
  },

  //向服务器发送请求 根据id获取package对象
  init: function (homePartyId) {
    var that = this
    // 获取套餐集合
    wx.request({
      // 8061
      url: 'http://localhost/servlet.Reserve?homePartyId=' + homePartyId,
      success: function (opt) {
        that.setData({
          packages: opt.data
        })
      }
    })
    // 填充月份
    var months = new Array
    for (let i = date.getMonth() + 1; i <= 12; i++)
      months.push(i)
    this.setData({
      months: months
    })
    // 获取月份
    this.getMonth()
  },



  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    getApp().calculatePrice()
    this.setData({ total: getApp().data.total })
    //获取homePartyId
    this.setData({
      homePartyId: options.id
    })
    // 初始化
    this.init(options.id)
  },


  onShow: function () {
    getApp().calculatePrice()
    //给合计赋初值
    this.setData({
      total: getApp().data.total,
      cartPrice: getApp().data.cartPrice
    })
  }
  ,
  //  点击确认
  comfirm: function () {
    // 如果未选择套餐
    if (this.data.currentItem == -1)
      wx.showToast({
        title: '请选择套餐',
      })
    // 如果未选择时间
    else if (this.data.mySelect.day == 0)
      wx.showToast({
        title: '请选择日期',
      })
    else {
      getApp().data.reserveDay = this.data.mySelect
      wx.navigateTo({
        url: '../order/order',
      })
    }
  },
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