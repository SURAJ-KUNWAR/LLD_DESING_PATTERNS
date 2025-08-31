package Creational.SimpleFactory;

public class ShapeFactory {
    public static Shape createShape(String shape){
        if(shape.equals("Circle")){
            return new Circle();
        }else if(shape.equals("Square")){
            return new Square();
        }
        throw new  IllegalArgumentException("Unknown shape" + shape);
    }
}
