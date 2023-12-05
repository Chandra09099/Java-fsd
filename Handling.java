import java.io.*;

		class Handling {

		    public static void main(String[] args) {
		        // File path
		        String filePath = "sample.txt";

		        // Writing to a file
		        try (FileWriter writer = new FileWriter(filePath)) {
		            writer.write("This is a sample text that will be written to the file.\n");
		            writer.write("Adding another line to the file.\n");
		            System.out.println("File written successfully!");
		        } catch (IOException e) {
		            System.out.println("An error occurred while writing to the file: " + e.getMessage());
		        }

		        // Appending to the file
		        try (FileWriter writer = new FileWriter(filePath, true)) {
		            writer.write("Appending new content to the file.\n");
		            System.out.println("Content appended to the file!");
		        } catch (IOException e) {
		            System.out.println("An error occurred while appending to the file: " + e.getMessage());
		        }

		        // Reading from the file
		        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
		            String line;
		            System.out.println("\nFile content:");
		            while ((line = reader.readLine()) != null) {
		                System.out.println(line);
		            }
		        } catch (IOException e) {
		            System.out.println("An error occurred while reading from the file: " + e.getMessage());
		        }
		    }

}

	