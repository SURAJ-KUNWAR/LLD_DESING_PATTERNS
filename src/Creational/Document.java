package Creational;

import java.util.ArrayList;

public class Document implements Cloneable{
    private String type;
    private String name;
    private String content;
    private ArrayList<Integer> pages;

    public Document(String type, String name, String content , ArrayList<Integer> pages){
        this.type = type;
        this.name = name;
        this.content = content;
        this.pages = pages;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Document{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", pages=" + pages +
                '}';
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArrayList<Integer> getPages() {
        return pages;
    }

    public void setPages(ArrayList<Integer> pages) {
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Document clone() {
        try{
            Document clone = (Document) super.clone();
            // deep clone => if we dont do this then if we make change in the copy
            // it will be refelcted in the original as well as in java for primitve
            //values get copies where as for objects reference gets copied
            clone.pages = new ArrayList<>(this.pages);
            return clone;
        }catch(CloneNotSupportedException e){
            throw new RuntimeException(e);
        }

    }
}
