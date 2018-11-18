package week4;

abstract class Person {
	void showFullName() {
		System.out.print("Person");
	}
}

class People extends Person{
	int age;
	final String name;
	People (int age, String name){
		this.age = age;
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return this.age;
	}
	public String getName() {
		return this.name;
	}
	public void showFullName() {
		System.out.println(this.name);
	}
}

class Student extends People {
	final int stuId;
	static int peopleType = 1;
	Student (int age, String name, int stuId){
		super(age,name);
		this.stuId = stuId;
	}
	public int getId() {
		return this.stuId;
	}
	@Override
	public void showFullName() {
		System.out.println("Student:"+this.name);
	}
	
}

class Book {
	final int bookId;
	int bookStatus;
	int bookPeopleType;
	int bookPeopleId;
	Book (int bookId){
		this.bookId = bookId;
		bookStatus = 1;
		bookPeopleType = 0;
		bookPeopleId = 0;
	}
	
	void borrowBook(Student a) {
		this.bookStatus = 0;
		this.bookPeopleType = Student.peopleType;
		this.bookPeopleId = a.stuId;
		System.out.println(a.name+" Borrows "+this.bookId+" Successful!");
	}
	void returnBook() {
		this.bookStatus = 1;
		this.bookPeopleType = 0;
		this.bookPeopleId = 0;
		System.out.println(this.bookId+" has been returned!");
	}
	void showStatus() {
		if(this.bookStatus == 0) {
			System.out.println("The book has been borrowed!");
		}else {
			System.out.println("You can borrow it now!");
		}
	}
}

public class Week4 {

	static Book book1 = new Book(123);
	static Book book2 = new Book(124);
	static Student stu1 = new Student(20,"Tom",20180001);
	static Student stu2 = new Student(19,"John",20180201);
	
	public static void main(String[] args) {
		//Show information about stu1
		stu1.showFullName();
		System.out.println(stu2.name);
		//Borrow a book
		book1.showStatus();
		book1.borrowBook(stu1);
		book1.showStatus();
		System.out.println(book1.bookPeopleId);
		//return the book
		book1.returnBook();
		book1.showStatus();
	}

}
