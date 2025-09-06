package Structural;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

// Flyweight: holds intrinsic, sharable, immutable state
final class TreeType{
    private final String name ;
    private final String color ;
    private final String textureId;

    public TreeType(String name, String color, String textureId){
        this.name = name;
        this.color = color;
        this.textureId = textureId;
    }

    // Operation that accepts extrinsic state
    public void draw(int x , int y , int height){
        System.out.printf("Drawing %s with color %s and tex = %s at %d , %d with height %d" , name, color,
                textureId, x, y, height);

    }

}

// Factory: ensures sharing of TreeType instances
class TreeFactory{
    private static final  HashMap<String , TreeType> cache = new HashMap<>();
    public static TreeType getTreeType(String name , String color , String textureId){
        String  key = name + "|" + color + "|" + textureId;
        return cache.computeIfAbsent(key , k-> new TreeType(name , color , textureId));
    }

    public static int  cacheSize(){
             return cache.size();
    }
}

// Context holder: keeps only extrinsic data, references shared flyweight

class Tree{
    private final   int x ; // extrinsic
    private final int y ; // extrinsic
    private final int height ; // extrinsic
    private final TreeType type;  // shared flyweight
    public Tree(int x, int y, int height, TreeType type) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.type = type;
    }
    public void drw(){
        type.draw(x , y , height);
    }
}
public class FlyWeightPattern {
    public static void main(String[] args) {

        List<Tree> forest = new ArrayList<>();
       TreeType peepal = TreeFactory.getTreeType("peepal", "light_green", "peepal_tex");
       TreeType neem =  TreeFactory.getTreeType("neem", "dark_green", "neem_tex");
       TreeType mango =  TreeFactory.getTreeType("mango", "extra-dark-green", "mango_tex");

       Random rnd = new Random(42);

       for(int i = 0 ; i < 10000 ; i++){
           int x =  rnd.nextInt(10_000);
           int y = rnd.nextInt(10_000);
           int height = rnd.nextInt(20);
           TreeType type = (i%3 == 0) ? peepal : (i%3 == 1) ? neem : mango;
           forest.add(new Tree(x, y, height, type));
       }




    }
}
