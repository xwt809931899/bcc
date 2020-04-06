// pages/warehouseman/classSignature/classSignature.js
const app = getApp()
var utils = require("../../../utils/utils.js");
Page({

  /**
   * 页面的初始数据
   */
  data: {
    tempFilePaths:""
  },
  showSignatureSelect:function(){
    wx.navigateTo({
      url: 'selectSignature/selectSignature'
    })
  },
  choosePic:function(){
    var that = this;
    wx.chooseImage({
      count:1,
      success: function(res) {
        that.setData({
          tempFilePaths:res.tempFilePaths
        })
      },
    })
  },
  preview:function(){
    wx.previewImage({
      urls: this.data.tempFilePaths,
    })
  },
  upload:function(e){
    var url = app.globalData.baseUrl + '/warehouseman/upload';
    console.log(url);
    console.log(this.data.tempFilePaths)
    var that = this;
    console.log(e.detail.value)
    wx.uploadFile({
      filePath: that.data.tempFilePaths[0],
      name: 'file',
      url: url,
      formData:{
        clazz:e.detail.value.clazz,
        tips:e.detail.value.tips
      },
      success(res){
        if (!utils.isEmpty(res.data)) {
          wx.showModal({
            title: '提示',
            content: JSON.parse(res.data).message,
          })
        }
      }
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(this.data.tempFilePaths.length)
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