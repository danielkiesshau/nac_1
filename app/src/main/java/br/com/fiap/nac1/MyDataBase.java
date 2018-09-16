package br.com.fiap.nac1;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;

@Database(entities = {Aluno.class}, version = 1)

public abstract class MyDataBase extends RoomDatabase {
    public abstract AlunoDao alunoDao();

    private static MyDataBase myInstance;

    public static MyDataBase getMyInstance(Context context) {
        if(myInstance == null){
            myInstance = Room.databaseBuilder(context, MyDataBase.class, "MyDataBase").build();
        }
        return myInstance;
    }
}
