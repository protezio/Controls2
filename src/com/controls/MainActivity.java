package com.controls;


//import protezio.control.R;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

import com.controls.GpioCtrl;
public class MainActivity extends Activity {

	
	String url = "http://192.168.1.100/led";
	Context context;
	GpioCtrl ctrl = new GpioCtrl(url,context);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	
		
		final ToggleButton toggle1 = (ToggleButton)findViewById(R.id.toggleButton01);
		final ToggleButton toggle2 = (ToggleButton)findViewById(R.id.toggleButton02);
		final ToggleButton toggle3 = (ToggleButton)findViewById(R.id.toggleButton03);
		final ToggleButton toggle4 = (ToggleButton)findViewById(R.id.toggleButton04);
		
		
		toggle1.setOnClickListener(listener);
		toggle2.setOnClickListener(listener);
		toggle3.setOnClickListener(listener);
		toggle4.setOnClickListener(listener);
		context = getApplicationContext();
		//passare il context per il toast nella classe GPIOCtrl
		ctrl.context = context;
	
		
		}
	
	
	View.OnClickListener listener = new View.OnClickListener()  {
		
		
		@Override
		public void onClick(View v) {
			switch (v.getId())
			{
			
								
				case R.id.toggleButton01:
					if (((ToggleButton)findViewById(R.id.toggleButton01)).isChecked())
						
						ctrl.set_gpio("1",true);
					else
						ctrl.set_gpio ("1",false);
						
					break;
				case R.id.toggleButton02:
					if (((ToggleButton)findViewById(R.id.toggleButton02)).isChecked())
						
						ctrl.set_gpio("2",true);
					else
						ctrl.set_gpio ("2",false);
						
					break;
				case R.id.toggleButton03:
					if (((ToggleButton)findViewById(R.id.toggleButton03)).isChecked())
						
						ctrl.set_gpio("3",true);
					else
						ctrl.set_gpio ("3",false);
						
					break;
			
				case R.id.toggleButton04:
					if (((ToggleButton)findViewById(R.id.toggleButton04)).isChecked())
						
						ctrl.set_gpio("4",true);
					else
						ctrl.set_gpio ("4",false);
						
					break;
			
			
			}
			
		}
	};
	
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

