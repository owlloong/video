<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div id="barChart" style="width: 600px;height:400px;"></div>
	<script type="text/javascript">
	var myChart = echarts.init(document.getElementById('barChart'));
	var chartdata=

	option = {
	    color: ['#3398DB'],
	    tooltip : {
	        trigger: 'axis',
	        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
	            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
	        }
	    },
	    grid: {
	        left: '3%',
	        right: '4%',
	        bottom: '3%',
	        containLabel: true
	    },
	    xAxis : [
	        {
	            type : 'category',
	            data : ['${HotVideoCount[0].videoName}', '${HotVideoCount[1].videoName}', 
	            	'${HotVideoCount[2].videoName}', '${HotVideoCount[3].videoName}', 
	            	'${HotVideoCount[4].videoName}', '${HotVideoCount[5].videoName}'],
	            axisTick: {
	                alignWithLabel: true
	            }
	        }
	    ],
	    yAxis : [
	        {
	            type : 'value'
	        }
	    ],
	    series : [
	        {
	            name:'播放量',
	            type:'bar',
	            barWidth: '60%',
	            data:[${HotVideoCount[0].count},${HotVideoCount[1].count},
	            	${HotVideoCount[2].count},${HotVideoCount[3].count},
	            	${HotVideoCount[4].count},${HotVideoCount[5].count}]
	        }
	    ]
	};

	myChart.setOption(option);
	</script>
</body>
</html>