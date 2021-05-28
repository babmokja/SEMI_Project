// 메뉴담기모달 떠야함
function PopUp1(check) {
	var pop1 = document.querySelector(".bg");
	var pop2 = check.parentElement.parentElement.nextElementSibling.nextElementSibling;

	pop1.style.display = 'block';
	pop2.style.display = 'block';
	document.querySelector(".spinner").value = "1";
}

// 시간 선택하는 주문 모달 끄기
function reservePopup(check) {
	var pop1 = document.querySelector(".bg");
	var pop2 = document.querySelector(".medal");

	pop1.style.display = 'none';
	pop2.style.display = 'none';

}

// 주문표에 추가
function makeTable1(check) {

	var menuName = check.parentElement.children[2].innerText;
	var price = Number.parseInt(check.parentElement.children[3].children[0].innerText);

	var cnt = 1;
	var menuCode = Number.parseInt(check.parentElement.children[6].innerText);

	if (document.getElementsByClassName('maketable')[0].innerHTML == "") {

		// table element 찾기
		var table = document.getElementsByClassName('maketable')[0];
		saveTest = document.getElementsByClassName('maketable')[0];
		// 새 행(Row) 추가
		var addmenu = table.insertRow(0);
		addmenu.classList.add('insert_menu1');
		var addmenu2 = table.insertRow(1);
		addmenu2.classList.add('insert_menu1_desc');

		// 새 행(Row)에 Cell 추가
		var newCell1 = addmenu.insertCell(0);
		newCell1.colSpan = 5;
		var newCell2 = addmenu2.insertCell(0);
		var newCell3 = addmenu2.insertCell(1);
		var newCell4 = addmenu2.insertCell(2);
		var newCell5 = addmenu2.insertCell(3);
		var newCell6 = addmenu2.insertCell(4);
		newCell5.classList.add('menucount1');

		// Cell에 텍스트 추가
		newCell1.innerText = menuName;
		newCell2.innerText = '가격';
		newCell3.innerText = price;
		newCell4.innerText = '개수';
		newCell5.innerText = cnt;
		newCell6.innerText = menuCode;

		newCell1.setAttribute('name', 'menuName');
		newCell3.setAttribute('name',  'menuPrice');
		newCell5.setAttribute('name',  'menuCnt');
		newCell6.setAttribute('name', 'menuCode');
		newCell6.setAttribute('style',  'display: none;');

	} else {

		var tdTest = document.getElementsByClassName('maketable')[0].getElementsByTagName('td');

		for (var i = 0; i < tdTest.length - 1; i++)  {
			if (tdTest[i].innerText == menuName) {
				console.log(tdTest[i].innerText);
				var cnt = Number(tdTest[i   + 4].innerText);

				tdTest[i + 4].innerHTML = cnt + 1;
				break;
			}

		}
		var check1 = 0;
		for  (var i = 0; i < tdTest.length - 1; i++) {
			if  (tdTest[i].innerText != menuName) {
				check1++;

			}
		}
		console.log("check카운트 : " + check1);

		if (check1 == tdTest.length - 1)  {
			// table element 찾기
			var table = document.getElementsByClassName('maketable')[0];

			// 새 행(Row) 추가
			var addmenu = table.insertRow(0);
			addmenu.classList.add('insert_menu1');
			var addmenu2 = table.insertRow(1);
			addmenu2.classList.add('insert_menu1_desc');

			// 새 행(Row)에 Cell 추가
			var newCell1 = addmenu.insertCell(0);
			newCell1.colSpan = 5;
			var newCell2 = addmenu2.insertCell(0);
			var newCell3 = addmenu2.insertCell(1);
			var newCell4 = addmenu2.insertCell(2);
			var newCell5 = addmenu2.insertCell(3);
			var newCell6 = addmenu2.insertCell(4);
			newCell5.classList.add('menucount1');

			// Cell에 텍스트 추가
			newCell1.innerText = menuName;
			newCell2.innerText = '가격';
			newCell3.innerText = price;
			newCell4.innerText = '개수';
			newCell5.innerText = cnt;
			newCell6.innerText = menuCode;

			newCell1.setAttribute('name', 'menuName');
			newCell3.setAttribute('name',  'menuPrice');
			newCell5.setAttribute('name',  'menuCnt');
			newCell6.setAttribute('name', 'menuCode');
			newCell6.setAttribute('style',  'display: none;');
		}

	}

	var pop1 = document.querySelector(".bg");
	var pop2 = check.parentElement;

	pop1.style.display = 'none';
	pop2.style.display = 'none';

}

