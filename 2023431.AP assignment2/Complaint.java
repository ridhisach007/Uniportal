public class Complaint {
    private String comp;
    private String stat;

    public Complaint(String comp) {
        this.comp = comp;
        this.stat = "pending";
    }

    public String get_comp() {
        return comp;
    }

    public String get_stat() {
        return stat;
    }

    public void set_stat(String stat) {
        this.stat = stat;
    }
}
