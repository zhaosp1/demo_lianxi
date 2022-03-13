package com.example.springboot.repository.util.xml;

import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class xml {
  public static String getxml(Map<String, String> map) {
    StringBuilder sb = new StringBuilder("");
    sb.append("<struct>");
    for (Map.Entry<String, String> m : map.entrySet()) {

      sb.append("<data name=\"" + m.getKey() + "\">");
      sb.append("<field type=\"string\" length=\"" + m.getValue().length() + "\">" + m.getValue()
        + "</field>");
      sb.append("</data>");
    }
    sb.append("</struct>");

    return sb.toString();
  }

  public static void main(String[] args) {
    Map<String, String> map = new HashMap<>();

    String s = "TEXT_FIELD_NO#TEXT_FIELD_NAME#TEXT_FIELD_VAL#TEXT_FIELD_TYPE#TEMPLATE_NO";
    for (String t : s.split("#")) {
      map.put(t, "");
    }
    JSONObject object = JSONObject.fromObject(map);

    JSONObject object1 = JSONObject.fromObject(map);
    object1.put("TEXT_FIELD_VAL", "1");
    System.out.println(object.toString());
    System.out.println(object1.toString());

    Map<String, String> map1 = new HashMap<>();
    map1.put("test1","1");
    for (Map.Entry<String, String> t : map1.entrySet()) {
      JSONObject temp = JSONObject.fromObject(
        "{\"TEXT_FIELD_VAL\":\"\",\"TEXT_FIELD_NAME\":\"\",\"TEMPLATE_NO\":\"\",\"TEXT_FIELD_TYPE\":\"\",\"TEXT_FIELD_NO\":\"\"}");
      temp.put("TEXT_FIELD_NAME", t.getKey());
      temp.put("TEXT_FIELD_VAL", t.getValue());
      System.out.println(getxml(temp));
    }
  }
}
