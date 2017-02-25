package com.warner.note;

import com.warner.note.clone.CloneUtil;
import com.warner.note.clone.Person;
import com.warner.note.clone.PersonSerializable;

public class NoteApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 不论是常量池的值还是在堆上分配的对象，clone时String对象都是浅拷贝
		String name = new String("warner constant");
		Person person = new Person();
		person.setName(name);
		person.setSex("man");
		Person clonePerson = null;
		try {
			clonePerson = (Person) person.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			clonePerson = new Person();
		}
		System.out.println(person == clonePerson);
		System.out.println(person.getName() == clonePerson.getName());// true
																		// clone完的对象中，String对象是浅拷贝
		person.setName("change name");
		System.out.println("original object ===" + person.getName());
		System.out.println("clone object ===" + clonePerson.getName());
		System.out.println(person.getName() == clonePerson.getName());

		// 序列化和Cloneable接口效率对比，通过实现Cloneable接口进行对象拷贝的效率明显要高
		PersonSerializable personSerializable = new PersonSerializable();
		long start1 = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			CloneUtil.seriaCopy(personSerializable);
		}
		long end1 = System.currentTimeMillis();
		System.out.println(end1 - start1);
		Person personObject = new Person();
		long start2 = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			try {
				personObject.clone();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		long end2 = System.currentTimeMillis();
		System.out.println(end2 - start2);
	}

}
