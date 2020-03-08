package 装饰器;

public class ItalicDecorator extends NodeDecorator {
    public ItalicDecorator(TextNode textNode) {
        super(textNode);
    }

    @Override
    public String getText() {
        return "<i>" + target.getText() + "</i>";
    }
}
