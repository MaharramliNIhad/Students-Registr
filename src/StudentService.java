import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Scanner;

public class StudentService {

    public StudentService(){

    }

    Students[] arr=new Students[100];
    int studentsCount=0;
  static  int idd=100;
    public void addStudent(String name,String surname){

        arr[studentsCount]=new Students(name,surname,idd);
        studentsCount++;
        idd++;
    }public void  showAll(){
        for (int i=0;i<studentsCount;i++){
            System.out.println(arr[i]);
        }
    }
    public void  deleteStudent(int idd){
        for (int i=0;i<studentsCount;i++){
            if (arr[i].id==idd){
                studentsCount--;
                arr[i]=null;
            for (int j=i;j<=studentsCount;j++){
                arr[j]=arr[j+1];
            }
            }
        }

    }
    public void  updateStudent(int idd,String name,String surname){
        for (int i=0;i<studentsCount;i++){
            if (arr[i].id==idd){
            arr[i].setName(name);
            arr[i].setSurname(surname);
            }

        }
        }
        public void writeToFileAll() throws IOException {
        if (!Files.exists(Paths.get("Students.txt"))){
        Files.createFile(Paths.get("Students.txt"));}
        for (int i=0;i<studentsCount;i++){
Files.write(Paths.get("Students.txt"),arr[i].toString().getBytes(StandardCharsets.UTF_8),StandardOpenOption.APPEND);

            System.out.println(Files.readAllLines(Paths.get("Students.txt")));
        }}

    public static void main(String[] args) throws IOException {
        StudentService s = new StudentService();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Student Registration \n" +
                "1-Add Student \n" +
                "2-Delete Student \n" +
                "3-Show All \n" +
                "4-Update Student \n" +
                "5-Write to File All \n" +
                "6-Exit System");
        while (true) {

            switch (sc.next()) {
                case "1":
                    System.out.println("Enter name and surname");
                    s.addStudent(sc.next(), sc.next());
                    break;
                case "2":
                    System.out.println("Enter id");
                    s.deleteStudent(sc.nextInt());
                    break;
                case "3":
                    s.showAll();
                    break;
                case "4":
                    System.out.println("Enter ID and change name and surname");
                    s.updateStudent(sc.nextInt(), sc.next(), sc.next());
                    break;
                case "5":
                    s.writeToFileAll();
                    System.out.println("Successfully added to file");
                    break;
                case "6":
                    System.out.println("see you later");
                    break;
                default:
                    System.out.println("invalid operation");
            }

        }
    }

}
