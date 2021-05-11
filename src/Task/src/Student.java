package Task.src;

import java.io.Serializable;
import java.util.Comparator;

/*
 * Student 클래스
 * 학생 각각의 정보는 하나의 Student 데이터의 객체가 된다.
 */
public class Student implements Comparable<Student>, Serializable{
	private String id;		//학번
	private String name;	//이름
	private int score;		//자바 성적

	public Student(String id, String name, int score) {
		this.id = id;
		this.name = name;
		this.score = score;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String toString() {
		return id+":"+name+":"+score;
	}

	public boolean equals(Student stu) {
		boolean result = false;
		if(id.equals(stu.id))
			return true;

		return result;
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return name.compareTo(o.name);
	}

	public static Comparator<Student> nameComparator = new Comparator<Student>() {
		@Override
		public int compare(Student student1, Student student2) {
			return student1.name.compareTo(student2.name);
		}
	};

	public static Comparator<Student> scoreComparator = new Comparator<Student>() {
		@Override
		public int compare(Student studentScore1, Student studentScore2) {
			return studentScore2.score - studentScore1.score;
		}
	};
}
