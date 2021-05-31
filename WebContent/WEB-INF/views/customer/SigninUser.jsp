<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script type="text/javascript" src="js/join_check.js?v=<%=new java.util.Date().getTime()%>"></script>
    <script src="//code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="//code.jquery.com/jquery-latest.min.js"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/customer/main.css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/customer/signin_user.css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/customer/main.css">
<%--     <link href="${ pageContext.servletContext.contextPath }/resources/css/customer/reset.css" type="text/css"
	rel="stylesheet"> --%>
   <link href="${ pageContext.servletContext.contextPath }/resources/css/customer/common_ah.css" type="text/css"
	rel="stylesheet">
</head>
<body>
   
      <center>
        <header>
		<div class="head">
			<div class="right">
				<div>
					<a href="${ pageContext.servletContext.contextPath }" class="logo">babmokja</a>
				</div>
				<div class="sq">

					<!-- 로그인이 필요한 경우 -->
					<c:if test="${ empty sessionScope.loginUser }">

						<!-- 로그인 폼 -->
						<form id="loginForm" method="post">
							<div class="btns" align="right">
								<div class="join">
									<a href="${ pageContext.servletContext.contextPath }/member/user/signin"class="join_icon">회원가입</a>
								</div>
								<div class="login">
									<a href="${ pageContext.servletContext.contextPath }/user/login" class="login_icon">로그인</a>
								</div>
							</div>
						</form>

					</c:if>

					<c:if test="${ !empty sessionScope.loginUser }">
						<!-- 로그인 되어 있는 경우 -->
						<div class="btns">
							<div class="mypage">
								<a href="${ pageContext.servletContext.contextPath}/user/mypage" class="mypage_icon"> 
									<img src="${ pageContext.servletContext.contextPath }/resources/image/customer/user.png" alt="이미지없음">
								</a>
							</div>
							<div class="logout">
								<a href="${ pageContext.servletContext.contextPath }/user/logout" class="logout_icon">로그아웃</a>
							</div>
						</div>
					</c:if>
					
				</div>
			</div>
			
			<div>
				<a href="${ pageContext.servletContext.contextPath }" class="title">너의
					밥먹는건 우리가 책임진다</a>
			</div>
			<div class="searchbox">
				<a href="${ pageContext.servletContext.contextPath }/store/list">
					<img src="${ pageContext.servletContext.contextPath }/resources/image/customer/magnifying.png" alt="이미지없음"
					id="icon">
				</a> <input type="text" class="searchpoint">
			</div>
			<div class="nav">
				<span> <a
					href="${ pageContext.servletContext.contextPath }/store/list?cate=kor&type=1&order=congestion&currentPage=1"
					class="a" id="kor">한식</a>
				</span> <span> <a
					href="${ pageContext.servletContext.contextPath }/store/list?cate=fra&type=1&order=congestion&currentPage=1"
					class="a" id="fra">프랜차이즈</a>
				</span> <span> <a
					href="${ pageContext.servletContext.contextPath }/store/list?cate=chi&type=1&order=congestion&currentPage=1"
					class="a" id="chi">중식</a>
				</span> <span> <a
					href="${ pageContext.servletContext.contextPath }/store/list?cate=jap&type=1&order=congestion&currentPage=1"
					class="a" id="jap">일식</a>
				</span> <span> <a
					href="${ pageContext.servletContext.contextPath }/store/list?cate=ame&type=1&order=congestion&currentPage=1"
					class="a" id="ame">양식</a>
				</span>
			</div>
		</div>
	</header>
      </center>

        <center>
        <div id= 'signin1' style="margin-top: 80px;">
          <label class="bigbtn" value="밥묵자 회원가입" >밥묵자회원가입	</label>
           <form name="form" id = "form" method="post" action="${ pageContext.servletContext.contextPath }/member/user/signin">
            <table style="margin-top: 70px;margin-left: 50px; border-collapse: separate;
               border-spacing: 17px 14px;"  >
             <tr>
              <th><label style="font-size: 25px">아이디</label> </th>
               <td><input type="text" id="userId" name ="userId" size = "25"style="font-size:17px;border-radius: 26px; border: 1px solid black;">
                 <input type="button" id="overlap" style="display:none;">
                 <label for="overlap" id="checkId" style="width: 60px;background-color: #ffcc00;border: 1px solid #d9e1e8;height: 32px; border-radius: 20px;font-weight: 600;font-size: 15px;cursor: pointer;padding: 10px 10px 10px 10px;" >중복확인</label>
               </td>
             </tr>
           
             <tr>
              <th><label style="font-size: 25px">비밀번호 </label></th>
               <td><input type="password" name="userPwd" id="pw" onchange="check_pw()"name="pw" class="chk" size="25" placeholder="영문소문자와숫자만입력하세요" style="font-size:17px;border-radius: 26px; border: 1px solid black;"> </td>
             </tr>
          
             <tr> 
              <th><label style="font-size: 25px">비밀번호 확인 </label></th>
               <td><input type="password"  name="userPwd" id="pw2"  onchange="check_pw()" name ="pw_ck" class= "chk" size="25" style="font-size:17px;border-radius: 26px; border: 1px solid black;">
                <span id="check" ></span>
               </td>
             </tr>
          
             <tr>
              <th><label style="font-size: 25px">이 름 </label></th>
                <td><input type="text" id="name"name ="userName" size="25" style="font-size:17px;border-radius: 26px; border: 1px solid black;"> </td>
             </tr>
          
             <tr> 
              <th><label style="font-size: 25px">주민번호</label></th>
                <td><input type="text" id="userNo" name ="userNo" size="10"
                       maxlength="13"  style="font-size:17px;border-radius: 26px; border: 1px solid black;">
                       __<input type="password" id="userNo2" name ="userNo2" size="13"
                       maxlength="13"  style="font-size:17px;border-radius: 26px; border: 1px solid black;"></td>
             </tr>

             <tr> 
               <th><label style="font-size: 25px">휴대전화 </label></th>
                <td><input type="text" id= "userPhone"name="userPhone" size="25"
                       maxlength="13" placeholder="숫자만입력하세요" style="font-size:17px;border-radius: 26px; border: 1px solid black;"></td>
             </tr>
         
             <tr>
               <th><label style="font-size: 25px">우편번호 </label></th>
                 <td><input type="text" name="zip" size="25" style="font-size:17px;border-radius: 26px; border: 1px solid black;"> 
                 <button type="button"  style="width:60px; background-color: #ffcc00; border: 1px solid #d9e1e8; height:32px; border-radius: 20px; font-weight: 600; font-size: 15px; cursor: pointer;" id="searchZipCode">검색</button></td>
             </tr>
          
             <tr>
               <th><label style="font-size: 25px">주소 </label></th>
                <td><input type="text"size="25" name="addr1" style="font-size:17px;border-radius: 26px; border: 1px solid black;" readonly /> </td>
             </tr> 
             <tr>
               <th><label style="font-size: 25px">상세주소 </label></th>
                 <td><input type="text"size="25" name="addr2" style="font-size:17px;border-radius: 26px; border: 1px solid black;"/> </td>
             </tr>

             <tr>
              <th><label style="font-size: 25px">이메일  </label></th>
                <td><input type="text" id="mail" name="userEmail" size="25" style="font-size:17px;border-radius: 26px; border: 1px solid black;"></td>   
             </tr>
 
         </table>
           <br>
           <br>
            
            <input type="submit" class="btn" value="제 출" style="margin-bottom: 50px;">
            
        </center>    
        </form>
        </div>

   
                 
