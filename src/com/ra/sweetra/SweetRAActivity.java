package com.ra.sweetra;

import com.example.rajawalivuforiaexample.R;

import rajawali.util.RajLog;
import rajawali.vuforia.RajawaliVuforiaActivity;
import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class SweetRAActivity extends RajawaliVuforiaActivity {
	private SweetRARenderer mRenderer;
	private RajawaliVuforiaActivity mUILayout;
	private Button mStartScanButton,screenShotButton;
	private ProgressDialog progress;
	
	private String[] nome_moveis = {
			"abajur",
			"assento1",
			"assento2",
			"assento3",
			"assento4",
			"cadeira_balanco",
			"cama1",
			"cama2",
			"criado1",
			"criado2",
			"criado3",
			"criado4",
			"criado5",
			"geladeira1",
			"mesa1",
			"mesa2",
			"mesa3",
			"mesa4",
			"mesa5",
			"planta1",
			"planta2",
			"poste",
			"sofa1",
			"tv1",
			"tv2",
			"tv3",
			"tv4"
			
			
	};
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setScreenOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		progress = new ProgressDialog(this);
		progress.setCancelable(false);
		//useCloudRecognition(false);
		//setCloudRecoDatabase("2f34c053d672f0f9a5f77bca10e9551a15b690d9","bf19e66ee8dac839651db811c7c9640cba571d91");
		
		LinearLayout ll = new LinearLayout(this);
		ll.setOrientation(LinearLayout.VERTICAL);
		ll.setGravity(Gravity.CENTER);
		
		ImageView logoView = new ImageView(this);
		logoView.setImageResource(R.drawable.rajawali_vuforia);
		ll.addView(logoView);
		
		addContentView(ll, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		
		startVuforia();
					
	}

	
	@Override
	protected void setupTracker() {
		int result = initTracker(TRACKER_TYPE_MARKER);
		if (result == 1) {
			result = initTracker(TRACKER_TYPE_IMAGE);
			if (result == 1) {
				super.setupTracker();
			} else {
				RajLog.e("Couldn't initialize image tracker.");
			}
		} else {
			RajLog.e("Couldn't initialize marker tracker.");
		}
	}

	@Override
	protected void initApplicationAR() {
		super.initApplicationAR();
		
		for(int i=0;i<nome_moveis.length;i++){
			createFrameMarker(i,nome_moveis[i].toString() , 100, 100);			
		}
				
		//createImageMarker("targets.xml");

		// -- this is how you add a cylinder target:
		// https://developer.vuforia.com/resources/dev-guide/cylinder-targets
		// createImageMarker("MyCylinderTarget.xml");

		// -- this is how you add a multi-target:
		// https://developer.vuforia.com/resources/dev-guide/multi-targets
		// createImageMarker("MyMultiTarget.xml");
	}

	public void showStartScanButton() {
		this.runOnUiThread(new Runnable() {
			public void run() {
				if (mStartScanButton != null)
					mStartScanButton.setVisibility(View.VISIBLE);
			}
		});
	}
	
	public void takeScreenshot() {	   
	   Toast.makeText(getApplicationContext(), "Tirando foto", Toast.LENGTH_SHORT).show();
	   mRenderer.screenshot = true;
	   Toast.makeText(getApplicationContext(), "Imagem salva", Toast.LENGTH_SHORT).show();
	}
	/*
	public void saveScreenshot(Bitmap screenshot){
	    try {
	    	
	        //File file = new File(Environment.getExternalStoragePublicDirectory(
	                //Environment.DIRECTORY_PICTURES), "openglscreenshots");
	        //file.mkdirs();
	        //String path = file.toString();
	    	Random gerador = new Random();
	    	
	        String frametime = "Imagem" + String.valueOf(gerador.nextInt(999));
	        FileOutputStream out = new FileOutputStream(Environment.getExternalStorageDirectory().toString() + "/" + frametime + ".png");
	           screenshot.compress(Bitmap.CompressFormat.PNG, 90, out);
	           out.close();
	           screenshot = null;
	           
	    } catch (Exception e) {
	           e.printStackTrace();
	    }       
	}*/
	
	@Override
	protected void initRajawali() {
		super.initRajawali();
		mRenderer = new SweetRARenderer(this);
		mRenderer.setSurfaceView(mSurfaceView);
		super.setRenderer(mRenderer);
		/*
		// Add button for Cloud Reco:
		mStartScanButton = new Button(this);
		mStartScanButton.setText("Start Scanning CloudReco");
		mStartScanButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				enterScanningModeNative();
				mStartScanButton.setVisibility(View.GONE);
			}
		});
		*/
		
		screenShotButton = new Button(this);
		screenShotButton.setText("Tirar Foto");
		screenShotButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				takeScreenshot();
			}
		});
		
		/*
		ToggleButton extendedTrackingButton = new ToggleButton(this);
		extendedTrackingButton.setTextOn("Extended Tracking On");
		extendedTrackingButton.setTextOff("Extended Tracking Off");
		extendedTrackingButton.setChecked(false);
		extendedTrackingButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if (((ToggleButton) v).isChecked()) {
					if(!startExtendedTracking())
						RajLog.e("Could not start extended tracking");
				} else {
					if(!stopExtendedTracking())
						RajLog.e("Could not stop extended tracking");
				}
			}
		});
		 */
	   progress.setMessage("Carregando imóveis ");
	   progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
	   progress.setIndeterminate(true);
	   progress.show();

	   final int totalProgressTime = 30;

	   final Thread t = new Thread(){

	   @Override
	   public void run(){
	 
	      int jumpTime = 0;
	      while(jumpTime < totalProgressTime){
	         try {
	            sleep(1000);
	            jumpTime += 1;
	            progress.setProgress(jumpTime);
	           //Log.e("TEMPO", String.valueOf(jumpTime));
	            
	         } catch (InterruptedException e) {
	           // TODO Auto-generated catch block
	           e.printStackTrace();
	         }
	         
	      }
	      progress.dismiss();
	   }
	   };
	   t.start();
            
	   
		mUILayout = this;
		LinearLayout ll = new LinearLayout(this);
		//ll.addView(mStartScanButton);
		//ll.addView(extendedTrackingButton);
		ll.addView(screenShotButton);
		mUILayout.addContentView(ll, new LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		
	}
	
	
	
}
