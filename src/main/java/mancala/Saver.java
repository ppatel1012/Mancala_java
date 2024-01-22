package mancala;
import java.io.Serializable;
//import java.util.logging.Logger;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;

//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;

public class Saver implements Serializable{
    private static final long serialVersionUID = 1L;
    public Saver(){
        final long serialVersionUID = 1L;
    }
   // private Path filepath;
    // public static Serializable loadObject(String filename) throws IOException{
    //     filepath = Path.of("./assets", filename);
    //     if(Files.notExists(filepath)) {
    //         throw new Exception("Could not open file '" + filepath + "'");
    //     }
    //     contents = Files.readAllLines(filepath);
    // }
    public void saveObject(final Serializable toSave, final String filename){
        final Path currentDir = Paths.get(System.getProperty("user.dir"));
        final String folderName = "assets";
        final Path assetsFolderPath = currentDir.resolve(folderName);
        if (!Files.exists(assetsFolderPath)) {
            try {
                Files.createDirectories(assetsFolderPath);
                System.out.println("Path created: " + assetsFolderPath);
            } catch (IOException e) {
                System.err.println("Error creating path: " + e.getMessage());
                return;
            }
        }

        // Create the full path for the serialized object file
        final Path filePath = assetsFolderPath.resolve(filename);

        try (ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(filePath.toFile()))) {
            objectOut.writeObject(toSave);
            System.out.println("Object saved successfully to: " + filePath);
        } catch (IOException e) {
            System.err.println("Error saving object: " + e.getMessage());
        }
        // if (Files.exists(assetsFolderPath)) {
        //     final ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(assetsFolderPath));
        //   //  Files.write(filepath, toSave);
        //     objectOut.writeObject(toSave);
        //     objectOut.close();
        //     //System.out.println("Path already exists: " + assetsFolderPath);
        // } else {
        //     // Path doesn't exist, try to create it
        //     try {
        //         Files.createDirectories(assetsFolderPath);
        //         System.out.println("Path created: " + assetsFolderPath);
        //     } catch (IOException e) {
        //         System.err.println("Error creating path: " + e.getMessage());
        //     }
        // }

    //    final String filepath = "./assets/saved";
    //    Logger log = Logger.getLogger(MancalaGame.class.getName());
    //    filepath = Path.of("./assets", filename);
    //    try{
    //        final ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(filepath.toFile()));
          //  Files.write(filepath, toSave);
    //        objectOut.writeObject(toSave);
    //        objectOut.close();
            //ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(filepath));
    //    }catch(IOException err){
           // err.getMessage();
    //        if(log.isLoggable(java.util.logging.Level.WARNING)){
    //            log.warning("File name invalid "+err.getMessage());
    //        }
      //  }
    }
    //@Override
    public Serializable loadObject(final String filename){
        final Path currentDir = Paths.get(System.getProperty("user.dir"));
        final String folderName = "assets";
        final Path filePath = currentDir.resolve(folderName).resolve(filename);

        if (!Files.exists(filePath)) {
            System.err.println("File does not exist: " + filePath);
            return null;
        }

        try (ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(filePath.toFile()))) {
            final Serializable loadedObject = (Serializable) objectIn.readObject();
            System.out.println("Object loaded successfully from: " + filePath);
            return loadedObject;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading object: " + e.getMessage());
            return null;
        }
        // Logger log = Logger.getLogger(MancalaGame.class.getName());
        // Serializable loadedObject = null;
        // final String filepath = "./assets./saved";
        // try{
        //     final ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(filepath));
        //     loadedObject = (Serializable) objectIn.readObject();
        // }catch(IOException err){
        //     //err.getMessage();
        //     if(log.isLoggable(java.util.logging.Level.WARNING)){
        //         log.warning("File name invalid "+err.getMessage());
        //     }
        // }catch(ClassNotFoundException err){
        //     //err.getMessage();
        //     if(log.isLoggable(java.util.logging.Level.WARNING)){
        //         log.warning("File name invalid "+err.getMessage());
        //     }
        // }
        // return loadedObject;
    }
    // void saveObject(Serializable toSave, String filename);
    // Serializable loadObject(String filename);
}