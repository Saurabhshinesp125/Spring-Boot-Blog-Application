package in.saurabh.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.saurabh.payloads.ApiResponse;
import in.saurabh.payloads.CategoryDto;
import in.saurabh.services.CategoryService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory (@Valid @RequestBody CategoryDto cateogDto) {
	CategoryDto createCategory = this.categoryService.createCategogy (cateogDto);
	return new ResponseEntity<CategoryDto> (createCategory, HttpStatus.CREATED);
	}
	// update
	@PutMapping("/{catId}")
	public ResponseEntity<CategoryDto> updateCategory (@Valid @RequestBody CategoryDto cateogDto,@PathVariable Integer catId) {
	CategoryDto createCategory = this.categoryService.createCategogy(cateogDto);
	return new ResponseEntity<CategoryDto>(createCategory,HttpStatus.OK);
	}
	
	@DeleteMapping("/{catId}")
	public ResponseEntity<ApiResponse> deleteCategory (@PathVariable Integer catId) {
	 this.categoryService.deleteCategory(catId);
	return new ResponseEntity<>(new ApiResponse("Category is deleted successfully !! ",true),HttpStatus.OK);
	}
	
	@GetMapping("/{catId}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer catId)
	{
		CategoryDto category = this.categoryService.getCategory(catId);
		return new ResponseEntity<CategoryDto>(category,HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity <List<CategoryDto>> getCategories()
	{
		 List<CategoryDto> categories = this.categoryService.getCategories();
		return  ResponseEntity.ok(categories);
	}
	
}
