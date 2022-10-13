<%--
  Created by IntelliJ IDEA.
  User: 13218
  Date: 2022/10/9
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>回收站</title>
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
        $(function() {
            $.ajax({
                type:"get",
                url:"${pageContext.request.contextPath}/showAllLogicServlet",
                dataType:"json",
                success:function (data) {
                    var content = $("#content");
                    var str ="";
                    for(i in data) {
                        str += '<div id="' + data[i].id + '">' + data[i].up_time +'<br/>' +
                            data[i].content + '<input type="button" value="恢复" onclick="recover('+ data[i].id + ')"/></div>'
                    }
                        content.append(str);
                },
                error:function () {
                    alert('error');
                }
            })
        })
        function recover(id) {
            var note = document.getElementById(id);
            note.remove();
            $.ajax({
                type: "get",
                url: "${pageContext.request.contextPath}/recoverContentServlet",
                data:{"id":id}
            })
        }
    </script>
</head>
<body>
<div>
    <h1 style="color: black;font-weight: bold;text-align: center;background: darkgray">回收站</h1>
</div>
<div id="content"></div>
</body>
</html>
