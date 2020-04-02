// pages/index/insertTextbook/insertTextbook.js

const app = getApp()
var utils = require("../../../utils/utils.js");
Page({

  /**
   * 页面的初始数据
   */
  data: {
    ISBN: '',
    textbook: {},
    courseid: "",
    caption:""
  },

  getISBN: function (e) {
    this.setData({
      ISBN: e.detail.value
    })
  },

  getBookInfo: function () {
    var that = this;
    var url = "http://49.234.70.238:9001/book/worm/isbn?isbn=" + this.data.ISBN;
    wx.request({
      url: url,
      method: 'GET',
      header: {
        "Content-Type": "json",
      },
      success: function (res) {
        that.setData({
          textbook: res.data.data[0]
        })
      }
    })
  },

  fromSubmit: function (e) {
    var that = this;
    var url = app.globalData.baseUrl + '/textbook/insert'
    wx.request({
      url: url,
      method: "POST",
      header: {
        'content-type': 'application/x-www-form-urlencoded; charset=UTF-8'
      },
      data: e.detail.value,
      dataType: "json",
      success: function (res) {
        console.log(res.data)
        if (res.data.code > 0) {
          var courseUrl = app.globalData.baseUrl + '/course/textbook/' + that.data.courseid + "/" + e.detail.value.isbn
          utils.get(courseUrl, function (res) {
            if (res.code > 0) {
              wx.showToast({
                title: res.message,
              })
            }
          });
        }
      }
    })
  },

  scan: function () {
    var that = this;
    wx.scanCode({
      success: function (res) {
        var url = "http://49.234.70.238:9001/book/worm/isbn?isbn=" + res.result
        console.log(url)
        wx.request({
          url: url,
          method: 'GET',
          header: {
            "Content-Type": "json",
          },
          success: function (res) {
            that.setData({
              textbook: res.data.data[0]
            })
          }
        })
      }
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      courseid: options.courseid,
      caption: options.caption
    })

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