
public class Student {
    public Student(String name, String id, String email, int rollNumber) {
        super();
        this.name = name;
        this.id = id;
        this.email = email;
        this.rollNumber = rollNumber;
    }

    private String name, id, email;
    private int rollNumber;

    public String get_student_details(String name, String id) {
        return this.name;
    }

    public int get_student_details(int id, String name) {
        return this.rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    @Override
    public String toString() {
        /**
         * Mutable - allows modification after the creation
         * Immutable - does not allow any modification after the creation
         */
        return String.format("Id : %s, Name - %s, email : %s", this.id, this.name
                , this.email);
    }

    public boolean equals(Student obj) {
        if (this.id == obj.id) {
            return true;
        }
        return false;
    }
}
