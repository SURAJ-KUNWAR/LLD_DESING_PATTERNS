package Creational;

import java.util.HashMap;

public class DocumentRegistry {
    private HashMap<String, Document> documents;
    public DocumentRegistry() {
        documents = new HashMap<>();
    }

    public void registerDocument(String type , Document document) {
        documents.put(type, document);
    }
    public Document getDocument(String type) {
         Document d = documents.get(type);
         if(d == null) {
             throw new IllegalArgumentException("No such document: " + type);
         }
         return d.clone();
    }
}
