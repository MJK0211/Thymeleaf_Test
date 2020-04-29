package com.mjk.thymeleafTest.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.After;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mjk.thymeleafTest.domain.post.Post;
import com.mjk.thymeleafTest.domain.post.PostRepository;


@SpringBootTest
public class PostRepositoryTest {

	@Autowired
	PostRepository postRepository;
	
	@After
	public void cleanup() {
		postRepository.deleteAll();
	}
	
	@Test
	public void loadtext() {
		String title = "테스트 게시글";
		String content = "테스트 본문";
			
		postRepository.save(Post.builder()
				.title(title)
				.content(content)
				.author("kim123")
				.build());
		
		List<Post> postList = postRepository.findAll();
		
		Post post = postList.get(4);
		assertThat(post.getTitle()).isEqualTo(title);
		assertThat(post.getContent()).isEqualTo(content);
		
	}
}
