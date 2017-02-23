package com.warner.note;

import com.warner.note.clone.Person;

public class NoteApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person person = new Person();
		person.setName("warner");
		person.setSex("man");
		Person clonePerson = null;
		try {
			clonePerson = (Person)person.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			clonePerson = new Person();
		}
		System.out.println(person == clonePerson);
		System.out.println(person.getName() == clonePerson.getName());
		person.setName("change name");
		System.out.println(clonePerson.getName());
		System.out.println(person.getName() == clonePerson.getName());
	}

}
