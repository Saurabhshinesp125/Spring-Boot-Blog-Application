package in.saurabh.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException{

	String resourceName;
	String fieldName;
	Integer userId;
	public ResourceNotFoundException(String resourseName, String fieldName, Integer userId) {
		super(String.format("%s not found with %s :%s",resourseName,fieldName,userId));
		resourceName = resourceName;
		this.fieldName = fieldName;
		this.userId = userId;
	}
	
	
}
