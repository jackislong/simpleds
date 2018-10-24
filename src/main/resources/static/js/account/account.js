/**
 * Created by Administrator on 2018-10-22.
 */

$(function () {


    $("#sub").bind("click",function () {
        checkdata();
    })
    
    $("#province").bind("change",function () {
        if(!StringUtils.isBlank($("#province").val())){
            $("#city").empty();
            var par= "province="+$("#province").val();
            var  html = "";
            $.ajax({
                type: "POST",
                url: "/account/selectcity",
                data: par,
                success: function(result){
                    $.each(result,function (i,item) {
                        html += "<option value="+item.CITYNO+">"+item.CITYNAME+"</option>";
                    })
                    $("#city").append(html);
                }
            });
        }else{
            //清空城市列表
            $("#city").empty();
        }
    })


    $("#custname").bind("blur",function () {
        if(StringUtils.isBlank($("#custname").val())){
            toastr.error('请输入客户姓名','提示');
        }
    })

    $("#eff").bind("click",function () {
        var  checked=$("#eff").prop('checked');
        if(checked){
            $("#limit").hide()
        }else{
            $("#limit").show()
        }
    })

    $("#certno").bind("blur",function () {
        if(StringUtils.isBlank($("#certno").val())){
            toastr.error('请输入证件号码','提示');
        }else {
            if($("#certtype").val()==0 && !simpleUtil.isCertNo($("#certno").val())){
                toastr.error('证件号码有误,请核对','提示');
            }
        }
    })

    $("#certno_a").bind("blur",function () {
        if(StringUtils.isBlank($("#certno_a").val())){
            toastr.error('请输入证件号码','提示');
        }else {
            if(($("#certno_a").val()!=$("#certno").val())){
                toastr.error('两次证件号码不想等,请核对','提示');
            }
        }
    })

    $("#phone").bind("blur",function () {
        if(StringUtils.isBlank($("#phone").val())){
            toastr.error('请输入手机号码','提示');
        }else{
            if(!StringUtils.isPhoneNo($("#phone").val())){
                toastr.error('手机号码格式有误，请核对','提示');
            }
        }
    })

    $("#email").bind("blur",function () {
        if(StringUtils.isNotBlank($("#email").val()) && !StringUtils.isEmail($("#email").val())){
            toastr.error('电子邮件格式有误，请核对','提示');
        }
    })

    $("#fax").bind("blur",function () {
        if(StringUtils.isNotBlank($("#fax").val()) && !StringUtils.isFax($("#fax").val())){
            toastr.error('传真格式有误，请核对','提示');
        }
    })

    $("#postcode").bind("blur",function () {
        if(StringUtils.isNotBlank($("#postcode").val()) && !StringUtils.isZipNo($("#postcode").val())){
            toastr.error('邮政编码格式有误，请核对','提示');
        }
    })
})

/**
 * 提交前数据额的检查
 */
