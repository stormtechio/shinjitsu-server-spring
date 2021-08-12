package com.stormtechio.shinjitsu.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.stormtechio.shinjitsu.model.News;

public interface NewsRepository extends Repository<News, Integer>{
	void save(News student);
	void deleteById(Long id);
	List<News> findAll();
	Optional<News> findById(Long id);
}
