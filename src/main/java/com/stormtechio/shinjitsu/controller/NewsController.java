package com.stormtechio.shinjitsu.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.stormtechio.shinjitsu.model.News;
import com.stormtechio.shinjitsu.service.NewsService;

@RestController
@RequestMapping("news")
public class NewsController {
	
	@Autowired
	private NewsService newsService;
	
	public NewsController(NewsService newsService) {
		this.newsService = newsService;
	}
	
	
	@GetMapping("/")
	@ResponseBody
	public List<News> getNews() {
		return this.newsService.getNews();
	}
	
	@PostMapping("/")
	@ResponseBody
	public Map<String, String> addNews(@RequestBody News news) {
		return this.newsService.addNews(news);
	}
	
	
	
}
