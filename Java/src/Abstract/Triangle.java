package Abstract;
/*三角形*/
public class Triangle extends Shape {
    private float a;
    private float b;
    private float c;

    Triangle() {}/*构造函数*/
    /*构造函数 重载：函数名相同参数不同*/
    Triangle(float a, float b, float c)
    {
            if(a > 0 && b > 0 && c > 0 && (a + b > c) && Math.abs(a - b) < c)
            {
                this.a = a;
                this.b = b;
                this.c = c;
            }else {
                System.out.println("不是三角形");
            }
    }
    @Override/*Shape 的抽象函数实现*/
    float CalculatedArea() {

        if(this.a > 0 && this.b > 0 && this.c > 0 && (this.a + this.b > this.c)&&Math.abs(this.a-this.b)<this.c)
        {
            float p = (a + b + c) / 2;
            return (float) Math.sqrt(p * (p-a)*(p-b)*(p -c));
        }else{
            System.out.println("不是三角形");
            return -1;
        }
    }

    public float getA() {
        return a;
    }

    public void setA(float a) {
        this.a = a;
    }

    public float getB() {
        return b;
    }

    public void setB(float b) {
        this.b = b;
    }

    public float getC() {
        return c;
    }

    public void setC(float c) {
        this.c = c;
    }


}
