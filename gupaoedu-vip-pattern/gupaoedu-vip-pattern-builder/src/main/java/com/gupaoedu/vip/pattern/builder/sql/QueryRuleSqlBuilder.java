package com.gupaoedu.vip.pattern.builder.sql;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.ArrayUtils;

import com.gupaoedu.vip.pattern.builder.sql.QueryRule.Rule;
import org.apache.commons.lang.StringUtils;


/**
 * 根据QueryRule自动构建sql语句
 * @author Tom
 *
 */
public class QueryRuleSqlBuilder {
	private int CURR_INDEX = 0; //记录参数所在的位置
	private List<String> properties; //保存列名列表
	private List<Object> values; //保存参数值列表
	private List<Order> orders; //保存排序规则列表
	
	private String whereSql = ""; 
	private String orderSql = "";
	private Object [] valueArr = new Object[]{};
	private Map<Object,Object> valueMap = new HashMap<Object,Object>();
	
	/**
	 * 或得查询条件
	 * @return
	 */
	private String getWhereSql(){
		return this.whereSql;
	}
	
	/**
	 * 获得排序条件
	 * @return
	 */
	private String getOrderSql(){
		return this.orderSql;
	}
	
	/**
	 * 获得参数值列表
	 * @return
	 */
	public Object [] getValues(){
		return this.valueArr;
	}
	
	/**
	 * 获取参数列表
	 * @return
	 */
	private Map<Object,Object> getValueMap(){
		return this.valueMap;
	}
	
	/**
	 * 创建SQL构造器
	 * @param queryRule
	 */
	public QueryRuleSqlBuilder(QueryRule queryRule) {
		CURR_INDEX = 0;
		properties = new ArrayList<String>();
		values = new ArrayList<Object>();
		orders = new ArrayList<Order>();
		for (QueryRule.Rule rule : queryRule.getRuleList()) {
			switch (rule.getType()) {
			case QueryRule.BETWEEN:
				processBetween(rule);
				break;
			case QueryRule.EQ:
				processEqual(rule);
				break;
			case QueryRule.LIKE:
				processLike(rule);
				break;
			case QueryRule.NOTEQ:
				processNotEqual(rule);
				break;
			case QueryRule.GT:
				processGreaterThen(rule);
				break;
			case QueryRule.GE:
				processGreaterEqual(rule);
				break;
			case QueryRule.LT:
				processLessThen(rule);
				break;
			case QueryRule.LE:
				processLessEqual(rule);
				break;
			case QueryRule.IN:
				processIN(rule);
				break;
			case QueryRule.NOTIN:
				processNotIN(rule);
				break;
			case QueryRule.ISNULL:
				processIsNull(rule);
				break;
			case QueryRule.ISNOTNULL:
				processIsNotNull(rule);
				break;
			case QueryRule.ISEMPTY:
				processIsEmpty(rule);
				break;
			case QueryRule.ISNOTEMPTY:
				processIsNotEmpty(rule);
				break;
			case QueryRule.ASC_ORDER:
				processOrder(rule);
				break;
			case QueryRule.DESC_ORDER:
				processOrder(rule);
				break;
			default:
				throw new IllegalArgumentException("type " + rule.getType() + " not supported.");
			}
		}
		//拼装where语句
		appendWhereSql();
		//拼装排序语句
		appendOrderSql();
		//拼装参数值
		appendValues();
	}
	
