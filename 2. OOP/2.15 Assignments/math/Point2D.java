package math;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Point2D implements Point {
	double x, y;
	String pointOnAxis = "You have not checked if the Point2D is on the axes", pointUnitVector = "You have not checked if Point2D is a vertex of the unit vector";

	public Point2D() {};

	@Override
	public void loadCoordinates() throws IOException {
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader("2D.txt"));
			String line = reader.readLine();

			if (line != null) {
				String[] coordinates = line.split(" ");

				x = Double.parseDouble(coordinates[0]);
				y = Double.parseDouble(coordinates[1]);

				System.out.println("Coordinates loaded successfully: x = " + x + ", y = " + y);
			} else {
				System.out.println("--------------------------------------------------------------------");
				System.out.println("File is empty or missing");
			}

		} catch (IOException e) {
			System.out.println("Error loading coordinates: " + e.getMessage());
		}

		finally {
			if (reader != null) {
				reader.close();
			}
		}
	}

	@Override
	public void isPointUnitVector() {
		double distance = Math.sqrt(x * x + y * y);
		if (distance - 1.0 < 1e-10) {
			System.out.println("--------------------------------------------------------------------");
			System.out.println("Point2D is the end point of the unit vector");
			pointUnitVector = "Point2D is the end point of the unit vector";
		} else {
			System.out.println("--------------------------------------------------------------------");
			System.out.println("Point2D is not the end point of the unit vector");
			pointUnitVector = "Point2D is not the end point of the unit vector";
		}
	}

	@Override
	public void isPointOnCoordAxis() {
		if (x == 0.0 && y != 0.0) {
			System.out.println("--------------------------------------------------------------------");
			System.out.println("Point2D is on the y axis");
			pointOnAxis = "Point2D is on the y axis";
		} else if (x != 0.0 && y == 0.0) {
			System.out.println("--------------------------------------------------------------------");
			System.out.println("Point2D is on the x axis");
			pointOnAxis = "Point2D is on the x axis";
		} else if (x == 0.0 && y == 0.0) {
			System.out.println("--------------------------------------------------------------------");
			System.out.println("Point2D is at the origin of the coordinate system");
			pointOnAxis = "Point2D is at the origin of the coordinate system";
		} else if (x != 0 && y != 0) {
			System.out.println("--------------------------------------------------------------------");
			System.out.println("Point2D is not on axes");
			pointOnAxis = "Point2D is not on any axes";
		} else {
			System.out.println("--------------------------------------------------------------------");
			System.out.println("Failed to determine the Point's location on any axis");
			pointOnAxis = "Failed to determine the Point's location on any axis";
		}
	}

	@Override
	public void savePoint() {
		File create2DDotFile = new File("2DPoint.txt");

		try {
			FileWriter write2D = new FileWriter(create2DDotFile);

			double x2D = x;
			double y2D = y;

			write2D.write("Point2D: x = " + x2D + ", y = " + y2D + "\n" + pointOnAxis + "\n" + pointUnitVector);
			write2D.close();

			System.out.println("--------------------------------------------------------------------");
			System.out.println("Created file: " + create2DDotFile.getName());
		} catch (IOException e) {
			System.out.println("Error saving file: " + e.getMessage());
		}
	}
}
