import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.aibirthdaywisher.data.local.BirthdayDao
import com.example.aibirthdaywisher.data.local.CardTemplateDao
import com.example.aibirthdaywisher.data.model.Birthday
import com.example.aibirthdaywisher.data.model.CardTemplate
import android.content.Context

@Database(entities = [Birthday::class, CardTemplate::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun birthdayDao(): BirthdayDao
    abstract fun cardTemplateDao(): CardTemplateDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "birthday_wisher_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}