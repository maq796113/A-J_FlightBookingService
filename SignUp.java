import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SignUp extends User{

	File passwordDB = new File("passwords.txt");
	public SignUp(String username, String password) throws FileNotFoundException {
		super(username, password);
		
		
	}
	
	private boolean checkIfUserAlreadyExists() throws FileNotFoundException {
		FileReader input = new FileReader(passwordDB);
		BufferedReader reader = new BufferedReader(input);
		String line;
		try {
			while ((line = reader.readLine()) != null) {
				if ((this.getUsername().indexOf(line) == -1) && (this.getPassword().indexOf(line) == -1)) {
					return false;
				}
			}
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	public void storeUserInDB() throws IOException {
		String filename = "passwords.txt";
		if (!checkIfUserAlreadyExists()) {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line = reader.readLine();
			if (line != null) {
				FileWriter passwordDB_writer = new FileWriter(filename, true);
				BufferedWriter bufferedWriter = new BufferedWriter(passwordDB_writer);
				bufferedWriter.newLine();
				bufferedWriter.write(this.getUsername());
				bufferedWriter.write(" ");
				bufferedWriter.write(this.getPassword());
				bufferedWriter.close();
			}
		}
	}

}
