<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.6.0.js"></script>
    <script>
        $(function () {
            $("#btn").click(function (){
                /*简写方式*/
                $.post("${pageContext.request.contextPath}/a2",function (data) {
                    // console.log(data);
                    var html;
                    for (let i = 0; i < data.length; i++) {
                        html += "<tr>" +
                            "<td>" + data[i].name + "</td>" +
                            "<td>" + data[i].age + "</td>" +
                            "<td>" + data[i].sex + "</td>" +
                            "</tr>"
                    }
                    /*jquery取标签元素，并插入html标签*/
                    $("#contend").html(html);
                })
            })
        });



    </script>
</head>
<body>
<input type="button" value="加载数据" id="btn">
<table>
    <tr>
        <td>姓名</td>
        <td>年龄</td>
        <td>性别</td>
    </tr>
    <tbody class="container" id="contend">

    </tbody>
</table>

</body>
</html>
