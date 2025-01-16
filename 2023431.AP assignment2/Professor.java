import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Professor extends User{
    public String name;
    public String email;
    public String password;

    public Professor(String name,String email,String password){
       super(name,email,password);


    }
    public void view_course(String code_teach,String sem,Admin admin_stu){
        ArrayList<Course_list> sem_curr_courses = admin_stu.getSemCourses(sem);
        for (Course_list course : sem_curr_courses) {
            if(code_teach.equals(course.Code())){
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


    }
   
    public void update_class_timings(Admin admin_stu,String updated_class_timings,String course_code,String sem){
        ArrayList<Course_list> sem_curr_courses = admin_stu.getSemCourses(sem);
        for(Course_list course: sem_curr_courses){
            if(course.Code().equals(course_code)){
                course.setTimings(updated_class_timings);
                System.out.println("Class timings updated successfully");
                return;
            }
        }
        System.out.println("Course not found.");
      


    }
    public void update_office_hour(Admin admin_stu,String updated_office_hour,String course_code,String sem){
        ArrayList<Course_list> sem_curr_courses = admin_stu.getSemCourses(sem);
        for(Course_list course: sem_curr_courses){
            if(course.Code().equals(course_code)){
                course.setOfficehours(updated_office_hour);
                System.out.println("Office hours updated successfully");
                return;
            }
        }
        System.out.println("Course not found.");
      


    }
    public void update_syllabus(Admin admin_stu,ArrayList updated_syllabus,String course_code,String sem){
        ArrayList<Course_list> sem_curr_courses = admin_stu.getSemCourses(sem);
        for(Course_list course: sem_curr_courses){
            if(course.Code().equals(course_code)){
                course.setSyllabus(updated_syllabus);
                System.out.println("Syllabus updated successfully");
                return;
            }
        }
        System.out.println("Course not found.");
      


    }
    public void assign_grades(Integer in_grade,String code_of_course,String in_email){

        Student student = main.find_student(in_email);

        if(student==null){
            System.out.print("Student not found\n");
            return;
        }

       ArrayList<String>registeredCourses=student.Registered();
       ArrayList<String>completedCourses=student.Completed();
       ArrayList<Integer>stu_grades=student.Grades();

       System.out.println("Registered courses: " + registeredCourses);



      if(registeredCourses.contains(code_of_course)){

         int idx=registeredCourses.indexOf(code_of_course);
         stu_grades.set(idx,in_grade);
         completedCourses.add(code_of_course);
         System.out.println("Grade assigned for " + code_of_course + ": " + in_grade);

      }
      else{
        System.out.print("Course not found\n");
      }

       


    }
    public void professor_func(){
        System.out.print("Professor mode: Please select from the following \n");
        System.out.print("1.1:-view  courses\n");
        System.out.print("1.2:-update courses\n");
        System.out.print("3:-assign_grades\n");
        System.out.print("4:-log out\n");
       

    }





}