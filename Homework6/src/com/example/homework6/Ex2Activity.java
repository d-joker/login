package com.example.homework6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class Ex2Activity extends Activity {

	private ListView listview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview);

		listview = (ListView) findViewById(R.id.listview);
		List<Map<String, Object>> contacts = new ArrayList<Map<String, Object>>();
		Map<String, Object> contact = new HashMap<String, Object>();
		contact.put("name", "委座");
		contact.put("head", R.drawable.ic_launcher);
		contact.put("time", "100年前");
		contact.put("address", "北京 110******");
		contacts.add(contact);
		contacts.add(contact);
		contacts.add(contact);
		contacts.add(contact);
		contacts.add(contact);
		SimpleAdapter adapter = new SimpleAdapter(this, contacts,
				R.layout.item2, new String[] { "name", "head", "time",
						"address" }, new int[] { R.id.textview_username,
						R.id.img_head, R.id.textview_time,
						R.id.textview_address });

		listview.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ex2, menu);
		return true;
	}

}
