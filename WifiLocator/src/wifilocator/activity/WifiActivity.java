package wifilocator.activity;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import wifilocator.service.*;

public class WifiActivity extends Activity {
    //------widget-----//
	private Button btn_open;
    private Button btn_close;
    private Button btn_scan;
    private TextView wifilist_text;
    
    private WifiService wifiService;
    private MyBtnListener btnListener;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);
        wifiService=new WifiService(this);
        initWidget();
        initListener();
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_wifi, menu);
        return true;
    }
    
    @Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		wifiService.closeWifi();
	}

	/**
	 * Initiate the widgets
	 * @author Eric Wang
	 */
    public void initWidget()
    {
    	btn_open=(Button)findViewById(R.id.openWifi);
    	btn_close=(Button)findViewById(R.id.closeWifi);
    	btn_scan=(Button)findViewById(R.id.scanWifi);
    	wifilist_text=(TextView)findViewById(R.id.wifiList);
    }
    
    /**
   	 * Initiate the Listeners
   	 * @author Eric Wang
   	 */
    public void initListener()
    {
    	btnListener=new MyBtnListener();
    	btn_open.setOnClickListener(btnListener);
    	btn_close.setOnClickListener(btnListener);
    	btn_scan.setOnClickListener(btnListener);   	
    }
    
    /**
   	 * display the results of all the latest wifi access points scan
   	 * @author Eric Wang
   	 */
    public void displayAllWifiList()
    {
    	wifiService.startScan();
    	StringBuilder scanResult=wifiService.getWifiListInString();
    	//StringBuilder scanResult=wifiService.getWifiInfoInString();
    	wifilist_text.setText(scanResult.toString());
    }
    
    /**
     * User defined class which implements the OnClickListerer interface.
     * Listener of button click event.
     * @author Eric Wang
     * @version beta
     */
    private class MyBtnListener implements OnClickListener{  
    	  
        public void onClick(View v) {  
            // TODO Auto-generated method stub  
	        switch (v.getId()) {  
	           case R.id.scanWifi:
	        	   displayAllWifiList();
	                break;  
	           case R.id.openWifi: 
	        	   wifiService.openWifi();
	                Toast.makeText(WifiActivity.this,"Current Wifi state is"+wifiService.getState(), Toast.LENGTH_SHORT).show();
	                break;  
	           case R.id.closeWifi:  
	        	   wifiService.closeWifi();  
	        	    Toast.makeText(WifiActivity.this,"Current Wifi state is"+wifiService.getState(), Toast.LENGTH_SHORT).show(); 
	                break;  
	           default:  
	                break;
	        }
        }
    }   
}
