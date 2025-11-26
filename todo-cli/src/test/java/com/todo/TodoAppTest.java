package com.todo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TodoAppTest {

    @BeforeEach
    void setUp() {
        // Reset state before each test
        // Since the list is static, we clear it by reflection
        try {
            var field = TodoApp.class.getDeclaredField("todos");
            field.setAccessible(true);
            ((java.util.ArrayList<String>) field.get(null)).clear();
        } catch (Exception e) {
            fail("Failed to reset todo list before test");
        }
    }

    @Test
    public void testAddSingleTodo() {
        TodoApp.addTodo("Test task 1");
        assertEquals(1, TodoApp.getTodoCount());
    }

    @Test
    public void testAddMultipleTodos() {
        TodoApp.addTodo("Task 1");
        TodoApp.addTodo("Task 2");
        TodoApp.addTodo("Task 3");

        assertEquals(3, TodoApp.getTodoCount());
    }

    @Test
    public void testInitialTodoCountIsZero() {
        assertEquals(0, TodoApp.getTodoCount());
    }

    @Test
    public void testTodoCountAfterAddingAndReading() {
        TodoApp.addTodo("Study");
        TodoApp.addTodo("Workout");

        int count = TodoApp.getTodoCount();
        assertTrue(count > 0);
        assertEquals(2, count);
    }

    @Test
    public void testAddingEmptyTask() {
        TodoApp.addTodo("");
        assertEquals(1, TodoApp.getTodoCount());
    }
}
