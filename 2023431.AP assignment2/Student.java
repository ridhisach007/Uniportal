import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Student extends User{
    
    public String name;
    public String email;
    public String password;
    public ArrayList<Record> stu_1;
    public ArrayList<Record> stu_2;
    public ArrayList<Record> stu_3;
    private ArrayList<Complaint> stu_complaint = new ArrayList<>();
    public ArrayList<String>registered=new ArrayList<>();
    public ArrayList<String>completed=new ArrayList<>();    
    public ArrayList<Integer>grades=new ArrayList<>();
    
    public ArrayList<String> Registered() {
        return registered;
    }

    public ArrayList<Integer> Grades() {
        return grades;
    }
    public ArrayList<String> Completed() {
        return completed;
    }


    public Student(String name,String email,String password){
        super(name,email,password);
        this.stu_1=new ArrayList<>();
        this.stu_2=new ArrayList<>();
        this.stu_3=new ArrayList<>();

        ArrayList<String> grades_1=new ArrayList<>();
        grades_1.add("7");
        grades_1.add("8");
        grades_1.add("9");
       

        stu_1.add(new Record("Ridhi", 19, "Delhi",grades_1 ));

        ArrayList<String> grades_2=new ArrayList<>();
        grades_2.add("10");
        grades_2.add("10");
        grades_2.add("10");


        stu_2.add(new Record("Nirmal Ji", 77, "IIIT",grades_2));

        ArrayList<String> grades_3=new ArrayList<>();

        grades_3.add("10");
        grades_3.add("10");
        grades_3.add("10");

        stu_3.add(new Record("Sheetal", 44, "Delhi",grades_3));
        
        


    } public void view_comp_stat() {
        if (stu_complaint.isEmpty()) {
            System.out.println("No complaints.");
        } else {
            for (Complaint complaint : stu_complaint) {
                System.out.println("Here is the complaint: " + complaint.get_comp());
                System.out.println("Here is the status: " + complaint.get_stat());
            }
        }
    }

     public void view_course(Admin admin_stu,String sem){
        ArrayList<Course_list> sem_curr_courses = admin_stu.getSemCourses(sem);
        for (Course_list course : sem_curr_courses) {
            System.out.println("Course Code: " + course.Code());
            System.out.println("Course Title: " + course.Title());
            System.out.println("Professor: " + course.Professor());
            System.out.println("Credits: " + course.Credits());
            System.out.println("Prerequisites: " + course.Prerequisites());
            System.out.println("Timings: " + course.Timings());
            System.out.println("Syllabus: " +  course.Syllabus());
            System.out.println("Enrollment: " +  course.Enrollment());
            System.out.println("Office hours: " +  course.Office_hours());
            System.out.println();
        }
     }
     
    public void register_courses(Admin admin_stu, ArrayList<String> course_code, int no_courses, String sem) {
        ArrayList<Course_list> sem_curr_courses = admin_stu.getSemCourses(sem); 
        int sum = 0;  
        int x = 0;
        ArrayList<String> valid_courses = new ArrayList<>(); 

        try {
              for (int i = 0; i < no_courses; i++) {
                int found = 0; 
                  for (Course_list course : sem_curr_courses) {
                     if (i < course_code.size() && course_code.get(i).equals(course.Code())) {
                            found = 1;

                       if (course.Enrollment() <= 0) {
                            throw new CourseFullException("Course " + course.Code() + " is full.");
                            }
                      if (sum + course.Credits() <= 20) {
                           sum += course.Credits();
                            valid_courses.add(course_code.get(i)); 

               } else {
                     x = 1;
                  }
                   break;  
                }
        }
           if (found == 0) {
                   System.out.println(course_code.get(i) +  " is not available in the semester.");
          }
           }

            if (x == 0) {
                 for (int i = 0; i < valid_courses.size(); i++) {
                      System.out.println("You are successfully registered for " + valid_courses.get(i));
                        registered.add(valid_courses.get(i));
                      for (Course_list course : sem_curr_courses) {
                           if (valid_courses.get(i).equals(course.Code())) {
                            System.out.print("\n");
                            int enroll = course.Enrollment();
                            System.out.print("Enrollment before" + enroll+"\n");
                             enroll-=1;
                             System.out.print("Enrollment after" + enroll+"\n");
                             
                             course.setEnrollment(enroll); 
                               }
                         }
                            grades.add(null);
                        }
                 } else {
                           System.out.println("Credits exceeded. Cannot register for courses!\n");
                  }
                } 
        catch (CourseFullException e) {
         System.out.println(e.getMessage()); 
          }
}

    
    public void submit_comp(String write_comp) {
        Complaint comp_stu = new Complaint(write_comp);
        stu_complaint.add(comp_stu);
        System.out.println("Complaint recorded.");
    }
    public void view_schedule(Admin admin_stu,String sem){
        if (registered.isEmpty()) {
            System.out.println("Not registered for any courses.");
            return;
        }
        ArrayList<Course_list> sem_curr_courses = admin_stu.getSemCourses(sem);
        for (Course_list course : sem_curr_courses) {
            if (registered.contains(course.Code())) {  
                System.out.println("Course Code: " + course.Code());
                System.out.println("Timings: " + course.Timings());
                System.out.println("Professor: " + course.Professor());
                System.out.println("Location: " + course.Location());
                System.out.println();
            }
        }
    }
    public void drop_course(String drop){
        if(registered.contains(drop)){
            registered.remove(drop);
            System.out.println("Course " + drop + " has been successfully dropped.");
        }
        else{
            System.out.println("Course not found");
        }



    }
    private Record findStudentRecord(String name) {
        
        ArrayList<Record> all_stu = new ArrayList<>();
        all_stu.addAll(stu_1);
        all_stu.addAll(stu_2);
        all_stu.addAll(stu_3);
    
        
        for (Record record : all_stu) {
            if (name.equals(record.Name())) {  
                return record;
            }
        }
        return null; 
    }
    
    public void track_academic_progress(String email){
         
        Student student = main.find_student(email);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
    

        if (student.grades.isEmpty()) {
            System.out.println("No completed courses available for tracking.");
            return;
        }

        int total=0;
        int num_courses=student.completed.size();

        for (Integer grade : student.grades) {
            if(grade !=null){
            total=total+ grade;
            }
        }

        System.out.print("grades: "+student.grades);
        System.out.print("\n");

        System.out.print("completed: "+student.completed);
        System.out.print("\n");
        
        double SGPA= (double) total/num_courses;
        System.out.print("SGPA is "+ SGPA);
        System.out.print("\n");
       

    }
    public void give_feedback(String email,String feed_code,String choice){
       
            Student student = main.find_student(email);
            if (student == null) {
                System.out.println("Student not found.");
                return;
            }
        
            
            if (student.completed.contains(feed_code)) {
                Scanner scanner = new Scanner(System.in);
                
                if (choice.equals("1")){

                    Feedback<Integer> numeric_feedback = new Feedback<>();
                    System.out.println("Enter numeric feedback (1-5):");
                    int feed_num = scanner.nextInt();
                    scanner.nextLine();
                    numeric_feedback.addFeedback(feed_num);
                    System.out.println("Numeric feedback submitted for course " + feed_code);

                   


                }
                else if(choice.equals("2")){

                    Feedback<String> textual_feedback = new Feedback<>();
                    System.out.println("Enter textual feedback:");
                    String feed_text = scanner.nextLine();
                    textual_feedback.addFeedback(feed_text);
                    System.out.println("Textual feedback submitted for course " + feed_code);

                   

                } 
                else {
                    System.out.println("Invalid feedback type.");
                                }
                
                            }

            else {
                System.out.println("You have not completed this course.");
            }

        }
        
    public void student_func(){
        System.out.print("\n");
        System.out.print("1:-view available courses\n");
        System.out.print("2:-register for courses\n");
        System.out.print("3:-view schedule\n");
        System.out.print("4:-track academic progress\n");
        System.out.print("5:-drop courses\n");
        System.out.print("6.1:-submit complaints\n");
        System.out.print("6.2:-view complaints\n");
        System.out.print("7:-give feedback\n");
        System.out.print("8:-log out\n");


    }
    





}