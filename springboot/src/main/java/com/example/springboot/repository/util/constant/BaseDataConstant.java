package com.example.springboot.repository.util.constant;/**
 * Created by lixiaobei on 2019/7/15.
 */

/**
 * @ClassName BaseDataConstant
 * @Description 基础数据常量
 * @Author lixbe
 * @Date 2019/7/15 14:43
 **/
public class BaseDataConstant {

    /**基础数据险种**/
    public  static  final String SIFC_AS_VAL_INSURANCE_CODE ="insuranceCode";

    /**启用状态 ：禁用**/
    public  static  final int SIFC_AS_VAL_FORBIDDEN_STATE =0;

    /**启用状态 ：启用**/
    public  static  final int SIFC_VAL_AS_USING_STATE =1;

    /**redis常量：tokenid**/
    public static final String SIFC_REDIS_TOKENID="tokenid";

    /**redis常量：userlogininfo**/
    public static final String SIFC_JEDISKEY="userlogininfo";

    /**返回类型为SQL*/
    public static final String SIFC_RETURN_TYPE_SQL = "0";
    /**返回类型为字符串*/
    public static final String SIFC_RETURN_TYPE_STR = "1";
    /**险种字段*/
    public static final String SIFC_INS_FIELD = "insuranceCode";

    public static final String SIFC_REC_STATUS_FIELD = "REC_STATUS";

    public static final String SIFC_REC_TIME_FIELD = "REC_TIME";

    /**成功*/
    public static final String SUCCESS = "成功";

    /**msg*/
    public static final String MSG = "msg";
    /**基础数据-险种类型**/
    public  static  final String SIFC_FORM_INSTYPE ="XZ";
    /**基础数据-险种类型 收入专用**/
    public static final String SMR_FORM_INSTYPE = "SMR_XZ";
    /**数据字典-险种*/
    public static final String INCOME_INSTYPE = "INSTYPE";
    /**基础数据-行政区划*/
    public static final String SIFC_FORM_AGENCY = "AGENCY";
    /**基础数据-银行账户*/
    public static final String SIFC_FORM_BANKINFO = "BANK_INFO";
    /**基础数据-往来单位账户*/
    public static final String SIFC_FORM_SUB_UNIT_ACC = "SUB_UNIT_ACC";
    /**基础数据-缴费类型*/
    public static final String SMC_FEE_TYPE = "FEE_TYPE";
    /**基础数据-数据传输类型*/
    public static final String SMC_DATA_TRANSFER_TYPE = "DATA_TRANSFER_TYPE";
    /** 是否入账*/
    public static final String SMC_RZ_YN = "RZ_YN";
    /**基础数据-缴费标识*/
    public static final String SMC_FEE_FLAG = "FEE_FLAG";
    /**基础数据-账户类型*/
    public static final String SMC_ACCOUNT_TYPE = "ACCOUNT_TYPE";
    /**基础数据-业务类型*/
    public static final String BUSINESS_TYPE = "BUSINESS_TYPE";
    /**基础数据-费款项目*/
    public static final String FEE_ITEM = "FEE_ITEM";

    public static final String FIELD_AGENCY_CODE = "AGENCY_CODE";
    public static final String FIELD_INSURANCE_CODE = "INSURANCE_CODE";

    // 青海新加的业务类型 开始
    /**基础数据-单位类型*/
    public static final String SMC_BIZ_SYS_EMP_TYPE = "BIZ_SYS_EMP_TYPE";
    /**医疗保险类别*/
    public static final String SMC_HI_TYPE = "HI_TYPE";
    /**单位管理类型*/
    public static final String SMC_EMP_MGT_TYPE = "EMP_MGT_TYPE";
    /**征收方式*/
    public static final String SMC_CHARGE_TYPE = "CHARGE_TYPE";
    // 青海新加的业务类型 结束

    public static final String CURRENT_ORG = "CURRENT_ORG";
    /**数据格式-列表*/
    public static final String SIFC_BASE_DATA_FORMAT_LIST = "LIST";
    /**数据格式-树*/
    public static final String SIFC_BASE_DATA_FORMAT_TREE = "TREE";

    /**缓存Region key*/
    public static final String REDIS_REGION_TREE_KEY = "UFGOV_SMC_REGION_TREE";
    /**缓存agent key*/
    public static final String REDIS_AGENCY_LIST_KEY = "REDIS_AGENCY_LIST_KEY";
    /**支付计划导入文件名集合*/
    public static final String REDIS_PAY_PLAN_FILENAME_SET_KEY = "UFGOV_SMC_PAY_PLAN_FILENAME_SET";
    /**转移支出导入文件名集合*/
    public static final String REDIS_TRANSFER_PAY_FILENAME_SET_KEY = "UFGOV_SMC_TRANSFER_PAY_FILENAME_SET";
    /**单笔支付*/
    public static final String SINGLE_PAY = "01";
    /**批量支付*/
    public static final String BATCH_PAY = "02";

