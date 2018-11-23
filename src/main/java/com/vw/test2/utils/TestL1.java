package com.vw.test2.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TestL1 {

	public static void main(String[] args) {
		List<String> proNames = Arrays.asList(new String[] {"Hello", "The", "Garden"});
		
		printList(proNames);
		List<String> newNames = proNames.stream().filter(str->str.length() >=5).map(String::toLowerCase).collect(Collectors.toList());
		printList(newNames);
		Collector c;
		
	}
	
	public static void printList(List<String> list) {
		list.forEach(System.out::print);
		System.out.println();
	}
}