<jsp:include page="/WEB-INF/views/common/customer/footer.jsp" />
<script>
  function check_pw(){
      var pw = document.getElementById('pw').value;
      var SC = ["!","@","#","$","%"];
      var check_SC = 0;

      if(pw.length < 6 || pw.length>16){
          window.alert('비밀번호는 6글자 이상, 16글자 이하만 이용 가능합니다.');
          document.getElementById('pw').value='';
      }
      for(var i=0;i<SC.length;i++){
          if(pw.indexOf(SC[i]) != -1){
              check_SC = 1;
          }
      
         if(check_SC == 1){
          document.getElementById('check').innerHTML='비밀번호에 특수문자가 포함되어 있습니다.';
          document.getElementById('check').style.color='red';  
        }
      }
      if(document.getElementById('pw').value !='' && document.getElementById('pw2').value!=''){
          if(document.getElementById('pw').value==document.getElementById('pw2').value){
              document.getElementById('check').innerHTML='비밀번호가 일치'
              document.getElementById('check').style.color='blue';
             
          }
          else{
              document.getElementById('check').innerHTML='비밀번호가 일치하지 않습니다.';
              document.getElementById('check').style.color='red';
              
             
          }
      }
  }
</script>

<script>
     const $searchZipCode = document.getElementById("searchZipCode");
     
     $searchZipCode.onclick = function() {
                new daum.Postcode({
                    oncomplete: function(data) {
                        $('[name=zip]').val(data.zonecode); // 우편번호 (5자리)
                        $('[name=addr1]').val(data.address);
                        $('[name=addr2]').val(data.buildingName);
                    }
                }).open();
            }      
