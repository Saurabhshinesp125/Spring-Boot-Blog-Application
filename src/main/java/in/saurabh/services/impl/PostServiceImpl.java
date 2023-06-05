package in.saurabh.services.impl;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import in.saurabh.entity.Category;
import in.saurabh.entity.Post;
import in.saurabh.entity.User;
import in.saurabh.exceptions.ResourceNotFoundException;
import in.saurabh.payloads.PostDto;
import in.saurabh.repositories.CategoryRepository;
import in.saurabh.repositories.PostRepository;
import in.saurabh.repositories.UserRepository;
import in.saurabh.services.PostService;

@Service
public class PostServiceImpl implements PostService {

	private PostRepository postRepository;
	private ModelMapper mapper;
	private UserRepository userRepository;
	private CategoryRepository categoryRepository;


	

	public PostServiceImpl(PostRepository postRepository, ModelMapper mapper, UserRepository userRepository,
			CategoryRepository categoryRepository) {
		super();
		this.postRepository = postRepository;
		this.mapper = mapper;
		this.userRepository = userRepository;
		this.categoryRepository = categoryRepository;
	}

	@Override
	public PostDto createPost(PostDto postDto,Integer userId,Integer categoryId) {
		
		User user = this.userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","user Id ", userId));
		Category category = this.categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","category Id",categoryId));
		
		Post post = this.mapper.map(postDto,Post.class);
		post.setImageName("default.png");
		post.setAddedDadte(new Date());
		post.setUser(user);
		post.setCategory(category);
		
		Post post2 = this.postRepository.save(post);
		PostDto dto = mapper.map(post2,PostDto.class);
		return dto;
	}

	@Override
	public Post updatePost(PostDto postDto, Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePost(Integer postId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Post> getAllPost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post getPostById(Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getPostsByCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getPostsByUser(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> searchPosts(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
