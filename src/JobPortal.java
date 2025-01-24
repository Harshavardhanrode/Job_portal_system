
import java.util.ArrayList;
import java.util.Scanner;

public class JobPortal {
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Job> jobs = new ArrayList<>();
    private int jobIdCounter = 1;

    public void registerUser(String username, String password, String role) {
        users.add(new User(username, password, role));
        System.out.println(role + " registered successfully!");
    }

    public User loginUser(String username, String password) {
        for (User user : users) {
            if (user.login(username, password)) {
                return user;
            }
        }
        System.out.println("Invalid credentials!");
        return null;
    }

    public void addJob(String jobTitle, String company, String description) {
        jobs.add(new Job(jobIdCounter++, jobTitle, company, description));
        System.out.println("Job added successfully!");
    }

    public void viewJobs() {
        for (Job job : jobs) {
            job.displayJob();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        JobPortal portal = new JobPortal();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Register\n2. Login\n3. Add Job\n4. View Jobs\n5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.println("Enter username:");
                    String username = scanner.nextLine();
                    System.out.println("Enter password:");
                    String password = scanner.nextLine();
                    System.out.println("Enter role (JobSeeker/Employer):");
                    String role = scanner.nextLine();
                    portal.registerUser(username, password, role);
                    break;

                case 2:
                    System.out.println("Enter username:");
                    username = scanner.nextLine();
                    System.out.println("Enter password:");
                    password = scanner.nextLine();
                    User user = portal.loginUser(username, password);
                    if (user != null) {
                        System.out.println("Login successful! Welcome, " + user.getUsername());
                    }
                    break;

                case 3:
                    System.out.println("Enter job title:");
                    String title = scanner.nextLine();
                    System.out.println("Enter company name:");
                    String company = scanner.nextLine();
                    System.out.println("Enter job description:");
                    String description = scanner.nextLine();
                    portal.addJob(title, company, description);
                    break;

                case 4:
                    portal.viewJobs();
                    break;

                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Try again!");
            }
        }
    }
}
