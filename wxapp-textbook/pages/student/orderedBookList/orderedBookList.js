// pages/student/orderedBookList/orderedBookList.js
const app = getApp()
var utils = require("../../../utils/utils.js");
Page({

  /**
   * 页面的初始数据
   */
  data: {
    books:[],
    money:0
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    var url = app.globalData.baseUrl + '/student/orderedbook'
    utils.get(url,function(res){
      var total = 0;
      for(var i=0;i<res.length;i++){
        console.log(total)
        total += res[i].price
        console.log(total)
      }
      that.setData({
        books:res,
        money:total
      });
    });
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})