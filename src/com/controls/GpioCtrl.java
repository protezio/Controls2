package com.controls;
import org.apache.http.Header;

import android.app.Application;
import android.content.Context;
import android.util.Log;


import android.widget.Toast;

import com.loopj.android.http.*;


public class GpioCtrl extends Application {
	
		
		private static AsyncHttpClient client = new AsyncHttpClient();
		public String url ;
		public Context context;
		private String ON = "=ON";
		private String OFF = "=OF";

		
		public GpioCtrl (String S, Context con )
		{
			url = S;
			context = con;
		}
		
		AsyncHttpResponseHandler response = new AsyncHttpResponseHandler() 
		{
			
			@Override
			public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
				// TODO Auto-generated method stub
				Log.d("MSG", "Successo");
				//Toast.makeText(context, "Ok :-)", Toast.LENGTH_SHORT).show();
				
			}
			
			@Override
			public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
				// TODO Auto-generated method stub
				Log.d ("MSG","Fallimento");
				Toast.makeText(context, "Errore di connessione :-(", Toast.LENGTH_SHORT).show();
				
			}
			
			
		};
		
		
		
		
		
		public void set_gpio (String gpio , Boolean status )
		{
			
			if (status == true )
			{
				this.post(this.url + gpio + ON  );
				
			}
			else 
			{
				this.post(this.url + gpio +  OFF );
				
				
			}

		}
	
		
		
		private void post (String url)
		{
			
			client.post(url, response);
			Log.d("MSG", url);
			
		}
		

		public void get_status ()
		{
			
			
			
			
		}
		
		
		
}
