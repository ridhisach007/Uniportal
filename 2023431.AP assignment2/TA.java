import java.util.ArrayList;

public class TA extends Student{
     
    public TA(String name,String email,String password){
        super(name,email,password);
    }


    public void ta_assign_grades(Integer in_grade,String code_of_course,String in_email){

        Student student = main.find_student(in_email);                                                                        
       ArrayList<String>ta_registeredCourses=student.Registered();
       ArrayList<String>ta_completedCourses=student.Completed();
       ArrayList<Integer>ta_stu_grades=student.Grades();

       System.out.println("Registered courses: " + ta_registeredCourses);



      if(ta_registeredCourses.contains(code_of_course)){

         int idx=ta_registeredCourses.indexOf(code_of_course);
         ta_stu_grades.set(idx,in_grade);
         ta_completedCourses.add(code_of_course);
         System.out.println("Grade assigned for " + code_of_course + ": " + in_grade);

      }
      else{
        System.out.print("Course not found\n");
      }

       


    }
    public void ta_func(){
        System.out.print("1:-view available courses\n");
        System.out.print("2:-register for courses\n");
        System.out.print("3:-view schedule\n");
        System.out.print("4:-track academic progress\n");
        System.out.print("5:-drop courses\n");
        System.out.print("6.1:-submit complaints\n");
        System.out.print("6.2:-view complaints\n");
        System.out.print("7:-give feedback\n");
        System.out.print("8:-assign grades\n");
        System.out.print("9:-log out\n");


    }
    





}