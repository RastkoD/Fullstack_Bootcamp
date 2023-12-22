package math;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Point3D implements Point {
	double x, y, z;
	String pointOnAxis = "You have not checked if the Point3D is on the axes", pointUnitVector = "You have not checked if Point3D is a vertex of the unit vector";

	public Point3D() {};

	@Override
	public void loadCoordinates() throws IOException {
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader("3D.txt"));
			String line = reader.readLine();

			if (line != null) {
				String[] coordinates = line.split(" ");

				x = Double.parseDouble(coordinates[0]);
				y = Double.parseDouble(coordinates[1]);
				z = Double.parseDouble(coordinates[2]);

				System.out.println("Coordinates loaded successfully: x = " + x + ", y = " + y + ", z = " + z);
				System.out.println("--------------------------------------------------------------------");
			} else {
				System.out.println("File is empty or missing");
				System.out.println("--------------------------------------------------------------------");
			}
		} catch (IOException e) {
			System.out.println("Error Loading Coordinates: " + e.getMessage());
		}

		finally {
			if (reader != null) {
				reader.close();
			}
		}
	}

	@Override
	public void isPointUnitVector() {
		double distance = Math.sqrt(x * x + y * y + z * z);
		if (distance - 1.0 < 1e-10) {
			System.out.println("Point3D is the end point of the unit vector");
			System.out.println("--------------------------------------------------------------------");
			pointUnitVector = "Point3D is the end point of the unit vector";
		} else {
			System.out.println("Point3D is not the end point of the unit vector");
			System.out.println("--------------------------------------------------------------------");
			pointUnitVector = "Point3D is not the end point of the unit vector";
		}
	}

	@Override
	public void isPointOnCoordAxis() {
		if (x == 0.0 && y != 0.0 && z == 0.0) {
			System.out.println("Point3D is on the y axis");
			System.out.println("--------------------------------------------------------------------");
			pointOnAxis = "Point3D is on the y axis";
		} else if (x != 0.0 && y == 0.0 && z == 0.0) {
			System.out.println("Point3D is on the x axis");
			System.out.println("--------------------------------------------------------------------");
			pointOnAxis = "Point3D is on the x axis";
		} else if (x == 0.0 && y == 0.0 && z != 0.0) {
			System.out.println("Point3D is on the z axis");
			System.out.println("--------------------------------------------------------------------");
			pointOnAxis = "Point3D is on the z axis";
		} else if (x == 0.0 && y == 0.0 && z == 0.0) {
			System.out.println("Point3D is at the origin of the coordinate system");
			System.out.println("--------------------------------------------------------------------");
			pointOnAxis = "Point3D is at the origin of the coordinate system";
		} else if (x != 0 && y != 0 && z != 0) {
			System.out.println("Point3D is not on axes");
			System.out.println("--------------------------------------------------------------------");
			pointOnAxis = "Point3D is not on axes";
		} else {
			System.out.println("Failed to determine the Point's location on any axis");
			System.out.println("--------------------------------------------------------------------");
			pointOnAxis = "Failed to determine the Point's location on any axis";
		}
	}

	@Override
	public void savePoint() {
		File create3DDotFile = new File("3DPoint.txt");

		try {
			FileWriter write3D = new FileWriter(create3DDotFile);

			double x3D = x;
			double y3D = y;
			double z3D = z;

			write3D.write("Point3D: x = " + x3D + ", y = " + y3D + ", z = " + z3D + "\n" + pointOnAxis + "\n" + pointUnitVector);
			write3D.close();

			System.out.println("Created file: " + create3DDotFile.getName());
			System.out.println("--------------------------------------------------------------------");
		} catch (IOException e) {
			System.out.println("Error saving file: " + e.getMessage());
		}
	}
}
