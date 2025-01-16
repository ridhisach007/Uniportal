import java.util.ArrayList;
import java.util.List;

public class Course_list{
    public String code;
    public String title;
    public String professor;
    public int credits;
    public ArrayList<String> prerequisites;
    public String timings;
    public ArrayList<String> syllabus;
    public int enrollment_limit;
    public String office_hours;
    public String location;
    public String ta;

    public Course_list(String code, String title, String professor, int credits, ArrayList<String> prerequisites, String timings,ArrayList<String> syllabus,int enrollment_limit,String office_hours,String location,String ta) {
        this.code = code;
        this.title = title;
        this.professor = professor;
        this.credits = credits;
        this.prerequisites = prerequisites;
        this.timings = timings;
        this.syllabus = syllabus;
        this.enrollment_limit = enrollment_limit;
        this.office_hours = office_hours; 
        this.location=location;
        this.ta=ta;
    }

    public String Code() {
        return code;
    }

    public String Title() {
        return title;
    }

    public String Professor() {
        return professor;
    }
    public String getTA() {
        return ta;
    }

    public int Credits() {
        return credits;
    }

    public ArrayList<String> Prerequisites() {
        return prerequisites;
    }
    public String Timings() {
        return timings;
    }

    public ArrayList<String> Syllabus() {
        return syllabus;
    }


    public int Enrollment() {
        return enrollment_limit;
    }

    public String Office_hours() {
        return office_hours;
    }
    public String Location() {
        return location;
    }

    public void setTimings(String timings) {
        this.timings = timings;
    }

    public void setEnrollment(int enrollment) {
        this.enrollment_limit = enrollment_limit;
    }
   
    public void setSyllabus(ArrayList syllabus) {
        this.syllabus = syllabus;
    }

    public void setOfficehours(String office_hours) {
        this.office_hours = office_hours;
    }
    public void setProfessorName(String professor) {
        this.professor = professor;
    }



}