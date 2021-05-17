$(document).ready(function(){
    $('.time_list > ul > li > a').click(function(){
        $(this).parent().css('background','gray').siblings().css('background','none');
    })

    $('.okbtn').click(function(){
$('.content-wrap > .content-info > div').css('');
$('.content-wrap > .content-info > div input ').prop('disabled',true);
    });
})