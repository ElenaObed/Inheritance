import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTestClass {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearch() {
        SimpleTask task1 = new SimpleTask(1, "Гулять на улице");
        SimpleTask task2 = new SimpleTask(2, "Приходить домой");
        Epic epic = new Epic(3, new String[]{"Купить джинсы, продать конфетку"});
        Meeting meeting = new Meeting(4, "Встреча", "Купить джинсы", "2023-06-20 10:00");
        Todos todos = new Todos();
        todos.add(task1);
        todos.add(task2);
        todos.add(epic);
        todos.add(meeting);

        Task[] result1 = todos.search("улице");
        Assertions.assertArrayEquals(new Task[]{task1}, result1);

        Task[] result2 = todos.search("конфетку");
        Assertions.assertArrayEquals(new Task[]{epic}, result2);

        Task[] result3 = todos.search("Купить джинсы");
        Assertions.assertArrayEquals(new Task[]{epic, meeting}, result3);

        Task[] result4 = todos.search("Денег нет");
        Assertions.assertArrayEquals(new Task[]{}, result4);
    }
}