function checkdata() {
    var  trusttype = $("#trusttype").val();
    if($.StringBank(trusttype)){
        $("#trusttype").focus();
        toastr.error('请选着委托方式','提示');
        return false;
    }
    var  requesttime = $("#requesttime").val();
    if($.StringBank(requesttime)){
        toastr.error('请输入申请时间','提示');
        $("#requesttime").focus();
        return false;
    }
    var  custname = $("#custname").val();
    if($.StringBank(custname)){
        toastr.error('请输入客户姓名','提示');
        $("#custname").focus();
        return false;
    }
    var  sex = $("#sex").val();
    if($.StringBank(sex)){
        toastr.error('请选着性别','提示');
        $("#sex").focus();
        return false;
    }
    var  certtype = $("#certtype").val();
    if($.StringBank(certtype)){
        toastr.error('请选着证件类型','提示');
        $("#certtype").focus();
        return false;
    }
    var  certno = $("#certno").val();
    if($.StringBank(certno)){
        toastr.error('请输入证件号码','提示');
        $("#certno").focus();
        return false;
    }
    var  certno_a = $("#certno_a").val();
    if($.StringBank(certno_a)){
        toastr.error('请输再次入证件号码','提示');
        $("#certno_a").focus();
        return false;
    }
    if(certno!=certno_a){
        toastr.error('两次的证件号码不匹配!请核对','提示');
        return false;
    }
    var  timelimit = $("#timelimit").val();
    var  eff = $("#eff").prop('checked');
    /*<![CDATA[*/
    if($.StringBank(timelimit) && eff == false){
        toastr.error('请输入证件有效期或选中长期有效按钮','提示');
        return false;
    }
    /*]]>*/
    var  birthday = $("#birthday").val();
    if($.StringBank(birthday)){
        $("#birthday").focus();
        toastr.error('请输入您的生日','提示');
        return false;
    }
    var  phone = $("#phone").val();
    if($.StringBank(phone)){
        $("#phone").focus();
        toastr.error('请输入电话号码','提示');
        return false;
    }
    var  moblieno = $("#moblieno").val();
    var  email = $("#email").val();
    var  fax = $("#fax").val();
    var  address = $("#address").val();
    if($.StringBank(address)){
        $("#address").focus();
        toastr.error('请输入通讯地址','提示');
        return false;
    }
    var  postcode = $("#postcode").val();
    if($.StringBank(postcode)){
        $("#postcode").focus();
        toastr.error('请输入邮政编码','提示');
        return false;
    }
    var  billtype = $("#billtype").val();
    var  billway = $("#billway").val();
    var  bankname = $("#bankname").val();
    if($.StringBank(bankname)){
        $("#bankname").focus();
        toastr.error('请选着银行名称','提示');
        return false;
    }
    var  province = $("#province").val();
    if($.StringBank(province)){
        $("#province").focus();
        toastr.error('请输入开户行省份','提示');
        return false;
    }
    var  nameinbank = $("#nameinbank").val();
    if($.StringBank(nameinbank)){
        $("#nameinbank").focus();
        toastr.error('请输入银行户名','提示');
        return false;
    }
    var  bankaccount = $("#bankaccount").val();
    if($.StringBank(bankaccount)){
        $("#bankaccount").focus();
        toastr.error('请输入银行账号','提示');
        return false;
    }
    var  szacco = $("#szacco").val();
    if(StringUtils.isNotBlank(szacco) && StringUtils.isAcco(szacco)){
        $("#szacco").focus();
        toastr.error('账号格式输入有误,清核对','提示');
        return false;
    }
    var  shacco = $("#shacco").val();
    if(StringUtils.isNotBlank(shacco) && StringUtils.isAcco(shacco)){
        $("#shacco").focus();
        toastr.error('账号格式输入有误,清核对','提示');
        return false;
    }
    var  trade = $("#trade").val();
    if($.StringBank(trade)){
        $("#trade").focus();
        toastr.error('请选着行业','提示');
        return false;
    }
    var  vocation = $("#vocation").val();
    if($.StringBank(vocation)){
        $("#vocation").focus();
        toastr.error('请选着职业','提示');
        return false;
    }
    var  income = $("#income").val();
    if(StringUtils.isNotBlank(income) && !StringUtils.isAllNumber(income)){
        $("#income").focus();
        toastr.error('请输入数字','提示');
        return false;
    }

    var  marry = $("#marry").val();
    var  context = $("#context").val();
    var  password = $("#password").val();
    if($.StringBank(password)){
        $("#password").focus();
        toastr.error('请输入密码','提示');
        return false;
    }
    var  password_a = $("#password_a").val();
    if($.StringBank(password_a)){
        $("#password_a").focus();
        toastr.error('请再次输入密码','提示');
        return false;
    }
    if(password!=password_a){
        toastr.error('两次密码不一致，请核对！','提示');
        return false;
    }

    $("#sub").prop("disabled",true);
    $.ajax({
        type: "POST",
        url: "/account/openaccount",
        data: getData(),
        datatype:"json",
        async:false,
        success: function(result){
            if(result.success){
                toastr.info('基金账户：'+result.fundacco+"\n"+'交易账户：'+result.tradeacco+"\n",'提示');
                //重置表单
                $("#accountfrom")[0].reset();
            }else{
                toastr.error('错误信息：'+result.msg,'提示');
            }

        }
    });
    $("#sub").prop("disabled",false);
}
/**
 * 获取数据
 * */
function getData() {
    return{
        trusttype:$("#trusttype").val(),
        requesttime:$("#requesttime").val(),
        custname:$("#custname").val(),
        gender:$("#sex").val(),
        identitype:$("#certtype").val(),
        identityno:$("#certno").val(),
        timelimit:$("#timelimit").val(),
        eff:$("#eff").prop("checked"),
        birthday:$("#birthday").val(),
        phone:$("#phone").val(),
        moblieno:$("#moblieno").val(),
        email:$("#email").val(),
        faxno:$("#fax").val(),
        address:$("#address").val(),
        zipno:$("#postcode").val(),
        billpath:$("#billtype").val(),
        billway:$("#billway").val(),
        bankno:$("#bankname").val(),
        province:$("#province").val(),
        city:$("#city").val(),
        bank:$("#bank").val(),
        nameinbank:$("#nameinbank").val(),
        bankaccount:$("#bankaccount").val(),
        tacode:$("#tacode").val(),
        szacco:$("#szacco").val(),
        shacco:$("#shacco").val(),
        tradetype:$("#trade").val(),
        vocation:$("#vocation").val(),
        income:$("#income").val(),
        marry:$("#marry").val(),
        context:$("#context").val(),
        password:$("#password").val()
    }
}


