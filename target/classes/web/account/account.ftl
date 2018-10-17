<!DOCTYPE html>
<html lang="en" class="loginHtml">
<#include '../include/header.ftl'/>
<body class="childrenBody">
<#include '../include/nav.ftl'/>
<div  style="margin-left:200px;">
    <form class="layui-form layui-row" action="">
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
            <legend>录单信息</legend>
        </fieldset>
        <div class="layui-form-item">
            <label class="layui-form-label">委托方式</label>
            <div class="layui-input-inline">
                <select name="trusttye" id="trusttye">
                    <option value="0">柜台委托</option>
                    <option value="1" selected="">传真委托</option>
                </select>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">申请时间</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" id="requestdate" placeholder="yyyy-MM-dd HH:mm:ss">
                </div>
            </div>
        </div>

        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
            <legend>用户信息</legend>
        </fieldset>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">客户姓名</label>
                <div class="layui-input-inline">
                    <input type="text" name="custname" lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">客户性别</label>
                <div class="layui-inline">
                    <select name="sex" id="sex">
                        <option value="0">男</option>
                        <option value="1" selected="">女</option>
                    </select>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">证件类型</label>
                <div class="layui-input-inline">
                    <input type="text" name="certtype" id="certtype" lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">证件号码</label>
                <div class="layui-input-inline">
                    <input type="text" name="certno" id="certno" lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">再次输入</label>
                <div class="layui-input-inline">
                    <input type="text" name="certno_a" id="certno_a" lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>


        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">有效期</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" id="timelimit" placeholder="yyyy-MM-dd">
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label">长期有效</label>
                <div class="layui-input-inline">
                    <input type="checkbox" checked="" name="efftective"  id="efftective" lay-skin="switch" lay-filter="switchTest" lay-text="ON|OFF">
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">生日</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" name="birthday" id="birthday" placeholder="yyyy-MM-dd">
                </div>
            </div>
         </div>

        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
            <legend>联系方式</legend>
        </fieldset>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">手机号码</label>
                <div class="layui-input-inline">
                    <input type="text" name="phone" id="phone" lay-verify="required|phone" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">联系电话</label>
                <div class="layui-input-inline">
                    <input type="text" name="certno_a" id="certno_a" lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">手机号码</label>
                <div class="layui-input-inline">
                    <input type="text" name="phone" id="phone" lay-verify="required|phone" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">联系电话</label>
                <div class="layui-input-inline">
                    <input type="text" name="mobileno" id="mobileno" lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">通讯地址</label>
                <div class="layui-input-inline">
                    <input type="text" name="address" id="address" lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">邮政编码</label>
                <div class="layui-input-inline">
                    <input type="text" name="postcode" id="postcode" lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">对账单邮寄方式</label>
            <div class="layui-input-inline">
                <select name="billtype" id="billtype">
                    <option value="">请选择</option>
                </select>
            </div>
            <label class="layui-form-label">对账单邮寄途径</label>
            <div class="layui-input-inline">
                <select name="billway" id="billway">
                    <option value="">请选择</option>
                </select>
            </div>
        </div>

        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
            <legend>账户信息</legend>
        </fieldset>


        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">资金方式</label>
                <div class="layui-input-inline">
                    <input type="text" name="capital" id="capital" lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>
            <label class="layui-form-label">银行名称</label>
            <div class="layui-input-inline">
                <select name="bank" id="bank">
                    <option value="">请选择</option>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">开户行省份</label>
            <div class="layui-input-inline">
                <select name="quiz1">
                    <option value="">请选择省</option>
                    <option value="浙江" selected="">浙江省</option>
                    <option value="你的工号">江西省</option>
                    <option value="你最喜欢的老师">福建省</option>
                </select>
            </div>
            <div class="layui-input-inline">
                <select name="quiz2">
                    <option value="">请选择市</option>
                    <option value="杭州">杭州</option>
                    <option value="宁波" disabled="">宁波</option>
                    <option value="温州">温州</option>
                    <option value="温州">台州</option>
                    <option value="温州">绍兴</option>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">开户银行</label>
                <div class="layui-input-inline">
                    <input type="text" name="bankname" id="bankname" lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">银行户名</label>
                <div class="layui-input-inline">
                    <input type="text" name="nameinbank" id="nameinbank" lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">银行账号</label>
                <div class="layui-input-inline">
                    <input type="text" name="accountbank" id="accountbank" lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>


        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
            <legend>其他信息</legend>
        </fieldset>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">TA</label>
                <div class="layui-input-inline">
                    <input type="text" name="tacode" id="tacode" lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">深交所账号</label>
                <div class="layui-input-inline">
                    <input type="text" name="szacco" id="szacco" lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">沪交所账号</label>
                <div class="layui-input-inline">
                    <input type="text" name="shacco" id="shacco" lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">行业类型</label>
            <div class="layui-input-inline">
                <select name="industry ">
                    <option value="">请选择</option>
                </select>
            </div>
            <label class="layui-form-label">职业</label>
            <div class="layui-input-inline">
                <select name="profession">
                    <option value="">请选择</option>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">年收入</label>
            <div class="layui-input-inline">
                <select name="income">
                    <option value="">请选择</option>
                </select>
            </div>
            <label class="layui-form-label">婚姻</label>
            <div class="layui-input-inline">
                <select name="marray">
                    <option value="">请选择</option>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">备注</label>
                <div class="layui-input-inline">
                    <input type="text" name="context" id="context" lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">交易密码</label>
                <div class="layui-input-inline">
                    <input type="text" name="password" id="password" lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">再次输入</label>
                <div class="layui-input-inline">
                    <input type="text" name="password_a" id="password_a" lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
<script>
    layui.use(['form', 'layedit', 'laydate'], function(){
        var form = layui.form
                ,layer = layui.layer
                ,layedit = layui.layedit
                ,laydate = layui.laydate;

        //日期
        laydate.render({
            elem: '#date'
        });
        laydate.render({
            elem: '#requestdate'
        });

//        //创建一个编辑器
//        var editIndex = layedit.build('LAY_demo_editor');
//
//        //自定义验证规则
//        form.verify({
//            title: function(value){
//                if(value.length < 5){
//                    return '标题至少得5个字符啊';
//                }
//            }
//            ,pass: [/(.+){6,12}$/, '密码必须6到12位']
//            ,content: function(value){
//                layedit.sync(editIndex);
//            }
//        });
//
//        //监听指定开关
//        form.on('switch(switchTest)', function(data){
//            layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
//                offset: '6px'
//            });
//            layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
//        });
//
//        //监听提交
//        form.on('submit(demo1)', function(data){
//            layer.alert(JSON.stringify(data.field), {
//                title: '最终的提交信息'
//            })
//            return false;
//        });
//
//        //表单初始赋值
//        form.val('example', {
//            "username": "贤心" // "name": "value"
//            ,"password": "123456"
//            ,"interest": 1
//            ,"like[write]": true //复选框选中状态
//            ,"close": true //开关状态
//            ,"sex": "女"
//            ,"desc": "我爱 layui"
//        })


    });
</script>

</body>
</html>