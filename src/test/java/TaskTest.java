import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskTest {

    Task task = new Task(1);

    @Test
    public void shouldFindQueryInMeeting() {

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        String query = "приложение";
        Task[] expected = {meeting};
        boolean actual = task.matches(query);
        Assertions.assertTrue(true);
    }

    @Test
    public void shouldFindQueryInMeetingFalse() {

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        String query = "дуб";
        Task[] expected = {meeting};
        boolean actual = task.matches(query);
        Assertions.assertFalse(false);
    }

    @Test
    public void shouldFindQueryInEpicFalse() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);


        String query = "дуб";
        Task[] expected = {epic};
        boolean actual = task.matches(query);
        Assertions.assertFalse(false);
    }

    @Test
    public void shouldFindQueryInEpicTrue() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        String query = "Хлеб";
        Task[] expected = {epic};
        boolean actual = task.matches(query);
        Assertions.assertTrue(true);
    }


    @Test
    public void shouldFindQueryInSimpleTaskFalse() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");


        String query = "дуб";
        Task[] expected = {simpleTask};
        boolean actual = task.matches(query);
        Assertions.assertFalse(false);
    }

    @Test
    public void shouldFindQueryInSimpleTaskTrue() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String query = "родителям";
        Task[] expected = {simpleTask};
        boolean actual = task.matches(query);
        Assertions.assertTrue(true);
    }

}
