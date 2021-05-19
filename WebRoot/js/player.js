$(document).ready(function() {

    $("#leftBox li").mousemove(function() {
        var index = $(this).index();
        $(this).addClass("active");
        $(this).siblings("li").removeClass("active");
        $("#rightBox div").hide(); //一定要先全部隐藏 (第一个已经是隐藏了的 直接就点了第二个 第二出线 第一是要隐藏的

        $("#rightBox div").eq(index).show();
    });
    $("#rightBox div ul li").mouseover(function() {
        var html = $(this).html();
        $(this).addClass("active");
        $(this).siblings("li").removeClass("active");
        $(this).parent("ul").siblings("p").html(html);
        $(this).parent("ul").siblings("p").css("color", "white")

    })
});