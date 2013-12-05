package com.example.photocheckin;

import java.io.UnsupportedEncodingException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LoginForm extends Activity implements View.OnClickListener {

	String strUsername = "";
	String strPassword = "";
	EditText input_username;
	EditText input_password;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.index_loginform);

		// call btn login
		Button call_login = (Button) findViewById(R.id.loginform_btn);
		call_login.setOnClickListener(this);

		// input value form textflid
		input_username = (EditText) findViewById(R.id.login_username_texf);
		input_password = (EditText) findViewById(R.id.login_password_texf);

		// go to register
		ImageButton goto_register = (ImageButton) findViewById(R.id.register_btnimg);
		goto_register.setOnClickListener(this);

	}

	// validate --
	
	//check username
	public boolean btnValidateUsername(View v) {
		boolean value = true;
		try {
			// รับค่ามาแปลงให้เป็น String
			strUsername = input_username.getText().toString().trim();
			if (strUsername.isEmpty()) {
				Toast.makeText(v.getContext(), "Your Username must not empty",
						Toast.LENGTH_SHORT).show();
				value = false;
			}
		}
		catch (NullPointerException ex) {
			ex.printStackTrace();
		}
		return value;
	}

	public boolean btnValidatePassword(View v) {
		boolean value = true;
		try {
			// รับค่ามาแปลงให้เป็น String
			strPassword = input_password.getText().toString().trim();
			if (strPassword.isEmpty()) {
				Toast.makeText(v.getContext(), "Your Password must not empty",
						Toast.LENGTH_SHORT).show();
				value = false;
			}
		}
		catch (NullPointerException ex) {
			ex.printStackTrace();
		}
		return value;
	}

	
	
	
	//check login --
	public void checkLogin(View v){
	       
			//create androind	
			String URL ="http://checkinphoto.com/index.php?option=com_users&view=login";
			// Create http cliient object to send request to server
            HttpClient Client = new DefaultHttpClient();
			
		try {
			String SetServerString = "";

			// Create Request to server and get response
			HttpGet httpget = new HttpGet(URL);
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			SetServerString = Client.execute(httpget, responseHandler);

			// Show response on activity

			input_username.setText(SetServerString);
		} catch (Exception ex) {
			input_username.setText("Fail!");
		}
	}   	 
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// check link to page ---
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.loginform_btn:
			if (btnValidateUsername(v) && btnValidatePassword(v)) {
				Intent call_index_wallpage = new Intent(this, WallPage.class);
				startActivity(call_index_wallpage);
			}
			break;
		case R.id.register_btnimg:
			Intent call_registerbtn = new Intent(this, Register.class);
			startActivity(call_registerbtn);
			break;
		}
	}

}