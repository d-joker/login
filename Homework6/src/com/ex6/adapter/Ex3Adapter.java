package com.ex6.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ex6.entity.Contact;
import com.example.homework6.R;

public class Ex3Adapter extends BaseAdapter {
	private Contact[] contacts;
	private Context context;
	private LayoutInflater inflater;
	
	public Ex3Adapter( Context context, Contact[] contacts) {
		this.contacts = contacts;
		this.context = context;
		inflater = LayoutInflater.from(this.context);
	}



	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		arg1 = inflater.inflate(R.layout.item2, null);
		TextView tv_username = (TextView) arg1.findViewById(R.id.textview_username);
		tv_username.setText(contacts[arg0].getName());
		TextView tv_address = (TextView) arg1.findViewById(R.id.textview_address);
		tv_address.setText(contacts[arg0].getAddress());
		TextView tv_time = (TextView) arg1.findViewById(R.id.textview_time);
		tv_time.setText(contacts[arg0].getTime());
		ImageView view = (ImageView)arg1.findViewById(R.id.img_head);
		view.setBackgroundResource(R.drawable.ic_launcher);
		return arg1;
	}



	@Override
	public int getCount() {
		
		return contacts.length;
	}



	@Override
	public Object getItem(int arg0) {
		
		return arg0;
	}



	@Override
	public long getItemId(int arg0) {
		
		return arg0;
	}
		
}

	
	

