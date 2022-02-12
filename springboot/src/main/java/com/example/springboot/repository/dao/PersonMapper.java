package com.example.springboot.repository.dao;

import com.example.springboot.component.pojo.Person;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PersonMapper {

  @Select("SELECT * FROM Person WHERE id = #{id}")
  Person selectUser(int id);

  @Insert(" insert into Person ( name ) values (#{name}) ")
  public int add(Person Person);

  @Delete(" delete from Person where id= #{id} ")
  public void delete(int id);

  @Select("select * from Person where id= #{id} ")
  public Person get(int id);

  @Update("update Person set name=#{name} where id=#{id} ")
  public int update(Person Person);

  @Select(" select * from Person_ ")
  public List<Person> list();
}