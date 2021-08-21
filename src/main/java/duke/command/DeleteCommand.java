package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;

public class DeleteCommand extends Command{
    private final String fullCommand;

    public DeleteCommand(String fullCommand) {
        this.fullCommand = fullCommand;
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        int delId = Integer.parseInt(fullCommand.split(" ")[1]);
        taskList.deleteTask(delId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeleteCommand that = (DeleteCommand) o;

        return fullCommand != null ? fullCommand.equals(that.fullCommand) : that.fullCommand == null;
    }
}
