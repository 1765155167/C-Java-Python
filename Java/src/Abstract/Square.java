package Abstract;
/*矩形*/
public class Square extends Shape {
    private float w;
    private float h;

    public float getW() {
        return w;
    }

    public void setW(float w) {
        if(w > 0) {
            this.w = w;
        }else{
            System.out.println("w < 0");
        }
    }

    public float getH() {
        return h;
    }

    public void setH(float h) {
        if(h > 0) {
            this.h = h;
        }else{
            System.out.println("h < 0");
        }
    }

    @Override
    float CalculatedArea() {
        if(this.h > 0 && this.w > 0) {
            return this.h * this.w;
        } else {
            System.out.println("不是矩形");
            return -1;
        }
    }
}
