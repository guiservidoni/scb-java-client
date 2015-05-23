/*
Copyright 2014 Daniel Nilsson

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. 
 */

package org.dannil.scbapi.utility;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.io.input.BOMInputStream;

public class RequestPoster {

	public static String doGet(String address) {
		// System.out.println("get address: " + address);

		StringBuilder builder = new StringBuilder();
		try {
			URL url = new URL(address);

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			connection.setDoInput(true);
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/json");

			try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
				String line;
				while ((line = br.readLine()) != null) {
					System.out.println(line);
					builder.append(line);
				}
			}

			connection.disconnect();

			return builder.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String doPost(String address, String query) {
		// System.out.println("post address: " + address);
		// System.out.println("Query: " + query);

		StringBuilder builder = new StringBuilder();
		try {
			URL url = new URL(address);

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Accept", "application/json");
			connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");

			try (OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "utf-8")) {
				writer.write(query);
				writer.close();
			}

			try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
				try (BOMInputStream bis = new BOMInputStream(connection.getInputStream())) {
					String line;
					while ((line = br.readLine()) != null) {
						builder.append(line);
					}
				}
			}

			connection.disconnect();

			return builder.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String getCodes(String table) {
		return doGet(String.format("http://api.scb.se/OV0104/v1/doris/en/ssd/%s", table));
	}

}
