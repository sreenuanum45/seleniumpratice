package DailyPratice;



public class GenericMethod_1 {

    public static <X extends Number> X add(X a, X b) {
        if (a instanceof Integer && b instanceof Integer) {
            return (X) Integer.valueOf(a.intValue() + b.intValue());
        } else if (a instanceof Double && b instanceof Double) {
            return (X) Double.valueOf(a.doubleValue() + b.doubleValue());
        } else if (a instanceof Float && b instanceof Float) {
            return (X) Float.valueOf(a.floatValue() + b.floatValue());
        } else {
            throw new IllegalArgumentException("Unsupported type");
        }
    }
    

    public static void main(String[] args) {

    }
}
