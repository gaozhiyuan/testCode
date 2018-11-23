package com.vw.test2.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class TestG1 {
	
	public static class Person {
		String name;
		Person preContact;
		String work;
		
		public Person(String name, String work) {
			this.name = name;
			this.work = work;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}		
		public Person getPreContact() {
			return preContact;
		}
		public void setPreContact(Person preContact) {
			this.preContact = preContact;
		}
		public String getWork() {
			return work;
		}
		public void setWork(String work) {
			this.work = work;
		}
	}

	public Person findMongoSeller(Map<Person, List<Person>> relations, Person p) {
		Queue<Person> queue = new LinkedList<>();
		List<Person> checkedList = new ArrayList<>();
		queue.add(p);
		checkedList.add(p);
		while(!queue.isEmpty()) {
			Person person = queue.poll();
			
			if("peach".equals(person.getWork()))
				return person;
			
			List<Person> persons = relations.get(person);
			if(persons == null)
				return null;
			else {				
				persons.forEach(ps -> {
					if(!checkedList.contains(ps)) {
						queue.add(ps); 
						ps.setPreContact(person); 
						checkedList.add(ps);
						}
					}
				);
				
			}
			
			
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		Map<Person, List<Person>> relations = new HashMap<>();
		Person Bob = new Person("Bob", "apple");
		Person Tom = new Person("Tom", "orange");
		Person Alice = new Person("Alice", "peach");
		Person Frank = new Person("Frank", "driver");
		Person James = new Person("James", "butcher");
		Person Joyce = new Person("Joyce", "chef");
		Person Rita = new Person("Rita", "pilot");
		Person Simon = new Person("Simon", "mongo");
		
		relations.put(Bob, Arrays.asList(new Person[]{Tom, Alice}));
		relations.put(Tom, Arrays.asList(new Person[] {Frank, Alice}));
		relations.put(Alice, Arrays.asList(new Person[] {James}));
		relations.put(Frank, Arrays.asList(new Person[] {Alice, James, Joyce}));
		relations.put(James, Arrays.asList(new Person[] {Rita}));
		relations.put(Joyce, Arrays.asList(new Person[] {Simon}));
		relations.put(Rita, Arrays.asList(new Person[] {Joyce}));
		relations.put(Simon, null);
		
		TestG1 t = new TestG1();
		Person person = t.findMongoSeller(relations, Bob);
		if(person != null) {
			Stack<Person> personChain = new Stack<>();
			personChain.push(person);
			while(person.getPreContact() != null) {
				person = person.getPreContact();
				personChain.push(person);
			}
			
			while(!personChain.isEmpty())
				System.out.print(personChain.pop().getName() + "->");
		}
	}
}
