package 状态;
//状态切换器
public class BotContext {
    private State state = new DisconnectedState();

    public String chat(String input) {
        if ("Hello".equalsIgnoreCase(input)) {
            state = new ConnectedState();//切换成在线模式
            return state.init();
        } else if ("Bye".equalsIgnoreCase(input)) {
            state = new DisconnectedState();
            return state.init();
        }
        return state.reply(input);
    }
}
