package com.example.homework6;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ListView;

import com.ex6.adapter.Ex1Adapter;
import com.ex6.entity.Person;

public class Ex1Activity extends Activity {

	private ListView listview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview);
		listview = (ListView)findViewById(R.id.listview);
		Person[] persons = {
				new Person("李伟鹏","110","woshitufu@qq.com"),
				new Person("李伟鹏","110","woshitufu@qq.com"),
				new Person("李伟鹏","110","woshitufu@qq.com"),
				new Person("李伟鹏","110","woshitufu@qq.com"),
		};
		Ex1Adapter adapter = new Ex1Adapter(persons, Ex1Activity.this);
		
		listview.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ex1, menu);
		return true;
	}

}
