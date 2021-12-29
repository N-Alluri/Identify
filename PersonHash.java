import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PersonHash {

    public Object[] Personlist;

    public PersonHash() {
        Personlist = new Object[17];

    }

    @SuppressWarnings("unchecked")
    public boolean add(Person2 p) {
        int key = (p.hashCode() & 0x7fffffff) % 17;

        ArrayList<Person2> P = (ArrayList<Person2>) Personlist[key];

        if (P == null) {
            P = new ArrayList<Person2>();
            Personlist[key] = P;
        }
        P.add(p);
        return true;

    }

    @SuppressWarnings("unchecked")
    public ArrayList<Person2> get(Person2 search) {
        int key = search.hashCode() % 17;
        ArrayList<Person2> P = (ArrayList<Person2>) Personlist[key];
        if (P == null)
            return null;
        ArrayList<Person2> ret = new ArrayList<>();
        for (Person2 p : P) {
            if (p.equals(search))
                ret.add(p);
        }
        return ret;
    }

    public static void main(String[] args) throws ParseException, FileNotFoundException {
        Scanner s1 = new Scanner(
                new FileInputStream("C:\\Users\\Neha\\Desktop\\Javaprograms2020\\Summer2021\\people.txt"));
        int id = 0;
        PersonHash h = new PersonHash();
        while (s1.hasNextLine()) {
            String s = s1.nextLine();
            String toks[] = s.split("[\\s,]+");
            String name = toks[0];
            SimpleDateFormat d = new SimpleDateFormat("MM/dd/yyyy");
            Date dob = d.parse(toks[1]);
            String city = toks[2];
            Person2 p = new Person2(name, dob, city, id);
            h.add(p);
            id++;
        }
        s1.close();
        ArrayList<Person2> P = h.get(new Person2("neha", null, null, 0));
        if (P != null)
            for (Person2 p : P)
                System.out.println(p);
    }

}
