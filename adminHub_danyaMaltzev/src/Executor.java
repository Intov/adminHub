import java.util.ArrayList;

public class Executor {
    String name;
    ArrayList<Task> id_task = new ArrayList<Task>();
    Executor (String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public  ArrayList<Task> getId_task() {
        return id_task;

    }
    public void appendId_task(Task task) {
        id_task.add(task);
    }
}