// 메뉴담기 모달 끄기
function cancel1(check) {

	var pop1 = document.querySelector(".bg");
	var pop2 = check.parentElement;

	pop1.style.display = 'none';
	pop2.style.display = 'none';
}

// 메뉴 빼기
function del1(check) {

	var makeTableArea = document.getElementsByClassName('maketable')[0];

	if (makeTableArea.innerHTML != "") {

		var tdCnt = makeTableArea.getElementsByTagName('td');
		var menuListLength = document.getElementsByClassName('menu01').length;

		for (var i = 0; i < tdCnt.length - 1; i++) {
			if (tdCnt[i].innerText == check.parentElement.parentElement.getElementsByClassName("menu1")[0].innerText) {
				console.log(tdCnt[i].innerText);
				console.log(tdCnt[i].parentElement.nextElementSibling);
				console.log('가격 : ' + tdCnt[i].parentElement.nextElementSibling.childNodes[1].innerText);
				console.log('개수 : ' + tdCnt[i].parentElement.nextElementSibling.childNodes[3].innerText);

				var menuName = tdCnt[i].innerText;
				var savePrice = tdCnt[i].parentElement.nextElementSibling.childNodes[1].innerText;
				var saveCount = tdCnt[i].parentElement.nextElementSibling.childNodes[3].innerText;
				if (saveCount > 0)  {

					tdCnt[i].parentElement.remove();
					tdCnt[i].parentElement.remove();
					if (saveCount > 1) {

						// 새 행(Row) 추가
						var addmenu = document.getElementsByClassName('maketable')[0].insertRow(0);
						addmenu.classList.add('insert_menu1');
						var addmenu2 = document.getElementsByClassName('maketable')[0].insertRow(1);
						addmenu2.classList.add('insert_menu1_desc');

						// 새 행(Row)에 Cell 추가
						var newCell1 = addmenu.insertCell(0);
						newCell1.colSpan = 5;
						var newCell2 = addmenu2.insertCell(0);
						var newCell3 = addmenu2.insertCell(1);
						var newCell4 = addmenu2.insertCell(2);
						var newCell5 = addmenu2.insertCell(3);
						var newCell6 = addmenu2.insertCell(4);
						newCell5.classList.add('menucount1');


						// Cell에 텍스트 추가
						newCell1.innerText = menuName;
						newCell2.innerText = '가격';
						newCell3.innerText = savePrice;
						newCell4.innerText = '개수';
						newCell5.innerText = saveCount - 1;
						newCell6.innerText = menuCode;


						newCell1.setAttribute('name', 'menuName');
						newCell3.setAttribute('name', 'menuPrice');
						newCell5.setAttribute('name', 'menuCnt');
						newCell6.setAttribute('name', 'menuCode');
						newCell6.setAttribute('style', 'display: none;');
					}
				} else {
					tdCnt[i].parentElement.remove();
					tdCnt[i].parentElement.remove();
				}

			}

		}

	}

}


// 시간 선택하는 모달 띄우기
function reservePopUp(check) {
	var pop1 = document.querySelector(".bg");
	var pop2 = document.querySelector(".medal");

	pop1.style.display = 'block';
	pop2.style.display = 'block';
}