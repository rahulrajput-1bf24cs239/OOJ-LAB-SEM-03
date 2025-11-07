import java.util.Scanner;
abstract class Shape {
    int a, b;
    abstract void printArea();
}

class Rectangle extends Shape {
    Rectangle(int x, int y) { a = x; b = y; }
    void printArea() { System.out.println("Area of Rectangle: " + (a * b)); }
}

class Triangle extends Shape {
    Triangle(int x, int y) { a = x; b = y; }
    void printArea() { System.out.println("Area of Triangle: " + (0.5 * a * b)); }
}

class Circle extends Shape {
    Circle(int r) { a = r; }
    void printArea() { System.out.println("Area of Circle: " + (Math.PI * a * a)); }
}

public class ShapeAbstract {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        System.out.print("Enter length and breadth of rectangle: ");
        int l = sc.nextInt();
        int b = sc.nextInt();
        Rectangle rect = new Rectangle(l, b);

        System.out.print("Enter base and height of triangle: ");
        int base = sc.nextInt();
        int height = sc.nextInt();
        Triangle tri = new Triangle(base, height);

        System.out.print("Enter radius of circle: ");
        int r = sc.nextInt();
        Circle cir = new Circle(r);

        rect.printArea();
        tri.printArea();
        cir.printArea();
       
        sc.close();
    }
}
