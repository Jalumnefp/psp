package example;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Task1_1_ProcessEnvironment {
	public static void main(String[] args) {

		ProcessBuilder pb = new ProcessBuilder(new String[] { "sleep", "750" });

		Map<String, String> map = pb.environment();

		Set<Map.Entry<String, String>> setmap = map.entrySet();

		for (Entry<String, String> s : setmap) {
			System.out.println(s);
		}

	}
}
