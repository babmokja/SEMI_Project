
function show1(){
    var tab1 = document.getElementById("tab1");
    var tab2 = document.getElementById("tab2");
    var tab3 = document.getElementById("tab3");

        tab1.addEventListener('click',function(){
            document.getElementsByClassName("content-wrap")[0].style.display='block';
            document.getElementsByClassName("content-wrap")[1].style.display='none';
            document.getElementsByClassName("content-wrap")[2].style.display='none';
            
    })

}

function show2(){

    var tab1 = document.getElementById("tab1");
    var tab2 = document.getElementById("tab2");
    var tab3 = document.getElementById("tab3");
    // var style1 = document.getElementById("tab1").style.background ="white";

        tab2.addEventListener('click',function(){
            document.getElementsByClassName("content-wrap")[0].style.display='none';
            document.getElementsByClassName("content-wrap")[1].style.display = 'block';
            document.getElementsByClassName("content-wrap")[2].style.display = 'none';
            // this.style.background = '#ffcc00';
            // this.style.color = "red";

            })
        
        // tab1.style.offset();
        // tab2.style
}

function show3(){
    var tab1 = document.getElementById("tab1");
    var tab2 = document.getElementById("tab2");
    var tab3 = document.getElementById("tab3");

        tab3.addEventListener('click',function(){
            document.getElementsByClassName("content-wrap")[0].style.display='none';
            document.getElementsByClassName("content-wrap")[1].style.display = 'none';
            document.getElementsByClassName("content-wrap")[2].style.display = 'block';
            
        })
    
}




