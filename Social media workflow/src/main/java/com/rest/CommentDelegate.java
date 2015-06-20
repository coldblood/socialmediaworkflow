package com.rest;

import org.activiti.engine.delegate.DelegateExecution;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CommentDelegate implements
		org.activiti.engine.delegate.JavaDelegate {

	@Override
	public void execute(DelegateExecution arg0) throws Exception {
		String text = arg0.getVariable("reply").toString();
		String user = arg0.getVariable("userName").toString();
		String nick = arg0.getVariable("Nick").toString();
		String id = arg0.getVariable("id").toString();
		String screen = arg0.getVariable("screen").toString();
		String url = "http://localhost:12392/Twitter/ProcessReply?statusId="
				+ id + "&userName=" + user + "&screenName=" + screen + "&Nick="
				+ nick + "&text=" + text;
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		int responseCode = con.getResponseCode();
	}
}