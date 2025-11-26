package com.todo;

import java.util.ArrayList;
import java.util.Scanner;

public class TodoApp {
    private static ArrayList<String> todos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Exit");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter task: ");
                String task = scanner.nextLine();
                todos.add(task);
                System.out.println("Task added.");
            } 
            else if (choice == 2) {
                System.out.println("\nTo-Do List:");
                for (int i = 0; i < todos.size(); i++) {
                    System.out.println((i + 1) + ". " + todos.get(i));
                }
            } 
            else if (choice == 3) {
                System.out.println("Goodbye.");
                break;
            } 
            else {
                System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }

    public static int getTodoCount() {
        return todos.size();
    }

    public static void addTodo(String task) {
        todos.add(task);
    }
}
