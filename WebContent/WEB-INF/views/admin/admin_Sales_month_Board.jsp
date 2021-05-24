<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                        <span class="months">
                            <select class="form" >
                                <option selected>-</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="3">4</option>
                                <option value="3">5</option>
                                <option value="3">6</option>
                                <option value="3">7</option>
                                <option value="3">8</option>
                                <option value="3">9</option>
                                <option value="3">10</option>
                                <option value="3">11</option>
                                <option value="3">12</option>
                              </select>
                            </span>
                        월
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
</body>
</html>