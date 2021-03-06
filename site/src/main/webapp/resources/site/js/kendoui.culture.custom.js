﻿//derived from en-GB
(function() {
	kendo.cultures["en-CUSTOM"] = {
		name : "en-CUSTOM",
		numberFormat : {
			pattern : [ "-n" ],
			decimals : 2,
			"," : ",",
			"." : ".",
			groupSize : [ 3 ],
			percent : {
				pattern : [ "-n %", "n %" ],
				decimals : 2,
				"," : ",",
				"." : ".",
				groupSize : [ 3 ],
				symbol : "%"
			},
			currency : {
				pattern : [ "-$n", "$n" ],
				decimals : 2,
				"," : ",",
				"." : ".",
				groupSize : [ 3 ],
				symbol : "£"
			}
		},
		calendars : {
			standard : {
				days : {
					names : [ "Sunday", "Monday", "Tuesday", "Wednesday",
							"Thursday", "Friday", "Saturday" ],
					namesAbbr : [ "Sun", "Mon", "Tue", "Wed", "Thu", "Fri",
							"Sat" ],
					namesShort : [ "Su", "Mo", "Tu", "We", "Th", "Fr", "Sa" ]
				},
				months : {
					names : [ "January", "February", "March", "April", "May",
							"June", "July", "August", "September", "October",
							"November", "December", "" ],
					namesAbbr : [ "Jan", "Feb", "Mar", "Apr", "May", "Jun",
							"Jul", "Aug", "Sep", "Oct", "Nov", "Dec", "" ]
				},
				AM : [ "AM", "am", "AM" ],
				PM : [ "PM", "pm", "PM" ],
				patterns : {
					d : CustomerConnect.dateFormat,
					D : "dd MMMM yyyy",
					F : "dd MMMM yyyy HH:mm:ss",
					g : CustomerConnect.dateTimeFormat,
					G : CustomerConnect.dateTimeFormat + ":ss",
					m : "dd MMMM",
					M : "dd MMMM",
					s : "yyyy'-'MM'-'dd'T'HH':'mm':'ss",
					t : "HH:mm",
					T : "HH:mm:ss",
					u : "yyyy'-'MM'-'dd HH':'mm':'ss'Z'",
					y : "MMMM yyyy",
					Y : "MMMM yyyy"
				},
				"/" : "/",
				":" : ":",
				firstDay : 1
			}
		}
	}
})(this);