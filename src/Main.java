import Creational.Document;
import Creational.DocumentRegistry;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //simple protoype demostration
        Document orignal = new Document("Resume" , "Orignal" , "Content of resume" , new ArrayList<>(List.of(1,2,3)));
        Document copy = orignal.clone();
        copy.setName("copy");
        System.out.println(orignal);
        System.out.println(copy);


        //protoype registry demonstation

        DocumentRegistry dr = new DocumentRegistry();
        dr.registerDocument("Resume" , new Document("resume" , "original" , "resume-content" , new ArrayList<>(List.of(1,2,3))));
        dr.registerDocument("Letter" , new Document("Letter" , "original" , "letter-content" , new ArrayList<>(List.of(1,2,3))));

        Document letterCopy  = dr.getDocument("Letter");
        letterCopy.setName("letter-for-a -friend");
        System.out.println(letterCopy);

    }
}