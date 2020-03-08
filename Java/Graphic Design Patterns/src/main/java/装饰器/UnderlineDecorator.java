package 装饰器;

public class UnderlineDecorator extends NodeDecorator {
    public UnderlineDecorator(TextNode textNode) {
        super(textNode);
    }

    @Override
    public String getText() {
        return "<u>" + target.getText() + "</u>";
    }
}
