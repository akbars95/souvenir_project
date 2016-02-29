/**
 * 
 */

/* jQuery js */
$(document).ready(function() {

	/* contact_us page */
	doNumber("#number1");
	doNumber("#number2");
	doNumber("#number3");

	function doNumber(idNumber) {
		var number1 = $(idNumber);
		number1.next().hide();

		number1.click(function() {
			number1.next().toggle(1000);
		});
	}

	var buttonShowHideMap = $("#button_show_hide_map");
	var span_show = $("#span_show");
	var span_hide = $("#span_hide");
	var googleMap = $("#googleMap");
	span_show.hide();
	googleMap.hide();
	var isShowMap = false;
	
	buttonShowHideMap.click(function() {
		isShowMap = !isShowMap;
		if (isShowMap) {
			span_show.hide();
			span_hide.show();
		} else {
			span_hide.hide();
			span_show.show();
		}
		googleMap.toggle(2500);
	});

});
