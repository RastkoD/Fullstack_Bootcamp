package math;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Brain {
    Scanner scanner = new Scanner(System.in);
	Point2D point2D = new Point2D();
	Point3D point3D = new Point3D();
	int choice = 0;


	public void menu() throws IOException {
		do {
			System.out.println("AxisManager - Create and Analyze 2D and 3D Points");
			initialMessage("2D.txt", "3D.txt");
			System.out.println("---------------------- MENU ---------------------");
			System.out.println("1. Create Coordinate Files(2D.txt and 3D.txt)");
			System.out.println("2. Check if Points are Vertices of the Unit Vector");
			System.out.println("3. Check if Points are on Coordinate Axes");
			System.out.println("4. Save Points(Create 2DPoint.txt and 3DPoint.txt)");
			System.out.println("5. Delete All Files");
			System.out.println("6. Exit");

			try {
				choice = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Enter a valid number");
				scanner.nextLine();
			}

			if (choice == 1) {
				createCoordFiles(scanner);
				point2D.loadCoordinates();
				point3D.loadCoordinates();
			} else if (choice == 2) {
				point2D.isPointUnitVector();
				point3D.isPointUnitVector();
			} else if (choice == 3) {
				point2D.isPointOnCoordAxis();
				point3D.isPointOnCoordAxis();
			} else if (choice == 4) {
				point2D.savePoint();
				point3D.savePoint();
			} else if (choice == 5) {
				deleteFile("2D.txt");
				deleteFile("3D.txt");
				deleteFile("2DPoint.txt");
				deleteFile("3DPoint.txt");
			} else if (choice == 6) {
				System.out.println("Thank you for using the program");
			} else {
				System.out.println("Unknown option. Please choose again");
			}

		} while (choice != 6);

		scanner.close();
	}

	public void createCoordFiles(Scanner scanner) throws IOException {
		File create2DCoordsFile = new File("2D.txt");
		File create3DCoordsFile = new File("3D.txt");
		
		FileWriter write2D = new FileWriter(create2DCoordsFile);
		FileWriter write3D = new FileWriter(create3DCoordsFile);

		try {
			

			System.out.println("Enter coodinates for 2D point (format: x y): ");
			double x2D = scanner.nextDouble();
			double y2D = scanner.nextDouble();

			System.out.println("Enter coordinates for 3D point (format: x y z): ");
			double x3D = scanner.nextDouble();
			double y3D = scanner.nextDouble();
			double z3D = scanner.nextDouble();

			write2D.write(x2D + " " + y2D);
			write2D.close();

			write3D.write(x3D + " " + y3D + " " + z3D);
			write3D.close();

			System.out.println("--------------------------------------------------------------------");
			System.out.println("Created Files: " + create2DCoordsFile.getName() + " and " + create3DCoordsFile.getName());

		} catch (IOException e) {
			System.out.println(e);
		}   
		
		finally {
			if (write2D != null) {
				write2D.close();
			}
			
			if (write3D != null) {
				write3D.close();
			}
		}
	}

	public void deleteFile(String filePath) {
		Path path = Paths.get(filePath);

		try {
			Files.delete(path);
			System.out.println("File deleted successfully: " + path.getFileName());
		} catch (NoSuchFileException e) {
			System.out.println("File not found: " + path.getFileName());
		} catch (IOException e) {
			System.out.println("Error deleting file: " + e.getMessage());
		}
	}
	
	public void initialMessage(String fileOne, String fileTwo) {
		Path pathOne = Paths.get(fileOne);
		Path pathTwo = Paths.get(fileTwo);
		
		boolean file1Exists = Files.exists(pathOne);
        boolean file2Exists = Files.exists(pathTwo);
		
        if (file1Exists && file2Exists) {
        	System.out.println("");
        } else if (!file1Exists && !file2Exists) {
        	System.out.println("X and Y are both 0. To change, create files(1).");
        	System.out.println("");
        } else {
        	System.out.println("");
        	System.out.println("You have only initialized one Point. To change, create files(1).");
        	System.out.println("");
        }
	}
}
