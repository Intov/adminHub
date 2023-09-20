import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ArrayList<Task> tasksFirstAdm = new ArrayList<Task>();
        tasksFirstAdm.add(new Task(false,"калькулятор", 1));
        tasksFirstAdm.add(new Task(false, "game-snake",1));
        tasksFirstAdm.add(new Task(false, "сапер",1));
        tasksFirstAdm.add(new Task(false, "paint",1));
        ArrayList<Task> tasksSecondAdm = new ArrayList<Task>();
        tasksSecondAdm.add(new Task(false,"<БД>", 2));
        tasksSecondAdm.add(new Task(false, "Маршруты",2));
        tasksSecondAdm.add(new Task(false, "Платформер",2));
        tasksSecondAdm.add(new Task(false, "google-maps",2));
        ArrayList<Executor> executors = new ArrayList<Executor>();
        Admin adminFirst = new Admin("Виктор Петрович");
        Admin admitSecond = new Admin("Даниил Мальцев");
        executors.add(new Executor("Федя")) ;
        executors.add(new Executor("Сеня")) ;
        executors.add(new Executor("Лева")) ;
        executors.add(new Executor("Луи")) ;
        executors.add(new Executor("Макс")) ;
        executors.add(new Executor("Ден")) ;
        executors.add(new Executor("Айнура")) ;
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Выберете пожалуйста профиль администратора: 1 или 2");
            int adminProfile = scanner.nextInt();
            System.out.println("Выберете пожалуйста действие, которое хотите совершить: 1. Выбрать исполнителя для задачи. 2. Снять исполнителя с задачи.");
            int a = scanner.nextInt();
            switch (a){
                case 1:
                    System.out.println("Выберете исполнителя, сейчас работают следующие люди.");
                    for (int i = 0; i < executors.size(); i++){
                        System.out.println(executors.get(i).getName());
                    }
                    if(adminProfile == 1){
                        System.out.println("Сейчас у вас есть, следующие не выполняющиеся задачи:");
                        for (int i = 0; i < tasksFirstAdm.size(); i++){
                            if(tasksFirstAdm.get(i).isBusy() == false) System.out.println(tasksFirstAdm.get(i).getNameTask());
                        }
                        System.out.println("Пожалуйста, выберете человека, которому хотите дать задание.");
                        scanner.nextLine();
                        String nameExecutor = scanner.nextLine();
                        System.out.println("Пожалуйста, выберете задание, которое хотите дать " + nameExecutor);
                        String taskCurrent = scanner.nextLine();
                        for(int i = 0; i < executors.size(); i++){

                            if(executors.get(i).getName().equals(nameExecutor)){
                                for(int y = 0; y < tasksFirstAdm.size(); y++){
                                    if(tasksFirstAdm.get(y).nameTask.equals(taskCurrent)){
                                        executors.get(i).appendId_task(tasksFirstAdm.get(y));
                                        tasksFirstAdm.get(y).busy = true;
                                    }
                                }
                            }
                        }
                    }
                    else if(adminProfile == 2){
                        System.out.println("Сейчас у вас есть, следующие не выполняющиеся задачи:");
                        for (int i = 0; i < tasksSecondAdm.size(); i++){
                            if(tasksSecondAdm.get(i).isBusy() == false) System.out.println(tasksSecondAdm.get(i).getNameTask());
                        }
                        System.out.println("Пожалуйста, выберете человека, которому хотите дать задание.");
                        scanner.nextLine();
                        String nameExecutor = scanner.nextLine();
                        System.out.println("Пожалуйста, выберете задание, которое хотите дать " + nameExecutor);
                        scanner.nextLine();
                        String taskCurrent = scanner.nextLine();
                        for(int i = 0; i < executors.size(); i++){
                            if(executors.get(i).getName().equals(nameExecutor)){
                                for(int y = 0; y < tasksSecondAdm.size(); y++){
                                    if(tasksSecondAdm.get(y).nameTask.equals(taskCurrent)){
                                        executors.get(i).appendId_task(tasksSecondAdm.get(y));
                                        tasksSecondAdm.get(y).busy = true;
                                    }
                                }
                            }
                        }
                    }
                    else System.out.println("Вы ввели неверный id, пожалуйста повторите вход в систему.\uD83D\uDE1B");
                    break;
                case 2:
                    System.out.println("Следущие исполнители сейчас работают:");
                    for(int i = 0; i < executors.size(); i++){
                        for(int y = 0; y < executors.get(i).id_task.size(); y++){
                            System.out.println( executors.get(i).getName() + " " + executors.get(i).id_task.get(y).nameTask);
                        }
                    }
                    System.out.println("Пожалуйста выберете человека, у которого хотите снять задачу.");
                    String executorCurrent = scanner.next();
                    System.out.println("Пожалуйста выберете, какую задачу вы хотите снять.");
                    String taskCurrent = scanner.next();

                    for(int i = 0; i < executors.size(); i++){
                        if(executors.get(i).name.equals(executorCurrent)){
                            for(int y = 0;y < executors.get(i).id_task.size(); y++){
                                if(executors.get(i).id_task.get(y).nameTask.equals(taskCurrent)){
                                    if(executors.get(i).id_task.get(y).getAdminTasks() == adminProfile){
                                        executors.get(i).id_task.get(y).busy = false;
                                        executors.get(i).id_task.remove(y);
                                    }
                                    else{
                                        System.out.println("Вы не имеете права управлять этой задачей.");
                                        break;
                                    }

                                }
                            }
                        }
                    }
                    break;
            }

        }
    }
}