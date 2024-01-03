package org.example;


import org.example.model.Task;
import org.example.controller.TaskController;
import org.example.dao.TaskDAO;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskDAO taskDAO = new TaskDAO();
        TaskController taskController = new TaskController(taskDAO);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Ajouter une tâche");
            System.out.println("2. Afficher toutes les tâches");
            System.out.println("3. Marquer une tâche comme terminée");
            System.out.println("4. Supprimer une tâche");
            System.out.println("5. Quitter");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Entrez la description de la tâche :");
                    String description = scanner.nextLine();
                    Task newTask = new Task();
                    newTask.setDescription(description);
                    taskController.addTask(newTask);
                    break;
                case 2:
                    List<Task> tasks = taskController.getAllTasks();
                    for (Task task : tasks) {
                        System.out.println(task.getId() + ". " + task.getDescription() +
                                (task.isCompleted() ? " (Terminée)" : ""));
                    }
                    break;
                case 3:
                    System.out.println("Entrez l'ID de la tâche à marquer comme terminée :");
                    Long completedTaskId = scanner.nextLong();
                    taskController.markTaskAsCompleted(completedTaskId);
                    break;
                case 4:
                    System.out.println("Entrez l'ID de la tâche à supprimer :");
                    Long removedTaskId = scanner.nextLong();
                    taskController.removeTask(removedTaskId);
                    break;
                case 5:
                    System.out.println("Au revoir !");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        }
    }
}
