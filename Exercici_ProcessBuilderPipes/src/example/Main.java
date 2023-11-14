package example;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		List<ProcessBuilder> pblist = new ArrayList<>(Arrays.asList(
				new ProcessBuilder(new String[] {"ifconfig", "-a"}),
				new ProcessBuilder(new String[] {"grep", "lo:"}).redirectOutput(Redirect.INHERIT)
				));
		
		List<Process> plist = ProcessBuilder.startPipeline(pblist);
		Process plast = plist.get(plist.size()-1);
		
		try {
			plast.waitFor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
