<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<%@ include file="../includes/header.jsp" %>

    <div class="row">
        <div clas="col-lg-12">
            <h1 class="page-header">Board Register</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->

    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">

                <div class="panel-heading">Board Read Page</div>
                <!-- /.panel-heading -->
                <div class="panel-body">

                    <form role="form" action="/board/modify" method="post">

                        <!-- 추가 -->
                        <input type="hidden" name="pageNum" value='<c:out value="${cri.pageNum}" />'>
                        <input type="hidden" name="amount" value='<c:out value="${cri.amount}" />'>
                        <input type="hidden" name="type" value='<c:out value="${cri.type}" />'>
                        <input type="hidden" name="keyword" value='<c:out value="${cri.keyword}" />'>

                        <div class="form-group">
                            <label>Bno</label> <input class="form-control" name="bno" value='<c:out value="${board.bno}" />' readonly="readonly">
                        </div>

                        <div class="form-group">
                            <label>Title</label> <input class="form-control" name="title" value='<c:out value="${board.title}" />'>
                        </div>

                        <div class="form-group">
                            <label>Text area</label>
                            <textarea class="form-control" rows="3" name="content"><c:out value="${board.content}" /></textarea>
                        </div>

                        <div class="form-group">
                            <label>Writer</label> <input class="form-control" name="writer" value='<c:out value="${board.writer}" />' readonly="readonly">
                        </div>

                        <div class="form-group">
                            <label>RegDate</label> <input class="form-control" name="regDate" value='<fmt:formatDate value="${board.regdate}" pattern="yyyy/MM/dd" />' readonly="readonly">
                        </div>

                        <div class="form-group">
                            <label>Update Date</label> <input class="form-control" name="updateDate" value='<fmt:formatDate value="${board.updatedate}" pattern="yyyy/MM/dd" />' readonly="readonly">
                        </div>

                        <button type="submit" data-oper="modify" class="btn btn-default">Modify</button>
                        <button type="submit" data-oper="remove" class="btn btn-danger">Remove</button>
                        <button type="submit" data-oper="list" class="btn btn-info">List</button>

                    </form>

                </div>
                <!-- end panel-body -->

            </div>
            <!-- end panel-body -->
        </div>
        <!-- end panel -->
    </div>
    <!-- /.row -->

    <script type="text/javascript">
        $(document).ready(function() {
            var formObj = $("form");

            $("button").on("click", function(e) {
                e.preventDefault();

                var operation = $(this).data("oper");

                console.log(operation);

                if(operation === "remove") {
                    formObj.attr("action", "/board/remove");
                } else if(operation === "list") {
                    // move to list
                    formObj.attr("action", "/board/list").attr("method", "get");

                    var pageNumTag = $("input[name='pageNum']").clone();
                    var amountTag = $("input[name='amount']").clone();
                    var typeTag = $("input[name='type']").clone();
                    var keywordTag = $("input[name='keyword']").clone();

                    formObj.empty();
                    formObj.append(pageNumTag);
                    formObj.append(amountTag);
                    formObj.append(typeTag);
                    formObj.append(keywordTag);
                }

                formObj.submit();
            });
        });
    </script>

<%@ include file="../includes/footer.jsp" %>