package duke.command;

import duke.*;

import java.time.format.DateTimeParseException;

public class AddCommand extends Command{
    private final String fullCommand;
    private final TaskEnum taskType;

    public AddCommand(String fullCommand, TaskEnum taskType) {
        this.fullCommand = fullCommand;
        this.taskType = taskType;
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        try {
            Task newTask;
            if (taskType == TaskEnum.TODO) {
                if (fullCommand.length() <= 4 || fullCommand.substring(5).strip().equals("")) {
                    throw new DukeException("The description of a todo cannot be empty.");
                }
                newTask = new Todo(fullCommand.substring(5).strip());
            } else if (taskType == TaskEnum.DDL) {
                newTask = Deadline.parseNewCommand(fullCommand);
            } else {    // i.e. EVENT
                newTask = Event.parseNewCommand(fullCommand);
            }
            taskList.addTask(newTask);
        } catch (IllegalArgumentException | DateTimeParseException | IndexOutOfBoundsException | DukeException e) {
            System.err.println("\tOops :( " + e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddCommand that = (AddCommand) o;

        if (fullCommand != null ? !fullCommand.equals(that.fullCommand) : that.fullCommand != null) return false;
        return taskType == that.taskType;
    }
}
