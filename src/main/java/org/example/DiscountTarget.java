package org.example;

/**
 * 할인율을 나타내는 열거형 (Enum)
 *
 * 각 할인 대상에 대해 할인율과 해당 대상을 설명하는 문자열을 저장하는 Enum입니다.
 * 이 Enum은 할인 대상에 따라 다른 할인율을 반환하는 기능을 제공합니다.
 *
 * @author mxcoogi
 * @version challenge lv2
 */
public enum DiscountTarget {

    /**
     * 학생 할인 대상 (할인율 30%)
     */
    STUDENT(0.7, "학생"),

    /**
     * 군인 할인 대상 (할인율 50%)
     */
    SOLDIER(0.5, "군인"),

    /**
     * 일반인 (할인 없음, 할인율 0%)
     */
    NORMAL(1.0, "해당없음");

    // 할인율을 저장하는 변수 (0.7, 0.5, 1.0 등)
    private final double rate;

    // 할인 대상을 설명하는 문자열 (학생, 군인, 해당없음 등)
    private final String target;

    /**
     * DiscountTarget 생성자
     *
     * 각 할인 대상에 대해 할인율(rate)과 할인 대상을 설명하는 문자열(target)을 설정합니다.
     *
     * @param rate 할인율 (0.0~1.0 사이 값)
     * @param target 할인 대상 설명
     */
    DiscountTarget(double rate, String target){
        this.rate = rate;
        this.target = target;
    }

    /**
     * 할인 대상 설명을 반환하는 메서드
     *
     * @return 할인 대상을 설명하는 문자열 (예: "학생", "군인", "해당없음")
     */
    public String getTarget() {
        return target;
    }

    /**
     * 할인율을 반환하는 메서드
     *
     * @return 할인율 (0.7, 0.5, 1.0 등)
     */
    public double getRate() {
        return rate;
    }
}

