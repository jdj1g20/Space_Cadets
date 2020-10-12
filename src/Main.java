import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

class Main{
    public static String searchLine(String emailID){ // Takes in emailID and return the line containing the name
        String line = "";
        try {
            URL url = new URL("https://www.ecs.soton.ac.uk/people/" + emailID);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

            while ((line = br.readLine()) != null){
                System.out.println(line);
                if(line.contains("property=\"name\"")){
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }
    public static String searchName(String line){ // Takes in the line containing the name and returns the name
        String name = line.substring(line.indexOf("name") + 6, line.indexOf("<",line.indexOf("name")));
        return name;
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Input emailID: ");
        String emailID = input.nextLine();
        String line = searchLine(emailID);
        System.out.println(searchName(line));
    }
}

