import javax.swing.*;
import java.util.ArrayList;
public class Task {
    private int taskNumber;
    private String taskName;
    private String taskDescription;
    private String developerDetails;
    private int taskDuration;
    private String taskID;
    private String taskStatus;
    static ArrayList<Task> taskList = new ArrayList<>();
    public static int totalHours = 0;

    public void setTaskNumber(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setTaskDescription(String taskDescription) {
        if(checkTaskDescription(taskDescription)){
            System.out.println("Please enter a task description of less than\n" +
                    "50 characters");
        }else{
            this.taskDescription = taskDescription;
            System.out.println("Task successfully captured");
        }

    }

    public Boolean checkTaskDescription(String taskDescription) {
        return taskDescription.length() <= 50;
    }

    public void setDeveloperDetails(String developerDetails) {
        this.developerDetails = developerDetails;
    }

    public void setTaskDuration(int taskDuration) {
        this.taskDuration = taskDuration;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public int getTaskDuration() {
        return taskDuration;
    }

    public String createTaskID() {
        String firstTwoChars = taskName.substring(0, Math.min(taskName.length(), 2));
        String lastThreeChars = developerDetails.substring(developerDetails.length() - 3);
        taskID = firstTwoChars.toUpperCase() + ":" + taskNumber + ":" + lastThreeChars.toUpperCase();
        return taskID;
    }

    public String printTaskDetails() {
        return "Task Status: " + taskStatus + "\nDeveloper Details: " + developerDetails + "\nTask Number: " + taskNumber
                + "\nTask Name: " + taskName + "\nTask Description: " + taskDescription + "\nTask ID: " + taskID
                + "\nDuration: " + taskDuration + " hours";
    }
    private void createTask(Task task) {
        this.taskList(task);
    }

    public static  void showWindow(){
        javax.swing.JOptionPane JOptionPane = new JOptionPane();
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");
        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks:"));
        for (int i = 0; i < numTasks; i++) {
            Task task = new Task();
            // Task Number is auto-incremented
            task.setTaskNumber(i);
            // Task Name
            task.setTaskName(JOptionPane.showInputDialog("Enter Task Name:"));
            // Task Description
            String description = JOptionPane.showInputDialog("Enter Task Description (max 50 characters):");
            if (description.length() <= 50) {
                task.setTaskDescription(description);
                JOptionPane.showMessageDialog(null, "Task successfully captured");
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
                i--; // Decrement i to allow the user to re-enter the task description
                continue;
            }
            // Developer Details
            task.setDeveloperDetails(JOptionPane.showInputDialog("Enter Developer Details:"));
            // Task Duration
            task.setTaskDuration(Integer.parseInt(JOptionPane.showInputDialog("Enter Task Duration (in hours):")));
            // Task Status
            Object[] statusOptions = {"To Do", "Done", "Doing"};
            int statusChoice = JOptionPane.showOptionDialog(null, "Select Task Status:", "Task Status",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, statusOptions, statusOptions[0]);
            switch (statusChoice) {
                case 0:
                    task.setTaskStatus("To Do");
                    break;
                case 1:
                    task.setTaskStatus("Done");
                    break;
                case 2:
                    task.setTaskStatus("Doing");
                    break;
            }
            // Calculate and display Task ID
            String taskID = task.createTaskID();
            JOptionPane.showMessageDialog(null, "Task ID: " + taskID);
            // Add task to the list
            createTask(task);
            taskList.add(task);
            // Calculate total hours
             totalHours += task.getTaskDuration();

            // Display task details
            JOptionPane.showMessageDialog(null, task.printTaskDetails());
        }
        // Display total hours
        JOptionPane.showMessageDialog(null, "Total Hours Across All Tasks: " + totalHours);
    }

}
