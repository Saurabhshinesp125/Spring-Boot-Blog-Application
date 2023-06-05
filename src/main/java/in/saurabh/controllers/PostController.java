package in.saurabh.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.saurabh.payloads.PostDto;
import in.saurabh.services.PostService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api")
public class PostController {

	
	private PostService postService;
	
	
	
	
	public PostController(PostService postService) {
		super();
		this.postService = postService;
	}

	@PostMapping("/user/{userId}/category/{ctegoryId}/posts")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postdto,
			@PathVariable Integer userId,
			@PathVariable Integer categoryId)
	{
		PostDto createPost = this.postService.createPost(postdto, userId, categoryId);
		return new ResponseEntity<PostDto>(createPost,HttpStatus.CREATED);
	}
}
