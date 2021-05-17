<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="resources/css/admin/admin_Customer_Secret_Board.css">
    <link rel="stylesheet" href="resources/css/admin/main1.css">
    <link rel="stylesheet" href="resources/css/admin/bootstrap.min.css">
    <title>Document</title>

    <script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body>
    <aside class="aside">
        <div class="aside_top2">BABMOKJA </div>
        <div class="aside_top">고객 게시판 </div>
        <div class="button01">고객</div>
        <div class="button02"><a href="admin_Owner_Secret_Board.html">업주</a></div>
    </aside>
  
    <section class="section">

        <div class="row">
            <span class="col-2 menu-item">
                <a href="../관리자/index-order.html" class="link-dark"><img src="resources/image/admin/item1.svg" />
                  &nbsp;&nbsp;&nbsp;주문확인   </a>
              </span>
              <span class="col-2 menu-item">
                <a href="../관리자/index-user.html" class="link-dark"><img src="resources/image/admin/item2.png" />
                  &nbsp;&nbsp;&nbsp; 고객관리</a>
              </span>
              <span class="col-2 menu-item">
                <a href="../관리자/index-owner.html" class="link-dark"><img src="resources/image/admin/item3.png" />
                
                  &nbsp;&nbsp;&nbsp; 업소관리</a> 
              </span>
            <span class="col-2 menu-item">
              <img src="resources/image/admin/item4.svg" />
              &nbsp;&nbsp;&nbsp;  <a href="admin_Customer_Secret_Board.html">게시판</a>
            </span>
        </div>

        <div class="section_top">
 
        <div class="top-1">
        
            <div class="top">
                말머리,제목,글쓴이
                <select class="form-select" >
                  <option selected>카테고리 선택</option>
                  <option value="1">말머리</option>
                  <option value="2">제목</option>
                  <option value="3">글쓴이</option>
                </select>
              </div>
              <div class="top">
                말머리,제목,글쓴이 입력
                <input class="form-control" type="text" >
                
              </div>
              
              <div class="top">
                <br>
                <button type="button" class="btn btn-outline-secondary">검색하기</button>
              </div>
        </div>

            <table> 
                <thead>
                    <tr class="contest_top">
                        <th class="section_contest section_contest_1">번호</th>
                        <th class="section_contest section_contest_2">말머리</th>
                        <th class="section_contest section_contest_3">제목</th>
                        <th class="section_contest section_contest_4">글쓴이</th>
                        <th class="section_contest section_contest_5">작성일</th>
                    </tr>
                </thead>
                <tbody>

                    <tr>
                        <td class="section_contest_first section_contest_1">1</td>
                        <td class="section_contest_first section_contest_2">말머리</td>
                        <td class="section_contest_first section_contest_3"><a href="admin_Customer_SecretWrite_Board.html">글제목11</a></td>
                        <td class="section_contest_first section_contest_4">00</td>
                        <td class="section_contest_first section_contest_5">2021-01-01</td>
                    </tr>

                    <tr>
                        <td class="section_contest_two section_contest_1">2</td>
                        <td class="section_contest_two section_contest_2">말머리</td>
                        <td class="section_contest_two section_contest_3">글제목22</td>
                        <td class="section_contest_two section_contest_4">00</td>
                        <td class="section_contest_two section_contest_5">2021-01-02</td>
                    </tr>

                    <tr>
                        <td class="section_contest_two section_contest_1">3</td>
                        <td class="section_contest_two section_contest_2">말머리</td>
                        <td class="section_contest_two section_contest_3">글제목33</td>
                        <td class="section_contest_two section_contest_4">00</td>
                        <td class="section_contest_two section_contest_5">2021-01-03</td>
                    </tr>

                    <tr>
                        <td class="section_contest_two section_contest_1">4</td>
                        <td class="section_contest_two section_contest_2">말머리</td>
                        <td class="section_contest_two section_contest_3">글제목44</td>
                        <td class="section_contest_two section_contest_4">00</td>
                        <td class="section_contest_two section_contest_5">2021-01-04</td>
                    </tr>

                    <tr>
                        <td class="section_contest_two section_contest_1">5</td>
                        <td class="section_contest_two section_contest_2">말머리</td>
                        <td class="section_contest_two section_contest_3">글제목55</td>
                        <td class="section_contest_two section_contest_4">00</td>
                        <td class="section_contest_two section_contest_5">2021-01-05</td>
                    </tr>

                    <tr>
                        <td class="section_contest_two section_contest_1">6</td>
                        <td class="section_contest_two section_contest_2">말머리</td>
                        <td class="section_contest_two section_contest_3">글제목66</td>
                        <td class="section_contest_two section_contest_4">00</td>
                        <td class="section_contest_two section_contest_5">2021-01-06</td>
                    </tr>

                    <tr>
                        <td class="section_contest_two section_contest_1">7</td>
                        <td class="section_contest_two section_contest_2">말머리</td>
                        <td class="section_contest_two section_contest_3">글제목77</td>
                        <td class="section_contest_two section_contest_4">00</td>
                        <td class="section_contest_two section_contest_5">2021-01-07</td>
                    </tr>
                    
                </tbody>
            </table>

            <div class="center clearfix">
                <div class="button button_space">1</div>
                <div class="button button_space">2</div>
                <div class="button button_space">3</div>
                <div class="button button_space">4</div>
                <div class="button">5</div>
            </div>
            
        </div>
    </section>

    <footer>
        <address class="footer footer-text"> Copyright &copy; BABMOKJA All Right Reserved.</address>
    </footer>
    
</body>
</html>