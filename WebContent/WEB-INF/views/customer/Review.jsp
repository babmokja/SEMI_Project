<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="resources/css/customer/main.css">
    <link rel="stylesheet" href="resources/css/customer/review.css">
    <script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
      <center>
		<jsp:include page="/WEB-INF/views/common/customer/header.jsp" />
	  </center>
      <center>
        <div class="section1">
            <form class="reviewsec" action="${ pageContext.servletContext.contextPath }/review" method="post" encType="multipart/form-data">
                <br>
                <br>
                <h1>사진과 함께 리뷰 작성시 포인트 적립 혜택!!</h1>
                
                <div id=emotion>
                   <span class=emoji>
                      <img src="resources/image/customer/good.png">
                       &nbsp;&nbsp;&nbsp;
                      <img src="resources/image/customer/okay.png">
                       &nbsp;&nbsp;&nbsp;
                      <img src="resources/image/customer/bad.png">
                   </span>
                </div> 
                    
                     <input type="radio"  name="emoji"value="5" >
                     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                     <input type="radio" name="emoji" value="3">
                     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                     <input type="radio" name="emoji" value="1">
            
              
               <div>
                   <br>
                   <h4>맛있다
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;
                    괜찮다
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;
                    별로다
                   </h4>
                   <br>
               </div>
                 
        
              
        
                <div id ="review">
                    <textarea name = "reviewContent" id= "text" cols="50" rows="20" placeholder=
                    "
                사진과 함께 리뷰 작성시 최대 150 포인트 적립 가능!
                음식에 대한 솔직한 리뷰를 남겨주세요(500자이하)" style="border-radius:10px;"maxlength="500"></textarea>
                    
                </div>
                
                <div><span id="counter">###</span></div>
                  <script>
                   $(function() {
                   $('#text').keyup(function (e){
                   var content = $(this).val();
                   $('#counter').html(content.length + '/500');
                   });
                   $('#text').keyup();
                   });
                 </script>   
             
              <div class="imagePreview" style="background:url('resources/image/customer/camera.png');background-repeat: no-repeat; margin-top: 20px;">
              <div class = "file_input">
                <label>
                   <input id="uploadFile" onchange="javascript:document.getElementById('file_route').value=this.value" type="file" name="image" class="img" />
               </label>
              </div>
              </div>
                 <input type = "text" readonly="readonly" title="File Route" id="file_route">
               
           
                 <script type="text/javascript">
                    $(function() {
                        $("#uploadFile").on("change", function(){
                            var files = !!this.files ? this.files : [];
                            if (!files.length || !window.FileReader) return; 
                            if (/^image/.test( files[0].type)){ 
                                var reader = new FileReader(); 
                                reader.readAsDataURL(files[0]); 
                                reader.onloadend = function(){ 
                                 $('.imagePreview').css("background-image", "url("+this.result+")"); 
                                };
                            }
                        });
                     });
                    
                  </script>
             
              <div id = insert>
                 <input type="submit" class="btn" value="등록완료">
              </div>
        
            </center> 
        </form>
        


    </div>





    <footer>
        <div id="footlim">
            <small>
                <br>㈜ 지금 배고프조<br><br>
                서울특별시 강남구 강남동 000, 타워 5층 | 사업자 등록번호: 000-00-00000 [사업자정보확인]<br>
                통신판매업 신고번호: 2021-서울강남-04026 | 개인정보 담당자 : babmokja@babmokja.co.kr | 제휴문의 :
                babmokja@babmokja.co.kr | 고객 만족센터 : babmokja@babmokja.co.kr<br><br>

                (유)지금 배고프조는 통신판매중개자이며 통신판매의 당사자가 아닙니다. <br> 따라서 상품/ 거래정보 및 거래와 관련하여 밥먹자에 등록된 판매자의 고의
                또는 과실로 소비자에게 발생하는 손해에 대해 (유)지금 배고프조는 책임을 지지 않습니다.<br>
                상품 및 거래에 관하여 보다 정확한 정보는 해당 판매자에게 직접 확인하여 주시기 바랍니다. Copyright BABMOKJA. All
                Rights Reserved.<br><br>

                고객센터: 02-123-4567 (24시간, 연중무휴)
                <br>
                <address>
                    Copyright &copy; BABMOKJA All Right Reserved.</address>
            </small>
        </div>
    </footer>





</body>
</html>