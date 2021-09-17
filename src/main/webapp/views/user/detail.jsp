<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${post.title }</title>
</head>
<body>
	<div class="breadcrumb-wrap">
		<div class="container">
			<ul class="breadcrumb">
				<li class="breadcrumb-item"><a
					href="${pageContext.request.contextPath }/trang-chu">Trang chủ</a></li>
				<li class="breadcrumb-item"><a
					href="${pageContext.request.contextPath }/the-loai?name=${cate.cateSlug}&id=${cate.id}&page=1">${post.cateName}</a></li>
			</ul>
		</div>
	</div>
	<!-- Breadcrumb End -->

	<!-- Single News Start-->
	<div class="single-news">
		<div class="container">
			<div class="row">
				<div class="col-lg-8">
					<div class="sn-container">
						<div class="sn-img">
							<img src="assets/thumb/${post.thumb }" />
						</div>

						<div class="sn-content">
							<h1 class="sn-title">${post.title }</h1>
							<input type="hidden" value="${post.id }" id="postid">
							<p>
								<i><fmt:formatDate value="${post.createdDate }"
										pattern="dd/MM/yyyy 'vào lúc' HH:mm" /></i>
							</p>
							<br>
							<p>
								<b>${post.excerpt }</b>
							</p>
							<br>
							<div class="sn-content sn-img">${post.content }</div>
						</div>
						<hr>
						<div class="comment row">
							<div class="col-lg-12">
								<h3>Bình luận(${totalCmt })</h3>
								<textarea rows="4" placeholder="Ý kiến của bạn..."
									class="form-control content"></textarea>
									<button class="btn btn-sent mb-6">Gửi</button>
							</div>
						</div>
						<div class="row d-flex justify-content-center">
								      <div class="col-md-12" id="comment-area">
								      <c:if test="${cmts.size()==0 }">
									<p class="text-center"><i>Hiện tại chưa có bình luận nào.</i></p>
								</c:if>
								      <c:forEach var="cmt" items="${cmts }">
								           <div class="card p-3 mt-3">
								              <div class="d-flex justify-content-between align-items-center">
								                  <div class="user d-flex flex-row align-items-center">
										                   <img src="https://i.imgur.com/hczKIze.jpg" width="30" class="user-img rounded-circle mr-2">
										                    <small class="font-weight-bold text-primary">${cmt.fname } :&nbsp;</small> 
										                    <small>${cmt.content}</small>
								                     </div> 
								              </div>
								                <small class="ml-3 mt-3">${cmt.timeAgo =="cách đây khắc" ? "Vừa xong" : cmt.timeAgo}</small>
								          </div>
								      </c:forEach>
								      </div>
    					</div>
					</div>
					<div class="sn-related mt-5">
						<h2>Liên quan</h2>
						<div class="row sn-slider">
						<c:forEach var ="post" items="${RelatedPost }">
							<div class="col-md-4">
									<div class="sn-img">
										<img src="/assets/thumb/${post.thumb }" />
										<div class="sn-title">
											<a href="${pageContext.request.contextPath }/bai-viet?title=${post.segment}&id=${post.id}">${post.title }</a>
										</div>
									</div>
								</div>
						</c:forEach>
						</div>
					</div>
				</div>

				<div class="col-lg-4">
					<div class="sidebar">
						<div class="sidebar-widget">
							<h2 class="sw-title">Cùng thể lọai</h2>
							<div class="news-list">
								<c:forEach var="post" items="${relatedPostOfCate }">
									<div class="nl-item">
										<div class="nl-img">
											<img src="assets/thumb/${post.thumb }" />
										</div>
										<div class="nl-title">
											<a
												href="${pageContext.request.contextPath }/bai-viet?title=${post.segment}&id=${post.id}"
												class="anchor">${post.title}</a>
										</div>
									</div>
								</c:forEach>
							</div>
						</div>
						<div class="sidebar-widget">
							<h2 class="sw-title">Thể loại</h2>
							<div class="category">
								<ul>
									<c:forEach var="cate" items="${PostOfCategory }">
										<li><a
											href="${pageContext.request.contextPath }/the-loai?name=${cate.cateSlug}&id=${cate.id}&page=1">${cate.name }</a><span>(${cate.totalPost})</span></li>
									</c:forEach>
								</ul>
							</div>
						</div>

						<div class="sidebar-widget">
							<div class="image">
								<a href="https://www.facebook.com/thihoanganh.it/" target="_blank"><img
									src="/assets/img/ads-2.jpg" alt="Image"></a>
							</div>
						</div>

						<div class="sidebar-widget">
							<h2 class="sw-title">Tags</h2>
							<div class="tags">
								<c:forEach var="tag" items="${post.tags }">
									<a href="${pageContext.request.contextPath }/tag?name=${tag}">${tag }</a>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<content tag="local_script">
