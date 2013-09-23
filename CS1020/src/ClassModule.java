import java.util.ArrayList;

class ClassModule {
    private String name; // module name
    private String code; // module code
    private int credit; // credit given
    private int time; // the time of the lecture
    private ArrayList<Lecturer> lecturers; // the lecturer[s] of the module
    private ArrayList<Student> studentEnrolled; // the students enrolled in the module

    /**
     * The constructor of the class Module
     *
     * @pre Arguments passed in must be valid
     * @post The object is successfully created and instantiated properly
     */
    public ClassModule(String _name, String _code, int _credit, int _time) {
        name = _name;
        code = _code;
        credit = _credit;
        time = _time;
    }

    // declare getters and setters
    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getCredit() {
        return credit;
    }

    public int getTime() {
        return time;
    }

    public void setName(String _name) {
        name = _name;
    }

    public void setCode(String _code) {
        code = _code;
    }

    public void setCredit(int _credit) {
        credit = _credit;
    }

    public void setTime(int _time) {
        time = _time;
    }

    /**
     * Returns the number of students enrolled in the module
     *
     * @pre studentEnrolled must be initialized
     * @post return the number of students back to parent
     */
    public int getStudentCount() {
        return studentEnrolled.size();
    }

    /**
     * Add the student to the front of the arraylist
     *
     * @pre studentEnrolled must be initialized and _student must not be null
     * @post _student object will be added into the front of arraylist
     */
    public boolean addStudentToFront(Student _student) {
        return studentEnrolled.add(_student);
    }

    /**
     * Add the student to the back of the arraylist
     *
     * @pre studentEnrolled must be initialized and _student must not be null
     * @post _student object will be added into the back of arraylist
     */
    public void addStudentToBack(Student _student) {
        studentEnrolled.add(0, _student);
    }

    /**
     * Remove the student object from the front of the arraylist
     *
     * @pre studentEnrolled must be initialized
     * @post studentEnrolled has a -1 in size and the object is removed from the front
     */
    public void removeFrontStudent() {
        studentEnrolled.remove(studentEnrolled.size() - 1);
    }

    /**
     * Remove the student object from the back of the arraylist
     *
     * @pre studentEnrolled must be initialized
     * @post studentEnrolled has a -1 in size and the object is removed from the back
     */

    public void removeBackStudent() {
        studentEnrolled.remove(0);
    }

    /**
     * Given the index, retrieve the student object from the arraylist
     *
     * @pre the index given must be of a valid index
     * @post the student object at that given index is returned
     */
    public Student searchStudent(int index) {
        return studentEnrolled.get(index);
    }
}


class Student {
    private String name; // name of student
    private String matric; // the matric number of student
    private String faculty; // the faculty the student is from
    private String[] contactInformation; // contains the student's contact information

    /**
     * The constructor of the class Student.
     *
     * @pre Argument passed in must be valid
     * @post The object is successfully created and instantiated properly
     */
    public Student(String _name, String _matric, String _faculty, String[] _contactInformation) {
        name = _name;
        matric = _matric;
        faculty = _faculty;
        contactInformation = _contactInformation;
    }

    // declare getters and setters
    public String getName() {
        return name;
    }

    public String getMatric() {
        return matric;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setName(String _name) {
        name = _name;
    }

    public void setMatric(String _matric) {
        matric = _matric;
    }

    public void setFaculty(String _faculty) {
        faculty = _faculty;
    }
}

class Lecturer {
    private String name; // name of lecturer
    private String faculty; // the faculty the lecturer is from
    private String[] contactInformation; // contains the lecturer's contact information

    /**
     * The constructor of the class Lecturer.
     *
     * @pre Argument passed in must be valid
     * @post The object is successfully created and instantiated properly
     */
    public Lecturer(String _name, String _faculty, String[] _contactInformation) {
        name = _name;
        faculty = _faculty;
        contactInformation = _contactInformation;
    }

    // declare getters and setters
    public String getName() {
        return name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setName(String _name) {
        name = _name;
    }

    public void setFaculty(String _faculty) {
        faculty = _faculty;
    }
}
