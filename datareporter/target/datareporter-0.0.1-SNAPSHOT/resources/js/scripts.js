jQuery(function() {
		//alert("initiate jquery called: ");
		//jQuery('#menuUpper').lavaLamp();
		jQuery('#menuLower').lavaLamp();
	});

function initDialog() {
	//alert('wow from script.css');
	$("#idOfDialogPlaceHolder").dialog({

		modal : true,
		buttons : {
			SomeButton : function() {
				$("#justAButton").click();
			},
			Close : function() {
				$(this).dialog("close");
			}
		},
	});
}

function refreshPage(){
	
		 jQuery.ajax({
		   	  url: "",
		   	  context: document.body,
		   	  success: function(s,x){
		       	  jQuery(this).html(s);
		   	  }
		   	}).fadeIn(); 
	//alert("refresh");
	   
}
/*
function handleLoginRequest(xhr, status, args) {  
    if(args.validationFailed || !args.loggedIn) {  
        jQuery('#dialog').effect("shake", { times:3 }, 100);  
    } else {  
        dlg.hide();  
        jQuery('#loginLink').fadeOut();  
    }  
}  
*/
function removeClass(menu) {
	//alert("remove Class called: " + menu);
	//jQuery('#menu li').removeClass('active');
	jQuery(menu).parent().children().removeClass('menu_active');
	jQuery(menu).addClass('menu_active');
}

function handleLoginRequest(xhr, status, args) {  
    if(args.validationFailed  || !args.loggedIn) {  
        jQuery('#loginDialog').effect("shake", { times:3 }, 100);  
    } else {  
        dlg.hide();  
        jQuery('lowerMenuPanel').fadeIn();  
    }  
} 

function handleLogoutRequest(xhr, status, args) {  
    if(args.validationFailed  || !args.loggedOut) {  
        jQuery('#logoutDialog').effect("shake", { times:3 }, 100);  
    } else {  
    	confirmation.hide();
    	setTimeout(refreshPage(), 3000);
    }  
} 

function handleRegisterRequest(xhr, status, args) {  
    if(args.validationFailed  || !args.register) {  
        jQuery('#registerDialog').effect("shake", { times:3 }, 100);  
    } else {  
    	registerDialog.hide();  
        jQuery('lowerMenuPanel').fadeIn();  
    }  
}

function handleCreateProjectRequest(xhr, status, args){
	if(args.validationFailed  || !args.projectCreated) {  
        jQuery('#createProjectDialog').effect("shake", { times:3 }, 100);  
    } else {  
    	createProjectDialog.hide();  
        //jQuery('lowerMenuPanel').fadeIn();  
    }  
}