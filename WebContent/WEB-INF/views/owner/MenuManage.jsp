<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>주문 내역</title>
  
  <link href="../css/bootstrap.min.css" rel="stylesheet">
  <link href="../css/main.css" rel="stylesheet">
  
  <style>

    td {
      position: relative;
    }
  </style>
  
  <body>
    
    <div class="container-fluid root">
      <div class="row main">
        <nav class="col-md-2 d-none d-md-block bg-yellow sidebar sidebar-bapmakja">
          <div class="sidebar-sticky">
            <ul class="nav flex-column">
              <li class="nav-item logo"><a href="../../front_semi_store/views/main_store.html">
                bakmokja</a>
              </li>
              <li class="nav-item title">
                주문 내역  
              </li>
            </ul>
            
            
          </div>
        </nav>
        
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
          
          <!-- <div class="row">
            <span class="col-2 menu-item menu-item-selected  ">
              <img src="../images/item1.svg" />
              &nbsp;&nbsp;&nbsp; 주문확인
            </span>
            <span class="col-2 menu-item  ">
              <a href="./index-user.html" class="link-dark"><img src="../images/item2.png" />
                &nbsp;&nbsp;&nbsp; 고객관리</a>
            </span>
            <span class="col-2 menu-item">
              <a href="./index-owner.html" class="link-dark"><img src="../images/item3.png" />
              
                &nbsp;&nbsp;&nbsp; 업소관리</a> 
            </span>
            <span class="col-2 menu-item">
              <a href="../admin/admin_Customer_Secret_Board.html" class="link-dark"><img src="../images/item4.svg" />
                &nbsp;&nbsp;&nbsp;  게시판</a>
            </span>
          </div> -->

          <div class="row">
            <span class="col-2 menu-item menu-item-selected">
                <img src="../images/item1.svg" />
                &nbsp;&nbsp;&nbsp;주문확인
              </span>
              <span class="col-2 menu-item  ">
                <img src="../images/item2.png" />
                &nbsp;&nbsp;&nbsp; 내 정보관리
              </span>
              <span class="col-2 menu-item">
                <img src="../images/item3.png" />
                
                &nbsp;&nbsp;&nbsp; <a class="text-dark" href="../../semi_board_sales/company/Owner_Sales_day_Board.html">내 업소 관리</a>
              </span>
              <span class="col-2 menu-item">
                <img class="img-fluid" src="../../front_semi_store/image/PC주문관리.png" width="40px" height="40px" />
                &nbsp;&nbsp;&nbsp;<a>pc주문현황</a>
              </span>
  
              <span class="col-2 menu-item">
                  <span class="imagesize"><img src="../images/item4.svg" /></span>
                  &nbsp;&nbsp;&nbsp; <a class="text-dark" href="../../semi_board/company/Owner_Comment_Board.html">리뷰관리</a>
                </span>
  
                <span class="col-2 menu-item">
                  <img src="../images/item4.svg" />
                  &nbsp;&nbsp;&nbsp; <a class="text-dark" href="../../semi_board/company/Owner_Seggestion_Board.html">1:1 문의하기</a>
                </span>
        </div>
          
          <br>
          <br>
          <br>
          
          <div class="row">
            <div class="table-responsive col-10 offset-md-1">
              
             
              <br>
              <table class="table  table-sm  text-center">
                <thead>
                  <tr>
                    <th>메뉴</th>
                    <th>메뉴가격</th>
                    <th>상태</th>
                    <th>메뉴설명</th>
                    <th>사진</th>
                    <th></th>

                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td><input class="form-control" type="text" value="갈릭마왕(한마리)"></td>
                    <td><input type="text"   class="form-control text-right"  style="display:inline-block;width:200px;" value="16000"> 원</td>
                    <td><select class="form-select" >
                      <option >판매여부 선택</option>
                      <option value="1" selected>판매중</option>
                      <option value="2" >품절</option>
                    </select></td>
                    <td><input class="form-control" type="text" value="알싸하고 달달한 마늘로 완성된 맛의 끝판왕!" ></td>
                    <td><a href="#"><img src="../images/pic.png" /></a></td>
                    <td><a href="#"><img src="../images/delete.png" /></a></td>
                  </tr>
                  <tr>
                    <td><input class="form-control" type="text"  value="갈비천왕(순살)"></td>
                    <td><input type="text"   class="form-control text-right"  style="display:inline-block;width:200px;" value="18000"> 원</td>
                    <td><select class="form-select" >
                      <option >판매여부 선택</option>
                      <option value="1">판매중</option>
                      <option value="2" selected>품절</option>
                    </select></td>
                    <td><input class="form-control" type="text" value="달콤한 갈비양념이 제대로!치킨의 새로운 지존"></td>
                    <td><a href="#"><img src="../images/pic.png" /></a></td>
                    <td><a href="#"><img src="../images/delete.png" /></a></td>
                  </tr>
                  <tr>
                    <td><input class="form-control" type="text" ></td>
                    <td><input type="text"   class="form-control text-right"  style="display:inline-block;width:200px;"> 원</td>
                    <td><select class="form-select" >
                      <option selected>판매여부 선택</option>
                      <option value="1">판매중</option>
                      <option value="2" >품절</option>
                    </select></td>
                    <td><input class="form-control" type="text" ></td>
                    <td><a href="#"><img src="../images/pic.png" /></a></td>
                    <td><a href="#"><img src="../images/delete.png" /></a></td>
                  </tr>
                  <tr>
                    <td><input class="form-control" type="text" ></td>
                    <td><input type="text"   class="form-control text-right"  style="display:inline-block;width:200px;"> 원</td>
                    <td><select class="form-select" >
                      <option selected>판매여부 선택</option>
                      <option value="1">판매중</option>
                      <option value="2" >품절</option>
                    </select></td>
                    <td><input class="form-control" type="text" ></td>
                    <td><a href="#"><img src="../images/pic.png" /></a></td>
                    <td><a href="#"><img src="../images/delete.png" /></a></td>
                  </tr>
                  <tr>
                    <td><input class="form-control" type="text" ></td>
                    <td><input type="text"   class="form-control text-right"  style="display:inline-block;width:200px;"> 원</td>
                    <td><select class="form-select" >
                      <option selected>판매여부 선택</option>
                      <option value="1">판매중</option>
                      <option value="2" >품절</option>
                    </select></td>
                    <td><input class="form-control" type="text" ></td>
                    <td><a href="#"><img src="../images/pic.png" /></a></td>
                    <td><a href="#"><img src="../images/delete.png" /></a></td>
                  </tr>
                  <tr>
                    <td><input class="form-control" type="text" ></td>
                    <td><input type="text"   class="form-control text-right"  style="display:inline-block;width:200px;"> 원</td>
                    <td><select class="form-select" >
                      <option selected>판매여부 선택</option>
                      <option value="1">판매중</option>
                      <option value="2" >품절</option>
                    </select></td>
                    <td><input class="form-control" type="text" ></td>
                    <td><a href="#"><img src="../images/pic.png" /></a></td>
                    <td><a href="#"><img src="../images/delete.png" /></a></td>
                  </tr>
                  <tr>
                    <td><input class="form-control" type="text" ></td>
                    <td><input type="text"   class="form-control text-right"  style="display:inline-block;width:200px;"> 원</td>
                    <td><select class="form-select" >
                      <option selected>판매여부 선택</option>
                      <option value="1">판매중</option>
                      <option value="2" >품절</option>
                    </select></td>
                    <td><input class="form-control" type="text" ></td>
                    <td><a href="#"><img src="../images/pic.png" /></a></td>
                    <td><a href="#"><img src="../images/delete.png" /></a></td>
                  </tr>
                  <tr>
                    <td><input class="form-control" type="text" ></td>
                    <td><input type="text"   class="form-control text-right"  style="display:inline-block;width:200px;"> 원</td>
                    <td><select class="form-select" >
                      <option selected>판매여부 선택</option>
                      <option value="1">판매중</option>
                      <option value="2" >품절</option>
                    </select></td>
                    <td><input class="form-control" type="text" ></td>
                    <td><a href="#"><img src="../images/pic.png" /></a></td>
                    <td><a href="#"><img src="../images/delete.png" /></a></td>
                  </tr>
                  <tr>
                    <td><input class="form-control" type="text" ></td>
                    <td><input type="text"   class="form-control text-right"  style="display:inline-block;width:200px;"> 원</td>
                    <td><select class="form-select" >
                      <option selected>판매여부 선택</option>
                      <option value="1">판매중</option>
                      <option value="2" >품절</option>
                    </select></td>
                    <td><input class="form-control" type="text" ></td>
                    <td><a href="#"><img src="../images/pic.png" /></a></td>
                    <td><a href="#"><img src="../images/delete.png" /></a></td>
                  </tr>
                  <tr>
                    <td><input class="form-control" type="text" ></td>
                    <td><input type="text"   class="form-control text-right"  style="display:inline-block;width:200px;"> 원</td>
                    <td><select class="form-select" >
                      <option selected>판매여부 선택</option>
                      <option value="1">판매중</option>
                      <option value="2" >품절</option>
                    </select></td>
                    <td><input class="form-control" type="text" ></td>
                    <td><a href="#"><img src="../images/pic.png" /></a></td>
                    <td><a href="#"><img src="../images/delete.png" /></a></td>
                  </tr>
                  <tr>
                    <td><input class="form-control" type="text" ></td>
                    <td><input type="text"   class="form-control text-right"  style="display:inline-block;width:200px;"> 원</td>
                    <td><select class="form-select" >
                      <option selected>판매여부 선택</option>
                      <option value="1">판매중</option>
                      <option value="2" >품절</option>
                    </select></td>
                    <td><input class="form-control" type="text" ></td>
                    <td><a href="#"><img src="../images/pic.png" /></a></td>
                    <td><a href="#"><img src="../images/delete.png" /></a></td>
                  </tr>
                  <tr>
                    <td><input class="form-control" type="text" ></td>
                    <td><input type="text"   class="form-control text-right"  style="display:inline-block;width:200px;"> 원</td>
                    <td><select class="form-select" >
                      <option selected>판매여부 선택</option>
                      <option value="1">판매중</option>
                      <option value="2" >품절</option>
                    </select></td>
                    <td><input class="form-control" type="text" ></td>
                    <td><a href="#"><img src="../images/pic.png" /></a></td>
                    <td><a href="#"><img src="../images/delete.png" /></a></td>
                  </tr>
                  
                  
                </tbody>
              </table>
              

              
            </div>
          </div>
          <div class="row">
            <span class="col-10"></span>
            
            <span class="col-1"><a href="#"><img src="../images/backpage.png" /></a></span>
          </div>
        </main>
        
      </div>
      
      <div class="footer text-right align-middle" style="background-color:#EF9309;">
        <a class="text-dark footer-text text-decoration-none">Copyright &copy; BABMOKJA All Right Reserved.&nbsp;</a>
      </div>
      
    </div>
    
    
  </body></html>