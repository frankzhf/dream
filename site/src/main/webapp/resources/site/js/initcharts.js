/**
 * @param id 			id of the div for destroying
 */
function destroyChart(id){
	$('#'+id).highcharts().destroy();
}

/**
 * 
 * @param id		id of div
 * @param data
 */
function columnInit(id, data){
	var category = [];
	var series = [];
	$.each(data.data, function(i, e){
		category.push(e.key);
		series.push(eval(e.value));
	});
	var chart = new Highcharts.Chart({
		credits:	{
			enabled:false
		},
        chart: {
            type: 'column',
            renderTo: 	id,
            margin: [ 50, 50, 100, 80]
        },
        title: {
            text: data.label
        },
        xAxis: {
            categories: category,
            labels: {
                rotation: -45,
                align: 'right',
                style: {
                    fontSize: '13px',
                    fontFamily: 'Verdana, sans-serif'
                }
            }
        },
        yAxis: {
        	allowDecimals:	false,
            min: 0,
            title: {
                text: data.fieldName
            }
        },
        legend: {
            enabled: false
        },
        tooltip: {
            formatter: function() {
                return '<b>' + this.point.category + '</b>: ' + this.point.y;
            }
        },
        series: [{
            name: data.fieldName,
            data: series,
            dataLabels: {
                enabled: true,
                rotation: -90,
                color: '#FFFFFF',
                align: 'right',
                x: 4,
                y: 10,
                style: {
                    fontSize: '13px',
                    fontFamily: 'Verdana, sans-serif'
                }
            }
        }]
    });
	
	
	
}


Highcharts.getOptions().colors = Highcharts.map(Highcharts.getOptions().colors, function(color) {
    return {
        radialGradient: { cx: 0.5, cy: 0.3, r: 0.7 },
        stops: [
            [0, color],
            [1, Highcharts.Color(color).brighten(-0.3).get('rgb')] // darken
        ]
    };
});

/**
 * 
 * @param id		id of div
 * @param data		
 */
function pieInit(id, data){
	var chart = new Highcharts.Chart({
		credits:	{
			enabled:false
		},
        chart: {
        	renderTo:	id,
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false
        },
        title: {
            text: data.label
        },
        tooltip: {
    	    formatter: function(){
    	    	return '<b>' + this.point.name + '</b>: ' + this.point.y;
    	    },
        	valueDecimals:	0
        },
        plotOptions: {
            pie: {
            	size: '80%',
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    color: '#000000',
                    connectorColor: '#000000',
                    formatter: function() {
                        return '<b>'+ this.point.name +'</b>: '+ this.point.y+' ('+ Math.round(this.percentage) +'%)';
                    }
                }
            }
        },
        series: [{
        	type:	'pie',
        	name:	data.fieldName,
        	data:	[]
        }]
    });
    $.each(data.data, function(i, e){
		chart.series[0].addPoint({name: e.key, y:eval(e.value)});
	});
}


/**
 * 	used for funnel chart
 * @param id
 * @param data
 */
function funnelInit(id, data){
	var chart = new Highcharts.Chart({
		credits:	{
			enabled:false
		},
        chart: {
        	renderTo:	id,
            type: 'funnel',
            marginRight: 100
        },
        title: {
        	text: data.label,
            x: -50
        },
        tooltip: {
    	    formatter: function(){
    	    	return '<b>' + this.point.name + '</b>: ' + this.point.y;
    	    },
        	valueDecimals:	0
        },
        plotOptions: {
            series: {
                dataLabels: {
                    enabled: true,
                    format: '<b>{point.name}</b> ({point.y:,.0f})',
                    color: 'black',
                    softConnector: true
                },
                neckWidth: '30%',
                neckHeight: '25%'
            }
        },
        legend: {
            enabled: false
        },
        series: [{
        	name:	data.fieldName,
            data: []
        }]
    });
	$.each(data.data, function(i, e){
		chart.series[0].addPoint({name: e.key, y:eval(e.value)});
	});
}

/**
 * used for gauge chart initialize
 * 
 * @param id
 * @param data
 */
function gaugeInit(id, data){
	var chart = new Highcharts.Chart({
		credits:	{
			enabled:false
		},
        chart: {
        	renderTo:	id,
        	type: 'gauge',
	        plotBackgroundColor: null,
	        plotBackgroundImage: null,
	        plotBorderWidth: 0,
	        plotShadow: false
	    },
	    
	    title: {
	        text: data.label
	    },
	    tooltip: {
    	    formatter: function(){
    	    	return '<b>' + this.point.name + '</b>: ' + this.point.y;
    	    },
        	valueDecimals:	0
        },
	    pane: {
	        startAngle: -150,
	        endAngle: 150,
	        background: [{
	            backgroundColor: {
	                linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
	                stops: [
	                    [0, '#FFF'],
	                    [1, '#333']
	                ]
	            },
	            borderWidth: 0,
	            outerRadius: '109%'
	        }, {
	            backgroundColor: {
	                linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
	                stops: [
	                    [0, '#333'],
	                    [1, '#FFF']
	                ]
	            },
	            borderWidth: 1,
	            outerRadius: '107%'
	        }, {
	            backgroundColor: '#DDD',
	            borderWidth: 0,
	            outerRadius: '105%',
	            innerRadius: '103%'
	        }]
	    },
	       
	    yAxis: {
	        min: data.min,
	        max: data.max,
	        
	        minorTickInterval: 'auto',
	        minorTickWidth: 1,
	        minorTickLength: 10,
	        minorTickPosition: 'inside',
	        minorTickColor: '#666',
	
	        tickPixelInterval: 30,
	        tickWidth: 2,
	        tickPosition: 'inside',
	        tickLength: 10,
	        tickColor: '#666',
	        labels: {
	            step: 2,
	            rotation: 'auto'
	        },
	        plotBands: [{
	            from: 	data.min,
	            to: 	data.warning,
	            color: 	'#55BF3B'
	        },{
	        	from: 	data.warning,
	        	to:		data.error,
	        	color:	'#DDDF0D'
	        },{
	        	from:	data.error,
	        	to:		data.max,
	        	color:	'#DF5353'
	        }] 
	    },
	
	    series: [{
	        name: data.fieldName,
	        data: []
	    }]
	
	});
	chart.series[0].addPoint({name: data.data[0].key, y:eval(data.data[0].value)});
}


function timeInit(id, data){
	var chart = new Highcharts.Chart({
		credits:	{
			enabled:false
		},
        chart: {
        	renderTo:	id,
            type: 'line',
            marginRight: 130,
            marginBottom: 25
        },
        title: {
            text: data.label,
            x: -20 //center
        },
        xAxis: {
            categories: []
        },
        yAxis: {
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
    	    formatter: function(){
    	    	return '<b>' + this.point.category + '</b>: ' + this.point.y;
    	    },
        	valueDecimals:	0
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'top',
            x: -10,
            y: 100,
            borderWidth: 0
        },
        series: []
    });
	var categories = [];
	$.each(data.snapshots, function(i, snapshot){
		categories.push(snapshot.month);
	});
	chart.xAxis[0].setCategories(categories);
	$.each(data.series, function(k, v){
		var data1 = [];
		$.each(v, function(i, e){
			data1.push(eval(e));
		});
		chart.addSeries({
			name: k,
			data: data1
		});
	})
}