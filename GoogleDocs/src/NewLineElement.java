import javax.print.Doc;

public class NewLineElement implements DocumentElement {

    @Override
    public String render() {
        return "\n";
    }
}
