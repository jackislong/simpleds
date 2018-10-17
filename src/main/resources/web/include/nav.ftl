<div class="layui-layout layui-layout-admin">
    <div class="layui-header header header-demo" autumn>
        <div class="layui-main">
        </div>
    </div>
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <ul class="layui-nav layui-nav-tree site-demo-nav">
                <@simpleTag method="resourcelist" key="${user.id}"/>
                <#if resourcelist?? && resourcelist?size gt 0>
                    <#list resourcelist as res>
                        <#if res.parentId = 0>
                            <li class="layui-nav-item layui-nav-itemed">
                                <a href="javascript:;">${res.name}</a>
                                <dl class="layui-nav-child">
                                    <#list resourcelist as chres>
                                        <#if chres.parentId = res.id>
                                            <dd><a href="${base}${chres.url}">${chres.name}</a></dd>
                                        </#if>
                                    </#list>
                                </dl>
                            </li>
                        </#if>
                    </#list>
                </#if>
                <li class="layui-nav-item" style="height: 30px; text-align: center"></li>
            </ul>
        </div>
    </div>
</div>
<script type="text/javascript">
    layui.use('element', function(){
        var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块

        //监听导航点击
        element.on('nav(simple-nav)', function(elem){
//            console.log(elem)
        });
    });
</script>