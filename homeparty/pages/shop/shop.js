var app=getApp()
// shop.js
Page({

  /**
   * 页面的初始数据
   */

  data: {
    productClass:["休闲小吃","充饥必备","酒水饮料","其他服务"],
    cartNum:0,
    shoppingListShow:false,
    // 将productList内四个类型的list联合放入cart中
    cart:[],
    cartTotal:0,
    selectedClassId:0,
    selectedList:{},
    productList: [[], [], [], []]
  },


// 根据classID获取商品
  getProduct:function(classId){
    var that=this 
    //数据库里的classID是1，2，3，4 所以要先加一
    var sqlClassId =parseInt(classId)+1
    wx.request({
      url: 'http://localhost/servlet.Shop?classId=' + sqlClassId,
      success: function (opt) {
      // setData不能指定数组的第几个元素进行赋值 所以先取出该数组
        var products = that.data.productList 
         //  将选中的类型赋值
        products[classId] = opt.data
     
        //  直接赋值给数组
        that.setData({
          selectedList: opt.data,
          productList: products
        })
      }
    })

    // this.getCartNum()
  },

  //初始化
  init: function () {
    // 如果全局数据的购物车为空
    if (app.data.productList==null)
  // 从服务器获取商品
    this.getProduct(0)
  //  从全局数据获取商品
    else this.setData({
      productList: app.data.productList,
      cartTotal: app.data.cartPrice,
      selectedList: app.data.productList[0],
      cartNum: app.data.cartNum
    })
    
  },
  // 购物车里点击删除按钮
  cartItemDeleteBtn:function(e){
   var index1= e.currentTarget.dataset.findex
   var index2 = e.currentTarget.dataset.sindex
    // 将productList里对应的item的quantity置0
   var productList = this.data.productList
   var selectedList = this.data.selectedList
  //  获取数量
   var quantity = productList[index1][index2].quantity
  //  获取价格
   var price = productList[index1][index2].product.price
   productList[index1][index2].quantity=0
   selectedList[index2].quantity = 0
   this.setData({
     productList: this.data.productList,
     selectedList: this.data.selectedList,
     cartNum: this.data.cartNum - quantity,
     cartTotal: this.data.cartTotal - quantity * price
   })

  },
// 购物车关闭
cartOutFocus:function(){
  this.setData({
    shoppingListShow:false
  })
},
// 购物车显示按钮
cartBtn:function(){
  this.setData({
    shoppingListShow: !this.data.shoppingListShow
  })
  console.log(this.data.productList)
},




// 获得购物车清单
getCart:function(){
  var that=this
  var cart =""
 
  var productList= that.data.productList
  // 遍历productList 将其中不为空的array合并放入cart
  for(let i=0;i<4;i++)
  {
    for (let j = 0; j < productList[i].length; j++)
    if (productList[i][j].quantity>0)
        { 
    var productId = productList[i][j].product.id
     var quantity = productList[i][j].quantity
     cart += ("productId=" + productId +","+ "quantity=" + quantity+";")
        }
  }
  this.setData({
    cart: cart
  })
},

    // 点击数量增加按钮
    add:function(e){
      this.addOrSub(true,e)
    },
    // 点击数量增加按钮
    sub: function (e) {
      var productIndex = e.currentTarget.dataset.index
      var selectedList = this.data.selectedList
      if (selectedList[productIndex].quantity>0)
      this.addOrSub(false, e)
    },
    // 
    addOrSub:function(isAdd,e){
     
      // 获取当前选中商品的列表
      var productIndex = e.currentTarget.dataset.index
      var selectedList = this.data.selectedList
      var productList = this.data.productList
      var selectedClassId = this.data.selectedClassId
      var cartTotal = this.data.cartTotal
      // 加还是减
      if (isAdd){
         selectedList[productIndex].quantity += 1
         cartTotal += selectedList[productIndex].product.price
         this.setData({ cartNum: this.data.cartNum+1})
         }
      else {
      selectedList[productIndex].quantity -= 1
      cartTotal -= selectedList[productIndex].product.price
      this.setData({ cartNum: this.data.cartNum- 1 })
      }
      //productList同步刷新
      productList[selectedClassId] = selectedList
      // 置数
      this.setData({
        selectedList: selectedList,
        productList: productList,
        cartTotal:cartTotal
      })
      
    },

   


  /**
   * 商品种类选择按钮
   */
  classBtnClick:function(e){
       var that=this
    // 选中的class的id
    var classId = e.currentTarget.dataset.class
       //如果这种类型的商品未获取 则从服务器获取
    if (this.data.productList[classId]==null)
      {
        this.getProduct(classId)
      }
      // 如果已经获得 则直接给selectedList赋值
      else{
        this.setData({selectedList: this.data.productList[classId]})
      }
      //标记当前选中的类型
    this.setData({selectedClassId: classId})

  },


  /**
  * 生命周期函数--监听页面加载
  */
  onLoad: function (options) {
    // 初始化
   
  },
  onShow:function(){
    this.init()
  },

// 点击确认 跳转
  confirm:function(){
    this.getCart()
    app.data.cartNum = this.data.cartNum
    app.data.cart = this.data.cart
    app.data.productList =this.data.productList
   app.data.cartPrice = this.data.cartTotal
   app.calculatePrice()
    wx.navigateBack({
      
    })
  }
})