package com.allfunction.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class Number implements Comparable<Number> {
	public static void main(String[] args) {
		List<Number> numbers = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			numbers.add(new Number((int) (Math.random() * 10)));
		}

		numbers.forEach(n -> System.out.print(n.var + ", "));

		Collections.sort(numbers);

		System.out.println();

		numbers.forEach(n -> System.out.print(n.var + ", "));

		numbers.forEach((n) -> {
			System.out.println("Number: " + n.var);
		});

		numbers.forEach(new Consumer<Number>() {
			@Override
			public void accept(Number n) {
				System.out.println("Number: " + n.var);
			}
		});

		NumberComsumer consumer = new NumberComsumer();
		numbers.forEach(consumer);

		for (Number n : numbers) {
			System.out.println("Number: " + n.var);
		}

		for (int i = 0; i < numbers.size(); i++) {
			Number number = numbers.get(i);
			System.out.println("Number: " + number.var);
		}
	}

	int var;

	public Number(int var) {
		this.var = var;
	}

	@Override
	public int compareTo(Number other) {
		// 음수: 현재 객체가 앞
		// 양수: 다른 객체가 앞
		return this.var - other.var;
	}
}

class NumberComsumer implements Consumer<Number> {
	@Override
	public void accept(Number n) {
		System.out.println("Number: " + n.var);
	}
}