import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {

    private static SimpleDateFormat dobFormatter = new SimpleDateFormat("dd-MMM-yyyy");
    private String name;
    private Date dob;
    private String city;

    public Person(String _name, Date _dob, String _city) {
        name = _name;
        dob = _dob;
        city = _city;
    }

    public String getName() {
        return name;
    }

    public Date getdob() {
        return dob;
    }

    public String getCity() {
        return city;
    }

    public String toString() {

        return "Name:" + name + ", Date of Birth: " + dobFormatter.format(dob) + ", City: " + city;
    }

    @Override
    public int hashCode() {
        int h = 17;
        h = 31 * h + name.hashCode();
        h = 31 * h + dob.hashCode();
        h = 31 * h + city.hashCode();
        return h;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Person) {
            Person p = (Person) o;
            return getName().equals(getName()) && getCity().equals(p.getCity()) && getdob().equals(p.getdob());
        }
        return false;

    }

}
