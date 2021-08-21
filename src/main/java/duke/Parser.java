package duke;

import duke.command.*;

class Parser {
    // constants for special commands
    private static final String CMD_BYE = "bye";
    private static final String CMD_LIST = "list";
    private static final String CMD_DONE = "done";
    private static final String CMD_TODO = "todo";
    private static final String CMD_DDL = "deadline";
    private static final String CMD_EVENT = "event";
    private static final String CMD_DEL = "delete";
    private static final String CMD_FIND = "find";

    public static Command parse(String fullCommand) throws DukeException {
        String keywork = fullCommand.split(" ")[0];

        switch (keywork) {
        case CMD_LIST:
            return new DisplayListCommand();
        case CMD_DONE:
            return new DoneCommand(fullCommand);
        case CMD_DEL:
            return new DeleteCommand(fullCommand);
        case CMD_TODO:
            return new AddCommand(fullCommand, TaskEnum.TODO);
        case CMD_DDL:
            return new AddCommand(fullCommand, TaskEnum.DDL);
        case CMD_EVENT:
            return new AddCommand(fullCommand, TaskEnum.EVENT);
        case CMD_BYE:
            return new ExitCommand();
        case CMD_FIND:
            return new FindCommand(fullCommand);
        default:
            throw new DukeException("Sorry, Yiyang-bot doesn't know what does that mean.");
        }
    }
}
