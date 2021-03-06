 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<link href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">

    body {
      font-family: 'Varela Round', sans-serif;
   }
   .modal-login {
      color: #636363;
      width: 350px;
   }
   .modal-login .modal-content {
      padding: 20px;
      border-radius: 5px;
      border: none;
   }
   .modal-login .modal-header {
      border-bottom: none;
      position: relative;
      justify-content: center;
   }
   .modal-login h4 {
      text-align: center;
      font-size: 26px;
   }
   .modal-login  .form-group {
      position: relative;
   }
   .modal-login i {
      position: absolute;
      left: 13px;
      top: 11px;
      font-size: 18px;
   }
   .modal-login .form-control {
      padding-left: 40px;
   }
   .modal-login .form-control:focus {
      border-color: #12b5e5;
   }
   .modal-login .form-control, .modal-login .btn {
      min-height: 40px;
      border-radius: 3px; 
        transition: all 0.5s;
   }
   .modal-login .close {
        position: absolute;
      top: -5px;
      right: -5px;
   }
    .modal-login input[type="checkbox"] {
        margin-top: 1px;
    }
    .modal-login .forgot-link {
        color: #12b5e5;
        float: right;
    }
   .modal-login .btn {
      background: #12b5e5;
      border: none;
      line-height: normal;
   }
   .modal-login .btn:hover, .modal-login .btn:focus {
      background: #10a3cd;
   }
   .modal-login .modal-footer {
      color: #999;
      border: none;
      text-align: center;
      border-radius: 5px;
      font-size: 13px;
        margin-top: -20px;
      justify-content: center;
   }
   .modal-login .modal-footer a {
      color: #12b5e5;
   }
   .trigger-btn {
      display: inline-block;
      margin: 100px auto;
   }
</style>    

    
    
<script>
function isNull(obj, msg) {
   if (obj.value == "") {
      alert(msg);
      obj.focus();
      return true;
   }
   return false;
}


function checkForm(){
             
   var f = document.lform;
   
   if(isNull(f.e_id, '아이디를 입력해 주세요')){
      return false;
   }
   
   if(isNull(f.e_password, '패스워드를 입력해 주세요')){
      return false;
   }
}



$(document).ready(function(){
    $("#login_btn").click(function(){
        
    	alert("Submitted");
        
    	$.ajax({
        	
  	      	url:"${ pageContext.request.contextPath}/ceoModal",
  	      	type: "POST",  
  	      	data: {
  	      		e_id : $('#e_id').val(),
				e_password : $('#e_password').val()  	      		
  	      	},
  	      	success: function(data) {  	        	      	
  	      		if(data==""){
					alert("회원 정보가 존재하지 않습니다");	
					window.location.href="#myModal";
				}else{
					
					window.location.href="${ pageContext.request.contextPath}/ceo";
				}	
  	      	}
        });           
    });   
});

</script>

 <div id="myModal" class="modal fade">
   <div class="modal-dialog modal-login">
      <div class="modal-content">
         <div class="modal-header">            
            <h4 class="modal-title">Sign in</h4>
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
         </div>
         <div class="modal-body">

            <form action="${ pageContext.request.contextPath }/ceoModal" name="lform" onsubmit="return checkForm()" method="post" >
               <div class="form-group">
                  <i class="fa fa-user"></i>
                  <input type="text" class="form-control" placeholder="아이디" name="e_id" id="e_id" />
               </div>
               <div class="form-group">
                  <i class="fa fa-lock"></i>
                  <input type="password" class="form-control" placeholder="패스워드" name="e_password" id="e_password" />               
               </div>
                    <div class="form-group small clearfix">
                        <label class="checkbox-inline"><%-- <form:checkbox path/>Remember me --%> </label>
                        <a href="${ pageContext.request.contextPath }/ceo/forgotmyid">아이디</a> / 
                        <a href="${ pageContext.request.contextPath }/ceo/forgotmypassword">비밀번호</a>를 잊으셨나요?
               </div>               
               <div class="form-group">
                  <input type="button" id="login_btn" class="btn btn-primary btn-block btn-lg" value="로그인"/>
               </div>
            </form>
         </div>
         <div class="modal-footer">아직 해방회원이 아니신가요? <a href="${ pageContext.request.contextPath }/ceo/register/join">회원가입하기</a></div>
      </div>
   </div>
</div>     
