package com.mjk.thymeleafTest.domain.post;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 500, nullable = false)
	private String title;
	
	@Column(columnDefinition = "Text", nullable = false)
	private String content;
	
	private String author;
	
	@Builder
	public Post(String title, String content, String author) {
		
		this.title=title;			
		this.content=content;
		this.author=author;
		
	}
}
