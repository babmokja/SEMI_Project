<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script type="text/javascript" src="resources/js/owner/semi_store/join_check.js?v=<%=new java.util.Date().getTime()%>"></script>
    <script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script type="text/javascript">
            $(document).ready(function() {
            $("#footer").load("WEB-INF/views/owner/footer.jsp");
            });
    </script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/owner/semi_board/signin_owner.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/owner/semi_board/main.css">

<title>Insert title here</title>
</head>
					<script>
                  function memid() {
                  
   
                     //****** .은 아무문자 들어와도 되는 위치 잡는 역할 .개수 그 이상도 가능하다. 이하는 불가능 
   
                     var regExp = /^[a-z^]{4}[a-z\dA-Z^]{0,}$/
                     var regExp2 = /^[A-Z^]{4}[a-z\dA-Z^]{0,}$/

                     
   
                     var pno = document.getElementById("memberId").value;
   
                     // 개수만 맞으면 true 반환
                     console.log(regExp.test(pno));
                     if (regExp.test(pno)||regExp2.test(pno)) {
                       alert("정상입력");
                     } else {
                       alert("영문자 4자리로 시작해야합니다.(특수문자 사용불가)");
                     }
                 }
                 </script>
					<script>
                      function mempwd() {
                      
       
                         //****** .은 아무문자 들어와도 되는 위치 잡는 역할 .개수 그 이상도 가능하다. 이하는 불가능 
       
                         var regExp = /^[A-Z\da-z]{6,16}$/
                         var regExp2 = /^[0-9]{6,16}$/
    
                         var pno = document.getElementById("mempwd").value;
       
     					
					     
					      if(document.getElementById('pw').value !='' && document.getElementById('pw2').value!=''){
					          if(document.getElementById('pw').value==document.getElementById('pw2').value){
					              document.getElementById('check').innerHTML='비밀번호가 일치'
					              document.getElementById('check').style.color='blue';
					             
					          }
					          else{
					              document.getElementById('check').innerHTML='비밀번호가 일치하지 않습니다.';
					              document.getElementById('check').style.color='red';
					              document.getElementsById('img').innerHTML=imgg;
					             
					          }
					      }
                         
                         // 개수만 맞으면 true 반환
                         console.log(regExp.test(pno));
                         if (regExp.test(pno)||regExp2.test(pno)) {
                           alert("정상입력");
                         } else {
                           alert("6자리이상 16자리이하로 입력하세요.(특수문자 사용불가)");
                         }
                     }
                     </script>
                <script>
                  function namecheck() {
                  
                     var regExp = /^[가-힣^]{3,}$/
   
                     var pno = document.getElementById("named").value;
   
                     // 개수만 맞으면 true 반환
                     console.log(regExp.test(pno));
                     if (regExp.test(pno)) {
                       alert("정상입력");
                     } else {
                       alert("한글로 입력해주세요");
                     }
                 }
                 </script>
                 <script>
               function resi() {
               

                  //****** .은 아무문자 들어와도 되는 위치 잡는 역할 .개수 그 이상도 가능하다. 이하는 불가능 

                  var regExp = /\d\d\d\d\d\d-[1234]\d\d\d\d\d\d/;
                  var regExp2 = /\d\d\d\d\d\d-[1234]\d\d\d\d\d\d/;

                  var pno = document.getElementById("residentNum").value;

                  // 개수만 맞으면 true 반환
                  console.log(regExp.test(pno));
                  if (regExp.test(pno)||regExp2.test(pno)) {
                    alert("정상입력");
                  } else {
                    alert("잘못 입력");
                  }
              }
              </script>


<body style="overflow:scroll;">

