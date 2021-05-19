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
	<div id="pieChart" style="width: 600px;height:400px;"></div>
	<script type="text/javascript">
	var myChart = echarts.init(document.getElementById('pieChart'));
	var chartdata=
	option = {
		    title : {
		        text: '各分类视频数量统计',
		        subtext: 'cilicili',
		        x:'center'
		    },
		    tooltip : {
		        trigger: 'item',
		        formatter: "{a} <br/>{b} : {c} ({d}%)"
		    },
		    legend: {
		        orient: 'vertical',
		        left: 'left',
		        data: ['动画','艺术','科技','游戏','生活','影视']
		    },
		    series : [
		        {
		            name: '视频数量',
		            type: 'pie',
		            radius : '55%',
		            center: ['50%', '60%'],
		            data:[
		                {value:${CategoryList[0].count}, name:'${CategoryList[0].categoryName}'},
		                {value:${CategoryList[1].count}, name:'${CategoryList[1].categoryName}'},
		                {value:${CategoryList[2].count}, name:'${CategoryList[2].categoryName}'},
		                {value:${CategoryList[3].count}, name:'${CategoryList[3].categoryName}'},
		                {value:${CategoryList[4].count}, name:'${CategoryList[4].categoryName}'},
		                {value:${CategoryList[5].count}, name:'${CategoryList[5].categoryName}'}
		            ],
		            itemStyle: {
		                emphasis: {
		                    shadowBlur: 10,
		                    shadowOffsetX: 0,
		                    shadowColor: 'rgba(0, 0, 0, 0.5)'
		                }
		            }
		        }
		    ]
		};
	myChart.setOption(option);
	</script>
</body>
</html>