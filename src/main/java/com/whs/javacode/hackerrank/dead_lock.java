package com.whs.javacode.hackerrank;

class Person {
	int age;
	String name;

	Person(int age, String name) {
		this.age = age;
		this.name = name;
	}
}

class dead_lock {
	Person p1 = new Person(25, "umesh");
	Person p2 = new Person(23, "murali");

	Thread t1 = new Thread(" ") {
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				synchronized (p1) {
					synchronized (p2) {
						if (p1.age > p2.age)
							System.out.println(p1.name + " is elder than " + p2.name);
						else
							System.out.println(p2.name + " is elder than " + p1.name);
					}
				}
			}

		}
	};

	Thread t2 = new Thread(" ") {
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				synchronized (p2) {
					synchronized (p1) {
						if (p1.age > p2.age)
							System.out.println(p1.name + " is elder than " + p2.name);
						else
							System.out.println(p2.name + " is elder than " + p1.name);
					}
				}
			}

		}
	};

	public static void main(String a[]) {
		dead_lock dl = new dead_lock();
		dl.t1.start();
		dl.t2.start();
	}
}
