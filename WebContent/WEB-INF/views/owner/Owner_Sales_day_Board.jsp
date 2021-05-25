<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>매출 관리</title>
 <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/owner/semi_store_css/Owner_Sales_day_Board.css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/owner/semi_store_css/main.css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/css/owner/semi_store/bootstrap.min.css">
    <script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
  

</head>
<body>
    <aside class="aside">
        <div class="aside_top2"><a href="${ pageContext.servletContext.contextPath }/main" 
        style="text-decoration: none;
   		color: black;
    	font-style: normal;
    	font-weight: bolder;}"> babmokja </a></div>
        <div class="aside_top">내 업소 관리</div>
        <div class="aside_top3"><a href="${ pageContext.servletContext.contextPath }/menu/all">메뉴 관리</a></div>
        <div class="aside_top4"><a href="${ pageContext.servletContext.contextPath }/owner/sales/day">매출 관리</a></div>
    </aside>

    <section class="section">

        <div class="row">
            <span class="col-2 menu-item menu-item-selected">
                <img src="${ pageContext.servletContext.contextPath }/resources/image/owner/item1.svg" />
                &nbsp;&nbsp;&nbsp;<a href="${ pageContext.servletContext.contextPath }/order/confirm">주문확인</a>
              </span>
              <span class="col-2 menu-item  ">
                <img src="${ pageContext.servletContext.contextPath }/resources/image/owner/item2.png" />
                &nbsp;&nbsp;&nbsp; 내 정보관리
              </span>
              <span class="col-2 menu-item">
                <img src="${ pageContext.servletContext.contextPath }/resources/image/owner/item3.png" />
                
                &nbsp;&nbsp;&nbsp; <a class="text-dark" href="${ pageContext.servletContext.contextPath }/menu/all">내 업소 관리</a>
              </span>
              <span class="col-2 menu-item">
                <img class="img-fluid" src="${ pageContext.servletContext.contextPath }/resources/image/owner/computer.png" />
                &nbsp;&nbsp;&nbsp;<a class="text-dark" href="${ pageContext.servletContext.contextPath }/owner/delivery">PC주문현황</a>
              </span>
  
              <span class="col-2 menu-item">
                  <span class="imagesize"><img src="${ pageContext.servletContext.contextPath }/image/owner/item4.svg" /></span>
                  &nbsp;&nbsp;&nbsp; <a class="text-dark" href="../../semi_board (업체용 게시판)/company/Owner_Comment_Board.html">리뷰관리</a>
                </span>
  
                <span class="col-2 menu-item">
                  <img src="${ pageContext.servletContext.contextPath }/image/owner/item4.svg" />
                  &nbsp;&nbsp;&nbsp; <a class="text-dark" href="${ pageContext.servletContext.contextPath }/suggestion/list">1:1 문의하기</a>
                </span>
        </div>

        <div class="section_top">
            
       
        <div class="button01">일별</div>
        <div class="button02"><a href="${ pageContext.servletContext.contextPath }/owner/sales/month">월별</a></div>
       <!--   <div class="center clearfix">
                <p class="total">오늘 총 [---,---,---]원<br>판매 하셨습니다.</p>
            </div> -->

       
             <div class="space"></div>

			<form action="${ pageContext.servletContext.contextPath }/owner/sales/day" method="GET">

            <table> 
                <thead>
                    <tr>   
                    <th class="section_contest section_contest_1" style=" width:200px;">
                        <span class="months">
                        <c:choose>
                        <c:when test="${!empty requestScope.month}">
                            <select class="form" name="month" id="month">
                            	
                                <option value="0" <c:if test="${month eq '0' }">selected</c:if>>-</option>
                                <option value="1" <c:if test="${month eq '1' }">selected</c:if>>1</option>
                                <option value="2" <c:if test="${month eq '2' }">selected</c:if>>2</option>
                                <option value="3" <c:if test="${month eq 3 }">selected</c:if>>3</option>
                                <option value="4"<c:if test="${month eq '4' }">selected</c:if>>4</option>
                                <option value="5" <c:if test="${month eq '5' }">selected</c:if>>5</option>
                                <option value="6" <c:if test="${month eq '6' }">selected</c:if>>6</option>
                                <option value="7" <c:if test="${month eq '7' }">selected</c:if>>7</option>
                                <option value="8" <c:if test="${month eq '8' }">selected</c:if>>8</option>
                                <option value="9" <c:if test="${month eq '9' }">selected</c:if>>9</option>
                                <option value="10" <c:if test="${month eq '10' }">selected</c:if>>10</option>
                                <option value="11" <c:if test="${month eq '11' }">selected</c:if>>11</option>
                                <option value="12" <c:if test="${month eq '12' }">selected</c:if>>12</option>
                              </select>                           
                              </c:when>
                              
                              <c:otherwise>
                              
                               <select class="form" name="month" id="month">
                            	
                                <option value="0">-</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8">8</option>
                                <option value="9">9</option>
                                <option value="10">10</option>
                                <option value="11">11</option>
                                <option value="12">12</option>
                              </select> 
                              
                              
                              
                              
                              </c:otherwise>
                              
                              
                              
                              
                              </c:choose>
                              
                              
                              
                              
                              
                            </span>
                        월
                        </th>
                        <th class="section_contest section_contest_2">주문번호</th>
                        <th class="section_contest section_contest_3">주문시간</th>
                        <th class="section_contest section_contest_4">서비스 유형</th>
                        <th class="section_contest section_contest_5" style=" width:200px;">결제금액</th>
                    </tr>
                </thead>
                
                <tbody>
					<c:forEach items="${ salesDayList }" var="dayList" >
                    <tr>
                    	<td class="section_contest_first section_contest_1" style=" width:200px;"></td>
                        <td class="section_contest_first section_contest_2"  name="orderCode">${dayList.orderCode}</td>
                        <td class="section_contest_first section_contest_3"  name ="orderTime">${dayList.orderTime}</td>
                        <td class="section_contest_first section_contest_4"  name="typeYN">${dayList.typeYN}</td>
                        <td class="section_contest_first section_contest_5" style=" width:200px;"  name="totalAmount">${dayList.totalAmount} 원</td>
                    </tr>

                    </c:forEach>
                    
                </tbody>
            </table>
			</form>

           
         <!--     <div class="button button_space">1</div>
                <div class="button button_space">2</div>
                <div class="button button_space">3</div>
                <div class="button button_space">4</div>
                <div class="button">5</div> -->
            
        </div>
    
    </section>

    <footer>
        <address class="footer"> Copyright &copy; BABMOKJA All Right Reserved.</address>
    </footer>
    
    <script>
    	$("#month").change(function(){
    		var mon = $("#month option:selected").val();
    			
    		location.href="${ pageContext.servletContext.contextPath }/owner/sales/day?month="+ mon;
    		
    	});
    	
    </script>
</body>
</html>