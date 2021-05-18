<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/SEMI_Project/resources/css/admin/admin_Sales_day_Board.css">
    <link rel="stylesheet" href="/SEMI_Project/resources/css/admin/main2.css">
    <link rel="stylesheet" href="/SEMI_Project/resources/css/admin/bootstrap.min.css">
    <title>Document</title>

</head>
<body>
    <aside class="aside">
        <div class="aside_top2">BABMOKJA </div>
        <div class="aside_top">일별 매출 관리 </div>
    </aside>

    <section class="section">

        <div class="row">
            <span class="col-2 menu-item">
                <a href="${pageContext.servletContext.contextPath}/admin/order" class="link-dark"><img src="/SEMI_Project/resources/image/admin/item1.svg" />
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
                <a href="${pageContext.servletContext.contextPath}/admin/customer/board" class="link-dark"><img src="/SEMI_Project/resources/image/admin/item4.svg" />
                  &nbsp;&nbsp;&nbsp;  게시판</a>
              </span>
        </div>

        <div class="section_top">
            
       
        <div class="button01">오늘</div>
        <div class="button02"><a href="${pageContext.servletContext.contextPath}/admin/sales/month">월별</a></div>

       
        <div class="space"></div>


            <table> 
                <thead>
                    <tr>
                        <th class="section_contest section_contest_1">주문번호</th>
                        <th class="section_contest section_contest_2">주문시간</th>
                        <th class="section_contest section_contest_3">서비스 유형</th>
                        <th class="section_contest section_contest_4">결제금액</th>
                    </tr>
                </thead>
                <tbody>

                    <tr>
                        <td class="section_contest_first section_contest_1">1</td>
                        <td class="section_contest_first section_contest_2">20:00</td>
                        <td class="section_contest_first section_contest_3">픽업</td>
                        <td class="section_contest_first section_contest_4">16,000원</td>
                    </tr>

                    <tr>
                        <td class="section_contest_first section_contest_1">2</td>
                        <td class="section_contest_first section_contest_2">20:30</td>
                        <td class="section_contest_first section_contest_3">배달</td>
                        <td class="section_contest_first section_contest_4">10,000원</td>
                    </tr>
                    <tr>
                        <td class="section_contest_first section_contest_1">3</td>
                        <td class="section_contest_first section_contest_2">21:00</td>
                        <td class="section_contest_first section_contest_3">픽업</td>
                        <td class="section_contest_first section_contest_4">15,000원</td>
                    </tr>

                    <tr>
                        <td class="section_contest_first section_contest_1">4</td>
                        <td class="section_contest_first section_contest_2">21:30</td>
                        <td class="section_contest_first section_contest_3">배달</td>
                        <td class="section_contest_first section_contest_4">18,000원</td>
                    </tr>

                    <tr>
                        <td class="section_contest_first section_contest_1">5</td>
                        <td class="section_contest_first section_contest_2">22:00</td>
                        <td class="section_contest_first section_contest_3">픽업</td>
                        <td class="section_contest_first section_contest_4">19,000원</td>
                    </tr>

                    <tr>
                        <td class="section_contest_first section_contest_1">6</td>
                        <td class="section_contest_first section_contest_2">20:00</td>
                        <td class="section_contest_first section_contest_3">배달</td>
                        <td class="section_contest_first section_contest_4">13,000원</td>
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
                <p class="total">오늘 총 [---,---,---]원<br>판매 하셨습니다.</p>
            </div>
            
        </div>
    </section>

    <footer>
        <address class="footer footer-text"> Copyright &copy; BABMOKJA All Right Reserved.</address>
    </footer>
</body>
</html>