// map.js
Page({
   
  /**
   * 页面的初始数据
   */
  data: {
    map:false,
    longitude:null,
    latitude:null,
    scale:14,
    markers: [{
      iconPath: "../../images/map-marker.png",
      id: 0,
      latitude: 23.099994,
      longitude: 113.324520,
      width: 50,
      height: 50,
      callout: { content: "柯岩大道 108号 E08", padding: 10, borderRadius:4}
    }]
  },
  /**
   * 初始化地图数据
   */
 onLoad:function(options){
   console.log(options)
      this.setData({ 'markers[0].latitude': options.latitude,
       'markers[0].longitude': options.longitude,
       longitude: options.longitude,
       latitude: options.latitude,
       'markers[0].callout.content': options.address
        })
        // 当数据初始化结束 再显示地图 这样不会显示不出来
        this.setData({map:true})
    }

})