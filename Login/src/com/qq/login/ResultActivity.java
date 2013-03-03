package com.qq.login;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParserException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

import com.qq.check.CheckService;
import com.qq.entity.Member;

import com.qq.xml.XMLService;

public class ResultActivity extends Activity {
	private static final int REFRESH = 1;
	private ArrayList<Member> list = new ArrayList<Member>();
	private ArrayList<Member> members = new ArrayList<Member>();
	private Handler handler;
	private StringBuffer buffer = new StringBuffer();
	TextView view = null;
	private int count = 0;
	private String content;
	private int index = -1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		view = (TextView) findViewById(R.id.result);
			
		

		Member user = getMemberInfo();
		File file = new File("/mnt/sdcard/aa.xml");

		members = readXML(file);

		count = countFile(file);
		Log.i("list", "count: " +count);
		showCheck(user, members);
	
		new Thread(new ShowTask()).start();
		
		handler = new Handler() {

			@Override
			public void handleMessage(Message msg) {
				switch(msg.what) {
				case REFRESH:
					String text = msg.getData().getString("buffer");
					view.setText(text + "\n");
					break;
				}
				super.handleMessage(msg);
			}
			
		};
		
	}

	private void showCheck(Member user, ArrayList<Member> members) {
		if (new CheckService().check(user, members)) {
			setTitle("OK!");
		} else {
			setTitle("failed!");
		}
	}

	private ArrayList<Member> readXML(File file) {
		ArrayList<Member> mlist = new ArrayList<Member>();
		try {
			mlist = new XMLService().readXML(file);
		} catch (XmlPullParserException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return mlist;
	}

	private Member getMemberInfo() {
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		String username = bundle.getString("username");
		String password = bundle.getString("password");

		return new Member(username, password);
	}

	

	private int countFile(File file) {
		FileReader reader = null;
		try {
			reader = new FileReader(file);
		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		}
		try {
			while(reader.read() != -1) {
				count ++;
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return count;
	}

	private class ShowTask implements Runnable {
		
		@Override
		public void run() {
			FileInputStream fin = null;
			try {
				fin = new FileInputStream(new File("/mnt/sdcard/TextView.txt"));
			} catch (FileNotFoundException e1) {
				
				e1.printStackTrace();
			}
			InputStreamReader reader = null;
			try {
				reader = new InputStreamReader(fin, "gbk");
			} catch (UnsupportedEncodingException e1) {
				
				e1.printStackTrace();
			}
			BufferedReader in = new BufferedReader(reader);
			try {
				while((content = in.readLine()) != null) {
					
					buffer.append(content);
					
					Message message = new Message();
					message.what = REFRESH;
					
					Bundle data = new Bundle();
					data.putString("buffer", buffer+"");
					
					message.setData(data);
					
					Log.i("buffer",buffer+"");
					
					handler.sendMessage(message);
					Thread.sleep(1000);
				}
			} catch (IOException e) {
				
				e.printStackTrace();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
	}
	    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_result, menu);
		return true;
	}

}
