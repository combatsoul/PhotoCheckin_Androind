package com.example.photocheckin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;

	public class IntroMain extends Activity implements View.OnClickListener{
		
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        this.requestWindowFeature(Window.FEATURE_NO_TITLE); //no title bar
	        setContentView(R.layout.intro_main); //strat page
	        
	        //call btn register
	        Button call_register = (Button) findViewById(R.id.register_btn);
	        call_register.setOnClickListener(this);
	        
	        //call btn login
	        Button call_login = (Button) findViewById(R.id.login_btn);
	        call_login.setOnClickListener(this);
	        
	        //call btn wallpage
	        Button call_wallpage = (Button) findViewById(R.id.wallpage_btn);
	        call_wallpage.setOnClickListener(this);
	        
	        //call btn profile
	        Button call_profile = (Button) findViewById(R.id.profile_btn);
	        call_profile.setOnClickListener(this);
	        
	        //call btn activityroom
	        Button call_activityroom = (Button) findViewById(R.id.activityroom_btn);
	        call_activityroom.setOnClickListener(this);   
	    }

	        @Override
	        public void onClick(View v) {
	                switch (v.getId()) {
	                
	                case R.id.register_btn:
	                        Intent call_registerbtn= new Intent(this, Register.class);
	                        startActivity(call_registerbtn);                        
	                        break;
	                case R.id.login_btn:
	                        Intent call_loginbtn = new Intent(this, LoginForm.class);
	                        startActivity(call_loginbtn);                        
	                        break;        
	                case R.id.wallpage_btn:
                        Intent call_wallpagebtn = new Intent(this, WallPage.class);
                        startActivity(call_wallpagebtn);                        
                        break;    
                        
	                case R.id.profile_btn:
                        Intent call_profilebtn = new Intent(this, Profile.class);
                        startActivity(call_profilebtn);                        
                        break; 
                        
	                case R.id.activityroom_btn:
                        Intent call_activityroombtn = new Intent(this, Profile.class);
                        startActivity(call_activityroombtn);                        
                        break; 
	                }
	                
	        }
	        
	        
	        
	    
	}