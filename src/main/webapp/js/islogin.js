$(function () {
  islogin();

})

function islogin() {
    $("#LeftNav").empty();
    let  uname =  sessionStorage.getItem("uname")
    let login = `<a href="register.html">注册</a>/<a href="login.html">登录</a><a href="#">QQ客服</a><a href="#">微信客服</a><a href="#">手机客户端</a>`;
    if(uname!=null){
        login = `欢迎您<span>${uname}</span></a>/<a href="javascript:destroy();">退出登录</a><a href="#">QQ客服</a><a href="#">微信客服</a><a href="#">手机客户端</a>\`;`
    }
    $("#LeftNav").append(login);
}
function destroy() {
   $.ajax({
       url:'LoadServlet',
        data:{method:'destroy'},
        success:function () {
            sessionStorage.clear();
   layer.msg("退出登录成功",{icon:1,time:1000})
   let login = `<a href="register.html">注册</a>/<a href="login.html">登录</a><a href="#">QQ客服</a><a href="#">微信客服</a><a href="#">手机客户端</a>`;
   $("#LeftNav").empty();

   $("#LeftNav").append(login);
        }
   })


}