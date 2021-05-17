function PopUp1(){
    var pop1 = document.querySelector(".bg");
    var pop2 = document.querySelector(".menuwrap");

    
    pop1.style.display='block';
    pop2.style.display='block';
    document.querySelector(".spinner").value="1";
    
    
}
function PopUp2(){
    var pop1 = document.querySelector(".bg2");
    var pop2 = document.querySelector(".menuwrap2");

    document.querySelector(".spinner2").value ="1";

    pop1.style.display='block';
    pop2.style.display='block';

    
}
function PopUp3(){
    var pop1 = document.querySelector(".bg3");
    var pop2 = document.querySelector(".menuwrap3");

    document.querySelector(".spinner3").value ="1";

    pop1.style.display='block';
    pop2.style.display='block';

}

function reservePopup(){
  var pop1 = document.querySelector(".bg");
  var pop2 = document.querySelector(".medal");

  
  pop1.style.display='none';
  pop2.style.display='none';
  
  }
// function makeTable() {
//     document.getElementsByClassName("menuwrap").style.display = 'none';
//     document.querySelector(".bg").style.display = 'none';

//     var m =document.getElementById("maketable");

//     // m.write("<table border= 1px solid black>");
//     // m.write("<tr height = '50px'>");
//     // m.write("<td width = '50px'></td>");
//     // m.write("</tr>");
//     // m.write("</table>");
//     "<tr>"
//     <td colspan="4" ><div class="allmenu"></div></td>
//     </tr>
//     <tr>
//         <td>가격</td>
//         <td><div class="menuprice"></div></td>
//         <td>개수</td>
//         <td><div class="menucount"></div></td>
//     </tr>";

