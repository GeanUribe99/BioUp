package pe.edu.idat.bioup.core.bd
import android.content.Context;
import androidx.room.Room;
import dagger.Module;
import dagger.Provides
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class BioupDbModule {

    fun providePacienteDao(bioupDatabase: BioupDatabase): PacienteDao{
        return bioupDatabase.pacienteDao()
    }

    @Provides
    @Singleton
    fun provideBioupDatabase(@ApplicationContext context:Context): BioupDatabase {
        return Room.databaseBuilder(context, BioupDatabase::class.java, "bioupdb").build()
    }
}