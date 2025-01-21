package com.whs.javacode.javadevelopers;

public class SequenceGeneratorMain {

	public static void main(String[] args) {
		SequenceGenerator sg = SequenceGenerator.getDefault();
		System.out.println(sg.getSequenceId());
		for( int i = 0; i < 10; i++ ) {
			System.out.println(sg.nextId());
			sg.persist();
		}
		System.out.println("Curr: "+sg.currentId());
	}

}
