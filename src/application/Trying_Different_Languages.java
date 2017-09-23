package application;

import java.io.IOException;

import com.darkprograms.speech.synthesiser.SynthesiserV2;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 * This is where all begins .
 * 
 * @author GOXR3PLUS
 *
 */
public class Trying_Different_Languages {
	
	//Create a Synthesizer instance
	SynthesiserV2 synthesizer = new SynthesiserV2("AIzaSyBOti4mM-6x9WDnZIjIeyEU21OpBXqWBgw");
	
	/**
	 * Constructor
	 */
	public Trying_Different_Languages() {
		
		//Let's speak in English
		synthesizer.setPitch(0.4);
		speak("Listen looser , you first have to straight up you back . Then look me in the eyes . Your game is weak! You have to be dominant with me . There is no like you grab my hand and kiss me . I mean in real life ! There are people watching this be serious and mysterious .");
		
		//Speak Chinese Fuckers
		//speak("我可以说你想要的任何语言！");
		
		//Let's Speak in Somalian       
		//speak("Waxaan ku hadli karaa luqad aad rabto!");
		
		//Let's Speak in Hindi
		//speak("मैं चाहता हूं कि कोई भी भाषा बोल सकता हूँ!");
		
		//Let's Speak in Polish
		//speak("Mogę mówić dowolnym językiem, którego chcesz!");
		
		//Let's Speak in Persian       ----- This doens't work for some reason i have to figure out ... ;(
		//speak("من می توانم به هر زبان که می خواهید صحبت کنید!");
		
	}
	
	/**
	 * Calls the MaryTTS to say the given text
	 * 
	 * @param text
	 */
	public void speak(String text) {
		System.out.println(text);
		
		//Create a new Thread because JLayer is running on the current Thread and will make the application to lag
		Thread thread = new Thread(() -> {
			try {
				
				//Create a JLayer instance
				Player player = new Player(synthesizer.getMP3Data(text));
				player.play();
				
				System.out.println("Successfully got back synthesizer data");
				
				Thread.sleep(2000);
				
				//Create a JLayer instance
				Player player2 = new Player(synthesizer.getMP3Data("Yes but you look crippy"));
				player2.play();
				
				Player player3 = new Player(synthesizer.getMP3Data("Have i told you about my last boyfriend , it was like .... "));
				player3.play();
				
				Thread.sleep(1500);
				
				Player player4 = new Player(synthesizer.getMP3Data("You must not tell me your name , keep an air of mystery about your self so my attraction level grows"));
				player4.play();
				
			} catch (IOException | JavaLayerException | InterruptedException e) {
				
				e.printStackTrace(); //Print the exception ( we want to know , not hide below our finger , like many developers do...)
				
			}
		});
		
		//We don't want the application to terminate before this Thread terminates
		thread.setDaemon(false);
		
		//Start the Thread
		thread.start();
		
	}
	
	public static void main(String[] args) {
		new Trying_Different_Languages();
	}
	
}
