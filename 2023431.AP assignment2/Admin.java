import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Admin extends User{

    private static final String admin_password = "1234";
    public ArrayList<Course_list> sem_1;
    public ArrayList<Course_list> sem_2;
    public ArrayList<Course_list> sem_3;
    public ArrayList<Course_list> sem_4;

    

    public Admin(String name,String email){
        super(name,email,admin_password);
        this.sem_1=new ArrayList<>();
        this.sem_2=new ArrayList<>();
        this.sem_3=new ArrayList<>();
        this.sem_4=new ArrayList<>();

        //prereqs
        ArrayList<String> noPrereqs = new ArrayList<>();
        noPrereqs.add("None");

        //syllabus
        ArrayList<String> ip_syllabus = new ArrayList<>();
        ip_syllabus.add("if,else ");
        ip_syllabus.add("for,while ");

        ArrayList<String> dc_syllabus = new ArrayList<>();
        dc_syllabus.add("logic gates ");
        dc_syllabus.add("boolean ");

        ArrayList<String> comm_syllabus = new ArrayList<>();
        comm_syllabus.add("Ch1 ");
        comm_syllabus.add("Ch2 ");

        ArrayList<String> hci_syllabus = new ArrayList<>();
        hci_syllabus.add("Ch9 ");
        hci_syllabus.add("Ch2 ");
        
        ArrayList<String> la_syllabus = new ArrayList<>();
        la_syllabus.add("Ch1-6 ");

        ArrayList<String> cse_syllabus = new ArrayList<>();
        cse_syllabus.add("Ch1-6 ");
       
        

    sem_1.add(new Course_list("CSE 101", "Introduction to Programming", "Shad Akhtar", 4, noPrereqs, "9-11am",ip_syllabus,50,"10-11pm","LHC","jai"));
    sem_1.add(new Course_list("ECE 101", "Digital Circuits", "Tammam", 4, noPrereqs, "11-12pm",dc_syllabus,90,"10-11pm","LHC","mangal"));
    sem_1.add(new Course_list("DES 101", "Human Computer Interaction", "Sonal", 4, noPrereqs, "12-1pm",hci_syllabus,89,"10-11pm","LHC","rahul"));
    sem_1.add(new Course_list("SSH 101", "Communication", "Payal", 4, noPrereqs, "1-2pm",comm_syllabus,78,"8-9pm","LHC","rai"));
    sem_1.add(new Course_list("MTH 101", "Linear Algebra", "Subhajit", 4, noPrereqs, "2-3pm",la_syllabus,90,"5-6pm","LHC","kanha"));
    sem_1.add(new Course_list("CSE 333", "Data ", "Deb", 4, noPrereqs, "9-11am",cse_syllabus,90,"4-5pm","LHC","ridhi"));
   
    //prereqs
    ArrayList<String> dsa_preq = new ArrayList<>();
    dsa_preq.add("CSE 101");

    ArrayList<String> co_preq = new ArrayList<>();
    co_preq.add("CSE 101");
    co_preq.add("ECE 101");

    ArrayList<String> mth_preq = new ArrayList<>();
    mth_preq.add("MTH 101");

    //syllabus
    ArrayList<String> dsa_syllabus = new ArrayList<>();
        dsa_syllabus.add("sorting ");
        dsa_syllabus.add("graphs ");

        ArrayList<String> pns_syllabus = new ArrayList<>();
        pns_syllabus.add("prob ");
        pns_syllabus.add("stats ");

        ArrayList<String> isa_syllabus = new ArrayList<>();
        isa_syllabus.add("Ch1 ");
        isa_syllabus.add("Ch2 ");

        ArrayList<String> ctrss_syllabus = new ArrayList<>();
        ctrss_syllabus.add("Ch9 ");
        ctrss_syllabus.add("Ch2 ");
        
        ArrayList<String> co_syllabus = new ArrayList<>();
        co_syllabus.add("Ch1-6 ");

        ArrayList<String> algo_syllabus = new ArrayList<>();
        algo_syllabus.add("Ch1-6 ");


    sem_2.add(new Course_list("CSE 102", "Data Structures Algorithm", "Debarka", 4, dsa_preq, "9-11am",dsa_syllabus,30,"8-9pm","LHC","rajesh"));
    sem_2.add(new Course_list("CSE 202", "Computer Organization", "Tammam", 4, co_preq, "11-12pm",co_syllabus,90,"1-2pm","LHC","kumar"));
    sem_2.add(new Course_list("SSH 102", "Introduction to Sociology", "Prince", 4, noPrereqs, "12-1pm",isa_syllabus,90,"5-6pm","LHC","khanna"));
    sem_2.add(new Course_list("SSH 103", "Critical Thinking", "Priyadarshini", 4, noPrereqs, "1-2pm",ctrss_syllabus,90,"2-3pm","LHC","rafi"));
    sem_2.add(new Course_list("MTH 102", "Probability", "Sanjit", 4,mth_preq, "2-3pm",pns_syllabus,2,"4-5pm","LHC","pv"));
    sem_2.add(new Course_list("CSE 342", "Algorithm", "Dev", 4, noPrereqs, "6-7am",algo_syllabus,60,"9-10pm","LHC","narsimha"));
     

    
    ArrayList<String> ap_preq=new ArrayList<>();
     ap_preq.add("CSE 101");
     ap_preq.add("CSE 102");

     ArrayList<String> dm_preq=new ArrayList<>();
     dm_preq.add("CSE 101");
    
     ArrayList<String> os_preq=new ArrayList<>();
     os_preq.add("ECE 101");
     os_preq.add("CSE 202");

     ArrayList<String> m3_preq=new ArrayList<>();
     m3_preq.add("MTH 101");
     m3_preq.add("MTH 102");

     //syllabus
    ArrayList<String> ap_syllabus = new ArrayList<>();
    ap_syllabus.add("oops ");
    ap_syllabus.add("classes ");

    ArrayList<String> dm_syllabus = new ArrayList<>();
    dm_syllabus.add("prob ");
    dm_syllabus.add("stats ");

    ArrayList<String> m3_syllabus = new ArrayList<>();
    m3_syllabus.add("Ch1 ");
    m3_syllabus.add("Ch2 ");

    ArrayList<String> rmssd_syllabus = new ArrayList<>();
    rmssd_syllabus.add("Ch9 ");
    rmssd_syllabus.add("Ch2 ");
    
    ArrayList<String> os_syllabus = new ArrayList<>();
    os_syllabus.add("Ch1-6 ");

    ArrayList<String> m4_syllabus = new ArrayList<>();
    m4_syllabus.add("Ch1-6 ");



    sem_3.add(new Course_list("CSE 103", "Advanced Programming", "Sambuddho", 4, ap_preq, "9-11am",ap_syllabus,90,"1-2pm","LHC","a"));
    sem_3.add(new Course_list("CSE 203", "Discrete Mathematics", "Bapi", 4, dm_preq, "11-12pm",dm_syllabus,90,"1-2pm","LHC","b"));
    sem_3.add(new Course_list("SSH 104", "RMSSD", "Gayatri", 4, noPrereqs, "12-1pm",rmssd_syllabus,90,"1-2pm","LHC","c"));
    sem_3.add(new Course_list("ECE 103", "Operating Systems", "Raghava", 4, os_preq, "1-2pm",os_syllabus,90,"1-2pm","LHC","d"));
    sem_3.add(new Course_list("MTH 103", "Math III", "Sarthok", 4,m3_preq, "2-3pm",m3_syllabus,90,"1-2pm","LHC","e"));
    sem_3.add(new Course_list("MTH 107", "Math IV", "Sarji", 4,m3_preq, "4-5pm",m4_syllabus,60,"9-10pm","LHC","f"));
 

    ArrayList<String> ml_preq=new ArrayList<>();
     ml_preq.add("CSE 102");

     ArrayList<String> csl_preq=new ArrayList<>();
     csl_preq.add("CSE 101");
    
     ArrayList<String> ct_preq=new ArrayList<>();
     ct_preq.add("ECE 101");
     ct_preq.add("CSE 202");

     ArrayList<String> m4_preq=new ArrayList<>();
     m4_preq.add("MTH 101");
     m4_preq.add("MTH 102");
     m4_preq.add("MTH 103");

     //syllabus

     ArrayList<String> ml_syllabus = new ArrayList<>();
    ml_syllabus.add("ml1 ");
    ml_syllabus.add("ml2 ");

    ArrayList<String> csl_syllabus = new ArrayList<>();
    csl_syllabus.add("cs ");
    csl_syllabus.add("cse ");

    ArrayList<String> eco_syllabus = new ArrayList<>();
    eco_syllabus.add("Ch1 ");
    eco_syllabus.add("Ch2 ");

    ArrayList<String> ct_syllabus = new ArrayList<>();
    ct_syllabus.add("Ch9 ");
    ct_syllabus.add("Ch2 ");
    
    ArrayList<String> lin_syllabus = new ArrayList<>();
    lin_syllabus.add("Ch1-6 ");

    ArrayList<String> m9_syllabus = new ArrayList<>();
    m9_syllabus.add("Ch1-6 ");



    sem_4.add(new Course_list("CSE 105", "Machine Learning", "Pankaj", 4, ml_preq, "9-11am",ml_syllabus,90,"3-4pm","LHC","ts"));
    sem_4.add(new Course_list("CSE 205", "Computer Science Logic", "Ojaswi", 4, csl_preq, "11-12pm",csl_syllabus,90,"3-4pm","LHC","wf"));
    sem_4.add(new Course_list("SSH 105", "Economics", "Deepak", 4, noPrereqs, "12-1pm",eco_syllabus,90,"2-3pm","LHC","jh"));
    sem_4.add(new Course_list("ECE 104", "Circuit Theory", "Praveen", 4, ct_preq, "1-2pm",ct_syllabus,90,"2-3pm","LHC","mn"));
    sem_4.add(new Course_list("MTH 105", "Linearization", "Joy", 4,m4_preq, "2-3pm",lin_syllabus,90,"1-2pm","LHC","kl"));
    sem_4.add(new Course_list("MTH 109", "Linear", "Joytika", 4,m4_preq, "6-7am",m9_syllabus,90,"1-2pm","LHC","om"));

        

        
        

    }
    public ArrayList<Course_list> getSemCourses(String sem) {
        if(sem.equals("1")){
            return sem_1;
        }
        if(sem.equals("2")){
            return sem_2;
        }
        if(sem.equals("3")){
            return sem_3;
        }
        if(sem.equals("4")){
            return sem_4;
        }
       
        return new ArrayList<Course_list>(); 
    }
    public void view(String sem){
        ArrayList<Course_list> courses = null;
        if(sem.equals("1")){
           courses=sem_1;
        }
        if(sem.equals("2")){
            courses=sem_2;
        }
        if(sem.equals("3")){
           courses=sem_3;
        }
        if(sem.equals("4")){
            courses=sem_4;
        }
       
        for(Course_list i:courses){
            System.out.println("Course Code: " + i.Code());
            System.out.println("Course Title: " + i.Title());
            System.out.println("Professor: " +  i.Professor());
            System.out.println("Credits: " +  i.Credits());
            System.out.println("Prerequisites: " +  i.Prerequisites());
            System.out.println("Syllabus: " +  i.Syllabus());
            System.out.println("Enrollment: " +  i.Enrollment());
            System.out.println("Office hours: " +  i.Office_hours());
            System.out.println("Location: " +  i.Location());
            

            System.out.println();
        }





    }
   
    public void add(String ad_code,String ad_title,String ad_prof,int ad_credit,ArrayList prerequisites,String ad_timings,ArrayList syllabus_course,int ad_enrollment,String ad_office,String ad_location,String ad_ta,String sem){
         if(sem.equals("1")){
            sem_1.add(new Course_list(ad_code, ad_title, ad_prof, ad_credit, prerequisites, ad_timings,syllabus_course,ad_enrollment,ad_office,ad_location,ad_ta));
         }
         if(sem.equals("2")){
            sem_2.add(new Course_list(ad_code, ad_title, ad_prof, ad_credit, prerequisites, ad_timings,syllabus_course,ad_enrollment,ad_office,ad_location,ad_ta));
         }
         if(sem.equals("3")){
            sem_3.add(new Course_list(ad_code, ad_title, ad_prof, ad_credit, prerequisites, ad_timings,syllabus_course,ad_enrollment,ad_office,ad_location,ad_ta));
         }
         if(sem.equals("4")){
            sem_4.add(new Course_list(ad_code, ad_title, ad_prof, ad_credit, prerequisites, ad_timings,syllabus_course,ad_enrollment,ad_office,ad_location,ad_ta));
        }


    }
   
    public void delete(ArrayList<Course_list> deleted_course,String del_code){
        
        for(int i=0;i<deleted_course.size();i++){
            
            if(deleted_course.get(i).Code().equals(del_code)){
                deleted_course.remove(i);
            }
        }
        
    }
    public void view_records(Student stu_admin){
        
        System.out.println("Student 1:");
        for (Record record : stu_admin.stu_1) {
            System.out.println("Name: " + record.Name());
            System.out.println("Age: " + record.Age());
            System.out.println("Address: " + record.Address());
            System.out.println("Grades: " + record.Grades());
            System.out.println();
        }
    
        
        System.out.println("Student 2:");
        for (Record record : stu_admin.stu_2) {
            System.out.println("Name: " + record.Name());
            System.out.println("Age: " + record.Age());
            System.out.println("Address: " + record.Address());
            System.out.println("Grades: " + record.Grades());
            System.out.println();
        }
    
       
        System.out.println("Student 3:");
        for (Record record : stu_admin.stu_3) {
            System.out.println("Name: " + record.Name());
            System.out.println("Age: " + record.Age());
            System.out.println("Address: " + record.Address());
            System.out.println("Grades: " + record.Grades());
            System.out.println();
        }




    }
    public Record find_stu(Student stu_admin, String name_stu) {
    ArrayList<Record> all_stu = new ArrayList<>();
    all_stu.addAll(stu_admin.stu_1);
    all_stu.addAll(stu_admin.stu_2);
    all_stu.addAll(stu_admin.stu_3);
    
    for (Record record : all_stu) {
        if (name_stu.equals(record.Name())) {
            return record;
        }
    }
    return null;
}
    public void update_name(String updated_name,Student stu_admin,String name_stu){
        Record record=find_stu(stu_admin, name_stu);
        record.setName(updated_name);
        System.out.println("Name updated successfully");
      


    }
    public void update_age(int updated_age,Student stu_admin,String name_stu){
        Record record=find_stu(stu_admin, name_stu);
        record.setAge(updated_age);
        System.out.println("Age updated successfully");
      


    }
    public void update_address(String updated_address,Student stu_admin,String name_stu){
        Record record=find_stu(stu_admin, name_stu);
        record.setAddress(updated_address);
        System.out.println("Address updated successfully");
      


    }
    public void update_grades(ArrayList<String> updated_grades,Student stu_admin,String name_stu){
        Record record=find_stu(stu_admin, name_stu);
        record.setGrades(updated_grades);
        System.out.println("Grades updated successfully");
      


    }
    public void assign_prof(String prof_name,String sem_to_enter,String course_code){
        ArrayList<Course_list> sem_curr_courses = getSemCourses(sem_to_enter);

        for (Course_list course : sem_curr_courses) {
            if (course.Code().equals(course_code)) {
                course.setProfessorName(prof_name); 
                System.out.println("Assigned Professor " + prof_name + " to course " + course_code);
                return;
            }
        }
        System.out.println("Course code " + course_code + " not found in semester " + sem_to_enter);
    }
    
    
    public void admin_func(){
        System.out.print("Admin mode: Please select from the following \n");
        System.out.print("1:-manage course catalog\n");
        System.out.print("1.1:-view\n");
        System.out.print("1.2:-add\n");
        System.out.print("1.3:-delete\n");
        System.out.print("2:-manage student records\n");
        System.out.print("2.1:-view\n");
        System.out.print("2.2:-update\n");
        System.out.print("3:-assign professors\n");
        System.out.print("5:-Log out\n");


    }







}