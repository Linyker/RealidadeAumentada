package com.ra.sweetra;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import java.util.Random;

import javax.microedition.khronos.opengles.GL10;

import com.example.rajawalivuforiaexample.R;

import rajawali.Object3D;
import rajawali.lights.DirectionalLight;
import rajawali.math.Quaternion;
import rajawali.math.vector.Vector3;
import rajawali.parser.LoaderOBJ;
import rajawali.vuforia.RajawaliVuforiaRenderer;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.renderscript.BaseObj;

public class SweetRARenderer extends RajawaliVuforiaRenderer {
	private DirectionalLight mLight;
	private Object3D cadeiraBalanco,abajur,assento1,assento2,assento3,assento4,
	cama1,cama2,criado1,criado2,criado3,criado4,criado5,geladeira1,mesa1,
	mesa2,mesa3,mesa4,mesa5,planta1,planta2,poste,sofa1,tv1,tv2,tv3,tv4;
	private SweetRAActivity activity;
	boolean screenshot = false;
	BaseObj aba;
	Bitmap lastScreenshot;
		
	
	public SweetRARenderer(Context context) {
		super(context);
		activity = (SweetRAActivity)context;
	}

	protected void initScene() {
		mLight = new DirectionalLight(.1f, 0, -1.0f);
		mLight.setColor(1.0f, 1.0f, 0.8f);
		mLight.setPower(1);
		
		getCurrentScene().addLight(mLight);
		
		try {		
				
			//carregando abajur
			LoaderOBJ loadAbajur = new LoaderOBJ(this, R.raw.abajur);
			loadAbajur.parse();
			abajur = loadAbajur.getParsedObject();
			getCurrentScene().addChild(abajur);
			
			//carregando assento1
			LoaderOBJ loadAssento1 = new LoaderOBJ(this, R.raw.assento1_obj);
			loadAssento1.parse();
			assento1 = loadAssento1.getParsedObject();
			getCurrentScene().addChild(assento1);
			
			//carregando assento2
			LoaderOBJ loadAssento2 = new LoaderOBJ(this, R.raw.assento2_obj);
			loadAssento2.parse();
			assento2 = loadAssento2.getParsedObject();
			getCurrentScene().addChild(assento2);
			
			//carregando assento3
			LoaderOBJ loadAssento3 = new LoaderOBJ(this, R.raw.assento3_obj);
			loadAssento3.parse();
			assento3 = loadAssento3.getParsedObject();
			getCurrentScene().addChild(assento3);
			
			//carregando assento4
			LoaderOBJ loadAssento4 = new LoaderOBJ(this, R.raw.assento4_obj);
			loadAssento4.parse();
			assento4 = loadAssento4.getParsedObject();
			getCurrentScene().addChild(assento4);
						
			//carregando cadeira de balanço
			LoaderOBJ loadCadeiraBalanco = new LoaderOBJ(this, R.raw.cadeira_balanco_animada_obj);
			loadCadeiraBalanco.parse();			
			cadeiraBalanco = loadCadeiraBalanco.getParsedObject();			
			getCurrentScene().addChild(cadeiraBalanco);
			
			//carregando cama1
			LoaderOBJ loadCama1 = new LoaderOBJ(this,R.raw.cama1_obj);
			loadCama1.parse();
			cama1 = loadCama1.getParsedObject();
			getCurrentScene().addChild(cama1);
			
			//carregando cama2
			LoaderOBJ loadCama2 = new LoaderOBJ(this,R.raw.cama2_obj);
			loadCama2.parse();
			cama2 = loadCama2.getParsedObject();
			getCurrentScene().addChild(cama2);
						
			//carregando criado1
			LoaderOBJ loadCriado1 = new LoaderOBJ(this, R.raw.criado1_obj);
			loadCriado1.parse();
			criado1 = loadCriado1.getParsedObject();
			getCurrentScene().addChild(criado1);
						
			//carregando criado2
			LoaderOBJ loadCriado2 = new LoaderOBJ(this, R.raw.criado2_obj);
			loadCriado2.parse();
			criado2 = loadCriado2.getParsedObject();
			getCurrentScene().addChild(criado2);
			
			//carregando criado3
			LoaderOBJ loadCriado3 = new LoaderOBJ(this, R.raw.criado3_obj);
			loadCriado3.parse();
			criado3 = loadCriado3.getParsedObject();
			getCurrentScene().addChild(criado3);
			
			//carregando criado4
			LoaderOBJ loadCriado4 = new LoaderOBJ(this, R.raw.criado4_obj);
			loadCriado4.parse();
			criado4 = loadCriado4.getParsedObject();
			getCurrentScene().addChild(criado4);
			
			//carregando criado5
			LoaderOBJ loadCriado5 = new LoaderOBJ(this, R.raw.criado5_obj);
			loadCriado5.parse();
			criado5 = loadCriado5.getParsedObject();
			getCurrentScene().addChild(criado5);
			
			//carregando geladeira1
			LoaderOBJ loadGeladeira1 = new LoaderOBJ(this, R.raw.geladeira1_obj);
			loadGeladeira1.parse();
			geladeira1 = loadGeladeira1.getParsedObject();
			getCurrentScene().addChild(geladeira1);
			
			//carregando mesa1
			LoaderOBJ loadMesa1 = new LoaderOBJ(this, R.raw.mesa1_obj);
			loadMesa1.parse();
			mesa1 = loadMesa1.getParsedObject();
			getCurrentScene().addChild(mesa1);
			
			//carregando mesa2
			LoaderOBJ loadMesa2 = new LoaderOBJ(this, R.raw.mesa2_obj);
			loadMesa2.parse();
			mesa2 = loadMesa2.getParsedObject();
			getCurrentScene().addChild(mesa2);
			
			//carregando mesa3
			LoaderOBJ loadMesa3 = new LoaderOBJ(this, R.raw.mesa3_obj);
			loadMesa3.parse();
			mesa3 = loadMesa3.getParsedObject();
			getCurrentScene().addChild(mesa3);
			
			//carregando mesa4
			LoaderOBJ loadMesa4 = new LoaderOBJ(this, R.raw.mesa4_obj);
			loadMesa4.parse();
			mesa4 = loadMesa4.getParsedObject();
			getCurrentScene().addChild(mesa4);
			
			//carregando mesa5
			LoaderOBJ loadMesa5 = new LoaderOBJ(this, R.raw.mesa5_obj);
			loadMesa5.parse();
			mesa5 = loadMesa5.getParsedObject();
			getCurrentScene().addChild(mesa5);
			
			//carregando planta1
			LoaderOBJ loadPlanta1 = new LoaderOBJ(this, R.raw.planta1_obj);
			loadPlanta1.parse();
			planta1 = loadPlanta1.getParsedObject();
			getCurrentScene().addChild(planta1);
			
			//carregando planta2
			LoaderOBJ loadPlanta2 = new LoaderOBJ(this, R.raw.planta2_obj);
			loadPlanta2.parse();
			planta2 = loadPlanta2.getParsedObject();		
			getCurrentScene().addChild(planta2);
						
			
			//carregando poste
			LoaderOBJ loadPoste = new LoaderOBJ(this, R.raw.poste_obj);
			loadPoste.parse();
			poste = loadPoste.getParsedObject();
			getCurrentScene().addChild(poste);
						
			//carregando sofa1
			LoaderOBJ loadSofa1 = new LoaderOBJ(this, R.raw.sofa1_obj);
			loadSofa1.parse();
			sofa1 = loadSofa1.getParsedObject();
			getCurrentScene().addChild(sofa1);
						
			//carregando tv1
			LoaderOBJ loadTV1 = new LoaderOBJ(this, R.raw.tv1_obj);
			loadTV1.parse();
			tv1 = loadTV1.getParsedObject();
			getCurrentScene().addChild(tv1);
			
			//carregando tv2
			LoaderOBJ loadTV2 = new LoaderOBJ(this, R.raw.tv2_obj);
			loadTV2.parse();
			tv2 = loadTV2.getParsedObject();
			getCurrentScene().addChild(tv2);
			
			//carregando tv3
			LoaderOBJ loadTV3 = new LoaderOBJ(this, R.raw.tv3_obj);
			loadTV3.parse();
			tv3 = loadTV3.getParsedObject();
			getCurrentScene().addChild(tv3);
			
			//carregando tv4
			LoaderOBJ loadTV4 = new LoaderOBJ(this, R.raw.tv4_obj);
			loadTV4.parse();
			tv4 = loadTV4.getParsedObject();
			getCurrentScene().addChild(tv4);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void foundFrameMarker(int markerId, Vector3 position,
			Quaternion orientation) {
			
		switch(markerId){
		case 0:
			abajur.setVisible(true);
			abajur.setPosition(position);
			abajur.setOrientation(orientation);
			break;
			
		case 1:
			assento1.setVisible(true);
			assento1.setPosition(position);
			assento1.setOrientation(orientation);
			break;
		case 2:
			assento2.setVisible(true);
			assento2.setPosition(position);
			assento2.setOrientation(orientation);
			break;
		case 3:			
			assento3.setVisible(true);
			assento3.setPosition(position);
			assento3.setOrientation(orientation);
			break;
		case 4:
			assento4.setVisible(true);
			assento4.setPosition(position);
			assento4.setOrientation(orientation);
			break;		
		case 5:
			cadeiraBalanco.setVisible(true);
			cadeiraBalanco.setPosition(position);
			cadeiraBalanco.setOrientation(orientation);
			break;
		case 6:
			cama1.setVisible(true);
			cama1.setPosition(position);
			cama1.setOrientation(orientation);
			break;
		case 7:
			cama2.setVisible(true);
			cama2.setPosition(position);
			cama2.setOrientation(orientation);
			break;
		case 8:
			criado1.setVisible(true);
			criado1.setPosition(position);
			criado1.setOrientation(orientation);
			break;
		case 9:
			criado2.setVisible(true);
			criado2.setPosition(position);
			criado2.setOrientation(orientation);
			break;
		case 10:
			criado3.setVisible(true);
			criado3.setPosition(position);
			criado3.setOrientation(orientation);
			break;
		case 11:
			criado4.setVisible(true);
			criado4.setPosition(position);
			criado4.setOrientation(orientation);
			break;
		case 12:
			criado5.setVisible(true);
			criado5.setPosition(position);
			criado5.setOrientation(orientation);
			break;
		case 13:
			geladeira1.setVisible(true);
			geladeira1.setPosition(position);
			geladeira1.setOrientation(orientation);
			break;
		case 14:
			mesa1.setVisible(true);
			mesa1.setPosition(position);
			mesa1.setOrientation(orientation);
			break;
		case 15:
			mesa2.setVisible(true);
			mesa2.setPosition(position);
			mesa2.setOrientation(orientation);
			break;
		case 16:
			mesa3.setVisible(true);
			mesa3.setPosition(position);
			mesa3.setOrientation(orientation);
			break;
		case 17:
			mesa4.setVisible(true);
			mesa4.setPosition(position);
			mesa4.setOrientation(orientation);
			break;
		case 18:
			mesa5.setVisible(true);
			mesa5.setPosition(position);
			mesa5.setOrientation(orientation);
			break;
		case 19:
			planta1.setVisible(true);
			planta1.setPosition(position);
			planta1.setOrientation(orientation);
			break;
		case 20:
			planta2.setVisible(true);
			planta2.setPosition(position);
			planta2.setOrientation(orientation);
			break;
		case 21:
			poste.setVisible(true);
			poste.setPosition(position);
			poste.setOrientation(orientation);
			break;
		case 22:
			sofa1.setVisible(true);
			sofa1.setPosition(position);
			sofa1.setOrientation(orientation);
			break;
		case 23:
			tv1.setVisible(true);
			tv1.setPosition(position);
			tv1.setOrientation(orientation);
			break;
		case 24:
			tv2.setVisible(true);
			tv2.setPosition(position);
			tv2.setOrientation(orientation);
			break;
		case 25:
			tv3.setVisible(true);
			tv3.setPosition(position);
			tv3.setOrientation(orientation);
			break;
		case 26:
			tv4.setVisible(true);
			tv4.setPosition(position);
			tv4.setOrientation(orientation);
			break;
			
		}
		
		
	}

	@Override
	protected void foundImageMarker(String trackableName, Vector3 position,
			Quaternion orientation) {
		/*
		if(trackableName.equals("Abajur"))
		{
			
			mBob.setVisible(true);
			mBob.setPosition(position);
			mBob.setOrientation(orientation);
			RajLog.d(activity.getMetadataNative());
			
			
			abajur.setVisible(true);
			abajur.setPosition(position);
			abajur.setOrientation(orientation);
		}
		if(trackableName.equals("CadeiraBalanco"))
		{/*
			cadeiraBalanco.setVisible(true);
			cadeiraBalanco.setPosition(position);
			cadeiraBalanco.setOrientation(orientation);
			
		}
		*/
		// -- also handle cylinder targets here
		// -- also handle multi-targets here
	}

	@Override
	public void noFrameMarkersFound() {
	}

	public void onDrawFrame(GL10 glUnused) {
		
		abajur.setVisible(false); 
		assento1.setVisible(false);
		assento2.setVisible(false);
		assento3.setVisible(false);
		assento4.setVisible(false);
		cadeiraBalanco.setVisible(false);
		cama1.setVisible(false);
		cama2.setVisible(false);
		criado1.setVisible(false);
		criado2.setVisible(false);
		criado3.setVisible(false);
		criado4.setVisible(false);
		criado5.setVisible(false);
		geladeira1.setVisible(false);
		mesa1.setVisible(false);
		mesa2.setVisible(false);
		mesa3.setVisible(false);
		mesa4.setVisible(false);
		mesa5.setVisible(false);
		planta1.setVisible(false);
		planta2.setVisible(false);
		poste.setVisible(false);
		sofa1.setVisible(false);
		tv1.setVisible(false);
		tv2.setVisible(false);
		tv3.setVisible(false);
		tv4.setVisible(false);
				
		super.onDrawFrame(glUnused);
				
		if(screenshot){
			int screenshotSize = mViewportHeight * mViewportWidth;
			ByteBuffer bb = ByteBuffer.allocateDirect(screenshotSize * 4);
			bb.order(ByteOrder.nativeOrder());
			glUnused.glReadPixels(0, 0, mViewportWidth, mViewportHeight, GL10.GL_RGBA, GL10.GL_UNSIGNED_BYTE, bb);
			
			int pixelsBuffer[] = new int[screenshotSize];
			
			bb.asIntBuffer().get(pixelsBuffer);
			bb = null;
			
			Bitmap bitmap = Bitmap.createBitmap(mViewportWidth,mViewportHeight,Bitmap.Config.RGB_565);
			bitmap.setPixels(pixelsBuffer, screenshotSize-mViewportWidth, -mViewportWidth, 0, 0, mViewportWidth, mViewportHeight);
			pixelsBuffer = null;
			
			short sBuffer[] = new short[screenshotSize];
			ShortBuffer sb = ShortBuffer.wrap(sBuffer);
			bitmap.copyPixelsToBuffer(sb);
			
			//Making created bitmap (from OpenGL points) compatible with Android bitmap
			
			for (int i = 0; i < screenshotSize; i++) {
				short v = sBuffer[i];
				sBuffer[i] = (short) (((v&0x1f) << 11) | (v&0x7e0) | ((v&0xf800) >> 11));
			}
			
			sb.rewind();
			bitmap.copyPixelsFromBuffer(sb);
			lastScreenshot = bitmap;
			//activity.saveScreenshot(lastScreenshot);
			
			Random gerador = new Random();
	    	
			File file = new File(Environment.getExternalStoragePublicDirectory(
	                Environment.DIRECTORY_PICTURES), "Sweet Home RA");
	        file.mkdirs();
	        String path = file.toString();
			
	        String frametime = "Imagem" + String.valueOf(gerador.nextInt(999));
	         try {
	        	FileOutputStream out = new FileOutputStream(path + "/" + frametime + ".png");
	 	        lastScreenshot.compress(Bitmap.CompressFormat.PNG, 90, out);
	 	       
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lastScreenshot = null;
			screenshot = false;
		}
		
		
		if (!activity.getScanningModeNative())
		{
			activity.showStartScanButton();
		}
	}

	
}
