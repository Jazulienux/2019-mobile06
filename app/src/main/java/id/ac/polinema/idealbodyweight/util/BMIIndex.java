package id.ac.polinema.idealbodyweight.util;

public class BMIIndex {

    private int massa = 0;
    private int height = 0;
    private float bmi;
    private String cdt;

    public BMIIndex(int massa, int height) {
        this.massa = massa;
        this.height = height;
        this.bmi = calculate();
        this.cdt = condition();
    }

    private String condition() {
        if(bmi < 18.50){
            return "Low";
        }
        else if(bmi >= 18.50 && bmi <= 24.99){
            return "Average";
        }
        else if(bmi >= 25.00 && bmi <= 29.99){
            return "Increased";
        }

        else if(bmi >= 30.00 && bmi <= 34.99){
            return "Moderate";
        }

        else if(bmi >= 35.00 && bmi <= 39.99){
            return "Severe";
        }
        else if(bmi >= 40.00){
            return "Very severe";
        }

        else{
            return "Unknown";
        }
    }

    public String getCdt() {
        return cdt;
    }

    public void setCdt(String cdt) {
        this.cdt = cdt;
    }

    public int getMassa() {
        return massa;
    }

    public void setMassa(int massa) {
        this.massa = massa;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getBmi() {
        return bmi;
    }

    public void setBmi(float bmi) {
        this.bmi = bmi;
    }

    private float calculate() {
        return (float) (massa / Math.pow(height,2));
    }
}
