
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
		isCertNo:function (str) {
		
			return str.match(/^[1-9][0-9]{5}(19|20)[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|31)|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}([0-9]|x|X)$/);
		},
		IsPhone:function (phone) {
			 var mobilePattern = /^1[3|4|5|6|7|8|9][0-9]{9}$/;
			 return mobilePattern.exec(phone);
		}
	}
	//这里确定了插件的名称
	this.simpleUtil = _plugin_api;
})();

var commonFn={};

commonFn.setAjaxPaginator = function (paginatorSelector, data, option) {
	var totals = data.count;//总条数
	var pageSize = option.pageSize; //每页条数
	var totalPages = 1;
	if (totals != 0) {
		if (totals % pageSize == 0) {
			totalPages = totals / pageSize;
		} else {
			totalPages = Math.ceil(totals / pageSize);
		}
	}
	if (totalPages > 1) {
		//当总页数大于1时生成显示分页否则不显示分页
		commonFn.buildAjaxPaginator(paginatorSelector, $.extend(option, {totalPages: totalPages}))
	}
}

commonFn.buildAjaxPaginator = function (paginatorSelector, option) {
	var _option = {
		currentPage: 1, //当前页
		totalPages: 1, //总页数
		numberOfPages: 5, //设置控件显示的页码数
		bootstrapMajorVersion: 3,//如果是bootstrap3版本需要加此标识，并且设置包含分页内容的DOM元素为UL,如果是bootstrap2版本，则DOM包含元素是DIV
		useBootstrapTooltip: false,//是否显示tip提示框
		itemTexts: function (type, page, current) {//文字翻译
			switch (type) {
				case "first":
					return "首页";
				case "prev":
					return "上一页";
				case "next":
					return "下一页";
				case "last":
					return "尾页";
				case "page":
					return page;
			}
		},
		onPageClicked: function (event, originalEvent, type, page, pageSize) {
		}
	};
	$.extend(_option, option);
	paginatorSelector.bootstrapPaginator(_option);
}