package in.saurabh.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserDto {

	private Integer id;
	private String name;
	private String email;
	private String password;
	private String about;
}
