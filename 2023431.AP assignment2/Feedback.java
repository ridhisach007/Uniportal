import java.util.ArrayList;

public class Feedback<T> {
    private ArrayList<T> feedbacks;

    
    public Feedback() {
        this.feedbacks = new ArrayList<>();
    }


    public void addFeedback(T feedback) {
        feedbacks.add(feedback);
    }

    
    public ArrayList<T> getFeedback() {
        return feedbacks;
    }

    public void printFeedback() {
        for (T feedback : feedbacks) {
            System.out.println(feedback);
        }
    }
}