function makeTable1() {
  if(!document.getElementById("insert_menu1")){
    // table element 찾기
    var table = document.getElementById('maketable');
    
    // 새 행(Row) 추가
    var addmenu = table.insertRow(0);
    addmenu.id = "insert_menu1";
    // addmenu.setAttribute("id","insert_menu1",0);
    var addmenu2 = table.insertRow(1);
    // addmenu2.setAttribute("id","insert_menu1_desc",0);
    addmenu2.id="insert_menu1_desc";

    // 새 행(Row)에 Cell 추가
    var newCell1 = addmenu.insertCell(0);
    newCell1.colSpan = 4;
    var newCell2 = addmenu2.insertCell(0);
    var newCell3 = addmenu2.insertCell(1);
    var newCell4 = addmenu2.insertCell(2);
    var newCell5 = addmenu2.insertCell(3);
    newCell5.id = "menucount1";
    
    // Cell에 텍스트 추가
    newCell1.innerText = document.getElementById("menu01").innerText;
    newCell2.innerText = '가격';
    newCell3.innerText = document.getElementById("price01").innerText;
    newCell4.innerText = '개수';
    newCell5.innerText = parseInt(document.querySelector(".spinner").value);
  } else{
    var k =document.getElementById("menucount1")
    k.innerHTML = parseInt(k.innerHTML) + 1;
  }
    
    var pop1 = document.querySelector(".bg");
    var pop2 = document.querySelector(".menuwrap");

    pop1.style.display='none';
    pop2.style.display='none';

  




  }


  function makeTable2() {
    if(!document.getElementById("insert_menu2")){

    // table element 찾기
    var table = document.getElementById('maketable');
    
    // 새 행(Row) 추가
    var addmenu = table.insertRow(0);
    addmenu.id = "insert_menu2";
    // addmenu.setAttribute("id","insert_menu2",0);
    var addmenu2 = table.insertRow(1);
    // addmenu2.setAttribute("id","insert_menu1_desc",0);
    addmenu2.id="insert_menu2_desc";

    // 새 행(Row)에 Cell 추가
    var newCell1 = addmenu.insertCell(0);
    newCell1.colSpan = 4;
    var newCell2 = addmenu2.insertCell(0);
    var newCell3 = addmenu2.insertCell(1);
    var newCell4 = addmenu2.insertCell(2);
    var newCell5 = addmenu2.insertCell(3);
    newCell5.id = "menucount2";

    // Cell에 텍스트 추가
    newCell1.innerText = document.getElementById("menu02").innerText;
    newCell2.innerText = '가격';
    newCell3.innerText = document.getElementById("price02").innerText;
    newCell4.innerText = '개수';
    newCell5.innerText = parseInt(document.querySelector(".spinner2").value);
  } else{
    var k =document.getElementById("menucount2")
    k.innerHTML = parseInt(k.innerHTML) + 1;
  }
    
    var pop1 = document.querySelector(".bg2");
    var pop2 = document.querySelector(".menuwrap2");

    pop1.style.display='none';
    pop2.style.display='none';




  }

  function makeTable3() {
    if(!document.getElementById("insert_menu3")){
    // table element 찾기
    var table = document.getElementById('maketable');
    
    // 새 행(Row) 추가
    var addmenu = table.insertRow(0);
    addmenu.id = "insert_menu3";
    // addmenu.setAttribute("id","insert_menu1",0);
    var addmenu2 = table.insertRow(1);
    // addmenu2.setAttribute("id","insert_menu1_desc",0);
    addmenu2.id="insert_menu3_desc";

    // 새 행(Row)에 Cell 추가
    var newCell1 = addmenu.insertCell(0);
    newCell1.colSpan = 4;
    var newCell2 = addmenu2.insertCell(0);
    var newCell3 = addmenu2.insertCell(1);
    var newCell4 = addmenu2.insertCell(2);
    var newCell5 = addmenu2.insertCell(3);
    newCell5.id = "menucount3";
    // Cell에 텍스트 추가
    newCell1.innerText = document.getElementById("menu03").innerText;
    newCell2.innerText = '가격';
    newCell3.innerText = document.getElementById("price03").innerText;
    newCell4.innerText = '개수';
    newCell5.innerText = parseInt(document.querySelector(".spinner3").value);
  } else{
    var k =document.getElementById("menucount3")
    k.innerHTML = parseInt(k.innerHTML) + 1;
  }
    
    var pop1 = document.querySelector(".bg3");
    var pop2 = document.querySelector(".menuwrap3");

    pop1.style.display='none';
    pop2.style.display='none';




  }

  function cancel1(){
   
       
    var pop1 = document.querySelector(".bg");
    var pop2 = document.querySelector(".menuwrap");

    pop1.style.display='none';
    pop2.style.display='none';
  }
    

  function cancel2(){
   

    var pop1 = document.querySelector(".bg2");
    var pop2 = document.querySelector(".menuwrap2");

    pop1.style.display='none';
    pop2.style.display='none';


}
  function cancel3(){
    
    var pop1 = document.querySelector(".bg3");
    var pop2 = document.querySelector(".menuwrap3");

    pop1.style.display='none';
    pop2.style.display='none';

}

function del1(){
  var k = document.getElementById("menucount1")
  if(k.innerHTML=="1"){
  // var tableRef = document.getElementById("insert_menu1");
  // var tableRef2 = document.getElementById("insert_menu1_desc");
  // tableRef.deleteRow(0);
  // tableRef2.deleteRow(0);
  document.getElementById("insert_menu1").remove();
  document.getElementById("insert_menu1_desc").remove();
} else { k.innerHTML = parseInt(k.innerHTML)-1;}

}
function del2(){
  var k = document.getElementById("menucount2")
if(k.innerHTML=="1"){
  // var tableRef = document.getElementById("insert_menu1");
  // var tableRef2 = document.getElementById("insert_menu1_desc");
  // tableRef.deleteRow(0);
  // tableRef2.deleteRow(0);
  document.getElementById("insert_menu2").remove();
  document.getElementById("insert_menu2_desc").remove();
} else { k.innerHTML = parseInt(k.innerHTML)-1;}

}
function del3(){
  var k = document.getElementById("menucount3")
    if(k.innerHTML=="1"){
  // var tableRef = document.getElementById("insert_menu1");
  // var tableRef2 = document.getElementById("insert_menu1_desc");
  // tableRef.deleteRow(0);
  // tableRef2.deleteRow(0);
  document.getElementById("insert_menu3").remove();
  document.getElementById("insert_menu3_desc").remove();
} else { k.innerHTML = parseInt(k.innerHTML)-1;}

}