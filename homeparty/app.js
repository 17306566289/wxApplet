App({
 data:{
   cartNum:0,
  cart:null,
  productList:null,
  basePrice:0,
  packagePrice:0,
  cartPrice:0,
 total:0,
 homeParty:null,
 reserveDay:null,
 myPackage:null,
},
calculatePrice:function(){
  this.data.total = parseInt(this.data.basePrice) + parseInt(this.data.packagePrice) + parseInt( this.data.cartPrice)
}
})
