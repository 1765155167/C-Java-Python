package 状态;

public interface State {
    String init();
    String reply(String input);
}
