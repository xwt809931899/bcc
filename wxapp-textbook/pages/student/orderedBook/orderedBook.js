// pages/student/orderedBook/orderedBook.js
const app = getApp()
var utils = require("../../../utils/utils.js");
Page({

  /**
   * 页面的初始数据
   */
  data: {
    books:[]
  },

  orderBook:function(e){
    var that = this;
    var courseid = e.currentTarget.dataset.courseid;
    var url = app.globalData.baseUrl + '/selectcourse/update/'+courseid;
    wx.showModal({
      title: '提示',
      content: '选择订购后不可取消！',
      success(res) {
        if (res.confirm) {
          utils.get(url,function(res){
            console.log(res);
            if(res.code>0){
              wx.showToast({
                title: res.message,
              })
              that.getData();
            }else{
              wx.showToast({
                title: res.message,
              })
            }
          })
        } 
      }
    })
  },
getData:function(){
  var that = this;
  var url = app.globalData.baseUrl + '/student/notorderedbook'
  wx.showLoading({
    title: '正在获取数据',
  })
  utils.get(url, function (res) {
    if(res.status == 500){
      wx.hideLoading();
      wx.showToast({
        title: '数据加载失败，退出重试',
      })
    }else{
      that.setData({
        books: res
      }, function () {
        wx.hideLoading();
      });
    }
    
  })
},


  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.getData()
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