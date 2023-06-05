package in.saurabh.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import in.saurabh.entity.Category;
import in.saurabh.exceptions.ResourceNotFoundException;
import in.saurabh.payloads.CategoryDto;
import in.saurabh.repositories.CategoryRepository;
import in.saurabh.services.CategoryService;
import io.swagger.v3.oas.annotations.servers.Servers;
@Service
public class CategoryServiceImpl implements CategoryService{

	private CategoryRepository categoryRepository;
	private ModelMapper mapper;
	
	
	
	public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper mapper) {
		super();
		this.categoryRepository = categoryRepository;
		this.mapper = mapper;
	}

	@Override
	public CategoryDto createCategogy(CategoryDto categoryDto) {
		Category map = this.mapper.map(categoryDto,Category.class);
		Category save = this.categoryRepository.save(map);
		return this.mapper.map(save,CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		Category category = this.categoryRepository.findById(categoryId)
		.orElseThrow(()->new ResourceNotFoundException("Category","Category Id", categoryId));
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDescription(categoryDto.getCategoryDescription()); 
		
		Category save = this.categoryRepository.save(category);
		return this.mapper.map(save,CategoryDto.class);
		
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		Category category = this.categoryRepository.findById(categoryId)
		.orElseThrow(()-> new ResourceNotFoundException("Category","category Id",categoryId));
		this.categoryRepository.delete(category);
		
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		this.categoryRepository.findById(categoryId)
		.orElseThrow(()->new ResourceNotFoundException("Category","category id", categoryId));
		return this.mapper.map(categoryId, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getCategories() {
		List<Category> findAll = this.categoryRepository.findAll();
		List<CategoryDto> list = findAll.stream().map((cat)->this.mapper.map(findAll,CategoryDto.class)).collect(Collectors.toList());
		
		return list;
	}

	
}
