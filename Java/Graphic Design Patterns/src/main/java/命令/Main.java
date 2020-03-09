package 命令;

import org.w3c.dom.Text;
import 命令.command.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        List<Command> commands = new ArrayList<>();
        commands.add(new AddCommand(editor, "Command pattern in text editor.\n"));
        commands.add(new CopyCommand(editor));
        commands.add(new AddCommand(editor, "-----\n"));
        commands.add(new PasteCommand(editor));
        for (var com : commands) {
            com.execute();
        }
        System.out.println(editor.getState());
    }
}
