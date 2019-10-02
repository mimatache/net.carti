package net.carti.utils.resource.handler;

import net.carti.logging.CardLogger;
import org.slf4j.Logger;

import java.io.ByteArrayInputStream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class FileManager {
    private static final Logger LOGGER = CardLogger.getInstance(FileManager.class);

    //Methods

    /**
     * Read the file from the project resources
     * @param pathToFile relative path to file in project resources
     * @return Contents of the file
     */
    public static ResourceContents readFromClassPath(String pathToFile){
        LOGGER.debug("Reading file: " + pathToFile);
        return ResourceContents.fromInputStream(FileManager.class.getClassLoader().getResourceAsStream(Objects.requireNonNull(pathToFile)));
    }

    /**
     * Read the file from the file system
     * @param pathToFile Path to the file system file
     * @return Contents of the file
     */
    public static ResourceContents readFromFileSystem(String pathToFile){
        Path path = Paths.get(pathToFile);
        LOGGER.debug("Reading report file: " +path);
        byte[] encoded;
        try {
            encoded = Files.readAllBytes(path);
            return ResourceContents.fromInputStream(new ByteArrayInputStream(encoded));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isFileOnClassPath(String pathToFile){
        LOGGER.debug("Checking file is present in class path: " + pathToFile);
        return FileManager.class.getClassLoader().getResourceAsStream(pathToFile) != null;
    }

}
