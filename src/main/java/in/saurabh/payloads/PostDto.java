package in.saurabh.payloads;

import java.util.Date;

import in.saurabh.entity.Category;
import in.saurabh.entity.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostDto {

	private String title;
	private String content;
	private String imageName;
	private Date addedDate;
	
	private Category category;
	
	private User user;
}
