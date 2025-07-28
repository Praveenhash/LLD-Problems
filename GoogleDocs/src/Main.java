//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Document document = new Document();

        Storage storage = new FileStorage();

        DocumentEditor editor = new DocumentEditor(document, storage);

        editor.addText("Hello world..!");
        editor.addNewLine();
        editor.addText("This is a real-world document editor example..!");
        editor.addNewLine();
        editor.addNewTab();
        editor.addText("Indented text after a tab space.");
        editor.addNewLine();
        editor.addText("picture.jpg");

        System.out.println(editor.renderDocument());

        editor.saveDocument();
    }
}