package Project.src;

import java.util.Comparator;

public class Student implements Comparable<Student> {
    private String id; //학번
    private String name; //이름
    private int score; // 자바 성적
    private String dept;

    public Student(String id, String name, String dept, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.dept = dept;
    }

    public Student() {

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

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String toString() {
        return id + " : " + name + " : " + dept + " : " + score + "\n";
    }


    public boolean equals(Student stu) {
        boolean result = false;
        if (id.equals(stu.id))
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
