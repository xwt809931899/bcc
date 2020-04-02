// pages/index/index.js
var utils = require("../../utils/utils.js");
var app = getApp();
var url = app.globalData.baseUrl + '/teacher/login';
var showUrl = '../index/index';
Page({

  /**
   * 页面的初始数据
   */
  data: {
    role:["教师","学生","仓库管理"],
    index:0,
    roleid:'teacherid'
  },

  bindPickerChange: function (e) {
    var that = this;
    console.log(e);
    //var id = this.data.areas[e.detail.value].id;
    //var url = app.globalData.baseUrl + '/sporttype?area=' + id;
    this.setData({
      index: e.detail.value
    },function(){
      if(that.data.index == 0){
        url = app.globalData.baseUrl + '/teacher/login';
        showUrl = '../index/index';
        that.setData({
          roleid:"teacherid"
        })
      } else if (that.data.index == 1){
        url = app.globalData.baseUrl + '/student/login';
        showUrl = '../student/student';
        that.setData({
          roleid: "stuid"
        })
      }else{
        url = app.globalData.baseUrl + '/warehouseman/login';
        showUrl = '../warehouseman/warehouseman';
        that.setData({
          roleid: "warehousemanid"
        })
      }
    })
  },

  fromSubmit: function (e) {
   // var url = app.globalData.baseUrl + '/teacher/login';
   
    wx.request({
      url:url,
      //url: app.globalData.baseUrl + 'teacher/login',
      method:"POST",
      header: {
        'content-type': 'application/x-www-form-urlencoded; charset=UTF-8'
      },
      data: e.detail.value, 
      dataType:"json",
      success:function(res){
        if(!utils.isEmpty(res.data)){
          wx.setStorageSync("user", res.data);
          wx.setStorageSync("sessionid", "JSESSIONID="+res.data.password);
          wx.redirectTo({
            url: showUrl,
          })
        }else{
          wx.showToast({
            title: '登录失败！请检查用户名或密码是否正确',
            icon: 'none',
            duration: 3000
          });
        }
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
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})