package com.muzima.patientform;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.muzima.api.model.FormData;
import com.muzima.api.model.Patient;
import com.muzima.api.model.PersonName;


public class MainActivity extends Activity {
	
	private WebView wv;  
	
	private String formsubmissionjson;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		  final String formuuid="fe9fc58f-d196-46cb-956d-f46445f558d9";
	      final String datasourceuuid="c1d68123-cecb-4b2b-8cc3-0352246c7a96";

	      Patient patient = new Patient();
	      patient.getFamilyName();
	      patient.getMiddleName();
	      patient.getGivenName();
         
               
	      final PersonName personname =new PersonName();
	      personname.setGivenName("PATRICK");
	      personname.setMiddleName("KIPLIMO");
	      personname.setFamilyName("TOROITICH");
	      personname.setUuid("0908sdsd8s877d");
	      
	        
	      
	      wv = (WebView) this.findViewById(R.id.webView1);  
		  // requires javascript  
		  wv.getSettings().setJavaScriptEnabled(true);  
		  // make this activity accessible to javascript  
		  wv.addJavascriptInterface(this, "android");
		  
		  wv.setWebChromeClient(new WebChromeClient());
		  // set the html view to load sample.html
		  wv.loadUrl("file:///android_asset/patientform.html"); 
		 
		 System.out.println("patient object is ========" + personname.getGivenName());
		 
		  wv.setWebViewClient(new WebViewClient() {
				@Override
		 public void onPageFinished(WebView view, String url) {	
			
		  wv.loadUrl("javascript:setPersonUUID(\"" + personname.getUuid() + "\")");
		  wv.loadUrl("javascript:setPersongivenNAME(\"" + personname.getGivenName() +"\")");
		  wv.loadUrl("javascript:setPersonmiddleNAME(\"" + personname.getMiddleName() + "\")");
		  wv.loadUrl("javascript:setPersonfamilyNAME(\"" + personname.getFamilyName() + "\")");
		  wv.loadUrl("javascript:setFormUuid(\"" +formuuid +"\")");
		  wv.loadUrl("javascript:setDatasourceUuid(\"" +datasourceuuid +"\")");
			
							
				}
			});
	}
	
	 public void FormData(String formData) {  
		 FormData formdata = new FormData();
		 formdata.setPayload(formData);
		 
		 
		 System.out.println("TestMethod FormData " + formData);  
		 try {  
		   JSONObject jsonData = new JSONObject(formData);  
		 } catch (JSONException e) {  
		   e.printStackTrace();  
		 }  
		 wv.loadUrl("javascript:onSubmit('" + formData + "');");  
		 //Toast.makeText(getApplicationContext(), formData, 500).show();  
		 System.out.println("Form data is #######" +formdata.getPayload());
		 
		
	}  



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
