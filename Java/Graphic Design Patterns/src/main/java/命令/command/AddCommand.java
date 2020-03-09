package 命令.command;

public class AddCommand implements Command {
    private TextEditor receiver;
    private String msg;

    public AddCommand(TextEditor receiver, String msg) {
        this.receiver = receiver;
        this.msg = msg;
    }

    @Override
    public void execute() {
        receiver.add(msg);
    }
}
