(function ($) {
    "use strict";
    
    // Sticky Navbar
    $(window).scroll(function () {
        if ($(this).scrollTop() > 150) {
            $('.nav-bar').addClass('nav-sticky');
        } else {
            $('.nav-bar').removeClass('nav-sticky');
        }
    });
    
    
    // Dropdown on mouse hover
    $(document).ready(function () {
        function toggleNavbarMethod() {
            if ($(window).width() > 768) {
                $('.navbar .dropdown').on('mouseover', function () {
                    $('.dropdown-toggle', this).trigger('click');
                }).on('mouseout', function () {
                    $('.dropdown-toggle', this).trigger('click').blur();
                });
            } else {
                $('.navbar .dropdown').off('mouseover').off('mouseout');
            }
        }
        toggleNavbarMethod();
        $(window).resize(toggleNavbarMethod);
    });
    
    
    // Back to top button
    $(window).scroll(function () {
        if ($(this).scrollTop() > 100) {
            $('.back-to-top').fadeIn('slow');
        } else {
            $('.back-to-top').fadeOut('slow');
        }
    });
    $('.back-to-top').click(function () {
        $('html, body').animate({scrollTop: 0}, 1500, 'easeInOutExpo');
        return false;
    });
    
    
    // Top News Slider
    $('.tn-slider').slick({
        autoplay: true,
        infinite: true,
        dots: false,
        slidesToShow: 1,
        slidesToScroll: 1
    });
    
    
    // Category News Slider
    $('.cn-slider').slick({
        autoplay: false,
        infinite: true,
        dots: false,
        slidesToShow: 2,
        slidesToScroll: 1,
        responsive: [
            {
                breakpoint: 1200,
                settings: {
                    slidesToShow: 2
                }
            },
            {
                breakpoint: 992,
                settings: {
                    slidesToShow: 1
                }
            },
            {
                breakpoint: 768,
                settings: {
                    slidesToShow: 2
                }
            },
            {
                breakpoint: 576,
                settings: {
                    slidesToShow: 1
                }
            }
        ]
    });
    
    
    // Related News Slider
    $('.sn-slider').slick({
        autoplay: false,
        infinite: true,
        dots: false,
        slidesToShow: 3,
        slidesToScroll: 1,
        responsive: [
            {
                breakpoint: 1200,
                settings: {
                    slidesToShow: 3
                }
            },
            {
                breakpoint: 992,
                settings: {
                    slidesToShow: 3
                }
            },
            {
                breakpoint: 768,
                settings: {
                    slidesToShow: 2
                }
            },
            {
                breakpoint: 576,
                settings: {
                    slidesToShow: 1
                }
            }
        ]
    });
    $('#btnRegister').prop( "disabled", true );
    // validate form
    var validator = $("#formRegister").validate({
		rules: {
			name: "required",
			email: {
				email:"email",
				required:true
			},
			username: {
				required: true,
				minlength: 4,
				maxlength:10
			},
			password:{
				required:true,
				minlength:6,
				maxlength:20
			},
			repassword:{
				required:true,
				equalTo:"#password"
			}
			
		},
		messages: {
				name: "Vui lòng nhập họ tên",
				email: {
					email:"Email sai định dạng",
					required:"Vui lòng nhập email"
				},
				username: {
					required: "Vui lòng nhập tài khoản",
					minlength: "Tài khoản phải lớn hơn 4 kí tự",
					maxlength:"Tài khoản phải nhỏ hơn 10 kí tự"
				},
				password:{
					required:"Vui lòng nhập mật khẩu",
					minlength:"Mật khẩu phải ít nhất 6 kí tự",
					maxlength:"Mật khẩu không được quá 20 kí tự"
				},
				repassword:{
					required:"Vui lòng nhập lại mật khẩu",
					equalTo:"Mật khẩu không khớp"
				}
		}
	});
    
    $('input[name="username"]').blur(function(){
    	var username = $('input[name="username"]').val()
        $.ajax({
            type: "GET",
            url : "CheckUserExist",
            data: {username: username},
            success: function(data){
                if(data == "true"){
                	$('#user-error').text("Tài khoản đã tồn tại");
                	$('#btnRegister').prop( "disabled", true );
                }else{
                	$('#btnRegister').prop( "disabled", false );
                	$('#user-error').text("");
                }
                
            }
    });
    });
    // when closing modal
    $('#registerModal').on('hidden.bs.modal', function () {
    	  $('#formRegister')[0].reset();
    	validator.resetForm();
    })
    // create comment
    $('.btn-sent').click(function(){
    	var content = $('.content').val();
    	 $.ajax({
             type: "POST",
             url : "Comment",
             data: {
            	 postid:$('#postid').val(),
            	 content:content
             },
             success: function(username){
                 if(username != "failure"){
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
                	  contentNode.innerHTML =  document.getElementsByClassName('content')[0].value
                	 
                	 var dayAgoNode = document.createElement('small');
                	 dayAgoNode.classList.add('ml-3','mt-3')
                	  dayAgoNode.innerHTML = 'Vừa xong';
                		  
	        		  divNodeChild2.appendChild(imgNode)
	        		  divNodeChild2.appendChild(usernameNode)
	        		  divNodeChild2.appendChild(contentNode)
                	
	        		  divNodeChild1.appendChild(divNodeChild2)
	        		  divNode.appendChild(divNodeChild1)
	        		  divNode.appendChild(dayAgoNode)
	        		   containerComment.insertBefore(divNode,containerComment.childNodes[0])
	        		   document.getElementsByClassName('content')[0].value=''
                 }else{
                	 var href = window.location.href;
                	  var url = "/dang-nhap?redirect="+ href.slice(href.indexOf('bai-viet'),href.length);
                      window.location.href = url;
                 }
                 
             }
     });
    });
    
    
})(jQuery);

