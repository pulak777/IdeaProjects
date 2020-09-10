import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception{
        File file = new File("movies.txt");
        Scanner scanner = new Scanner(file);
        ArrayList movies = new ArrayList();
        while(scanner.hasNextLine()){
            movies.add(scanner.nextLine());
        }
        int moviesNum = movies.size();
        int index = (int) (Math.random()*moviesNum) + 1;
        String guessedMovie = (String) movies.get(index);
        String copyGuessedMovie = guessedMovie.replaceAll(".", "_");
        System.out.println("You are guessing:" + copyGuessedMovie);
        System.out.println("You are guessing:" + guessedMovie);
        int wrongLetters = 0;
        System.out.println("You have guessed (" + wrongLetters + ") wrong letters:");
        int points = 10;
        String characters = "[^";
        while(points > 0){
            System.out.println("Guess a letter:");
            Scanner scanner1 = new Scanner(System.in);
            String character = scanner1.next();
            if(guessedMovie.indexOf(character) != moviesNum){
                characters += character;
                String regularExp = new StringBuilder().append(characters).append("]").toString();
                copyGuessedMovie = guessedMovie.replaceAll(regularExp, "_");
            }
            else {
                wrongLetters++;
            }
            System.out.println("You are guessing:" + copyGuessedMovie);
            System.out.println("You have guessed (" + wrongLetters + ") wrong letters:");
            points--;
        }
    }
}
