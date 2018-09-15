package br.com.fiap.nac1;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;

@Database(entities = {Aluno.class}, version = 1)

public abstract class MyDataBase extends RoomDatabase {
    public abstract AlunoDao alunoDao();
}
