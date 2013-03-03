package com.qq.xml;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import android.util.Xml;

import com.qq.entity.Member;

public class XMLService {

	public ArrayList<Member> readXML(File file) throws XmlPullParserException,
			IOException {
		ArrayList<Member> members = null;
		Member member = null;
		FileInputStream fin = new FileInputStream(file);
		InputStreamReader reader = new InputStreamReader(fin, "UTF-8");
		BufferedReader in = new BufferedReader(reader);
		XmlPullParser parser = Xml.newPullParser();

		parser.setInput(in);

		int eventType = parser.getEventType();

		while (eventType != XmlPullParser.END_DOCUMENT) {

			switch (eventType) {

			case XmlPullParser.START_DOCUMENT:
				members = new ArrayList<Member>();
				break;

			case XmlPullParser.START_TAG:
				String tag = parser.getName();
				
				if ("member".equals(tag)) {
					member = new Member();
				}

				if(member != null) {
					if ("username".equals(tag)) {
						member.setUsername(parser.nextText());
					}
					if ("password".equals(tag)) {
						member.setPassword(parser.nextText());
					}
				}
				break;

			case XmlPullParser.END_TAG:
				if ("member".equals(parser.getName())) {
					members.add(member);

				}
				break;

			}

			eventType = parser.next();
		}

		return members;
	}

	public void genXML(File file, List<Member> list)
			throws IllegalArgumentException, IllegalStateException, IOException {
		FileOutputStream fout = new FileOutputStream(file);
		OutputStreamWriter oswriter = new OutputStreamWriter(fout, "UTF-8");
		BufferedWriter writer = new BufferedWriter(oswriter);
		XmlSerializer serializer = Xml.newSerializer();

		serializer.setOutput(writer);
		serializer.startDocument("UTF-8", true);

		serializer.startTag(null, "mitt");

		for (Member member : list) {
			serializer.startTag(null, "member");

			serializer.startTag(null, "username");
			serializer.text(member.getUsername());
			serializer.endTag(null, "username");

			serializer.startTag(null, "password");
			serializer.text(member.getPassword());
			serializer.endTag(null, "password");

			serializer.endTag(null, "member");
		}

		serializer.endTag(null, "mitt");
		serializer.endDocument();

		writer.close();
	}
}
