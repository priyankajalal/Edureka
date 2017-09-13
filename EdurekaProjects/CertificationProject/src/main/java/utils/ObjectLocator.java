package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

import org.openqa.selenium.By;
import org.yaml.snakeyaml.Yaml;

public class ObjectLocator {

	static ObjectLocator yamlHelper = null;

	private ObjectLocator() {
		try {
			Yaml yaml = new Yaml();
			InputStream ios = new FileInputStream(new File("data/locators.yaml"));
			data = (Map<String, Map<String, Map<String, String>>>) yaml.load(ios);
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

	public static ObjectLocator getInstance() {
		if (yamlHelper == null) {
			yamlHelper = new ObjectLocator();
		}
		return yamlHelper;
	}

	static Map<String, Map<String, Map<String, String>>> data = null;

	public By getElement(String page, String element) {
		String type = data.get(page).get(element).get("type");
		String elementValue = data.get(page).get(element).get("element");
		if (type.equals("id")) {
			return By.id(elementValue);
		} else if (type.equals("tagName")) {
			return By.tagName(elementValue);
		} else if (type.equals("linkText")) {
			return By.linkText(elementValue);
		} else if (type.equals("xpath")) {
			return By.xpath(elementValue);
		} else if (type.equals("cssSelector")) {
			return By.cssSelector(elementValue);
		} else if (type.equals("partialLinkText")) {
			return By.partialLinkText(elementValue);
		} else if (type.equals("name")) {
			return By.name(elementValue);
		} else if (type.equals("className")) {
			return By.className(elementValue);
		} else {
			return null;
		}

	}
}
