package pojo;

import java.util.List;

/**
 * TODO
 *
 * @author zhaosp1
 * @version 1.0
 * @date 2021/7/28 22:32
 */

public class Person {
  private long id;
  private String name;
  private String age;
  private List<Person> parents;
  private List<Person> friends;
  private Person wife;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public List<Person> getParents() {
    return parents;
  }

  public void setParents(List<Person> parents) {
    this.parents = parents;
  }

  public List<Person> getFriends() {
    return friends;
  }

  public void setFriends(List<Person> friends) {
    this.friends = friends;
  }

  public Person getWife() {
    return wife;
  }

  public void setWife(Person wife) {
    this.wife = wife;
  }

  @Override
  public String toString() {
    return "Person{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", age='" + age + '\'' +
            ", parents=" + parents +
            ", friends=" + friends +
            ", wife=" + wife +
            '}';
  }
}
