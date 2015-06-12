package com.rest;

import org.activiti.engine.delegate.DelegateExecution;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WsDelegate implements org.activiti.engine.delegate.JavaDelegate {

	@Override
	public void execute(DelegateExecution arg0) throws Exception {
		String text = arg0.getVariable("tweet").toString();
		String user = arg0.getVariable("user").toString();
		String nick = arg0.getVariable("nick").toString();
		String url = "http://localhost:12392/Twitter/ProcessTweet?status="
				+ text + "&user=" + user + "&nick=" + nick;
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		int responseCode = con.getResponseCode();
	}
}