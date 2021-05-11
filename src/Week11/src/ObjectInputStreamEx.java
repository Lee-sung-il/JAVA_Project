package Week11.src;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ObjectInputStreamEx {
    public static void main(String[] args) throws Exception {
        InputStream in = new FileInputStream("person.txt");
        ObjectInputStream ois = new ObjectInputStream(in);

        Person p1 = (Person) ois.readObject();
        Person p2 = (Person) ois.readObject();
        Person p3 = (Person) ois.readObject();

        ArrayList<Person> list = (ArrayList<Person>) ois.readObject();

        System.out.println(list);
        ois.close();
        in.close();

    }
}
