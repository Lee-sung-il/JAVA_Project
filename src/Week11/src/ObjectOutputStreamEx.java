package Week11.src;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class ObjectOutputStreamEx {
    public static void main(String[] args) throws Exception {
        OutputStream out = new FileOutputStream("person.txt");
        ObjectOutputStream oos = new ObjectOutputStream(out);

        Person p1 = new Person("kim",20,"111-1111");
        Person p2 = new Person("Lee",22,"222-2222");
        Person p3 = new Person("Park",22,"333-3333");

        oos.writeObject(p1);
        oos.writeObject(p2);
        oos.writeObject(p3);

        ArrayList<Person> list = new ArrayList<Person>();

        list.add(p1);
        list.add(p2);
        list.add(p3);

        oos.writeObject(list);

        oos.close();
        out.close();

    }
}
