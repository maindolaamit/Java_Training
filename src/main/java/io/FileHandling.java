package io;

import java.io.*;

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
        bufferedFileReader();
    }

    /**
     * Copy an image using BufferedInputStream
     */
    private static void bufferedFileStreamCopyImage() {
        //        Stream --> InputStream --> FilterInputStream --> BufferedInputStream
        try {
            BufferedInputStream input = new BufferedInputStream(new FileInputStream("src/main/resources/sleeping.jpg"));
            BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream("image.jpg"));
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
        try {
            FileInputStream input = new FileInputStream("src/main/resources/sleeping.jpg");
            FileOutputStream output = new FileOutputStream("image.jpg");
            int read = input.read();
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

    private static void bufferedFileReader() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("pom.xml"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("reader.readLine() = " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
