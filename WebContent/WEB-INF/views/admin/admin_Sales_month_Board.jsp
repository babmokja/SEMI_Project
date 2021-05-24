<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/SEMI_Project/resources/css/admin/admin_Sales_month_Board.css">
    <link rel="stylesheet" href="/SEMI_Project/resources/css/admin/main2.css">
    <link rel="stylesheet" href="/SEMI_Project/resources/css/admin/bootstrap.min.css">
    <title>Document</title>

</head>
<body>
    <aside class="aside">
        <div class="aside_top2">BABMOKJA </div>
        <div class="aside_top">월별 매출 관리 </div>
    </aside>

    <section class="section">

        <div class="row">
            <span class="col-2 menu-item">
                <a href="${pageContext.servletContext.contextPath}/admin/order" class="link-dark"><img src="/SEMI_Project/resources/image/admin/item1.png" />
                  &nbsp;&nbsp;&nbsp;주문확인   </a>
              </span>
              <span class="col-2 menu-item ">
              <a href="${pageContext.servletContext.contextPath}/admin/customer" class="link-dark">  <img src="/SEMI_Project/resources/image/admin/item2.png" />
                &nbsp;&nbsp;&nbsp; 고객관리</a>
              </span>
              <span class="col-2 menu-item menu-item-selected  ">
                <img src="/SEMI_Project/resources/image/admin/item3.png" />
                &nbsp;&nbsp;&nbsp; 업소관리
              </span>
              <span class="col-2 menu-item">
                <a href="${pageContext.servletContext.contextPath}/admin/customer/board" class="link-dark"><img src="/SEMI_Project/resources/image/admin/item4.png" />
                  &nbsp;&nbsp;&nbsp;  게시판</a>
              </span>
        </div>

        <div class="section_top">
            
       
        <div class="button01"><a href="${pageContext.servletContext.contextPath}/admin/sales/today">오늘</a></div>
        <div class="button02">월별</div>

       
        <div class="space"></div>

        <!-- <div class="table_box"> -->

            <table> 
                <thead>
                    <tr>
                        <th class="section_contest section_contest_1">
                        <form id="loginForm" action="${ pageContext.servletContext.contextPath }/admin/sales/month?ownerNum=${ requestScope.ownerNum }&" method="get">
                        
                        <c:choose>
				    	<c:when test="${ !empty requestScope.searchValue }">
				    		<span class="months">
                            <select class="form" onchange="this.form.submit()"  id="searchValue" name="searchValue">
                                <option value="1" <c:if test="${requestScope.searchValue eq '1'}">selected</c:if>>1</option>
                                <option value="2" <c:if test="${requestScope.searchValue eq '2'}">selected</c:if>>2</option>
                                <option value="3" <c:if test="${requestScope.searchValue eq '3'}">selected</c:if>>3</option>
                                <option value="4" <c:if test="${requestScope.searchValue eq '4'}">selected</c:if>>4</option>
                                <option value="5" <c:if test="${requestScope.searchValue eq '5'}">selected</c:if>>5</option>
                                <option value="6" <c:if test="${requestScope.searchValue eq '6'}">selected</c:if>>6</option>
                                <option value="7" <c:if test="${requestScope.searchValue eq '7'}">selected</c:if>>7</option>
                                <option value="8" <c:if test="${requestScope.searchValue eq '8'}">selected</c:if>>8</option>
                                <option value="9" <c:if test="${requestScope.searchValue eq '9'}">selected</c:if>>9</option>
                                <option value="10" <c:if test="${requestScope.searchValue eq '10'}">selected</c:if>>10</option>
                                <option value="11" <c:if test="${requestScope.searchValue eq '11'}">selected</c:if>>11</option>
                                <option value="12" <c:if test="${requestScope.searchValue eq '12'}">selected</c:if>>12</option>
                              </select>
                            </span>
                            월
                            </form>
                        </c:when>
                        <c:otherwise>
                        <span class="months">
                            <select class="form"  onchange="this.form.submit()" id="searchValue" name="searchValue">
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
                            </span>
                            월
                            </form>
                        </c:otherwise>
                        </c:choose>
                        </th>
                        <th class="section_contest section_contest_2">일자</th>
                        <th class="section_contest section_contest_3">총 주문건수</th>
                        <th class="section_contest section_contest_4">일별 판매금액</th>
                    </tr>
                </thead>
                <tbody>

                    <tr>
                        <td class="section_contest_first section_contest_1">-</td>
                        <td class="section_contest_first section_contest_2">_월 1일</td>
                        <td class="section_contest_first section_contest_3">11건</td>
                        <td class="section_contest_first section_contest_4">1000000원</td>
                    </tr>

                    <tr>
                        <td class="section_contest_first section_contest_1">-</td>
                        <td class="section_contest_first section_contest_2">_월 3일</td>
                        <td class="section_contest_first section_contest_3">11건</td>
                        <td class="section_contest_first section_contest_4">1000000원</td>
                    </tr>
                    <tr>
                        <td class="section_contest_first section_contest_1">-</td>
                        <td class="section_contest_first section_contest_2">_월 5일</td>
                        <td class="section_contest_first section_contest_3">11건</td>
                        <td class="section_contest_first section_contest_4">1000000원</td>
                    </tr>

                    <tr>
                        <td class="section_contest_first section_contest_1">-</td>
                        <td class="section_contest_first section_contest_2">_월 7일</td>
                        <td class="section_contest_first section_contest_3">11건</td>
                        <td class="section_contest_first section_contest_4">1000000원</td>
                    </tr>

                    <tr>
                        <td class="section_contest_first section_contest_1">-</td>
                        <td class="section_contest_first section_contest_2">_월 9일</td>
                        <td class="section_contest_first section_contest_3">11건</td>
                        <td class="section_contest_first section_contest_4">1000000원</td>
                    </tr>

                    <tr>
                        <td class="section_contest_first section_contest_1">-</td>
                        <td class="section_contest_first section_contest_2">_월 11일</td>
                        <td class="section_contest_first section_contest_3">11건</td>
                        <td class="section_contest_first section_contest_4">1000000원</td>
                    </tr>
                    
                </tbody>
            </table>
        <!-- </div> -->

            <div class="center clearfix">
                <div class="button button_space">1</div>
                <div class="button button_space">2</div>
                <div class="button button_space">3</div>
                <div class="button button_space">4</div>
                <div class="button">5</div>
                <p class="total">-월달 총 [---,---,---]원<br>판매 하셨습니다.</p>
            </div>
            
        </div>
    </section>

    <footer>
        <address class="footer footer-text"> Copyright &copy; BABMOKJA All Right Reserved.</address>
    </footer>
    
    <script>

    </script>
</body>
</html>