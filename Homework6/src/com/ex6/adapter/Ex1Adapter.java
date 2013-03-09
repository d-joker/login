package com.ex6.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ex6.entity.Person;
import com.example.homework6.R;

public class Ex1Adapter extends BaseAdapter {

	private Person[] persons;
	private Context context;
	private LayoutInflater inflater;
	

	public Ex1Adapter(Person[] persons, Context context) {
		this.persons = persons;
		this.context = context;
		inflater = LayoutInflater.from(this.context);
	}

	

	@Override
	public int getCount() {

		return persons.length;
	}

	@Override
	public Object getItem(int arg0) {

		return arg0;
	}

	@Override
	public long getItemId(int arg0) {

		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		arg1 = inflater.inflate(R.layout.item1, null);
		TextView tv_name = (TextView) arg1.findViewById(R.id.textview_name);
		tv_name.setText(persons[arg0].getName());
		TextView tv_phone = (TextView) arg1.findViewById(R.id.textview_phone);
		tv_phone.setText(persons[arg0].getPhone());
		TextView tv_email = (TextView) arg1.findViewById(R.id.textview_email);
		tv_email.setText(persons[arg0].getEmail());
		return arg1;
	}

}
