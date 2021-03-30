package com.example.jetpack.viewmodels

import android.annotation.SuppressLint
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.jetpack.PersonDataClass
import com.example.jetpack.database.DatabaseBuilder
import java.util.concurrent.Executors

class PersonViewModel(application: Application) : AndroidViewModel(application) {

    @SuppressLint("StaticFieldLeak")
    private val context = getApplication<Application>().applicationContext
    lateinit var allPersons: LiveData<List<PersonDataClass>>
    private val roomDatabaseBuilder = DatabaseBuilder.getInstance(context)

    init {
        //getAllPersonsDetails()

        allPersons = roomDatabaseBuilder.personDao().getAllPersonsDetails()
        Executors.newSingleThreadExecutor().execute {

        }

    }

//    fun getAllPersonsDetailsObserver(): MutableLiveData<List<PersonDataClass>>  = allPersons

    /*private fun getAllPersonsDetails() {
        Executors.newSingleThreadExecutor().execute {
            val list = roomDatabaseBuilder.personDao().getAllPersonsDetails()
            allPersons.postValue(list)
        }
    }*/

    fun addPersonDetails(personDataClass: PersonDataClass) {
        Executors.newSingleThreadExecutor().execute {
            roomDatabaseBuilder.personDao().insertPersonDetails(
                PersonDataClass(
                    personId = personDataClass.personId,
                    personName = personDataClass.personName,
                    personContact = personDataClass.personContact,
                    personAddress = personDataClass.personAddress
                )
            )
        }
    }
}