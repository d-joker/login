package com.example.homework6;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

import com.ex6.adapter.Ex3Adapter;
import com.ex6.entity.Contact;

public class Ex3Activity extends Activity {

	private ListView listview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview);
		
		listview = (ListView)findViewById(R.id.listview);
		
		Contact[] contacts = {
				new Contact("委座","朝鲜君 110*****","10000年前"),
				new Contact("委座","朝鲜君 110*****","10000年前"),
				new Contact("委座","朝鲜君 110*****","10000年前"),
				new Contact("委座","朝鲜君 110*****","10000年前"),
				new Contact("委座","朝鲜君 110*****","10000年前"),
		};
		Ex3Adapter adapter = new Ex3Adapter(this, contacts);
		
		listview.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ex3, menu);
		return true;
	}

}
