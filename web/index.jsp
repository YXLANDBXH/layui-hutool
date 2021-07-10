<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="layui/css/layui.css" media="all">
</head>
<body>
<table id="demo" lay-filter="test"></table>
<script src="layui/layui.all.js"></script>
<script>
    layui.use('table', function(){
        var table = layui.table;
        //第一个实例
        table.render({
            elem: '#demo'
            ,height: 410
            ,url: '${pageContext.request.contextPath}/product' //数据接口
            ,page: true   //开启分页
            ,cols: [[     //表头
                {field: 'pid', title: '商品ID', width:100, sort:true, fixed: 'left'}
                ,{field: 'pname', title: '商品名称', width:180}
                ,{field: 'marketPrice', title: '超市价格', width:80}
                ,{field: 'shopPrice', title: '线上价格', width:80}
                ,{field: 'pimage', title: '商品图片', width: 180}
                ,{field: 'pdate', title: '生产日期', width: 110}
                ,{field: 'isHot', title: '热款', width: 50}
                ,{field: 'pdesc', title: '商品详情', width: 200}
                ,{field: 'pflag', title: '商品标记', width: 50}
                ,{field: 'cid', title: '商品类型', width: 50}
            ]]
        });
    });
</script>
</body>
</html>
