package com.shihaichen.newsservices;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsController {
	
	@Inject
	private NewsApiClient newsApiClient;
	
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "text/plain")
	public String getNews(@RequestParam String category) throws Exception {

		newsApiClient.getNews(category).stream()
		.flatMap(x -> x.getArticles().stream())
		.map(x -> x.getTitle())
		.forEach(x -> System.out.println(x));
		return category;
	}
	public static void main(String[] args) throws Exception {
		NewsController newsController = new NewsController();
		newsController.getNews("general");
	}
}
