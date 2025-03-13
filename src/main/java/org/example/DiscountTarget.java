package org.example;

public enum DiscountTarget {

    STUDENT(0.7, "학생"),
    SOLDIER(0.5, "군인"),
    NORMAL(1.0, "해당없음");

    private final double rate;
    private final String target;


    DiscountTarget(double rate, String target){
        this.rate = rate;
        this.target = target;
    }


    public String getTarget() {
        return target;
    }

    public double getRate() {
        return rate;
    }
}