</script> 


<script>
function joinform_check() {
	  //변수에 담아주기
	  var uid = document.getElementById("userId");
	  var pwd = document.getElementById("UserPwd");
	  var uname = document.getElementById("userName");
	  var mobile = document.getElementById("userPhone");
	  var mail = document.getElementById("mail");
	  var emailRegExp = /^[A-Za-z0-9_]+[A-Za-z0-9]*[@]{1}[A-Za-z0-9]+[A-Za-z0-9]*[.]{1}[A-Za-z]{1,3}$/;
	  var userNo = document.getElementById("userNo"); 
	  if (!emailRegExp.test(mail)) {
	               window.alert("이메일 형식이 올바르지 않습니다!");
	               form.mail.value = "";
	               form.mail.focus();
	               return false;
	    }

	  if (uid.value == "") { 
	    alert("아이디를 입력하세요.");
	    uid.focus(); 
	    return false; 
	  };

	  if (pwd.value == "") {
	    alert("비밀번호를 입력하세요.");
	    pwd.focus();
	    return false;
	  };


	  if (uname.value == "") {
	    alert("이름을 입력하세요.");
	    uname.focus();
	    return false;
	  };

	  if (!female.checked && !male.checked) { //둘다 미체크시
	    alert("성별을 선택해 주세요.");
	    female.focus();
	    return false;
	  }

	  var reg = /^[0-9]+/g; //숫자만 입력하는 정규식

	  if (!reg.test(mobile.value)) {
	    alert("전화번호는 숫자만 입력할 수 있습니다.");
	    mobile.focus();
	    return false;
	  }
	  if (!reg.test(userNo.value)) {
		    alert("주민번호는 숫자만 입력할 수 있습니다.");
		    mobile.focus();
		    return false;
		  }


	  if (email_id.value == "") {
	    alert("이메일 주소를 입력하세요.");
	    email_id.focus();
	    return false;
	  }



	 
	  document.form.submit();    
	}




</script> 
<script>
	$("#checkId").click(function(){
			         
	const userId = document.getElementById("userId").value;
			    	
			         
	$.ajax({
	url: "${ pageContext.servletContext.contextPath }/user/check",
	type: "get",
	data : { userId: userId },
	success: function(data, textStatus, xhr) {
	     console.table(data);
	     if(data == "1"){
	     alert("중복된 아이디입니다.");
	     }else {
		 alert("사용가능한 아이디입니다.");
			}
		},
		error: function(xhr, status, error) {
		console.log(error);	            }
			         });
			      });
			      		      
</script>   


</body>
</html>