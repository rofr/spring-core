package m02;

import java.util.List;

public class Calculator {

	List<Integer> numbers;
	
	public Calculator(List<Integer> numbers) {
		this.numbers = numbers;
	}
	
	public int sum()
	{
		int sum = 0;
		for(Integer n : numbers) sum += n;
		return sum;
	}

}
