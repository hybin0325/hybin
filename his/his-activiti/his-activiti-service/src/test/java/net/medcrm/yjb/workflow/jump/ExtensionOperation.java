package net.medcrm.yjb.workflow.jump;

import java.util.HashMap;
import java.util.Map;

public class ExtensionOperation {
	protected Map<String, String> propeies = new HashMap<String, String>();
	protected String name;

	public ExtensionOperation(String name) {

	}

	public void addProperty(String name, String value) {
		propeies.put(name, value);
	}

	public Map<String, String> getPropeies() {
		return propeies;
	}
}
