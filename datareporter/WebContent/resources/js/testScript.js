$(document).ready(function() {
	jQuery('#menuLower').lavaLamp();
});

jQuery(function(){	
	$( "#dialog" ).dialog();
	$( "#dialog" ).dialog("close");
	
	jQuery('#menuLower').lavaLamp();
	/*
	alert("Document is ready ..... primeface way!");	
	
	$( "#dialog" ).dialog();

    $( "#link1" ).click(function() {
        $( "#pop" ).dialog( "open" );
        return false;
    });
    */
});

function testFunction(){
	alert("Thanks for visiting!");
}

function testFunction1(){
	$( "#dialog" ).dialog( { width: 460,
		resizable: false});
	return false;
}

function removeClass(menu) {
	//alert("remove Class called: " + menu);
	//jQuery('#menu li').removeClass('active');
	jQuery(menu).parent().children().removeClass('menu_active');
	jQuery(menu).addClass('menu_active');
}