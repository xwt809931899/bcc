//index.js
//获取应用实例
const app = getApp()
var utils = require("../../utils/utils.js");
Page({
  data: {
    index:0,
    term:[],
    courses:[]
  },
 
  bindPickerChange: function (e) {
    var that = this;
    var term = this.data.term[e.detail.value];
    var url = app.globalData.baseUrl + '/course/list/' + term;
    this.setData({
      index: e.detail.value
    })
    utils.get(url, function (res) {
      that.setData({
        courses: res
      })
    });
  },

  insertTextbook:function(e){
    var courseid = e.currentTarget.dataset.courseid
    var caption = e.currentTarget.dataset.caption
    wx.navigateTo({
      url: 'insertTextbook/insertTextbook?courseid=' + courseid + "&caption=" + caption,
    })
  },

  showDetails:function(event){
    var that = this;
    var textbook = event.currentTarget.dataset.textbook;
    console.log(textbook)
    var url = app.globalData.baseUrl + '/textbook/isbn/'+textbook;
    utils.get(url,function(res){
      console.log(res)
      wx.showModal({
        title: '图书详情',
        showCancel:false,
        content: 'isbn:' + res.isbn + '\n'
          + '书名:' + res.title + '\n'
          + '作者:' + res.author + '\n',
      })
    });
  },

  onLoad: function () {
    var that = this;
    var termUrl = app.globalData.baseUrl + '/course/term';
    var courseUrl = app.globalData.baseUrl + '/course/list/';
    wx.showLoading({
      title: '正在获取数据',
    })
    utils.get(termUrl, function (res) {
      that.setData({
        term: res
      },
        function () {
          utils.get(courseUrl + res[0], function (result) {
            that.setData({
              courses: result
            }, function () {
              wx.hideLoading();
            })
          })
        })
    });
  }
})
