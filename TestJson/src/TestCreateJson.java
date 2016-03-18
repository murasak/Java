import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class TestCreateJson {

	public static void main(String[] args) {
		JsonObject object = new JsonObject();
		object.addProperty("cat", "it");
		
		JsonArray array = new JsonArray();
		
		JsonObject lan1 = new JsonObject();
		lan1.addProperty("id", 1);
		lan1.addProperty("name", "Java");
		lan1.addProperty("ide", "Eclipse");
		
		array.add(lan1);
		
		object.add("languages", array);
		
		object.addProperty("pop", true);
		
		System.out.println(object.toString());

	}
}
