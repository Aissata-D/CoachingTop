package com.sitadigi.coachingtop

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sitadigi.coachingtop.database.CoachingTopDatabase
import com.sitadigi.coachingtop.models.User
import com.sitadigi.coachingtop.models.Video
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.*
import org.junit.Assert.assertEquals


@RunWith(AndroidJUnit4::class)// AndroidJUnit4 est le Runner utilisé pour notre test instrumenté  ici--> il est souvent utilisé par defaut
class UserDaoTest {

    private lateinit var database: CoachingTopDatabase
    val videoTest = Video(1, "video_path")

    @Before// L'annotation @Before précise que la méthode createBd doit être appelée avant l’exécution de chacun des tests.
    fun createBd() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),  //À noter que pour créer l’instance de la base de données vous aurez besoin d’unContext. Dans le cadre de tests d’instrumentation, il est possible d’en obtenir une instance grâce à la méthode  ApplicationProvider.getApplicationContext()
            CoachingTopDatabase::class.java
        ).allowMainThreadQueries()
            .build()  //Pour manipuler la base de données dans les tests, on privilégie une base de données in memory sur laquelle la manipulation sur le thread principal est permise.

    }

    @After //  @After précise que cette méthode doit être appelée après l’exécution de chacun des tests.
    fun closeBd() {
        database.close() // on ferme la base de donnée après chq test ---> garantit que toutes les ressources SQlite ouvertes lors du test sont correctement libérées. On évite ainsi des fuites de mémoire et des potentiels effets de bord lors de l’exécution du test suivant.
    }

    @Test// @Test pour indiquer que c'est un test
    fun insertUserIntoDatabaseSuccessfully() =
        runTest { // En kotlin on encapsule l’exécution du futur test dans la méthode runTest pour gérer facilement les coroutines.
            //Given
            val user = User(1, "Aissata", "Je suis courageuse", "image_path", 1)
            //When
            database.videoDao().createVideo(videoTest)
            database.userDao().createUser(user)

            //then
            val insertedUser = database.userDao().getUserById(1)

            //Verify
            assertEquals("Inserted and retrieved user must be equal", user, insertedUser)
        }

    @Test
    fun updateUserIntoDatabaseSuccessfully() =
        runTest { // En kotlin on encapsule l’exécution du futur test dans la méthode runTest pour gérer facilement les coroutines.
            //Given
            database.videoDao().createVideo(videoTest)
            val user = User(1, "Aissata", "Je suis courageuse", "image_path", 1)
            val updatedUser = User(1, "Souare", "Je suis perceverante", "image_path", 1)
            //When
            database.userDao().createUser(user)
            database.userDao().updateUser(updatedUser)

            //then
            val insertedUser = database.userDao().getUserById(1)

            //Verify
            assertEquals("Inserted and retrieved user must be equal", insertedUser, updatedUser)
        }

    @Test
    fun deleteUserIntoDatabaseSuccessfully() =
        runTest { // En kotlin on encapsule l’exécution du futur test dans la méthode runTest pour gérer facilement les coroutines.
            //Given
            database.videoDao().createVideo(videoTest)
            val user = User(1, "Aissata", "Je suis courageuse", "image_path", 1)
            //When
            database.userDao().createUser(user)

            //then
            database.userDao().deleteUser(user)
            val deletedUser = database.userDao().getUserById(1)

            //Verify
            assertEquals("Inserted and retrieved user must be equal", null, deletedUser)
        }


    /*

            // FOR DATA
            private var database: CoachingTopDatabase? = null

            @Rule
            var instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

            @Before
            @Throws(Exception::class)
            fun initDb() {
                this.database = inMemoryDatabaseBuilder(
                    InstrumentationRegistry.getContext(),

                    CoachingTopDatabase::class.java
                )

                    .allowMainThreadQueries()

                    .build()
            }

            @After
            @Throws(Exception::class)
            fun closeDb() {
                database?.close()
            }

    */
}