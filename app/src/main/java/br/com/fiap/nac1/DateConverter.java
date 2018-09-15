package br.com.fiap.nac1;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

public class DateConverter {
    @TypeConverter
    public static Date toDate(Long dateLong){
        return dateLong == null ? null : new Date(dateLong);
    }

    @TypeConverter
    public static Long fromDate(Date date){
        return date == null ? null : date.getTime();
    }
}
