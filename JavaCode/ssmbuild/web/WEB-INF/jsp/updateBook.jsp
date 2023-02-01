<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改书籍</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/book/updateBook" method="post">

        <div class="form-group">
            <input type="hidden" name="bookID" class="form-control" value="${book.bookID}">
        </div>

        <div class="form-group">
            <label for="bookName">书籍名称：</label>
            <input type="text" name="bookName" class="form-control" id="bookName" value="${book.bookName}" placeholder="书籍名称">
        </div>
        <div class="form-group">
            <label for="bookCounts">书籍数量：</label>
            <input type="text" name="bookCounts" class="form-control" id="bookCounts" value="${book.bookCounts}" placeholder="书籍数量">
        </div>
        <div class="form-group">
            <label for="detail">书籍详情：</label>
            <input type="text" name="detail" class="form-control" id="detail" value="${book.detail}" placeholder="书籍详情">
        </div>

        <div class="form-group">
            <input type="submit" class="form-control" value="保存">
        </div>


    </form>
</div>

</body>
</html>
