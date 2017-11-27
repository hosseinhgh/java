
package peopleinfile;

public class Person {
    private String name;
    private int age;
    // TODO: enum Gender    

    public Person(String name, int age) {
        setName(name);
        setAge(age);
    }
    
    public String getName() {
        return name;
    }

    public final void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name must not be null");
        }
        if (name.length() < 2 || name.length() > 50) {
            throw new IllegalArgumentException("Name must 2-50 characters long");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public final void setAge(int age) {
        this.age = age;
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Age must be between 0-150");
        }
    }

    @Override
    public String toString() {
        return String.format("%s is %d y/o", name, age);
    }
    
}
