package com.cqupt.web.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定义一个转换器，将2018-10-5类型的字符串转换成date
 *
 * 先使用"yyyy-MM-dd",若出现异常则使用yyyy/MM/dd
 */
public class DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        String pattern1 = "yyyy-MM-dd";
        String pattern2 = "yyyy/MM/dd";

        SimpleDateFormat dateFormat = new SimpleDateFormat();
        try {
            dateFormat.applyPattern(pattern1);
            return dateFormat.parse(source);
        } catch (ParseException e) {

            try {
                dateFormat.applyPattern(pattern2);
                return dateFormat.parse(source);
            } catch (ParseException ex) {
                System.out.println("转换出现异常");
                ex.printStackTrace();
            }
        }
        return null;
    }
}