<div class="mainsec">
        <label class="bigbtn" >밥묵자 사장님 회원가입</label>
        <center>
      <div id='signin'>
    <form id="joinForm" action="${ pageContext.servletContext.contextPath }/member/owner/regist" method="post" encType="multipart/form-data">
        <table cellpadding="10" cellspacing="15" style="margin-left: 180px;" >
           <tr >
             <td>아이디 </td>
             <td><input type="text" size = "25"style="padding:4px;font-size:13px;border-radius: 10px;" name="memberId">
                 <input type="button" id="overlap" style="display:none;" >
                 <label for="overlap">중복확인</label>
             </td>
             
            <td>비밀번호 </td>
            <td><input type="password" id="pw" onchange="mempwd();" name="pw"  class="chk" size="25" placeholder="6자리 이상 16자리 이하로 입력하세요" style="padding:4px;font-size:13px;border-radius: 10px;" > </td>
          </tr>
          
          
          <tr> 
              <td>비밀번호확인 </td>
              <td><input type="password" id="pw2"  onchange="check_pw()" name ="pw_ck" class= "chk" size="25" style="padding:4px;font-size:13px;border-radius: 10px;" >
                <span id="check" ></span>

          
            </td>
            <td>이 름</td>
            <td><input type="text"size="25" style="padding:4px;font-size:13px;border-radius: 10px;" name="named" > </td>
          </tr>
          
          
          <tr> 
            <td>가게전화번호</td>
            <td><input type="text" size="25" maxlength="13" placeholder="숫자만입력하세요" style="padding:4px;font-size:13px;border-radius: 10px;" name="phone" ></td>
            <td>가게이름</td>
            <td><input type="text" size="25"
                       maxlength="13" style="padding:4px;font-size:13px;border-radius: 10px;" name="storeName"  ></td>
          </tr> 
          
          
          <tr> 
          <td>개업일자</td>
            <td><input type="date"size="25" name="openDate" style="padding:4px;font-size:13px;border-radius: 10px;"   /></td>
          
            <td>우편번호</td>
            <td><input type="text" name="zip" size="25" style="padding:4px;font-size:13px;border-radius: 10px;"> 
            <button type="button"  style="width:60px; background-color: #ffcc00; border: 1px solid #d9e1e8; height:32px; border-radius: 20px; font-weight: 600; font-size: 15px; cursor: pointer;" onclick="openZipSearch()">검색</button></td>
          </tr> 
          
          
          <tr>
            <td>가게주소</td>
            <td><input type="text"size="25" name="addr1" style="padding:4px;font-size:13px;border-radius: 10px;"/> </td>
          
            <td>상세주소</td>
            <td><input type="text"size="25" name="addr2" style="padding:4px;font-size:13px;border-radius: 10px;"/> </td>
          </tr>
          <tr>
            <td>본점소재지</td>
            <td><input type="text"size="25" name="mainAddress" style="padding:4px;font-size:13px;border-radius: 10px;"/> </td>
          
            <td></td>
            <td></td>
          </tr>
          <script>
            function openZipSearch() {
                new daum.Postcode({
                    oncomplete: function(data) {
                        $('[name=zip]').val(data.zonecode); // 우편번호 (5자리)
                        $('[name=addr1]').val(data.address);
                        $('[name=addr2]').val(data.buildingName);
                    }
                }).open();
            }
            
            </script>
            
            <!-- ---------------------추가---------------------------------- -->
            
            <tr>
            <td>상호명</td>
            <td><input type="text"size="25" name="sbName" style="padding:4px;font-size:13px;border-radius: 10px;" /> </td>
         	
            <td>주민등록번호</td>
            <td><input type="text"size="25" name="residentNum" id="residentNum" style="padding:4px;font-size:13px;border-radius: 10px;" /></td>
          	</tr>
          	<script>
        	function test7(){
                var regExp = /\d\d\d\d\d\d-[1234]\d\d\d\d\d\d/;
                // [1234]=1,2,3,4만 포함
                var pno = document.getElementById("residentNum").value;

                if(regExp.test(pno)){
                    alert("정상입력");
                } else {
                    alert("잘못입력");
                }
                //여기까지 숫자,문자 걸러냄
		        }
		    </script>
          	
          	<tr>
            <td>업태</td>
            <td><input type="text"size="25" name="condition" style="padding:4px;font-size:13px;border-radius: 10px;"  /> </td>
         	
            <td>종목</td>
            <td><input type="text"size="25" name="major" style="padding:4px;font-size:13px;border-radius: 10px;"/> </td>
          	</tr>
          	
          	<tr>
            <td>사업자등록증 발급일자</td>
            <td><input type="date"size="25" name="issueDate" style="padding:4px;font-size:13px;border-radius: 10px;"   /> </td>
         	
            <td>이메일</td>
            <td><input type="text"size="25" name="email" style="padding:4px;font-size:13px;border-radius: 10px;"/> </td>
          	</tr>
          	
          	<tr>
            <td>식당좌표</td>
            <td><input type="text"size="25" name="storeXY" style="padding:4px;font-size:13px;border-radius: 10px;" /> </td>
         	
            <td>식당소개</td>
            <td><input type="text"size="25" name="storeIntro" style="padding:4px;font-size:13px;border-radius: 10px;"/> </td>
          	</tr>
            
            
            
            
            
            <!-- ----------------------------------------------------------------------- -->
            
            
         <tr>
         <td>업종카테고리</td>
         <td><select style="font-size: larger; border-radius: 8px;" name="category">
               <option value="한식">한식</option>
               <option value="프랜차이즈">프랜차이즈</option>
               <option value="중식">중식</option>
               <option value="일식">일식</option>
               <option value="양식">양식</option>
         </select></td>
         
         
         <!-- </tr> 
          <tr> -->
            <td>사업자번호</td>
            <td><input type="text" size="25"
                       maxlength="13" placeholder="숫자만입력하세요" style="padding:4px;font-size:13px;border-radius: 10px;" name="businessNum"  >
                    
                       <!-- <input type="file" name="filebox" id="filebox" onchange="javascript:document.getElementById('upload-name').value=this.value">
                       <label for = "filebox" class="upload-hidden" >파일 </label>
                       <input type='text' class='upload-name' id='upload-name' disabled />
                       <script>
                        var uploadname = document.getElementById('upload-name')
                        uploadname.addEventListener('change',function (e) {
                            var files = e.target.files;
                            uploadname.value = files[0].name
                        })
                      </script> -->
                     
            </td>
          </tr>
          
          
          <tr>
            <td>서비스유형</td>
            <td><input type="radio" name="service" value="1" onclick="div_OnOff(this.value,'con');" >  배달만
                <input type="radio" name="service" value="2" onclick="div_OnOff(this.value,'con');">   픽업만
                <input type="radio" name="service" value="3" onclick="div_OnOff(this.value,'con'); ">  배달+픽업</td>
            <td></td>
            <td></td>
          </tr>
          
          <tr>
            <td>사업자구분</td>
            <td><input type="radio" name="BISI" value="개인" onclick="div_OnOff(this.value,'con');" >  개인
                <input type="radio" name="BISI" value="사업자" onclick="div_OnOff(this.value,'con');">   사업자
            <td></td>
            <td></td>
          </tr>
          

			<!-- -------------------------------------------------------- -->
			
			<div class="thumbnail-insert-area">
				<table align="center">
					<tr>
					<td style="text-align:left;" colspan="2">&nbsp;&nbsp;사업자등록증 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 가게 사진</td>
					</tr>
					<tr>
						<td>
							<div class="content-img-area1" id="contentImgArea1">
								<img id="contentImg1" width="120" height="100">
							</div>
						</td>
						<td>
							<div class="content-img-area2" id="contentImgArea2">
								<img id="contentImg2" width="120" height="100">
							</div>
						</td>				
					</tr>
				</table>
				
				<div class="thumbnail-file-area">
					<input type="file" id="thumbnailImg1" name="thumbnailImg1" onchange="loadImg(this,1)">
					<input type="file" id="thumbnailImg2" name="thumbnailImg2" onchange="loadImg(this,2)">
				</div>
			</div>
			<br>
			
			
		<script>
			
			const $contentImgArea1 = document.getElementById("contentImgArea1");
			const $contentImgArea2 = document.getElementById("contentImgArea2");
			
			$contentImgArea1.onclick = function() { 
				document.getElementById("thumbnailImg1").click(); 
			}
			
			$contentImgArea2.onclick = function() {
				document.getElementById("thumbnailImg2").click();
			}
			
			function loadImg(value, num) {
				if (value.files && value.files[0]) {
					const reader = new FileReader();
					reader.onload = function(e) {
						switch(num){
						case 1:
							document.getElementById("contentImg1").src = e.target.result;
							break;
						case 2:
							document.getElementById("contentImg2").src = e.target.result;
							break;
						}
					}
					reader.readAsDataURL(value.files[0]);
				}
			}
			
		</script>
		
		
		

        
         </table><br>
           <div class="thumbnail-btn-area">
				<button>취소하기</button>
				<button type="submit">작성완료</button>
			</div>
		</form>
       
       </div>
       </center>
        
                 
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
                    Copyright &copy; BABMOKJA All Right Reserved.
                </address>
            </small>
        </div>
    </footer>     
</div>

</body>
</html>