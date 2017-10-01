package com.shihaichen.newsservices;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class NewsController {
	
	@Inject
	private NewsApiClient newsApiClient;
	
	@RequestMapping(value = "/news", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public AlexaResponse doPost(@RequestBody AlexaRequest request) throws Exception {
		System.out.println(request);
		
		List<String> titles = newsApiClient.getNews(request.getRequest()
				.getIntent().getSlots().get("category").getValue()).stream()
		.flatMap(x -> x.getArticles().stream())
		.map(x -> x.getTitle())
		.collect(Collectors.toList());
		String speech = "<speak>Here are the latest news. <break time=\"500ms\"> " + 
				String.join(" <break time=\"500ms\"> ", titles) + "</speak>";
		AlexaResponse alexaResponse = new AlexaResponse();
		alexaResponse.setVersion("1.0");
		Response response = new Response();
		OutputSpeech outputSpeech = new OutputSpeech();
		outputSpeech.setSsml(speech);
		response.setOutputSpeech(outputSpeech);
		alexaResponse.setResponse(response);
		
		return alexaResponse;
	}

//	/*public static void main(String[] args) throws Exception {
//		NewsController newsController = new NewsController();
//		
//		newsController.getNews("general");
//	}
}
