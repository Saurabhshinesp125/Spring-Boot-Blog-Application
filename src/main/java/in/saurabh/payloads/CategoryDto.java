package in.saurabh.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {

	private Integer categoryId;
	@NotBlank
	@Size(min = 4 ,message="min size of category Title is 4 Chars")
	private String categoryTitle;
	@NotBlank
	@Size(min =10 , message="min size of category Desc is 10 chars ")
	private String categoryDescription;
}
