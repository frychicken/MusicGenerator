import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
public class Soundfx {
	  public void sound(String where){
	    try{
	      File dafile = new File(System.getProperty("user.dir")+"/SoundRes/"+where+".wav");
	      AudioInputStream audioIn = AudioSystem.getAudioInputStream(dafile);
	      AudioFormat format = audioIn.getFormat();
	      DataLine.Info info = new DataLine.Info(Clip.class, format);
	      Clip clip = (Clip)AudioSystem.getLine(info);
	      clip.open(audioIn);
	      clip.start();
	   
	      Thread.sleep(600);
	    }
	    catch(Exception e){
	    	e.printStackTrace();

	    }
	  }
	  public void trya(int anum) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
	
	      File dafile = new File(System.getProperty("user.dir")+"/drum/"+Integer.toString(anum)+".wav");
	      AudioInputStream audioIn = AudioSystem.getAudioInputStream(dafile);
	      AudioFormat format = audioIn.getFormat();
	      DataLine.Info info = new DataLine.Info(Clip.class, format);
	      Clip clip = (Clip)AudioSystem.getLine(info);
	      clip.open(audioIn);
	      clip.start();
	  }
	  

	  public void anothr(int anum) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
	
	      File dafile = new File(System.getProperty("user.dir")+"/SoundRes/"+Integer.toString(anum)+".wav");
	      AudioInputStream audioIn = AudioSystem.getAudioInputStream(dafile);
	      AudioFormat format = audioIn.getFormat();
	      DataLine.Info info = new DataLine.Info(Clip.class, format);
	      Clip clip = (Clip)AudioSystem.getLine(info);
	      clip.open(audioIn);
	      clip.start();
	  }
}