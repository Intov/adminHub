public class Task {
    boolean busy;
    int adminTasks;
    String nameTask;
    Task(boolean busy, String nameTask, int adminTasks){
        this.busy = busy;
        this.nameTask = nameTask;
        this.adminTasks = adminTasks;

    }

    public int getAdminTasks() {
        return adminTasks;
    }

    public String getNameTask() {
        return nameTask;
    }

    public boolean isBusy() {
        return busy;
    }
}
