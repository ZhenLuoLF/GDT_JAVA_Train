import java.util.Objects;

public class User implements Comparable<User>{
    private String userId;
    private String firstName;
    private String lastName;
    private String companyName;
    private int version;

    public User(String userId, String firstName, String lastName, String companyName, int version) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
        this.version = version;
    }

    @Override
    public int compareTo(User other) {
        // Compare by first name first
        int firstNameComparison = this.firstName.compareTo(other.firstName);
        if (firstNameComparison != 0) {
            return firstNameComparison;
        }
        // If first names are the same, compare by last name
        return this.lastName.compareTo(other.lastName);
    }
    @Override
    public int hashCode(){
        return Objects.hash(firstName, lastName, companyName);
    }

    @Override
    public String toString() {
        return "" + userId + ", " + firstName + ", " + lastName + ", " + companyName + ", " + version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User u = (User) o;
        boolean result = false;
        if(this.firstName.equals(u.getFirstName())
                && this.lastName.equals(u.getLastName())
                && this.companyName.equals(u.getCompanyName())) {
            result = true;
        }
        return result;
    }
    public String[] toCSVString(){
        String[] strings = new String[5];
        strings[0] = this.userId;
        strings[1] = this.firstName;
        strings[2] = this.lastName;
        strings[3] = "" + this.version;
        strings[4] = this.companyName;
        return strings;
    }




    public String getUserId() {
        return userId;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getCompanyName() {
        return companyName;
    }
    public int getVersion() {
        return version;
    }



}
