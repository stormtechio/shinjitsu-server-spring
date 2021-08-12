package com.stormtechio.shinjitsu.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stormtechio.shinjitsu.model.News;
import com.stormtechio.shinjitsu.repository.NewsRepository;
import com.stormtechio.shinjitsu.utils.Utils;

@Service
public class NewsService {

	@Autowired
	private NewsRepository newsRepository;
	
	public NewsService(NewsRepository newsRepository) {
		this.newsRepository = newsRepository;
	}
	
	public List<News> getNews(){
		return this.newsRepository.findAll();
	}

	public Map<String, String> addNews(News news) {
		
		Map<String, String> response = new HashMap<>();
		if(news == null) {
			 response.put(Utils.STATUS_KEY, Utils.STATUS_FAIL);
			 response.put(Utils.MESSAGE_KEY, "No news was sent to the server or the Id is not valid");
			 return response;
		}
		
		this.newsRepository.save(news);
		
		response.put(Utils.STATUS_KEY, Utils.STATUS_SUCCESS);
		response.put(Utils.MESSAGE_KEY, "News saved sucessfuly");
		return response;
		
		
	}
}
