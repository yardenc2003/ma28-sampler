package workspace.extensions;

public class FileNameGenerator {
    public static String generateFileName(String fileName) {
        int extensionIndex = fileName.lastIndexOf('.');
        return fileName.substring(0, extensionIndex) + "%d" + fileName.substring(extensionIndex);
    }
}