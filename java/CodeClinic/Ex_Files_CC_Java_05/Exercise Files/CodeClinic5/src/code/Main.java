package code;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import static java.nio.file.StandardCopyOption.*;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

public class Main {

	public static void main(String[] args) throws IOException, ImageProcessingException {
		Main main = new Main();
		Map<String, File> captions = new HashMap<String, File>();
		File folder = new File("src/code/images");
		File[] images = folder.listFiles();
		for(File f : images) {
			if(main.getCaption(f) != null) {
				captions.put(main.getCaption(f).substring(26), f);
			}
		}
		main.reorganize(captions);
	}
	
	public String getCaption(File f) throws ImageProcessingException, IOException {
		Metadata metadata = ImageMetadataReader.readMetadata(f);
		for (Directory directory : metadata.getDirectories()) {
		    for (Tag tag : directory.getTags()) {
		        if(tag.toString().contains("[Iptc] Caption")) {
		        	return tag.toString();
		        }
		    }
		}
		return null;
	}
	
	public void reorganize(Map<String, File> captions) throws IOException {
		for(String s : captions.keySet()) {
			File folder = new File("src/code/images/" + s.substring(0,1));
			folder.mkdir();
			Files.move(captions.get(s).toPath(), new File(folder.toPath()+"/"+captions.get(s).getName()).toPath(), REPLACE_EXISTING);
		}
	}
}
