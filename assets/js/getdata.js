var uuidGlobal; 
            function setPersonUUID(patientUuid){
            alert("Getting uuid: " + patientUuid);
            uuidGlobal = patientUuid;
            document.getElementById("person.uuid").value=uuidGlobal;

        }
		
        var patient_middlename; 
            function setPersonmiddleNAME(patientmiddlename){
            alert("Getting patient middle name: " + patientmiddlename);
            patient_middlename = patientmiddlename;
            document.getElementById("inputPatientmiddlename").value=patient_middlename;
        }

   

           var patient_givenname; 
            function setPersongivenNAME(patientgivenname){
            alert("Getting patient given name: " + patientgivenname);
            patient_givenname = patientgivenname;
            document.getElementById("inputpatientgivenname").value=patient_givenname;

    }

   
   
    var patient_familyname; 
        function setPersonfamilyNAME(patientfamilyname){
        alert("Getting patient family name: " + patientfamilyname);
        patient_familyname = patientfamilyname;
        document.getElementById("inputPatientfamily").value=patient_familyname;

    }

   
	
	        var datasource_uuid; 
            function setDatasourceUuid(datasourceuuid){
            alert("Getting datasource: " + datasourceuuid);
            datasource_uuid = datasourceuuid;
            

    }

    
	
	        var form_uuid; 
            function setFormUuid(formuuid){
            alert("Getting formuuid: " + formuuid);
            form_uuid = formuuid;
            

    }

    