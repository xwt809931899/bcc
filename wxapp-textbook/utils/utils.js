function get(url, callback) {
  var sessionid = wx.getStorageSync("sessionid");
  wx.request({
    url: url,
    method: 'GET',
    header: {
      "Content-Type": "json",
      'Cookie': sessionid
    },
    success: function (res) {
      callback(res.data);
    },
    fail: function (err) {
      console.log(err);
      wx.showToast({
        title: '请检查网络设置',
        icon: 'none',
        duration: 3000
      });
    },
    complete: function () {
      // wx.hideLoading();
    }
  })
}
function post(url, data,callback) {
  var sessionid = wx.getStorageSync("sessionid");
  wx.request({
    url: url,
    method: 'POST',
    data:data,
    header: {
      "Content-Type": 'application/x-www-form-urlencoded; charset=UTF-8',
      'Cookie': sessionid
    },
    success: function (res) {
      callback(res.data);
    },
    fail: function (err) {
      console.log(err);
      wx.showToast({
        title: '数据提交失败！请重试',
        icon: 'none',
        duration: 3000
      });
    },
    complete: function () {
      // wx.hideLoading();
    }
  })
}
function formatNumber(n) {
  n = n.toString()
  return n[1] ? n : '0' + n
}
// 格式化当前系统days天后的日期,days从0开始取值
function formatDate(days) {
  var date = new Date();
  date.setDate(date.getDate() + days);
  var year = date.getFullYear();
  var month = date.getMonth() + 1;
  var day = date.getDate();
  return [year, month, day].map(formatNumber).join('-');
}
//跳往登录界面
function login(flag,url){
  if (flag) {
    wx.reLaunch({
      url: url,
    })
  }
}
function isEmpty(obj) {
  // 检验 undefined 和 null
  if (JSON.stringify(obj) == "{}" || obj == ''){
    return true;
  }else{
    return false;
  }
}
module.exports = {
  get: get,
  formatDate: formatDate,
  isEmpty:isEmpty,
  login:login,
  post:post
}
