package com.bridgelabz.junit;
//Uc3
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Test;
import com.bridgelabz.watcher.WatchServicePractice;
public class WatchServiceTest {
	private static String HOME=System.getProperty("user.home");
	private static String PLAY_WITH_NIO="TempPlayGround";
	@Test
	public void givenDirectory_whenWatched_listAllTheActivities() throws IOException {
		try {
			Path dir=Paths.get(HOME+"/"+PLAY_WITH_NIO);
			Files.list(dir).filter(Files::isRegularFile).forEach(System.out::println);
			new WatchServicePractice(dir).processEvents();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
