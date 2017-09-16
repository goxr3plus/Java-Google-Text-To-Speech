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
public class Application {
	
	/**
	 * Constructor
	 */
	public Application() {
		
		//Let's speak in English
		speak("Hello my name is Alex");
		
		//Let's Speak in Greek
		speak("Καλημέρα με λένε Αλέξανδρο");
		
		//Let's Speak in Russian
		speak("");
		
		//Let's Speak in Hindi
		speak("");		
		
		//Let's Speak in Polish
		//speak("");
		
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
			//Create a Synthesizer instance
			SynthesiserV2 synthesizer = new SynthesiserV2("AIzaSyBOti4mM-6x9WDnZIjIeyEU21OpBXqWBgw");
			try {
				
				//Create a JLayer instance
				Player player = new Player(synthesizer.getMP3Data(text));
				player.play();
				
				System.out.println("Successfully got back synthesizer data");
			} catch (IOException | JavaLayerException e) {
				
				e.printStackTrace(); //Print the exception ( we want to know , not hide below our finger , like many developers do...)
				
			}
		});
		
		//We don't want the application to terminate before this Thread terminates
		thread.setDaemon(false);
		
		//Start the Thread
		thread.start();
		
	}
	
	public static void main(String[] args) {
		new Application();
	}
	
}
