import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class PersonId {

    private static HashMap<Person, Integer> personMap = new HashMap<>();

    public static void main(String[] args) throws ParseException, FileNotFoundException {
        Scanner s1 = new Scanner(
                new FileInputStream("C:\\Users\\Neha\\Desktop\\Javaprograms2020\\Summer2021\\people.txt"));
        int id = 0;

        while (s1.hasNextLine()) {
            String s = s1.nextLine();
            String toks[] = s.split("[\\s,]+");
            String name = toks[0];
            SimpleDateFormat d = new SimpleDateFormat("MM/dd/yyyy");
            Date dob = d.parse(toks[1]);
            String city = toks[2];
            Person p = new Person(name, dob, city);
            Integer val = personMap.get(p);
            if (val == null) {
                personMap.put(p, id);
                System.out.println("New Person:" + p + "Id:" + id);
                id++;
            } else {
                System.out.println(" Person Found:" + p + "Id:" + val);
            }

        }

        s1.close();
    }
}
