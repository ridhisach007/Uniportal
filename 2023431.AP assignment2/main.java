import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
public class main{

    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Professor> professors = new ArrayList<>();
    private static ArrayList<TA> tas = new ArrayList<>();
    private static Admin admin_stu = new Admin("Admin Name", "admin@");
    private static Student stu_admin = new Student("Student Name", "student@","password");
    public static void main(String[] args){

        System.out.print("\n");
        System.out.println("       Welcome To The University ERP Page!       \n");
         
        Student Riya=new Student("riya","riya@","24");
        Riya.completed.add("MTH 102");
        Riya.completed.add("CSE 102");
        Riya.grades.add(10);
        Riya.grades.add(9);

        students.add(Riya);

        Student Jiya=new Student("jiya","jiya@","25");
        Jiya.completed.add("SSH 102");
        Jiya.completed.add("CSE 342");
        Jiya.grades.add(8);
        Jiya.grades.add(9);

        students.add(Jiya);

       Student Diya=new Student("diya","diya@","26");
       Diya.grades.add(0);
       Diya.grades.add(0);
       students.add(Diya);




        Scanner scanner = new Scanner(System.in);
        boolean run = true;

        while (run) {
            System.out.print("Log in as student/professor/admin/ta or 'exit' ");
            String user = scanner.nextLine();

            if (user.equals("exit")) {
                run = false;
                break;
            }

            switch (user) {
                case "admin":
                    log_admin(scanner);
                    break;
                case "student":
                    log_stu(scanner);
                    break;
                case "professor":
                    log_prof(scanner);
                    break;
                case "ta":
                    log_ta(scanner);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();

    }
    public static Student find_student(String email) {
        for (Student student : students) {
            if (student.get_email().equals(email)) {
                return student;
            }
        }
        return null; 
    }
    
    private static void log_admin(Scanner scanner) {
        try{
        System.out.print("Enter admin email: ");
        String email = scanner.nextLine();
        System.out.print("Enter admin password: ");
        String password = scanner.nextLine();

        if (admin_stu.login(email, password)) {
            admin_func(scanner, admin_stu);
        } else {
            throw new InvalidLoginException("Sorry, Invalid admin credentials.");
        }
    }
    catch(InvalidLoginException e){
        System.out.println(e.getMessage());
    }

    }
    private static void admin_func(Scanner scanner, Admin admin) {
        boolean adminLoggedIn = true;

    
       System.out.print("Enter semester: ");
       String sem = scanner.nextLine();

    
       while (adminLoggedIn) {
          System.out.println("Select option no: ");
          admin.admin_func(); 

          String function = scanner.nextLine();
          switch (function) {
            case "1.1":
                admin.view(sem);
                break;
            case "1.2":
                System.out.print("Enter course code to add: ");
                String ad_code = scanner.nextLine();
                System.out.print("Enter course title to add: ");
                String ad_title = scanner.nextLine();
                System.out.print("Enter course professor to add: ");
                String ad_prof = scanner.nextLine();
                System.out.print("Enter course credits to add: ");
                int ad_credit = scanner.nextInt();
                scanner.nextLine(); 
                System.out.print("Enter number of prerequisites to add: ");
                int n = scanner.nextInt();
                scanner.nextLine(); 
                
                ArrayList<String> prerequisites = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    System.out.print("Enter prerequisite " );
                    prerequisites.add(scanner.nextLine());
                }

                System.out.print("Enter course timings to add: ");
                String ad_timings = scanner.nextLine();

                System.out.print("Enter number of topics in syllabus: ");
                int no_of_topics = scanner.nextInt();
                scanner.nextLine(); 
                
                ArrayList<String> syllabus_course = new ArrayList<>();
                for (int i = 0; i < no_of_topics; i++) {
                    System.out.print("Enter syllabus topic ");
                    syllabus_course.add(scanner.nextLine());
                }

                System.out.print("Enter enrollment limit: ");
                int ad_enrollment = scanner.nextInt();
                scanner.nextLine(); 

                System.out.print("Enter office hour timings: ");
                String ad_office = scanner.nextLine();

                System.out.print("Enter location to add: ");
                String ad_location = scanner.nextLine();

                System.out.print("Enter course TA to add: ");
                String ad_ta = scanner.nextLine();

                admin.add(ad_code, ad_title, ad_prof, ad_credit, prerequisites, ad_timings, syllabus_course, ad_enrollment, ad_office,ad_location,ad_ta,sem);
                System.out.println("Details successfully added.");

                break;
            case "1.3":
                System.out.println("Please select course code to delete from the following: ");
                admin.view(sem);
                System.out.print("Enter course code to delete: ");
                String del_code = scanner.nextLine();
                ArrayList<Course_list> deleted_course = admin.getSemCourses(sem);
                admin.delete(deleted_course, del_code);
                System.out.println("After deletion:");
                admin.view(sem);
                System.out.println(del_code + " successfully deleted.");
                break;
            case "2.1":
                System.out.println("Here are the records:");
                admin.view_records(stu_admin);
                break;
            case "2.2": 
            System.out.print("Enter name of student to udpdate: \n");
            String name_stu=scanner.nextLine();
            System.out.print("Choose field to update: \n");
            System.out.print("name \n");
            System.out.print("age \n");
            System.out.print("address \n");
            System.out.print("grades \n");
            String field=scanner.nextLine();
            if(field.equals("name")){
                System.out.print("Give updated name; \n");
                String updated_name=scanner.nextLine();
                admin.update_name(updated_name,stu_admin,name_stu);


            }
            if(field.equals("age")){
                System.out.print("Give updated age; \n");
                int updated_age=scanner.nextInt();
                admin.update_age(updated_age,stu_admin,name_stu);

                
            }
            if(field.equals("address")){
                System.out.print("Give updated adress   ; \n");
                String updated_address=scanner.nextLine();
                admin.update_address(updated_address, stu_admin, name_stu);

                
            }
            if(field.equals("grades")){
                ArrayList<String> updated_grades=new ArrayList<>();
                for(int i=0;i<3;i++){
                System.out.print("Give updated grade; \n");
                String up_grade=scanner.nextLine();
                updated_grades.add(up_grade);


                }
                admin.update_grades(updated_grades, stu_admin, name_stu);
                break;

            }
            case "3" :
              System.out.print("Enter professor name\n");
              String prof_name=scanner.nextLine();
              System.out.print("Enter semester\n");
              String sem_to_enter=scanner.nextLine();
              System.out.print("Enter course code\n");
              String course_code=scanner.nextLine();
              admin.assign_prof(prof_name,sem_to_enter,course_code);


            case "5": 
                adminLoggedIn = false; 
                System.out.println("Logged out.");
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
        return; 
    }
    }
    private static void log_stu(Scanner scanner) {
        System.out.println("1. Login");
        System.out.println("2. Sign Up");
        String choice = scanner.nextLine();

        if (choice.equals("1")) {
            try{
            System.out.print("Enter email: ");
            String email = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            Student student = log_sign_equal_stu(email);

            if (student != null && student.login(email, password)) {
                stu_func(scanner, student);
            } else {
                throw new InvalidLoginException("Sorry, Invalid student credentials");
            }
          }
          catch(InvalidLoginException e){
            System.out.println(e.getMessage());
          }
        } else if (choice.equals("2")) {
            signUpStudent(scanner);
        }
    }
    private static void log_ta(Scanner scanner) {
        System.out.println("1. Login");
        System.out.println("2. Sign Up");
        String choice = scanner.nextLine();
    
        if (choice.equals("1")) {
            try{
            System.out.print("Enter email: ");
            String email = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
    
            TA ta = log_sign_equal_ta(email);
            if (ta != null && ta.login(email, password)) {
                ta_func(scanner, ta);
            } else {
                throw new InvalidLoginException("Sorry, Invalid TA credentials");
              }
           }
           catch(InvalidLoginException e){
            System.out.println(e.getMessage());
           }
        } else if (choice.equals("2")) {
            signUpTA(scanner);
        }
    }




    private static void log_prof(Scanner scanner) {
        System.out.println("1. Login");
        System.out.println("2. Sign Up");
        String choice = scanner.nextLine();

        if (choice.equals("1")) {
            try{
            System.out.print("Enter email: ");
            String email = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            Professor professor = log_sign_equal_prof(email);
            if (professor != null && professor.login(email, password)) {
                professorActions(scanner, professor);
            } else {
               throw new InvalidLoginException("Sorry, Invalid professor credentials");
            }
          }
           catch(InvalidLoginException e){
            System.out.println(e.getMessage());
           }
        } else if (choice.equals("2")) {
            signUpProfessor(scanner);
        }
    }

    private static void signUpStudent(Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
    

        Student student = new Student(name, email, password);
        students.add(student);
        System.out.println("Student signed up successfully!");
    }
    private static void signUpTA(Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
    
        TA ta = new TA(name, email, password);
        tas.add(ta);
        System.out.println("TA signed up successfully!");
    }
    private static void signUpProfessor(Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        Professor professor = new Professor(name, email, password);
        professors.add(professor);
        System.out.println("Professor signed up successfully!");
    }
    private static Student log_sign_equal_stu(String email) {
        for (Student student : students) {
            if (student.get_email().equals(email)) {
                return student;
            }
        }
        return null;
    }
    private static TA log_sign_equal_ta(String email) {
        for (TA ta : tas) {
            if (ta.get_email().equals(email)) {
                return ta;
            }
        }
        return null;
    }
    private static Professor log_sign_equal_prof(String email) {
        for (Professor professor : professors) {
            if (professor.get_email().equals(email)) {
                return professor;
            }
        }
        return null;
    }
    private static void stu_func(Scanner scanner, Student student) {
        boolean studentLoggedIn = true;
        System.out.print("Enter semester: ");
        String sem = scanner.nextLine();
        
        while(studentLoggedIn){
             System.out.println("Select option no: ");
             student.student_func();
        
            String function = scanner.nextLine();
            switch (function) {
                case "1": 
                    student.view_course(admin_stu, sem);
                    //studentLoggedIn = false;
                    break;
    
                case "2": 
                    System.out.print("Enter semester : ");
                    String semester = scanner.nextLine();
                    System.out.print("Enter no of courses to register : ");
                    int no_courses = scanner.nextInt();
                    scanner.nextLine(); 
                    ArrayList<String> course_codes = new ArrayList<>();
                    for (int i = 0; i < no_courses; i++) {
                        System.out.print("Enter course code: ");
                        String code = scanner.nextLine();
                        course_codes.add(code);
                    }
                    student.register_courses(admin_stu, course_codes, no_courses, semester);
                
                    break;

                case "3":
                  student.view_schedule(admin_stu,sem);
                  //studentLoggedIn = false;
                  break;
                
                case "4":
                  System.out.print("Enter mail to track progress ");
                  String email=scanner.nextLine();
                  student.track_academic_progress(email);
                  break;
                 
                case "5": 
                  LocalDate now = LocalDate.now();
                  int month = now.getMonthValue();
                  int year = now.getYear();
                  int day = now.getDayOfMonth();
                  LocalDate deadline =LocalDate.of(2024,1,1);
                  try{
                    int fyear=2024;
                    int fmonth = 1;
                    int fday = 1;
                    if(now.isAfter(deadline)){
                        throw new DropDeadlinePassedException("You missed the deadline ");
                    }
                    System.out.print("Enter course code to drop");
                    String drop= scanner.nextLine();
                    student.drop_course(drop);
                    break;
                  }catch(DropDeadlinePassedException e){
                    System.out.println(e.getMessage());
                  }
                  break;
                  
                  case "6.1": 
                    System.out.print("Write your issue: ");
                    String write_comp = scanner.nextLine();
                    student.submit_comp(write_comp);
                    break;
    
                case "6.2": 
                    student.view_comp_stat();
                    break;
                
                case "7": 
                   System.out.println("Enter your email ");
                   String email_feed = scanner.nextLine();
                   System.out.println("Enter course code for feedback");
                   String feed_code = scanner.nextLine();
                   System.out.println("1. Numeric rating or 2. Textual feedback?");
                   String choice = scanner.nextLine();
                   student.give_feedback(email_feed,feed_code,choice);
                   break;



                case "8": 
                    studentLoggedIn = false;
                    System.out.println("Logged out.");
                    break;
    
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
       
    }
    private static void ta_func(Scanner scanner, TA ta) {
        boolean taLoggedIn = true;
        System.out.print("Enter semester: ");
        String sem = scanner.nextLine();

        System.out.print("Enter the code course of whom you are the TA of: ");
        String code_ta = scanner.nextLine();
        
        while(taLoggedIn){
             System.out.println("Select option no: ");
             ta.ta_func();
        
            String function = scanner.nextLine();
            switch (function) {
                case "1": 
                    ta.view_course(admin_stu, sem);
                    //studentLoggedIn = false;
                    break;
    
                case "2": 
                    System.out.print("Enter semester : ");
                    String semester = scanner.nextLine();
                    System.out.print("Enter no of courses to register : ");
                    int no_courses = scanner.nextInt();
                    scanner.nextLine(); 
                    ArrayList<String> course_codes = new ArrayList<>();
                    for (int i = 0; i < no_courses; i++) {
                        System.out.print("Enter course code: ");
                        String code = scanner.nextLine();
                        course_codes.add(code);
                    }
                    ta.register_courses(admin_stu, course_codes, no_courses, semester);
                
                    break;

                case "3":
                  ta.view_schedule(admin_stu,sem);
                  break;
                
                case "4":
                  System.out.print("Enter mail to track progress ");
                  String email=scanner.nextLine();
                  ta.track_academic_progress(email);
                  break;
                 
                case "5": 
                  System.out.print("Enter course code to drop");
                  String drop= scanner.nextLine();
                  ta.drop_course(drop);
                  break;
                
                case "6.1": 
                    System.out.print("Write your issue: ");
                    String write_comp = scanner.nextLine();
                    ta.submit_comp(write_comp);
                    break;
    
                case "6.2": 
                    ta.view_comp_stat();
                    //studentLoggedIn = false;
                    break;
                
                case "7": 
                   System.out.println("Enter your email ");
                   String email_feed = scanner.nextLine();
                   System.out.println("Enter course code for feedback");
                   String feed_code = scanner.nextLine();
                   System.out.println("1. Numeric rating or 2. Textual feedback?");
                   String choice = scanner.nextLine();
                   ta.give_feedback(email_feed,feed_code,choice);


                case "8":
                    System.out.print("Enter code to assign grade ");
                    String code_of_course=scanner.nextLine();
                    if(code_of_course.equals(code_ta)){
                    System.out.print("Enter email of student");
                    String in_email=scanner.nextLine();
                    System.out.print("Enter assigned grade ");
                    int in_grade=scanner.nextInt();
                    scanner.nextLine();
                    ta.ta_assign_grades(in_grade, code_of_course,in_email);
                    }
                    else{
                        System.out.print("This is not your assigned course\n");
                    }
                break;

                case "9": 
                    taLoggedIn = false;
                    System.out.println("Logged out.");
                    break;
    
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
       
    }
    private static void professorActions(Scanner scanner, Professor professor) {
        boolean professorLoggedIn = true;
        
        System.out.print("Enter your course speciality: ");
        String code_teach = scanner.nextLine();

        System.out.print("Enter semester: ");
        String sem = scanner.nextLine();
        
        while (professorLoggedIn) {
            System.out.println("Select option no: ");
            professor.professor_func();
            
            String function = scanner.nextLine();
            
            switch (function) {
                case "1.1": 
                    System.out.print("Enter course code: ");
                    String course_code = scanner.nextLine();
                    if(course_code.equals(code_teach)){
                    professor.view_course(code_teach, sem, admin_stu);
                    }
                    else{
                        System.out.print("This is not your course\n ");
                    }
                    //professorLoggedIn = false;
                    break;
    
                case "1.2":
                    System.out.print("Enter course code to update: \n");
                    String update_course_code = scanner.nextLine();
                    if(update_course_code.equals(code_teach)){
                    System.out.println("Choose field to update: \n");
                    System.out.println("1. Timings \n2. Office hours \n3. Syllabus");
                    String field = scanner.nextLine();
    
                    switch (field) {
                        case "1":
                            System.out.print("Give updated timings: \n");
                            String updated_class_timings = scanner.nextLine();
                            professor.update_class_timings(admin_stu, updated_class_timings, update_course_code, sem);
                            professor.view_course(update_course_code, sem, admin_stu);
                            break;
    
                        case "2":
                            System.out.print("Give updated office hours: \n");
                            String updated_office_hour = scanner.nextLine();
                            professor.update_office_hour(admin_stu, updated_office_hour, update_course_code, sem);
                            professor.view_course(update_course_code, sem, admin_stu);
                            break;
    
                        case "3":
                            ArrayList<String> updated_syllabus = new ArrayList<>();
                            System.out.println("Enter number of topics in syllabus: ");
                            int n = scanner.nextInt();
                            scanner.nextLine();
                            for (int i = 0; i < n; i++) {
                                System.out.print("Enter syllabus topic: \n");
                                String syllabus_topic = scanner.nextLine();
                                updated_syllabus.add(syllabus_topic);
                            }
                            professor.update_syllabus(admin_stu, updated_syllabus, update_course_code, sem);
                            professor.view_course(update_course_code, sem, admin_stu);
                            break;
                          

    
                        default:
                            System.out.println("Invalid option. Please try again.");
                    }
                    
                    }
                    else{
                        System.out.println("This is not your course\n");
                    }
                    break;
                    
                case "3":
                  System.out.print("Enter code to assign grade ");
                  String code_of_course=scanner.nextLine();
                  if(code_of_course.equals(code_teach)){
                  System.out.print("Enter assigned grade ");
                  int in_grade=scanner.nextInt();
                  scanner.nextLine();
                  System.out.print("Enter email ");
                  String in_email=scanner.nextLine();
                  professor.assign_grades(in_grade, code_of_course,in_email);
                  }
                  else{
                    System.out.print("This is not your course\n");
                  }
                  break;

                case "4":
                    professorLoggedIn = false;
                    System.out.println("Logged out.");
                    break;
    
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    
    
       
    
    }
       
      
   
      