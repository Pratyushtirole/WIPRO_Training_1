package WIPRO_TRAINING_1;

import java.util.*;



interface Attendance {
    void markAttendance();
    void displayAttendance();
}



class User {
    protected String name;
    protected String id;

    public User(String name, String id) {
        this.name = name;
        this.id = id;
    }
}


class Student extends User implements Attendance {
    private boolean isPresent;

    public Student(String name, String id) {
        super(name, id);
        this.isPresent = false;
    }

    @Override
    public void markAttendance() {
        this.isPresent = true;
        System.out.println("Attendance marked for student: " + name);
    }

    @Override
    public void displayAttendance() {
        String status = isPresent ? "Present" : "Absent";
        System.out.println("Student: " + name + ", ID: " + id + ", Attendance: " + status);
    }
}

class Record{
    private Student[] students;
    private  int index ;
    private int totalStudent;
    public Record(int val){
        this.students=new Student[val];
        this.index=0;
        this.totalStudent=val;
    }
    public void insertStudent(Student student){
        if(this.index>=this.totalStudent){
          System.out.println("Record in Overflow");
          return;
        }
        this.students[this.index]=student;
        this.index++;
    }

    public void markAttendance(String id){
        for(int i=0;i<this.index;i++){
            if(this.students[i].id==id){
                this.students[i].markAttendance();
            }
        }

        System.out.println("Student Not Found");
    }
    public void ShowAttendance(){
        for(int i=0;i<this.index;i++){
           
                this.students[i].displayAttendance();
            
        }

      
    }

}


public class AttendanceManagement {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Welcome in our Attendance management system");

        System.out.print("New Record has Created \n Give no.of Student you want to insert in record");
        int val=sc.nextInt();

        Record record=new Record(val);

        int entry;
do{
    System.out.println("\nSelect '1' for insert new student \n Select '2' To mark  attendance \n Select '3' To display all Student attendance \n Select '-1' to exit");
     entry=sc.nextInt();

    switch (entry) {
        case 1:
        System.out.print("Insert name=");
        String name=sc.nextLine();
        System.out.print("\n Insert id=");
        String id=sc.nextLine();
        Student student1 = new Student(name, id);
        record.insertStudent(student1);
            break;
    
        case 2:
        System.out.print("\n Insert id=");
        String rt=sc.nextLine();
        record.markAttendance(rt);
            break;   

        case 3:
        record.ShowAttendance();
            break;
        
        default:
            break;
    }

}while(entry>-1);

sc.close();

    }
}
