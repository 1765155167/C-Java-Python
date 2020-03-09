package 命令.command;

public class CopyCommand implements Command {
    private TextEditor receiver;

    public CopyCommand(TextEditor receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.copy();
    }
}
