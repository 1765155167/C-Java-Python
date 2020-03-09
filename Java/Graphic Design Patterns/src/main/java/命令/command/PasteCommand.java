package 命令.command;

public class PasteCommand implements Command {
    private TextEditor receiver;

    public PasteCommand(TextEditor receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.paste();
    }
}
