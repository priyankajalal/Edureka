package vinod.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.Yaml;

public class YamlTestNg {
	

	@Test(dataProvider="yamlData")
	public void test(String uid,String pwd)
	{
		System.out.println(uid);
		System.out.println(pwd);
	}
	@DataProvider
	public Object[][] yamlData() throws FileNotFoundException
	{
		Yaml yaml = new Yaml();

		InputStream ios = new FileInputStream(new File("Data/uidpwd.yaml"));
		Map<String, Object> result = (Map<String, Object>) yaml.load(ios);
		System.out.println(result.toString());
		Object[][] arr = new Object[result.size()][];
		int i = 0;
		for(String key : result.keySet())
		{
			ArrayList<String> lst= new ArrayList<String>();
			lst.add(key);
			lst.add(result.get(key).toString());
			arr[i++]=lst.toArray();
		}
		return arr;
	}

}
