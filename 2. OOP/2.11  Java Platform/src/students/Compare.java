package students;

import java.util.Comparator;

class Compare implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getSSN().compareTo(o2.getSSN());
    }
}
