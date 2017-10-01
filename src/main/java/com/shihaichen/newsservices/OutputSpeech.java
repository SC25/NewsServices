package com.shihaichen.newsservices;

public class OutputSpeech {
	private String type = "SSML";
	private String ssml;
	
	public String getType() {
		return type;
	}
	public String getSsml() {
		return ssml;
	}
	public void setSsml(String ssml) {
		this.ssml = ssml;
	}
	
}
