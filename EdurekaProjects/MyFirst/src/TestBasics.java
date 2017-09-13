import java.util.ArrayList;
import java.util.List;

public class TestBasics {
	
	public static void main(String[] args) {
		List<String> lst = new ArrayList<String>();
		lst.add("s");
		lst.add("s");
		lst.add("sa");
		lst.add("s");
		
		System.out.println(lst);
		
		for(String s :lst)
		{
			System.out.println(s);
			if((s.equals("sa")))
			{
				System.out.println("heheheheh");
			}
			else{
				System.out.println("sdadasd");
			}
		}
		
		for(int i=0;i<lst.size();i++)
		{
			System.out.println(lst.get(i));
		}
		
		if(lst.contains("sa"))
		{
			System.out.println("yes it contains sa");
		}
		
	}

}