    /**number -1*/
    public static final String MINUS_ONE = "-1";
    /**number 0*/
    public static final String NUMBER_ZERO = "0";
    /**number 1*/
    public static final String NUMBER_ONE = "1";
    /**number 2*/
    public static final String NUMBER_TWO = "2";
    /**number 3*/
    public static final String NUMBER_THREE = "3";
    /**number 4*/
    public static final String NUMBER_FOUR = "4";
    /**number 5*/
    public static final String NUMBER_FIVE = "5";
    /**number 6*/
    public static final String NUMBER_SIX = "6";
    /**number 7*/
    public static final String NUMBER_SEVEN = "7";
    /**number 8*/
    public static final String NUMBER_EIGHT = "8";
    /**number 9*/
    public static final String NUMBER_NINE = "9";
    /**number 11*/
    public static final String NUMBER_ELEVEN = "11";
    /**number 13*/
    public static final String NUMBER_HIRTEEN="13";
    /**number 0*/
    public static final Integer NUMBER_ZERO_INT = 0;
    /**number 1*/
    public static final Integer NUMBER_ONE_INT = 1;
    /**number 2*/
    public static final Integer NUMBER_TWO_INT = 2;
    /**number 3*/
    public static final Integer NUMBER_THREE_INT = 3;
    /**number 9*/
    public static final Integer NUMBER_NINE_INT = 9;

    /**区县国标code长度**/
    public  static  final int SMC_COUNTY_REGION_CODE_LENGTH = 6;

    /**统筹区设置**/
    public static final String UNION_REGION_CONFIG = "UNION_REGION_CONFIG";

    /**统筹区设置-当前省份编码*/
    public static final String CURRENT_PROVINCE_CODE = "CURRENT_PROVINCE_CODE";

    /**自定义往来单位ele_code*/
    public static final String SMC_ORG_UNIT_AUTHORITY_ELE_CODE = "ZDYWLDW";
    /** 业务类型ele_code*/
    public static final String SMC_BUSINESS_TYPE_AUTHORITY_ELE_CODE = "ZDYYWLX";

    public static final String CHECK_DATA_CURRENT_ORG = "CURRENT_ORG";

    public static final String VOU_STATUS = "VOU_STATUS";

    public static final String SIFC_REC_STATUS = "REC_STATUS";

    public static final String CHECK_DATA_BUSINESS_TYPE = "BUSINESS_TYPE";

    public static final String INSU_TYPE = "INSU_TYPE";
    public static final String FUND_PAY_TYPE = "FUND_PAY_TYPE";
    public static final String BIZ_SYS_EMP_TYPE = "BIZ_SYS_EMP_TYPE";
    public static final String PSN_TYPE = "PSN_TYPE";
    public static final String CLR_TYPE = "CLR_TYPE";
    public static final String MED_TYPE = "MED_TYPE";
    public static final String AAC058 = "AAC058";
    public static final String FIXMEDINS_TYPE = "FIXMEDINS_TYPE";
    /**文本*/
    public static final String CHECK_DATA_01 = "01";
    /** 目前 尚未配置*/
    public static final String CHECK_DATA_02 = "02";
    /**数字*/
    public static final String CHECK_DATA_03 = "03";
    /** 日期(YYYY-MM-DD) */
    public static final String CHECK_DATA_04 = "04";
    /** 日期(YYYYMMDD) */
    public static final String CHECK_DATA_05 = "05";
    /** 金额 */
    public static final String CHECK_DATA_06 = "06";
    /** 日期单选(YYYY-MM) */
    public static final String CHECK_DATA_07 = "07";
    /** 日期(YYYYMM) */
    public static final String CHECK_DATA_08 = "08";





    public static final int MONTH_ONE = 1;
    public static final int MONTH_THREE = 3;
    public static final int MONTH_FOUR = 4;
    public static final int MONTH_SIX = 6;
    public static final int MONTH_SEVEN = 7;
    public static final int MONTH_NINE = 9;
    public static final int MONTH_TEN = 10;
    public static final int MONTH_TEW = 12;

    public static final String QUARTER_ONE = "1";
    public static final String QUARTER_TWO = "2";
    public static final String QUARTER_THREE = "3";
    public static final String QUARTER_FOUR = "4";

    public static final String INSURANCE_CODE = "110";

    public static final String INSURANCE_NAME = "城镇职工基本养老保险";

    /**
     * 支出户类型
     */
    public static final String ACCOUNT_TYPE_EXP = "02";

    /**
     * 转移收入标记作废数据推送标识
     */
    public static final String ZYSR_MARK_PUSH_FLAG="ZYSR_MARK";

    /**
     * 转移收入推送中间库数据推送标识
     */
    public static final String ZYSR_PUSH_PUSH_FLAG="ZYSR_PUSH";
    /**
     * 征缴收入国库对账数据推送标识
     */
    public static final String ZJSR_TREASURY_RECON_PUSH_FLAG="ZJSR_TREASURY_RECON";
    /**
     * 征缴收入单位缴费数据推送标识
     */
    public static final String ZJSR_UNIT_PAYMENT_PUSH_FLAG="ZJSR_UNIT_PAYMENT";
    /**
     * 征缴收入财政专户数据推送标识
     */
    public static final String ZJSR_FISCAL_REVENUE_PUSH_FLAG="ZJSR_FISCAL_REVENUE";


