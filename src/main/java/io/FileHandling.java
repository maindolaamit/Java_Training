package io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandling {

    public static void main(String[] args) {
//        long start = System.currentTimeMillis();
//        fileStreamCopyImage();
//        long end = System.currentTimeMillis();
//        System.out.println("Input stream time in ms = " + (end - start));
//
//        start = System.currentTimeMillis();
//        bufferedFileStreamCopyImage();
//        end = System.currentTimeMillis();
//        System.out.println("Buffered Stream time in ms = " + (end - start));
//        bufferedFileReader();
        // Newer implementation in Java
//        try {
//            System.out.println(Files.readString(Paths.get("pom.xml")));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        pathDemo();
//        fileDemo();
        serializeDemo();
    }

    /**
     * Copy an image using BufferedInputStream
     */
    private static void bufferedFileStreamCopyImage() {
        //        Stream --> InputStream --> FilterInputStream --> BufferedInputStream
        try {
            BufferedInputStream input = new BufferedInputStream(new FileInputStream("src/main/resources/sleeping.jpg"));
            BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream("src/main/resources/image.jpg"));
            int read = input.read();
            // -1 is just representing EOF
            while (read != -1) {
                output.write(read);
                read = input.read();
            }
            input.close();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Copy an image using FileStream
     */
    private static void fileStreamCopyImage() {
        //        Stream --> InputStream --> FileInputStream
        // Try-with-resources
        try (FileInputStream input = new FileInputStream("src/main/resources/sleeping.jpg");
             FileOutputStream output = new FileOutputStream("src/main/resources/image.jpg");) {
            int read = input.read();
            while (read != -1) {
                output.write(read);
                read = input.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void bufferedFileReader() {
        // We should always be closing the resources
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("pom.xml"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("reader.readLine() = " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally { // Finally, block will always be executed
            try {
                if (reader != null) reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void pathDemo() {
        String filePath = "src/main/java/io/FileHandling.java";
        System.out.println("fileLoaction = " + filePath);
        Path path = Paths.get(filePath);
        System.out.println("path.getFileName() = " + path.getFileName());
        System.out.println("path.getParent() = " + path.getParent());
        if (path.endsWith(".xml")) {
            System.out.println("It is an xml file");
        } else {
            System.out.println("Oops !!! some other file type.");
        }
    }

    private static void fileDemo() {
        File file = new File("pom.xml");
        System.out.println(file.isDirectory() ? "Is a directory." : "Is a file.");
        System.out.println("file.length() = " + file.length());
        System.out.println("file.lastModified() = " + file.lastModified());

        try {
            boolean sameFile = Files.isSameFile(Path.of(file.getPath()), Paths.get("pom.xml"));
            System.out.println("sameFile = " + sameFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void serializeDemo() {
        Book book = new Book("Effective Java", "Java", "Vishal");
        System.out.println("book = " + book);
        String filePath = "src/main/resources/book.ser";
//        serializeBook(book, filePath);
        Book book1 = deserializeBook(filePath);
        System.out.println("book1 = " + book1);
        if (book1.isEqualsTo(book)) {
            System.out.println("both Books are same");
        } else {
            System.out.println("Books are not same.");
        }
    }

    private static Book deserializeBook(String filePath) {
        Book book = null;
        // De-serialize the file
        try (FileInputStream fis = new FileInputStream("src/main/resources/book.ser");
             ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            book = (Book) ois.readObject();
        } catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
        return book;
    }

    private static void serializeBook(Book book, String filePath) {
        try (FileOutputStream out = new FileOutputStream(filePath)) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
            objectOutputStream.writeObject(book);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
