package bubbleGame.bubbleGame.test.ex00;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class Dog {
	private String name;	
}


public class LombokTest {
	
	public static void main(String[] args) {
		Dog d = new Dog();
		d.setName("멍멍이");			
		System.out.println(d.getName());
	}
}
