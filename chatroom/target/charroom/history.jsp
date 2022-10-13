<%--
  Created by IntelliJ IDEA.
  User: 13218
  Date: 2022/10/9
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>聊天记录</title>
    <style>
        #content {
            width: 500px;
            background-color: darkgray;
        }
        input {
            float: right;
        }
    </style>
    <script src="webjars/jquery/3.5.1/jquery.min.js"></script>
    <script>
        $(function () {

            $.ajax({
                type:"get",
                url:"${pageContext.request.contextPath}/ShowAllContentServlet",
                dataType:"json",
                success:function (data) {
                    var content = $("#content");
                    var str = "";
                    for(var i in data) {
                        //i --> 索引
                        //data[i] --> json对象
                        //data[i].属性
                        str += '<div id="' + data[i].id + '">' + data[i].up_time + '<br/>' +
                            data[i].content + '<input  type="button" value="彻底删除" onclick="del('+data[i].id+')"/>'+
                            '<input type="button" value="逻辑删除" onclick="dele('+ data[i].id +')" /></div>'
                    }
                    content.append(str);

                },
                error: function () {
                    alert("error");
                }

            })


        })
        function del(id) {
            var status =confirm("你确定要彻底删除这条记录吗？")
            if(status == true) {
                var note = document.getElementById(id);
                note.remove();
                $.ajax({
                    type:"get",
                    url:"${pageContext.request.contextPath}/deleteContentServlet",
                    data: {"id":id}
                })
            }
        }
        function dele(id) {
            var note = document.getElementById(id);
            note.remove();
            $.ajax({
                type:"get",
                url:"${pageContext.request.contextPath}/logicDeleteServlet",
                data: {"id":id}
            })
        }
    </script>
</head>
<body>
<div>
    <h1 style="color: black;font-weight: bold;text-align: center;background: darkgray">聊天记录</h1>
</div>

<div id="content">
</div>
<a href="recyclebin.jsp">回收站</a>
</body>
</html>
