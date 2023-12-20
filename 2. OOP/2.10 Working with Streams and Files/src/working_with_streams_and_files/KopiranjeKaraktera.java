package working_with_streams_and_files;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class KopiranjeKaraktera {

	public static void main(String[] args) throws IOException {
		FileReader input = null;
		FileWriter output = null;
		
		try {
			input = new FileReader("ulazKarakter.txt");
			output = new FileWriter("izlazKarakter.txt");
			int c;
			while ((c = input.read()) != -1) {
				output.write(c);
			}
		}

		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		finally {
			if (input != null) {
				input.close();
			}
			if (output != null) {
				output.close();
			}

		}

	}

}
