package com.shihaichen.newsservices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class NewsApiClient {
	private Map<String, String[]> categoryMap;
	
	public NewsApiClient() {
		super();
		categoryMap = new HashMap<>();
		categoryMap.put("general", new String[]{"associated-press", "the-huffington-post"});
		categoryMap.put("business", new String[]{"the-wall-street-journal", "bloomberg"});
		categoryMap.put("sports", new String[]{"espn", "fox-sports"});
		categoryMap.put("politics", new String[]{"breitbart-news"});
		categoryMap.put("entertainment", new String[]{"buzzfeed", "entertainment-weekly"});
		categoryMap.put("technology", new String[]{"engadget", "hacker-news"});
	}
	public List<Response> getNews(String category) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		List<Response> responseList = new ArrayList<>();
		for(String source: categoryMap.get(category)) {
			URL url = new URL("https://newsapi.org/v1/articles?source="+ source +"&apikey=7b39613ec06c444a908c4ca833923a3b");
			responseList.add(mapper.readValue(url, Response.class));
		}
		return responseList;
	}
}
