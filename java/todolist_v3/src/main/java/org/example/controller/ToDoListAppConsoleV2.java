package org.example.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.example.impl.TaskDAOImpl;
import org.example.impl.UserDAO;
import org.example.model.Task;
import org.example.model.TaskInfo;
import org.example.model.User;

public class ToDoListAppConsoleV2 {

    private static EntityManagerFactory entityManagerFactory;
    private static TaskDAOImpl taskDAO;

    private static UserDAO userDAO;

    private static User user;


    public static void main() {
        entityManagerFactory = Persistence.createEntityManagerFactory("todolist");
        taskDAO = new TaskDAOImpl(entityManagerFactory);
        userDAO = new UserDAO();


        Scanner scanner = new Scanner(System.in);


        int choice;
        do {
            System.out.println("#### To Do List ####");
            System.out.println("1. Ajouter une tâche à la liste");
            System.out.println("2. Afficher toutes les tâches de la liste");
            System.out.println("3. Marquer une tâche comme terminée");
            System.out.println("4. Supprimer une tâche de la liste");
            System.out.println("5. Modifier une tâche");
            System.out.println("6. Modifier les informations d'une tâche");
            System.out.println("7. Gérer les utilisateurs");
            System.out.println("8. Quitter l'application");
            System.out.println("Choix : ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addTask(scanner);
                    break;
                case 2:
                    displayTasks();
                    break;
                case 3:
                    markTaskAsCompleted(scanner);
                    break;
                case 4:
                    deleteTask(scanner);
                    break;
                case 5:
                    updateTask(scanner);
                    break;
                case 6:
                    updateTaskInfo(scanner);
                    break;
                case 7:
                    manageUsers(scanner);
                    break;
                case 8:
                    System.out.println("Bye");
                    entityManagerFactory.close();
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (choice != 7);
    }

    private static void addTask(Scanner scanner) {
        System.out.println("Entrez l'id de l'utilisateur : ");
        long userName = scanner.nextLong();
        scanner.nextLine();

        user = userDAO.getUserById(userName);
        if (user == null) {
            user = new User();
            user.setId(userName);
            userDAO.addUser(user);
        }

        System.out.println("Entrer le titre de la tâche : ");
        String title = scanner.nextLine();

        System.out.println("Entrer la description de la tâche : ");
        String description = scanner.nextLine();

        System.out.println("Date limite de la tâche : (dd.MM.yyyy)");
        String dueDateStr = scanner.nextLine();

        LocalDate dueDate = LocalDate.parse(
                dueDateStr,
                DateTimeFormatter.ofPattern("dd.MM.yyyy")
        );

        System.out.println("Priorité de la tâche : ");
        int priority = scanner.nextInt();
        scanner.nextLine();

        // Creation de la tache
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);

        // Creation de la taskinfo
        TaskInfo taskInfo = new TaskInfo(description, dueDate, priority);

        // Mise en relation
        task.setTaskInfo(taskInfo);
        task.setUser(user);
        taskInfo.setTask(task);

        if (taskDAO.addTask(task)) {
            System.out.println("Tâche ajoutée avec succès !");
        } else {
            System.out.println("Erreur");
        }
    }

    private static void displayTasks() {
        List<Task> tasks = taskDAO.getAllTasks();

        if (tasks.isEmpty()) {
            System.out.println("Aucune tâche trouvée.");
        } else {
            System.out.println("=== Liste des tâches ===");
            for (Task task : tasks) {
                System.out.println("###########");
                System.out.println(
                        task.getId() +
                                ". " +
                                task.getTitle() +
                                " (" +
                                (task.isCompleted() ? "Terminée" : "En cours") +
                                ")"
                );
                System.out.println(task.getTaskInfo().toString());
                System.out.println("###########");
            }
        }
    }


    private static void updateTask(Scanner scanner) {
        System.out.println("Entrez l'ID de la tâche à modifier : ");
        Long taskId = scanner.nextLong();
        scanner.nextLine();

        Task task = taskDAO.findTaskById(taskId);
        if (task == null) {
            System.out.println("Tâche non trouvée.");
            return;
        }

        System.out.println("Entrez le nouveau titre de la tâche (actuel: " + task.getTitle() + ") :");
        String title = scanner.nextLine();
        task.setTitle(title);

        if (taskDAO.updateTask(task)) {
            System.out.println("Tâche mise à jour avec succès.");
        } else {
            System.out.println("Erreur lors de la mise à jour de la tâche.");
        }
    }

    private static void updateTaskInfo(Scanner scanner) {
        System.out.println("Entrez l'ID de la tâche dont vous voulez modifier les informations : ");
        Long taskId = scanner.nextLong();
        scanner.nextLine();

        Task task = taskDAO.findTaskById(taskId);
        if (task == null || task.getTaskInfo() == null) {
            System.out.println("Tâche ou informations de tâche non trouvées.");
            return;
        }

        TaskInfo taskInfo = task.getTaskInfo();

        System.out.println("Entrez la nouvelle description (actuelle: " + taskInfo.getDescription() + ") :");
        String description = scanner.nextLine();
        taskInfo.setDescription(description);

        System.out.println("Date limite de la tâche (actuelle: " + taskInfo.getDueDate() + ") : (dd.MM.yyyy)");
        String dueDateStr = scanner.nextLine();
        LocalDate dueDate = LocalDate.parse(dueDateStr, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        taskInfo.setDueDate(dueDate);

        System.out.println("Priorité de la tâche (actuelle: " + taskInfo.getPriority() + ") : ");
        int priority = scanner.nextInt();
        scanner.nextLine();
        taskInfo.setPriority(priority);

        if (taskDAO.updateTaskInfo(taskInfo)) {
            System.out.println("Informations de la tâche mises à jour avec succès.");
        } else {
            System.out.println("Erreur lors de la mise à jour des informations de la tâche.");
        }
    }


    private static void deleteTask(Scanner scanner) {
        System.out.println("Entrez l'ID de la tâche à supprimer : ");
        Long taskId = scanner.nextLong();
        scanner.nextLine();

        if (taskDAO.deleteTask(taskId)) {
            System.out.println("Suppression OK");
        } else {
            System.out.println("Erreur");
        }
    }

    private static void markTaskAsCompleted(Scanner scanner) {
        System.out.println("Entrez l'ID de la tâche à supprimer : ");
        Long taskId = scanner.nextLong();
        scanner.nextLine();

        if (taskDAO.markTaskAsCompleted(taskId)) {
            System.out.println("Modification OK");
        } else {
            System.out.println("Erreur");
        }
    }

    private static void manageUsers(Scanner scanner) {
        int userChoice;
        do {
            System.out.println("#### Gestion des Utilisateurs ####");
            System.out.println("1. Ajouter un utilisateur");
            System.out.println("2. Afficher les tâches par utilisateur");
            System.out.println("3. Supprimer un utilisateur");
            System.out.println("4. Afficher tout les utilisateurs");
            System.out.println("5. Retour au menu principal");
            System.out.println("Choix : ");

            userChoice = scanner.nextInt();
            scanner.nextLine();

            switch (userChoice) {
                case 1:
                    addUser(scanner);
                    break;
                case 2:
                    displayTasksByUser(scanner);
                    break;
                case 3:
                    deleteUser(scanner);
                    break;
                case 4:
                    getAllUsers(scanner);
                    break;
                case 5:
                    System.out.println("Retour au menu principal");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (userChoice != 4);
    }

    private static void addUser(Scanner scanner) {
        System.out.println("Entrez le nom de l'utilisateur : ");
        String userName = scanner.nextLine();

        User user = new User();
        user.setName(userName);

        userDAO.addUser(user);

        System.out.println("Utilisateur ajouté avec succès !");
    }

    private static void displayTasksByUser(Scanner scanner) {
        System.out.println("Entrez l'ID de l'utilisateur pour afficher ses tâches : ");
        Long userId = scanner.nextLong();
        scanner.nextLine();

        List<Task> tasks = taskDAO.getTasksByUserId(userId);
        if (tasks.isEmpty()) {
            System.out.println("Aucune tâche trouvée pour cet utilisateur.");
        } else {
            System.out.println("=== Liste des tâches de l'utilisateur ===");
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }

    private static void deleteUser(Scanner scanner) {
        System.out.println("Entrez l'ID de l'utilisateur à supprimer : ");
        Long userId = scanner.nextLong();
        scanner.nextLine();

        userDAO.deleteUser(userId);

        System.out.println("Utilisateur supprimé avec succès !");
    }

    private static void getAllUsers(Scanner scanner) {
        List<User> users = userDAO.getAllUsers();

        if (users.isEmpty()) {
            System.out.println("Aucun utilisateur trouvé.");
        } else {
            System.out.println("=== Liste des utilisateurs ===");
            for (User user : users) {
                System.out.println("ID: " + user.getId() + ", Nom: " + user.getName());
            }
        }
    }
}
