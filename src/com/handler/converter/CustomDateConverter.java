package com.handler.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 日期转化器，需要实现Converter接口
 * @author Administrator
 *
 */
public class CustomDateConverter  implements Converter<String, Date>{

	public Date convert(String source) {
		//实现将日期串转成日期类型
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			//参数绑定成功
			return simpleDateFormat.parse(source);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//绑定失败，返回空
		return null;
	}

}
