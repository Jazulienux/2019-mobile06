package id.ac.polinema.idealbodyweight.util;

public class BrocaIndex {
    public  static final int MALE = 0;
    public  static final int FEMALE = 1;

    private  int gender;
    private  int height;
    private  float index;

    public static int getMALE() {
        return MALE;
    }

    public static int getFEMALE() {
        return FEMALE;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getIndex() {
        return index;
    }

    public void setIndex(float index) {
        this.index = index;
    }

    public BrocaIndex(int gender, int height) {
        this.gender = gender;
        this.height = height;
        this.index = calculate();
    }

    private float calculate() {
        switch (gender){
            case MALE:
                return (height-100) - ((height-100) * 0.1f);
            case FEMALE:
                return (height-100) + ((height-100) * 0.15f);
            default: return 0f;
        }
    }
}
