import java.util.Scanner;

public class Students {
   private String name;
   private String surname;
    int id;
    public Students(String name, String surname,int id) {
this.name=name;
this.surname=surname;
this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", id=" + id +
                '}';
    }
}
