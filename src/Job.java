
public class Job {
    private int jobId;
    private String jobTitle;
    private String company;
    private String description;

    public Job(int jobId, String jobTitle, String company, String description) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.company = company;
        this.description = description;
    }

    public void displayJob() {
        System.out.println("Job ID: " + jobId);
        System.out.println("Title: " + jobTitle);
        System.out.println("Company: " + company);
        System.out.println("Description: " + description);
    }

    public int getJobId() {
        return jobId;
    }
}

