import java.io.FileWriter;

public class FileStorage implements Storage{


    @Override
    public void save(String data) {
        try{
            FileWriter outFile = new FileWriter("document.txt");
            outFile.write(data);
            outFile.close();
            System.out.println("Document saved to document.txt");
        } catch (Exception e){
            System.out.println("Error: Unable to open file for writing.");
        }
    }
}
