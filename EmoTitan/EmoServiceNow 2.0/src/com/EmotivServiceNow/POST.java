package com.EmotivServiceNow;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
//import org.apache.http.HttpStatus;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.JsonGenerationException;



public class POST {
	public static void restPost() throws ClientProtocolException, IOException, HttpException, JsonGenerationException {
		POST restAction = new POST();
		restAction.postRequest();
	}

	public void postRequest() throws IOException {

		Map<String, String> params = new HashMap<String, String>();
		params.put("caller_id", "admin");
		params.put("short_description", "I can open a ticket with my mind this is really cool!");
		params.put("description", "I made this ticket hands free I was created with my brainwaves!!");
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(params);

		
		CloseableHttpClient httpclient = HttpClients.custom().build();
		try {
			HttpPost httpPost = new HttpPost("https://<YOUR_INSTANCE>.service-now.com/api/now/v2/table/incident");
			httpPost.setHeader("Accept", "application/json");
			httpPost.setHeader("Content-Type", "application/json");
			httpPost.setHeader("Authorization", "<YOUR_BASE64>");
			HttpEntity entity = new ByteArrayEntity(jsonStr.getBytes("utf-8"));
			httpPost.setEntity(entity);

			System.out.println("__________________________________________________________________________________________________");
			System.out.println(" ");
			System.out.println("Executing request " + httpPost.getRequestLine());
			CloseableHttpResponse response = httpclient.execute(httpPost);
			try {
				System.out.println("__________________________________________________________________________________________________");
				System.out.println(" ");
				System.out.println(response.getStatusLine());
				String responseBody = EntityUtils.toString(response.getEntity());
				System.out.println(" ");
				System.out.println("These are the Fields Populating via JSON Format: " + jsonStr);
				System.out.println(" ");
				System.out.println(responseBody);
				System.out.println(" ");
				System.out.println("__________________________________________________________________________________________________");
				System.out.println(" ");
			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}
	}
	public static void restPost1() throws ClientProtocolException, IOException, HttpException, JsonGenerationException {
		POST restAction = new POST();
		restAction.postRequest1();
	}

	public void postRequest1() throws IOException {

		Map<String, String> params = new HashMap<String, String>();
		params.put("caller_id", "admin");
		params.put("short_description", "I can open a ticket with my mind this is real cool!");
		params.put("description", "I made this ticket hands free all done with my brain waves!!");
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(params);

		
		CloseableHttpClient httpclient = HttpClients.custom().build();
		try {
			HttpPost httpPost = new HttpPost("https://<YOUR_INSTANCE>.service-now.com/api/now/v2/table/incident");
			httpPost.setHeader("Accept", "application/json");
			httpPost.setHeader("Content-Type", "application/json");
			httpPost.setHeader("Authorization", "<YOUR_BASE64>");
			HttpEntity entity = new ByteArrayEntity(jsonStr.getBytes("utf-8"));
			httpPost.setEntity(entity);

			System.out.println("__________________________________________________________________________________________________");
			System.out.println(" ");
			System.out.println("Executing request " + httpPost.getRequestLine());
			CloseableHttpResponse response = httpclient.execute(httpPost);
			try {
				System.out.println("__________________________________________________________________________________________________");
				System.out.println(" ");
				System.out.println(response.getStatusLine());
				String responseBody = EntityUtils.toString(response.getEntity());
				System.out.println(" ");
				System.out.println("These are the Fields Populating via JSON Format: " + jsonStr);
				System.out.println(" ");
				System.out.println(responseBody);
				System.out.println(" ");
				System.out.println("__________________________________________________________________________________________________");
				System.out.println(" ");
			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}
	}	
	public static void restPost2() throws ClientProtocolException, IOException, HttpException, JsonGenerationException {
		POST restAction = new POST();
		restAction.postRequest2();
	}
		public void postRequest2() throws IOException {

			Map<String, String> params = new HashMap<String, String>();
			params.put("u_userid", "admin");
			params.put("u_state", "approved");
			ObjectMapper mapper = new ObjectMapper();
			String jsonStr = mapper.writeValueAsString(params);
	
			CloseableHttpClient httpclient = HttpClients.custom().build();
		
		try {
			HttpPost httpPost = new HttpPost("https://<YOUR_INSTANCE>.service-now.com/api/now/v2/table/<YOUR_TABLE>");
			httpPost.setHeader("Accept", "application/json");
			httpPost.setHeader("Content-Type", "application/json");
			httpPost.setHeader("Authorization", "<YOUR_BASE64>");
			HttpEntity entity = new ByteArrayEntity(jsonStr.getBytes("utf-8"));
			httpPost.setEntity(entity);

		System.out.println("__________________________________________________________________________________________________");
		System.out.println(" ");
		System.out.println("Executing request " + httpPost.getRequestLine());
		CloseableHttpResponse response = httpclient.execute(httpPost);
		try {
			System.out.println("__________________________________________________________________________________________________");
			System.out.println(" ");
			System.out.println(response.getStatusLine());
			String responseBody = EntityUtils.toString(response.getEntity());
			System.out.println(" ");
			System.out.println("These are the Fields Populating via JSON Format: " + jsonStr);
			System.out.println(" ");
			System.out.println(responseBody);
			System.out.println(" ");
			System.out.println("__________________________________________________________________________________________________");
			System.out.println(" ");
			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}
	}
		public static void restPost3() throws ClientProtocolException, IOException, HttpException, JsonGenerationException {
			POST restAction = new POST();
			restAction.postRequest3();
		}
		public void postRequest3() throws IOException {

			Map<String, String> params = new HashMap<String, String>();
			params.put("u_userid", "admin");
			params.put("u_state", "rejected");
			ObjectMapper mapper = new ObjectMapper();
			String jsonStr = mapper.writeValueAsString(params);
	
			CloseableHttpClient httpclient = HttpClients.custom().build();
		
		try {
			HttpPost httpPost = new HttpPost("https://<YOUR_INSTANCE>.service-now.com/api/now/v2/table/<YOUR_TABLE>");
			httpPost.setHeader("Accept", "application/json");
			httpPost.setHeader("Content-Type", "application/json");
			httpPost.setHeader("Authorization", "<YOUR_BASE64>");
			HttpEntity entity = new ByteArrayEntity(jsonStr.getBytes("utf-8"));
			httpPost.setEntity(entity);

		System.out.println("__________________________________________________________________________________________________");
		System.out.println(" ");
		System.out.println("Executing request " + httpPost.getRequestLine());
		CloseableHttpResponse response = httpclient.execute(httpPost);
		try {
			System.out.println("__________________________________________________________________________________________________");
			System.out.println(" ");
			System.out.println(response.getStatusLine());
			String responseBody = EntityUtils.toString(response.getEntity());
			System.out.println(" ");
			System.out.println("These are the Fields Populating via JSON Format: " + jsonStr);
			System.out.println(" ");
			System.out.println(responseBody);
			System.out.println(" ");
			System.out.println("__________________________________________________________________________________________________");
			System.out.println(" ");
			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}
	}	
}