package Abstract;

public class Test {
    public static void main(String[] args) {
        Square square = new Square();
        square.setH(12);
        square.setW(2);
        System.out.println("正方形面积：" + square.CalculatedArea());

        Triangle triangle = new Triangle(4, 5, 6);
        System.out.println("三角形面积：" + triangle.CalculatedArea());
    }
}
