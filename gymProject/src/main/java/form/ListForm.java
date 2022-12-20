package form;

import java.io.Serializable;

import lombok.Data;

@Data
public class ListForm implements Serializable {
	private String cardNo;
	private String name;
	private String gender;
	private String phone;

}
