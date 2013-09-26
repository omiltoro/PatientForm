 function foo(){  
		
	var currentTime = new Date();
	var hours = currentTime.getHours();
	var minutes = currentTime.getMinutes();
	
	var time= hours + ":" + minutes;
	var date= document.getElementById("dp4").value;
	var date_time= date + " " +time;

     var dataObj = new Object();
     dataObj.datasource = datasource_uuid;
     dataObj.discriminator = "encounter";

     var payload = new Object();

     var person = new Object();
     person["person.uuid"] = uuidGlobal;
     payload.person = person;

     var encounter = new Object();
     encounter["provider.uuid"] = document.getElementById("providerlocation").value;
     encounter["location.uuid"] = document.getElementById("locationuuid").value;
     encounter["form.uuid"] = form_uuid;
     encounter["encounterType.uuid"]="8d5b2be0-c2cc-11de-8d13-0010c6dffd0f";
     encounter["datetime"] = date_time;
     payload.encounter = encounter;

     var obs = new Array();

     var obsElement = new Object();
	 var checkedValue = null; 
	 var uuid_code = null;
	 var inputElements = document.getElementsByTagName('input');
		 for(var i=0; inputElements[i]; ++i){
		 if(inputElements[i].className==="messageCheckbox" && 
         inputElements[i].checked){
           checkedValue = inputElements[i].value;
		   uuid_code = "159969AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
           break;
      } 

		
}
	 var inputElements = document.getElementsByTagName('input');
		 for(var i=0; inputElements[i]; ++i){
		 if(inputElements[i].className==="checkbox" && 
         inputElements[i].checked){
           checkedValue = inputElements[i].value;
		   uuid_code = "307AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
           break;
      } 

		
}
		 
     obsElement.uuid = uuid_code;
     obsElement.type = "coded";
     obsElement.value = checkedValue;
     obs.push(obsElement);

     payload.obs = obs;

     dataObj.payload = payload;
			 
     var jsonObj = JSON.stringify(dataObj);  
	 alert('Form submitted. Values object:\n' + JSON.stringify(dataObj, null, 2));
     /* NOTE: Calling Activity Method using the Activity defined 
        instance "android" in JavaScript */
     android.FormData(jsonObj); 
     }  