<%--
  Created by IntelliJ IDEA.
  User: 86139
  Date: 2021/4/19
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登录页面</title>
    <link rel="stylesheet" href="layui/css/layui.css" media="all">
    <script src="layui/layui.all.js"></script>
    <style type="text/css">
      #main{
        width: 580px;
        margin: auto;
        padding-top: 40px;
        border: solid 0px red;
        font-family: 宋体;
        font-weight: bold;
      }
      #main .layui-input-inline{
        width: 400px;
      }
      #code{
        text-align: center;
      }
    </style>
    <script>
        window.onload = function () {
            document.getElementById("change").onclick = function () {
                // alert(1);
                document.getElementById("img1").src= "${pageContext.request.contextPath}/checkcode?r="+Math.random();
            }
        }
    </script>
  </head>
  <body>
  <div id="main">
    <h1 align="center">登录</h1>
    <form class="layui-form" action="${pageContext.request.contextPath }/login" method="post">
      <div class="layui-form-item">
        <label class="layui-form-label">用户名称：</label>
        <div class="layui-input-inline">
          <input type="text" name="username" required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">用户密码：</label>
        <div class="layui-input-inline">
          <input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">验证码：</label>
        <div class="layui-input-inline">
          <input type="text" name="validateCode" required  lay-verify="required" placeholder="请输入验证码" autocomplete="off" class="layui-input">
        </div>
        <div id="code">
          <img src="${pageContext.request.contextPath }/checkcode" alt="" id="img1">
          <a id="change">验证码不清楚？换一张</a>
        </div>
      </div>
      <div class="layui-form-item">
        <div class="layui-input-block">
          <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
          <button type="reset" class="layui-btn layui-btn-primary">重置</button>
          <span style="color: red">${errorMeg }</span>
        </div>
      </div>
    </form>
  </div>
  </body>
</html>
