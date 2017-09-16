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
	
	//Create a Synthesizer instance
	SynthesiserV2 synthesizer = new SynthesiserV2("AIzaSyBOti4mM-6x9WDnZIjIeyEU21OpBXqWBgw");
	
	/**
	 * Constructor
	 */
	public Application() {
		
		//Let's speak in English
		//speak("I can speak any language you want !");
		
		//Speak Spanish and Sing Despasito
		//synthesizer.setPitch(0.25);
		//synthesizer.setSpeed(1);
		speak("sabes que ya llevo un rato mirándote Tengo que bailar contigo hoy (DY) Vi que tu mirada ya estaba llamándome Muéstrame el camino que yo voy (Oh) Tú, tú eres el imán y yo soy el metal Me voy acercando y voy armando el plan Solo con pensarlo se acelera el pulso (Oh yeah) Ya, ya me está gustando más de lo normal Todos mis sentidos van pidiendo más Esto hay que tomarlo sin ningún apuro Despacito Quiero respirar tu cuello despacito Deja que te diga cosas al oído Para que te acuerdes si no estás conmigo Despacito Quiero desnudarte a besos despacito Firmo en las paredes de tu laberinto Y hacer de tu cuerpo todo un manuscrito (sube, sube, sube)(Sube, sube)Quiero ver bailar tu pelo Quiero ser tu ritmo Que le enseñes a mi boca Tus lugares favoritos (favoritos, favoritos baby) Déjame sobrepasar tus zonas de peligro Hasta provocar tus gritos Y que olvides tu apellido (Diridiri, dirididi Daddy)(DY) Si te pido un beso ven dámelo Yo sé que estás pensándolo Llevo tiempo intentándolo Mami, esto es dando y dándolo Sabes que tu corazón conmigo te hace bom, bom Sabes que esa beba está buscando de mi bom, bom Ven prueba de mi boca para ver cómo te sabe Quiero, quiero, quiero ver cuánto amor a ti te cabe Yo no tengo prisa, yo me quiero dar el viaje Empecemos lento, después salvaje Pasito a pasito, suave suavecito Nos vamos pegando poquito a poquito Cuando tú me besas con esa destreza Veo que eres malicia con delicadeza Pasito a pasito, suave suavecito Nos vamos pegando, poquito a poquito Y es que esa belleza es un rompecabezas Pero pa montarlo aquí tengo la pieza Despacito Quiero respirar tu cuello despacito Deja que te diga cosas al oído Para que te acuerdes si no estás conmigo Despacito Quiero desnudarte a besos despacito Firmo en las paredes de tu laberinto Y hacer de tu cuerpo todo un manuscrito (sube, sube, sube)(Sube, sube)Quiero ver bailar tu pelo Quiero ser tu ritmo Que le enseñes a mi boca Tus lugares favoritos (favoritos, favoritos baby) Déjame sobrepasar tus zonas de peligro Hasta provocar tus gritos Y que olvides tu apellido Despacito Vamos a hacerlo en una playa en Puerto Rico Hasta que las olas griten \"¡ay, bendito!\" Para que mi sello se quede contigo Pasito a pasito, suave suavecito Nos vamos pegando, poquito a poquito Que le enseñes a mi boca Tus lugares favoritos (favoritos, favoritos baby) Pasito a pasito, suave suavecito Nos vamos pegando, poquito a poquito Hasta provocar tus gritos Y que olvides tu apellido (DY)");
		
		
		
		//Speak Chinese Fuckers
		//speak("我可以说你想要的任何语言！");
		
		//Let's Speak in Somalian       
		//speak("Waxaan ku hadli karaa luqad aad rabto!");
		
		//Let's Speak in Hindi
		//speak("मैं चाहता हूं कि कोई भी भाषा बोल सकता हूँ!");
		
		//Let's Speak in Polish
		//speak("Mogę mówić dowolnym językiem, którego chcesz!");
		
		//Let's Speak in Russan       ----- This doens't work for some reason i have to figure out ... ;(
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
