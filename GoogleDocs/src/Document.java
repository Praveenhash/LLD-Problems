import java.util.ArrayList;
import java.util.List;

public class Document {

    private List<DocumentElement> documentElements = new ArrayList<>();

    public void addElements(DocumentElement element){
        documentElements.add(element);
    }

    public String render(){
        StringBuilder result = new StringBuilder();
        for(DocumentElement docs : documentElements){
            result.append(docs.render());
        }
        return result.toString();
    }
}
