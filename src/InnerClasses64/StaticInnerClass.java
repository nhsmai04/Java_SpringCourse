package InnerClasses64;

public class StaticInnerClass {
    // Static inner class (nested class)
    public static class Pair {
        private double first;
        private double second;

        public Pair(double f, double s) {
            first = f;
            second = s;
        }

        public double getFirst() {
            return first;
        }

        public double getSecond() {
            return second;
        }
    }

    // Static method trả về Pair
    public static Pair minmax(double[] values) {
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;

        for (double v : values) {
            if (min > v) min = v;
            if (max < v) max = v;
        }

        return new Pair(min, max);
    }

    public static void main(String[] args) {
        double[] d = {3.4, 1.2, 7.8, 2.1, 5.5};

        StaticInnerClass.Pair p = StaticInnerClass.minmax(d);

        System.out.println("Min = " + p.getFirst());
        System.out.println("Max = " + p.getSecond());
    }

}