<script>
	  $(function() {
		// read more in comment
		    var cmtCountInPage =$('.card').length
		    var cmtTotalCmt = 0
		    var postId = $('#postid').val()
		    var counter = 1
		    $.ajax({
	            type: "GET",
	            url : "Comment?action=total&postid="+postId,
	            success: function(totalCmt){
	             	if(cmtCountInPage<totalCmt){
	             		cmtTotalCmt = totalCmt
	             		appendReadMoreButton()
	             	}
	            }
	    });
		function appendReadMoreButton(){
			 var containerComment = document.getElementById('comment-area')
     		 var readMoreNode = document.createElement('p')
     		 readMoreNode.setAttribute('id','read-more')
     		 readMoreNode.style.cursor = 'pointer'
     			readMoreNode.classList.add('text-center','mt-3')
     		 readMoreNode.innerHTML = 'Xem thêm...'
     			containerComment.after(readMoreNode)
     			readMoreNode.addEventListener('click', e => {
     				  loadMoreComment();
     				  //check enable or disable btn read more
     				 cmtCountInPage+=5
     				if(cmtCountInPage > parseInt(cmtTotalCmt)){
     					console.log('disable....')
	             		readMoreNode.style.display = 'none';
	             	}
     			});
		}
		
		function loadMoreComment(){
			counter += 1
			$.ajax({
	            type: "GET",
	            url : "Comment?action=next&page="+counter+"&postid="+postId,
	            success: function(cmts){
	            	JSON.parse(cmts).forEach(function(cmt){
	            		console.log(cmt)
	            		appendComment(cmt.Content,cmt.TimeAgo,cmt.Fname)
	            	})
	            }
	    });
		}
		
		function appendComment(content,timeAgo,username){
       	 var containerComment = document.getElementById('comment-area')
    	 var divNode = document.createElement('div');
    	 divNode.classList.add('card','p-3','mt-3')
    	 
    	  var divNodeChild1 = document.createElement('div');
    	 divNodeChild1.classList.add('d-flex','justify-content-between','align-items-center')
    	 
    	  var divNodeChild2 = document.createElement('div');
    	 divNodeChild2.classList.add('user','d-flex','flex-row','align-items-center')
    	 
    	 var imgNode = document.createElement('img');
    	 imgNode.classList.add('user-img','rounded-circle','mr-2')
    	 imgNode.setAttribute('src','https://i.imgur.com/hczKIze.jpg')
    	 imgNode.setAttribute('width','30')
    	 
    	   var usernameNode = document.createElement('small');
    	 usernameNode.classList.add('font-weight-bold','text-primary')
    	  usernameNode.innerHTML = username + ":"
    		  	
    	  var contentNode = document.createElement('small');
    	  contentNode.innerHTML =  content
    	 
    	 var dayAgoNode = document.createElement('small');
    	 dayAgoNode.classList.add('ml-3','mt-3')
    	  dayAgoNode.innerHTML = timeAgo;
    		  
		  divNodeChild2.appendChild(imgNode)
		  divNodeChild2.appendChild(usernameNode)
		  divNodeChild2.appendChild(contentNode)
    	
		  divNodeChild1.appendChild(divNodeChild2)
		  divNode.appendChild(divNodeChild1)
		  divNode.appendChild(dayAgoNode)
		   containerComment.appendChild(divNode)
		}
		
});
</script>
</content>
</body>
</html>