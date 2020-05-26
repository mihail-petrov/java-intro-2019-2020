package homework.config;

import java.io.IOException;

public class Configurations extends ConfigFile {
	private final int probesCount;
	private final int disposalsCount;

	public Configurations() throws IOException {
		super("configurations.txt");

		probesCount = Integer.parseInt(properties.getProperty("number_of_probes"));
		disposalsCount = Integer.parseInt(properties.getProperty("number_of_disposal"));
	}

	public int getProbesCount() {
		return probesCount;
	}

	public int getDisposalsCount() {
		return disposalsCount;
	}
}
