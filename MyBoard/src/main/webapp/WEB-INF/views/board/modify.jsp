<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../includes/header.jsp" %>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Board Modify/Delete</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                           Board Read
                        </div>
                        <!-- /.panel-heading -->
                       
                        <div class="panel-body">
	                         <form>
	                        	<div class="form-group">
	                                <label>BNO</label>
	                                <input class="form-control" name = "bno" readonly= "readonly" value='<c:out value ="${board.bno }"/>'>
	                             </div>
	                         	<div class="form-group">
	                                <label>Title</label>
	                                <input class="form-control" name = "title" value='<c:out value ="${board.title }"/>'>
	                             </div>
	                             
								<div class="form-group">
	                                <label>Content</label>
	                                <textarea class="form-control" rows="5" cols="50" name="content"> <c:out value ="${board.content }"/> </textarea>
	                             </div>
	                             
	                            	<div class="form-group">
	                                <label>Writer</label>
	                                <input class="form-control" name = "writer" value='<c:out value ="${board.writer }"/>'>
	                             </div>
									<button type="button" class="btn btn-default "data-oper="modify">수정</button>
									<button type="button" class="btn btn-info listbtn"><a href='/board/list'></a>목록</button>
	                          		<button type="button" class="btn btn-danger " data-oper="remove">삭제</button>
	                        </form>
	                        
                          	<form id="actionForm" action="/board/list" method="get">
                            	<input type ="hidden" name="pageNum" value="${cri.pageNum }">
							   	<input type ="hidden" name="amount" value="${cri.amount }">
							   	<input type ="hidden" name="bno" value="${board.bno }">
                            </form>
                            
                             <script>
	                        	var actionForm = $("#actionForm");
	                        	
	                        	$(".listbtn").click(function(e){
	                        		e.preventDefault();
	                        		actionForm.submit();
	                        	});
	                        	
                        	</script>
                             
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
<script>
 $(document).ready(function(){
	 
	 var formObj = $("form");
	 
	 $('.btn').click(function(e){
		 
		e.preventDefault();
		var operation = $(this).data("oper")
		
		console.log(operation);
		
		if(operation === 'remove'){
			formObj.attr("action","/board/remove")
			.attr("method","post");
			formObj.submit();
			
		}else if(operation === 'modify'){
			formObj.attr("action","/board/modify")
			.attr("method","post");
			formObj.submit();
		}
		
	 })
 })
</script>           
          
  
  <%@include file="../includes/footer.jsp" %>
