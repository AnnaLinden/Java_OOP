public class Main {
    public static void main(String[] args) {
        List<Point> points = new ArrayList<Point>();
        points.add(new Point(4, 8));
        points.add(new ColouredPoint(1, 1, "green"));
        points.add(new ColouredPoint(2, 5, "blue"));
        points.add(new Point(0, 0));

        for (Point point : points) {
            System.out.println(point);
        }
    }
}