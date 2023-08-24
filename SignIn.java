import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SignIn extends User{
	
	public SignIn(String username, String password)  {
		super(username, password);
		
	}
	

	

	public boolean isUserValid() throws IOException {
		File passwordDB = new File("passwords.txt");   //username password format
		FileReader input;
		BufferedReader reader;
		try {
			input = new FileReader(passwordDB);
			reader = new BufferedReader(input);
			try {
				String line;
				while ((line = reader.readLine()) != null) {
					if ((this.getUsername().indexOf(line) != -1) && (this.getPassword().indexOf(line) != -1)) {
						return true;
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	

}
