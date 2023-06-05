package in.saurabh.services;

import java.util.List;

import in.saurabh.payloads.CategoryDto;

public interface CategoryService {

	public CategoryDto createCategogy(CategoryDto categoryDto);
	public CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);
	public void deleteCategory(Integer categoryId);
	public CategoryDto getCategory(Integer categoryId);
	public List<CategoryDto> getCategories();
}
