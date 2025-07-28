public class DocumentEditor {

    private Document document;
    private Storage storage;
    private String renderedDocument = "";

    public DocumentEditor(Document document, Storage storage){
        this.document = document;
        this.storage = storage;
    }

    public void addText(String text){
        document.addElements(new TextElement(text));
    }
    public void addImage(String imagePath){
        document.addElements(new ImageElement(imagePath));
    }

    public void addNewLine(){
        document.addElements(new NewLineElement());
    }

    public void addNewTab(){
        document.addElements(new TabSpaceElement());
    }

    public String renderDocument(){
        if(renderedDocument.isEmpty()){
            renderedDocument = document.render();
        }
        return renderedDocument;
    }

    public void saveDocument(){
        storage.save(renderedDocument);
    }
}
