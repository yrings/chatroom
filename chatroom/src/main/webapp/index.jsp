<%--
  Created by IntelliJ IDEA.
  User: 13218
  Date: 2022/10/6
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>聊天室</title>
    <style>
        #content {
            width: 500px;
            background-color: darkgray;
        }
        #input {
            border-radius: 4px;
            width: 500px;
        }
    </style>
    <script src="webjars/jquery/3.5.1/jquery.min.js"></script>

    <script>
       $(function (){
           $.ajax({
               type:"get",
               url:"${pageContext.request.contextPath}/showNewContentServlet",
               dataType: "json",
               success: function(data) {
                   var content = $("#content");
                   for(var i in data) {
                       //i --> 索引
                       //data[i] --> json对象
                       //data[i].属性
                       var str = "";
                       str += '<div>' + data[i].up_time + '<br/>' + data[i].content + '</br></div>';
                       content.prepend(str);
                   }
               },
                error:function (XMLHttpRequest,textStatus,errorThrown) {
                   console.log(XMLHttpRequest.status);
                   console.log(XMLHttpRequest.readyState);
                   console.log(XMLHttpRequest.readyState);
                   console.log(textStatus);
                }
           })
           $("form").submit(function () {
               if($("#input").val()) {
                   return true;
               } else {
                   alert("内容不能为空");
                   return  false;
               }
           })
       })

    </script>
</head>
<body>
<div>
    <h1 style="color: black;font-weight: bold;text-align: center;background: darkgray">简易聊天室</h1>
</div>
<div>只显示最新10条记录</div>
<div id = "content" >
</div>
<form action="${pageContext.request.contextPath}/AddNewContentServlet" method="get">
    <div>
        <input type="text" id ="input" name="input" placeholder="请输入~" autofocus="autofocus" />
        <input type="submit" value="发送" id="send" /><br/>
        <a href="history.jsp">聊天记录</a>
    </div>
</form>
</body>
</html>



