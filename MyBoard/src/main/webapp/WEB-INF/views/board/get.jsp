<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../includes/header.jsp" %>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Board Read</h1>
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
                        	<div class="form-group">
                                <label>BNO</label>
                                <input class="form-control" name = "bno" readonly= "readonly" value='<c:out value ="${board.bno }"/>'>
                             </div>
                         	<div class="form-group">
                                <label>Title</label>
                                <input class="form-control" name = "title" readonly= "readonly" value='<c:out value ="${board.title }"/>'>
                             </div>
                             
							<div class="form-group">
                                <label>Content</label>
                                <textarea class="form-control" rows="5" cols="50" name="content"  readonly= "readonly"> <c:out value ="${board.content }"/> </textarea>
                             </div>
                             
                           	<div class="form-group">
                                <label>Writer</label>
                                <input class="form-control" name = "writer" readonly= "readonly" value='<c:out value ="${board.writer }"/>'>
                             </div>
                               
                           	 <div class="form-group">
                                <label>조회수</label>
                                <input class="form-control" name = "hit" readonly= "readonly" value='<c:out value ="${board.hit }"/>'>
                             </div>
                             
                            <form id="actionForm" action="/board/list" method="get">
                            	<input type ="hidden" name="pageNum" value="${cri.pageNum }">
							   	<input type ="hidden" name="amount" value="${cri.amount }">
							   	<input type ="hidden" name="bno" value="${board.bno }">
							   	<input type ="hidden" name="type" value="${cri.type }">
							   	<input type ="hidden" name="keyword" value="${cri.keyword }">
                            </form>
                             
							<button  type = 'button' class="btn btn-info listbtn"><a href='/board/list'></a>목록</button>
							<button  type = 'button'class = "btn btn-danger modbtn"><a href='/board/modify?bno=<c:out value = "${board.bno }"/>'></a>수정/삭제</button>
                        	
                        	<script type="text/javascript" src ="/resources/js/reply.js"></script>
                        	
                        	<script>
								$(document).ready(function(){
								
									var bnoValue = '<c:out value ="${board.bno}"/>';
									var replyUL = $(".chat");
									
									showList(1);
									
									function showList(page){
										replyService.getList({bno:bnoValue, page:1}, function(list){
											var str ="";
											if(list == null || list.length == 0){
												replyUL.html("");
												return;
											}
											for(var i = 0, len = list.length || 0; i < len; i++){
												str += "<li class='left clearfix' data-rno='"+list[i].rno+"'>";
												str += "<div><div class='header'><strong class ='primary-font'>"+list[i].replyer+"</strong>";
												str += "<small class ='pull-right text-muted'>"+replyService.displayTime(list[i].replyDate) + "</small></div>";
												str += "<p>" + list[i].reply + "</p></div></li>";
											}
											replyUL.html(str);
										});
									}
								});                        		
                        	</script> 
                        	
                        	<script>
                        	var actionForm = $("#actionForm");
                        	
                        	$(".listbtn").click(function(e){
                        		e.preventDefault();
                        		actionForm.find("input[name = 'bno']").remove();
                        		actionForm.submit();
                        	});
                        	
                        	$(".modbtn").click(function(e){
                        		e.preventDefault();
                        		actionForm.attr("action", "/board/modify");
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
            
            <!-- 댓글 -->
            <div class ="row">
            	<div class ="col-lg-12">
            		<div calss = "panel panel-default">
            			<div class = "panel-heading">
            				<i class =fa fa-comments fa-fw"></i>댓글
            			</div>
            			
            			<div class ="panel-body">
            				<ul class ="chat">
            					<li class = "left clearfix" data-rno ='12'>
            					<div>
            						<div class = "header">
            							<strong class="primary-font">user00</strong>
            							<small class ="pull-right text-muted">2018-01-01 13:13</small>
            						</div>	
            						<p>Good job!</p>
            					</div>
            				</ul>
            			</div>
            			
            		</div>
            	</div>
            </div>
            
		
			<script>
			/* 
				var bnoValue = '<c:out value ="${board.bno}"/>';
				
				replyService.getList({bno:bnoValue, page:1}, function(list){
					for(var i = 0, len = list.length || 0; i < len; i++){
						console.log(list[i]);
					}
				});
				
				replyService.update({
					rno : 9,
					bno : bnoValue,
					reply : "Modified Reply...."
				},function(result){
					alert("수정 완료");
				});
				
				replyService.get(10, function(data){
					console.log(data);
				});
			*/
			</script>     

          
  
  <%@include file="../includes/footer.jsp" %>