    /**
     * md5加密开关code
     */
    public static final String MD5_SWITCH_CODE = "MD5_ENCRYPT_SWITCH";

    /**
     * md5加密开关code
     */
    public static final String REC_SWITCH_CODE = "REC_SWITCH";

    /**
     * 入账是否账套必填开关
     */
    public static final String ACCOUNT_CREDITED_SWITCH = "ACCOUNT_CREDITED_SWITCH";

    /**
     * 支付密码开关
     */
    public static final String PAY_AUTH_SWITCH = "PAY_PASSWORD_SWITCH";

    /**
     * 利息收入开启分摊开关code
     */
    public static final String INTEREST_SHARE_SWITCH = "INTEREST_SHARE_SWITCH";

    /** 往来单位是否允许修改*/
    public static final String ORG_UNIT_MODIFIABLE_SWITCH = "ORG_UNIT_MODIFIABLE_SWITCH";
    /**
     * 系统级单位code
     */
    public static final String SYS_AGENCY = "*";
    /**
     * 是否推送业务系统
     */
    public static final String IS_PUSH_BUSINESS_SYSTEM = "IS_PUSH_BUSINESS_SYSTEM";

    /**
     * 导出文件类型
     */
    public static final String FILE_SQL="sql";
    public static final String FILE_TXT="txt";

    /**
     * 导出文件类型--数据源类型
     */
    public static final String FILE_TYPE_DATASOURCE="目标表";
    /**
     * 导出文件类型--业务类型
     */
    public static final String FILE_TYPE_SERVICETYPE_DETAIL="业务类型";
    /**
     * 导出文件类型--业务类型明细
     */
    public static final String FILE_TYPE_SERVICETYPE="单据模型";
    /**
     * 导出文件类型--方案
     */
    public static final String FILE_TYPE_PLAN="方案";
    /**
     * 导出文件类型--脚本
     */
    public static final String FILE_TYPE_SCENARIO="物理表脚本";

    //---------------------业财一体化相关接口常量
    /**业财一体化业务端服务地址枚举code*/
    public static final String BUSINESS_SERVICE_ADDRESS = "BUSINESS_SERVICE_ADDRESS";

    /** 业务地址ip*/
    public static final String IP = "ip";

    /** 业务接口统一路径*/
    public static final String INTERFACE_URL = "interfaceUrl";

    /** 招采业务数据接口路径*/

    public static final String ZC_INTERFACE_URL="zcInterfaceUrl";

    /** 招采业务数据接口IP*/

    public static final String ZC_INTERFACE_IP="zcIP";

    /**异地就医调用接口ip地址枚举字典code*/
    public static final String RM_SYS_URL="RM_SYS_URL";

    /**异地就医调用接口url枚举字典*/
    public static final String RM_INTERFACEURL="rm_interfaceUrl";

    /**
     * 银行代码枚举字典代码
     **/
    public static final String BANK_CODE = "BANK_CODE";

    /**
     * 基金支付银行受理业务时间范围 加密开关code
     */
    public static final String PAY_TIME_STAGE_SWITCH = "PAY_TIME_STAGE_SWITCH";

    /** 利息收入组合查询*/
    public static final String INTEREST_COMBINE_SWITCH = "INTEREST_COMBINE_SWITCH";
    /** 转移收入组合查询*/
    public static final String TRANSFER_COMBINE_SWITCH = "TRANSFER_COMBINE_SWITCH";
    /** 开启业务财务经办机构编码转换*/
    public static final String AGENCY_TRANSFER_SWITCH = "AGENCY_TRANSFER_SWITCH";

    /**请求类型post**/
    public static final String  REQUEST_TYPE_POST="POST";
    /**请求类型get**/
    public static final String  REQUEST_TYPE_GET="GET";
    /**支付id（密码或随机码）**/
    public static final String PAY_ID = "payId";
    /**校验类型 0先校验后发请求 1校验与请求同时进行**/
    public static final String PAY_CHECK_TYPE = "payCheckType";
    /**数据data**/
    public static final String PAY_DATA = "data";

    /**
     * 分隔字符 ,
     */
    public final static String SPLIT_COMMA = ",";

    /**费款项打印文件名称**/
    public final static String COST_DETAIL_RESULT = "费款项明细";

    public final static String TRANBATCHNO_SPLIT = "#";

    /** 稽核系统IP 枚举code*/
    public static final String DEDUCTION_SYS_IP="DEDUCTION_SYS_IP";

    /** 稽核系统URI 枚举code*/
    public static final String DEDUCTION_SYS_URI="DEDUCTION_SYS_URI";
    /**重庆更新收款账户地址*/
    public static final String CQ_UPDATE_ACC_ADDR="CQ_UPDATE_ACC_ADDR";
    public static final String TC_FUND_PAY_TYPE="TC_FUND_PAY_TYPE";
}
