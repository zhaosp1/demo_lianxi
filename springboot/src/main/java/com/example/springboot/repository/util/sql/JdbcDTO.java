package com.example.springboot.repository.util.sql;

/**
 * 用于连接jdbc的配置信息类
 */
public class JdbcDTO {
  private String driverName;
  private String url;
  private String userName;
  private String passWord;

  /**
   * TODO 临时默认配置
   * @param model
   * @return
   */
  public static JdbcDTO  getDefaultConfig(String model){
    JdbcDTO jdbcDTO=new JdbcDTO();
    if("mysql5".equals(model)){
      jdbcDTO.setDriverName("com.mysql.jdbc.Driver");
      jdbcDTO.setUrl("jdbc:mysql://127.0.0.1:13306/hibernate?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC");
      jdbcDTO.setUserName("root");
      jdbcDTO.setPassWord("20133073");
    }else if("oracle".equals(model)){
      jdbcDTO.setDriverName("oracle.jdbc.driver.OracleDriver");
      jdbcDTO.setUrl("jdbc:oracle:thin:@localhost:1521/orcl");
      jdbcDTO.setUserName("root");
      jdbcDTO.setPassWord("1");
    }
    return jdbcDTO;
  }

  public String getDriverName() {
    return driverName;
  }

  public void setDriverName(String driverName) {
    this.driverName = driverName;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassWord() {
    return passWord;
  }

  public void setPassWord(String passWord) {
    this.passWord = passWord;
  }
}
