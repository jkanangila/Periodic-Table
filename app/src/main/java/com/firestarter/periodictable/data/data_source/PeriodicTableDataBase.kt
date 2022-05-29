package com.firestarter.periodictable.data.data_source

import android.app.Application
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.firestarter.periodictable.R
import com.firestarter.periodictable.data.data_source.converters.Converters
import com.firestarter.periodictable.data.data_source.entity.ChemicalElementDetails
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONException
import java.io.IOException

@Database(
    entities = [ChemicalElementDetails::class],
    exportSchema = false,
    version = 1
)
@TypeConverters(Converters::class)
abstract class PeriodicTableDataBase: RoomDatabase() {

    abstract val dao: PeriodicTableDao

    companion object {

        private const val DATABASE_NAME = "periodic_table_db"
        @Volatile private var INSTANCE: PeriodicTableDataBase? = null

        fun getInstance(app: Application): PeriodicTableDataBase = INSTANCE ?: synchronized(this){
            INSTANCE ?: buildDatabase(app).also{ INSTANCE = it }
        }

        private fun buildDatabase(app: Application) =
            Room.databaseBuilder(
                app,
                PeriodicTableDataBase::class.java,
                DATABASE_NAME
            )
                .addCallback(
                    // DATABASE PRE-POPULATED HERE
                    object: Callback(){
                        @RequiresApi(Build.VERSION_CODES.N)
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)

                            val handler = CoroutineExceptionHandler { _, throwable ->
                                Log.d(
                                    "DATABASE_CREATION",
                                    "Caught during database create",
                                    throwable
                                )
                            }

                            CoroutineScope(Dispatchers.IO).launch(handler){
                                prePopulateDatabase(app, getInstance(app).dao)
                            }
                        }
                    }
                )
                .build()

        @RequiresApi(Build.VERSION_CODES.N)
        private suspend fun prePopulateDatabase(app: Application, dao: PeriodicTableDao) {
            val elements = loadJSONData(app)

            try {
                elements?.forEach { element ->
                    dao.insertElement(element)
                }
            } catch (e: Exception){
                e.printStackTrace()
            }
        }

        private fun loadJSONData(context: Context?): List<ChemicalElementDetails>?{

            val jsonString: String

            try {
                jsonString = context?.resources!!
                    .openRawResource(R.raw.periodic_table)
                    .bufferedReader().use { it.readText() }

                val listContactTypes = object: TypeToken<List<ChemicalElementDetails>>(){}.type

                return Gson().fromJson(jsonString, listContactTypes)

            } catch (ioException: IOException){
                ioException.printStackTrace()
            } catch (jsonException: JSONException){
                jsonException.printStackTrace()
            }
            return null
        }
    }
}