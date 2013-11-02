import  sun.audio.*;    //import the sun.audio package
import  java.io.*;

/**
 * An example of playing a sound file.
 */
public class PlaySound {

	public void PlaySoundFile(String fileName) throws Exception {
		// Open an input stream  to the audio file.
		InputStream in = new FileInputStream(fileName);
		// Create an AudioStream object from the input stream.
		AudioStream as = new AudioStream(in);         
		// Use the static class member "player" from class AudioPlayer to play
		// sound file.
    	System.out.println("Playing sound");
		AudioPlayer.player.start(as);            
		// Similarly, to stop the audio.
//		AudioPlayer.player.stop(as); 
	}
}        

