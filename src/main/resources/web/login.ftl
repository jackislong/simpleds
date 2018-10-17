<!DOCTYPE html>
<html lang="en" class="loginHtml">
<#include 'include/header.ftl'/>
<head>
    <meta charset="utf-8">
    <title>登录</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
</head>
<body class="loginBody">
<form class="layui-form" id="login-form" action="${base}/passport/signin" method="post" >
    <div class="login_face"><img src="${base}/static/images/face.jpg" class="userAvatar"></div>
    <div class="layui-form-item input-item">
        <label for="userName">用户名</label>
        <input type="text" placeholder="请输入用户名" autocomplete="off" id="userName" name="userName" class="layui-input" lay-verify="required">
    </div>
    <div class="layui-form-item input-item">
        <label for="password">密码</label>
        <input type="password" placeholder="请输入密码" autocomplete="off" id="password" name="password" class="layui-input" lay-verify="required">
    </div>
    <div class="layui-form-item input-item">
        <font style="color: red">${msg!}</font>
    </div>
    <div class="layui-form-item">
        <button class="layui-btn layui-block" lay-filter="login" lay-submit>登录</button>
    </div>
</form>
<script type="text/javascript" src="${base}/static/js/login.js"></script>
</body>
</html>