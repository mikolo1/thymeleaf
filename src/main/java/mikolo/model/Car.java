package mikolo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Car {
	
	private Long nr;
	private String mark;
	private String model;
	
	public Car(String mark, String model) {
		this.mark = mark;
		this.model = model;
	}

	
}
