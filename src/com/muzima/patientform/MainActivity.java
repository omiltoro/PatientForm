package com.muzima.patientform;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MainActivity extends Activity {
	
	private WebView wv;  

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		  final  String patientUuid = "3c18e94e-db15-46b2-88e3-21b3d9a5ef2b";
	   
	      final String patientgivenname = "TOROITICH";
	      final String patientmiddlename = "PATRICK";
	      final String patientfamilyname = "KIPLIMO";
	      final String formuuid="fe9fc58f-d196-46cb-956d-f46445f558d9";
	      final String datasourceuuid="c1d68123-cecb-4b2b-8cc3-0352246c7a96";

	      wv = (WebView) this.findViewById(R.id.webView1);  
		  // requires javascript  
		  wv.getSettings().setJavaScriptEnabled(true);  
		  // make this activity accessible to javascript  
		  wv.addJavascriptInterface(this, "android");
		  wv.setWebChromeClient(new WebChromeClient());
		  // set the html view to load sample.html
		  wv.loadUrl("file:///android_asset/patientform.html"); 
		  System.out.println("Patient Names is ======= " + patientgivenname  +patientfamilyname  +patientmiddlename);  
		 
		  wv.setWebViewClient(new WebViewClient() {
				@Override
		 public void onPageFinished(WebView view, String url) {
					
		  wv.loadUrl("javascript:setPersonUUID(\"" + patientUuid + "\")");
		  wv.loadUrl("javascript:setPersongivenNAME(\"" + patientgivenname + "\")");
		  wv.loadUrl("javascript:setPersonmiddleNAME(\"" + patientmiddlename + "\")");
		  wv.loadUrl("javascript:setPersonfamilyNAME(\"" + patientfamilyname + "\")");
		  wv.loadUrl("javascript:setFormUuid(\"" +formuuid +"\")");
		  wv.loadUrl("javascript:setDatasourceUuid(\"" +datasourceuuid +"\")");

						
				}
			});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
