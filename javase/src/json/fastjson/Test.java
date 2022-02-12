package json.fastjson;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * readValue是将json字符串读取为对象
 * writeValue是将对象写为json字符串
 */
public class Test {
  public static void main(String[] args) {
    ObjectMapper mapper = new ObjectMapper();
    String jsonString = "{\"name\":\"eric\", \"age\":21}";

    try{
      //把JSON转换为Java对象
      Student student = mapper.readValue(jsonString, Student.class);
      System.out.println(student);

      //把Java对象为JSON
      jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);
      System.out.println(jsonString);
    }
    catch (JsonParseException e) {
      e.printStackTrace();
    }
    catch (JsonMappingException e) {
      e.printStackTrace();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }
}
