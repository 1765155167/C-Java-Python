package 命令.command;

public class DeleteCommand implements Command {
    private TextEditor receiver;

    public DeleteCommand(TextEditor receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.delete();
    }
}
