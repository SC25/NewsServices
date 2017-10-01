package com.shihaichen.newsservices;

import java.util.List;

public class Response {
	
	private String status;
	private String source;
	private String sortBy;
	private List<Article> articles;
	
	@Override
	public String toString() {
		return "Response [status=" + status + ", source=" + source + ", sortBy=" + sortBy + ", articles=" + articles
				+ "]";
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
}