	/**
	 * 去掉order
	 * 
	 * @param sql
	 * @return
	 */
	private String removeOrders(String sql) {
		Pattern p = Pattern.compile("order\\s*by[\\w|\\W|\\s|\\S]*", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(sql);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sb, "");
		}
		m.appendTail(sb);
		return sb.toString();
	}
	
	/**
	 * 去掉select
	 * 
	 * @param sql
	 * @return
	 */
	private String removeSelect(String sql) {
		if(sql.toLowerCase().matches("from\\s+")){
			int beginPos = sql.toLowerCase().indexOf("from");
			return sql.substring(beginPos);
		}else{
			return sql;
		}
	}
	
	/**
	 * 处理like
	 * @param rule
	 */
	private  void processLike(QueryRule.Rule rule) {
		if (ArrayUtils.isEmpty(rule.getValues())) {
			return;
		}
		Object obj = rule.getValues()[0];

		if (obj != null) {
			String value = obj.toString();
			if (!StringUtils.isEmpty(value)) {
				value = value.replace('*', '%');
				obj = value;
			}
		}
		add(rule.getAndOr(),rule.getPropertyName(),"like","%"+rule.getValues()[0]+"%");
	}

	/**
	 * 处理between
	 * @param rule
	 */
	private  void processBetween(QueryRule.Rule rule) {
		if ((ArrayUtils.isEmpty(rule.getValues()))
				|| (rule.getValues().length < 2)) {
			return;
		}
		add(rule.getAndOr(),rule.getPropertyName(),"","between",rule.getValues()[0],"and");
		add(0,"","","",rule.getValues()[1],"");
	}
	
	/**
	 * 处理 =
	 * @param rule
	 */
	private  void processEqual(QueryRule.Rule rule) {
		if (ArrayUtils.isEmpty(rule.getValues())) {
			return;
		}
		add(rule.getAndOr(),rule.getPropertyName(),"=",rule.getValues()[0]);
	}

	/**
	 * 处理 <>
	 * @param rule
	 */
	private  void processNotEqual(QueryRule.Rule rule) {
		if (ArrayUtils.isEmpty(rule.getValues())) {
			return;
		}
		add(rule.getAndOr(),rule.getPropertyName(),"<>",rule.getValues()[0]);
	}

	/**
	 * 处理 >
	 * @param rule
	 */
	private  void processGreaterThen(
			QueryRule.Rule rule) {
		if (ArrayUtils.isEmpty(rule.getValues())) {
			return;
		}
		add(rule.getAndOr(),rule.getPropertyName(),">",rule.getValues()[0]);
	}

	/**
	 * 处理>=
	 * @param rule
	 */
	private  void processGreaterEqual(
			QueryRule.Rule rule) {
		if (ArrayUtils.isEmpty(rule.getValues())) {
			return;
		}
		add(rule.getAndOr(),rule.getPropertyName(),">=",rule.getValues()[0]);
	}

	/**
	 * 处理<
	 * @param rule
	 */
	private  void processLessThen(QueryRule.Rule rule) {
		if (ArrayUtils.isEmpty(rule.getValues())) {
			return;
		}
		add(rule.getAndOr(),rule.getPropertyName(),"<",rule.getValues()[0]);
	}

	/**
	 * 处理<=
	 * @param rule
	 */
	private  void processLessEqual(
			QueryRule.Rule rule) {
		if (ArrayUtils.isEmpty(rule.getValues())) {
			return;
		}
		add(rule.getAndOr(),rule.getPropertyName(),"<=",rule.getValues()[0]);
	}

	/**
	 * 处理  is null
	 * @param rule
	 */
	private  void processIsNull(QueryRule.Rule rule) {
		add(rule.getAndOr(),rule.getPropertyName(),"is null",null);
	}

	/**
	 * 处理 is not null
	 * @param rule
	 */
	private  void processIsNotNull(QueryRule.Rule rule) {
		add(rule.getAndOr(),rule.getPropertyName(),"is not null",null);
	}

	/**
	 * 处理  <>''
	 * @param rule
	 */
	private  void processIsNotEmpty(QueryRule.Rule rule) {
		add(rule.getAndOr(),rule.getPropertyName(),"<>","''");
	}

	/**
	 * 处理 =''
	 * @param rule
	 */
	private  void processIsEmpty(QueryRule.Rule rule) {
		add(rule.getAndOr(),rule.getPropertyName(),"=","''");
	}

	
	/**
	 * 处理in和not in
	 * @param rule
	 * @param name
	 */
	private void inAndNotIn(QueryRule.Rule rule,String name){
		if (ArrayUtils.isEmpty(rule.getValues())) {
			return;
		}
		if ((rule.getValues().length == 1) && (rule.getValues()[0] != null)
				&& (rule.getValues()[0] instanceof List)) {
			List<Object> list = (List) rule.getValues()[0];
			
			if ((list != null) && (list.size() > 0)){
				for (int i = 0; i < list.size(); i++) {
					if(i == 0 && i == list.size() - 1){
						add(rule.getAndOr(),rule.getPropertyName(),"",name + " (",list.get(i),")");
					}else if(i == 0 && i < list.size() - 1){
						add(rule.getAndOr(),rule.getPropertyName(),"",name + " (",list.get(i),"");
					}
					if(i > 0 && i < list.size() - 1){
						add(0,"",",","",list.get(i),"");
					}
					if(i == list.size() - 1 && i != 0){
						add(0,"",",","",list.get(i),")");
					}
				}
			}
		} else {
			Object[] list =  rule.getValues();
			for (int i = 0; i < list.length; i++) {
				if(i == 0 && i == list.length - 1){
					add(rule.getAndOr(),rule.getPropertyName(),"",name + " (",list[i],")");
				}else if(i == 0 && i < list.length - 1){
					add(rule.getAndOr(),rule.getPropertyName(),"",name + " (",list[i],"");
				}
				if(i > 0 && i < list.length - 1){
					add(0,"",",","",list[i],"");
				}
				if(i == list.length - 1 && i != 0){
					add(0,"",",","",list[i],")");
				}
			}
		}
	}
	
	/**
	 * 处理 not in
	 * @param rule
	 */
	private void processNotIN(QueryRule.Rule rule){
		inAndNotIn(rule,"not in");
	}
	
	/**
	 * 处理 in
	 * @param rule
	 */
	private  void processIN(QueryRule.Rule rule) {
		inAndNotIn(rule,"in");
	}
	
	/**
	 * 处理 order by
	 * @param rule 查询规则
	 */
	private void processOrder(Rule rule) {
		switch (rule.getType()) {
		case QueryRule.ASC_ORDER:
			// propertyName非空
			if (!StringUtils.isEmpty(rule.getPropertyName())) {
				orders.add(Order.asc(rule.getPropertyName()));
			}
			break;
		case QueryRule.DESC_ORDER:
			// propertyName非空
			if (!StringUtils.isEmpty(rule.getPropertyName())) {
				orders.add(Order.desc(rule.getPropertyName()));
			}
			break;
		default:
			break;
		}
	}
	
	
	/**
	 * 加入到sql查询规则队列
	 * @param andOr and 或者 or
	 * @param key 列名
	 * @param split 列名与值之间的间隔
	 * @param value 值
	 */
	private  void add(int andOr,String key,String split ,Object value){
		add(andOr,key,split,"",value,"");
	}
	
	/**
	 * 加入到sql查询规则队列
	 * @param andOr and 或则 or
	 * @param key 列名
	 * @param split 列名与值之间的间隔
	 * @param prefix 值前缀
	 * @param value 值
	 * @param suffix 值后缀
	 */
	private  void add(int andOr,String key,String split ,String prefix,Object value,String  suffix){
		String andOrStr = (0 == andOr ? "" :(QueryRule.AND == andOr ? " and " : " or "));  
		properties.add(CURR_INDEX, andOrStr + key + " " + split + prefix + (null != value ? " ? " : " ") + suffix);
		if(null != value){
			values.add(CURR_INDEX,value);
			CURR_INDEX ++;
		}
	}
	
	
	/**
	 * 拼装 where 语句
	 */
	private void appendWhereSql(){
		StringBuffer whereSql = new StringBuffer();
		for (String p : properties) {
			whereSql.append(p);
		}
		this.whereSql = removeSelect(removeOrders(whereSql.toString()));
	}
	
	/**
	 * 拼装排序语句
	 */
	private void appendOrderSql(){
		StringBuffer orderSql = new StringBuffer();
		for (int i = 0 ; i < orders.size(); i ++) {
			if(i > 0 && i < orders.size()){
				orderSql.append(",");
			}
			orderSql.append(orders.get(i).toString());
		}
		this.orderSql = removeSelect(removeOrders(orderSql.toString()));
	}
	
	/**
	 * 拼装参数值
	 */
	private void appendValues(){
		Object [] val = new Object[values.size()];
		for (int i = 0; i < values.size(); i ++) {
			val[i] = values.get(i);
			valueMap.put(i, values.get(i));
		}
		this.valueArr = val;
	}

	public String builder(String tableName){
		String ws = removeFirstAnd(this.getWhereSql());
		String whereSql = ("".equals(ws) ? ws : (" where " + ws));
		String sql = "select * from " + tableName + whereSql;
		Object [] values = this.getValues();
		String orderSql = this.getOrderSql();
		orderSql = (StringUtils.isEmpty(orderSql) ? " " : (" order by " + orderSql));
		sql += orderSql;
		return sql;
	}


	private String removeFirstAnd(String sql){
		if(StringUtils.isEmpty(sql)){return sql;}
		return sql.trim().toLowerCase().replaceAll("^\\s*and", "") + " ";
	}

}
