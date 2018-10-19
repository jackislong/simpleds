
$.extend({
	StringBank:function(str){
		return str==undefined || str ==null ||$.trim(str).length==0;
	}
});

var StringUtils={};
StringUtils.isNull = function( s )
{
	return s == undefined || s == null;
};
StringUtils.isNotNull = function( s )
{
	return !StringUtils.isNull(s);
};
StringUtils.isBlank = function( s )
{
	return StringUtils.isNull(s) || $.trim(s).length == 0;
};
StringUtils.isNotBlank = function( s )
{
	return !StringUtils.isBlank(s);
};
StringUtils.isEmail = function( s )
{
	return s.match(/^\w+([-+.]\w+)*@\w+([-.]\\w+)*\.\w+([-.]\w+)*$/);
};
StringUtils.isAcco = function (s) {
	return s.match(/^[0-9]{6,10}$/);
}
StringUtils.isMoblieNo = function (s) {
	s.match(/^0[0-9]{2}-[0-9]{8}$/);
}
StringUtils.isAllNumber = function( s )
{
	return s.match(/^\d*$/)!=null;
};
StringUtils.isZipNo = function( s )
{
	return StringUtils.isAllNumber(s) && (""+s).length == 6;
};

StringUtils.isFax = function (s) {
	return s.match(/^[0-9]{6,20}$/);
}
StringUtils.isPhoneNo = function( s )
{
	var reg = /^1[3|4|5|6|7|8|9][0-9]{9}$/;
	return reg.exec(s);
};
StringUtils.lengthInByte = function(str)
{
	return (str||"").replace(/[^\x00-\xff]/gm, "**").length;
};
StringUtils.replaceAll = function(str,s1,s2){
	return str.replace(new RegExp(s1,"gm"),s2);
};

(function(){
	//定义一些api
	var _plugin_api = {
		StringBank:function(str){
		   return str==''||str.toString().length==0;
	    },
		IsEmail:function (email) {

		},
		IsNumber:function (num) {

		},
		IsPhone:function (phone) {
			 var mobilePattern = /^1[3|4|5|6|7|8|9][0-9]{9}$/;
			 return mobilePattern.exec(phone);
		}
	}
	//这里确定了插件的名称
	this.simpleUtil = _plugin_api;
})();