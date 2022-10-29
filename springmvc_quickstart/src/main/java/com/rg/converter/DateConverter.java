package com.rg.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @BelongsProject: springmvc_quickstart
 * @Author: RG
 * @CreateTime: 2022/10/27 7:18 下午
 * @Description:
 */
public class DateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String s) {

        // 将日期字符串转化成日期对象，进行返回
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
