package example;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task1_2_PipeMime {
	public static void main(String[] args) {
		List<ProcessBuilder> pblist = new ArrayList<>(Arrays.asList(
				new ProcessBuilder(new String[] {"cat", "/var/log/syslog"}),
				new ProcessBuilder(new String[] {"grep", "dhcp4"}),
				new ProcessBuilder(new String[] {"tail"}).redirectOutput(Redirect.INHERIT)
				));
		
		try {
			
			List<Process> plist = ProcessBuilder.startPipeline(pblist);
			Process p = plist.get(plist.size()-1);
			
			p.waitFor();
			
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
