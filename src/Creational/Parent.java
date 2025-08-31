package Creational;

public class Parent {

    private final int  a ;
    private final int b ;
    private final int c ;
    private Parent(Builder b){ // so that on one can create instance of parent without using builder
          this.a = b.a;
          this.b = b.b;
          this.c = b.c;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public static class  Builder{
        private int  a ;
        private int b ;
        private int c ;
        Builder setA (int a ){
            this.a = a;
            return this;
        }

        Builder setB(int b){
            this.b = b;
            return this;
        }
        Builder setC(int c){
            this.c = c;
            return this;
        }

        public Parent build(){
            // any validation logic if required
            if(this.a < 0){
                throw new RuntimeException("a cnnot be negative");

            }
            return new Parent(this);
        }
    }

}
