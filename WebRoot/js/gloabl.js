/**
 * Created by WHB on 2016/7/14.
 */

(function($,doc,win,unde){
	var menu = $(".menu>li");
	menu.hover(
        function(){
            $(this).find(".child").slideDown();

        },
        function(){
            $(this).find(".child").slideUp();
        });
	menu.hover(
	        function(){
	            $(this).find(".child1").slideDown();

	        },
	        function(){
	            $(this).find(".child1").slideUp();
	        });
	menu.hover(
	        function(){
	            $(this).find(".child2").slideDown();

	        },
	        function(){
	            $(this).find(".child2").slideUp();
	        });
    $(".slides-box").height($("body").height()-90);
})(jQuery,document,window,undefined)

