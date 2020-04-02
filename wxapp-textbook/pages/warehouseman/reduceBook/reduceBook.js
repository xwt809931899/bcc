// pages/warehouseman/reduceBook/reduceBook.js
const app = getApp()
var utils = require("../../../utils/utils.js");
Page({

  /**
   * 页面的初始数据
   */
  data: {
    book: {},
    ISBN: ''
  },
  getISBN: function (e) {
    this.setData({
      ISBN: e.detail.value
    })
  },
  getBookInfo: function () {
    var that = this;
    var url = app.globalData.baseUrl + '/textbook/isbn/' + this.data.ISBN;
    wx.request({
      url: url,
      method: 'GET',
      header: {
        "Content-Type": "json",
      },
      success: function (res) {
        that.setData({
          book: res.data
        })
      }
    })
  },
  scan: function () {
    var that = this;
    wx.scanCode({
      success: function (res) {
        var url = app.globalData.baseUrl + '/textbook/isbn/' + res.result
        console.log(url)
        that.setData({
          ISBN: res.result
        })
        wx.request({
          url: url,
          method: 'GET',
          header: {
            "Content-Type": "json",
          },
          success: function (res) {
            that.setData({
              book: res.data
            })
          }
        })
      }
    })
  },

  fromSubmit: function (e) {
    var that = this;
    var url = app.globalData.baseUrl + '/textbook/reduce'
    wx.request({
      url: url,
      method: "POST",
      header: {
        'content-type': 'application/x-www-form-urlencoded; charset=UTF-8'
      },
      data: e.detail.value,
      dataType: "json",
      success: function (res) {
        console.log(res)
        wx.showToast({
          title: res.data.message,
        })
      }
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

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