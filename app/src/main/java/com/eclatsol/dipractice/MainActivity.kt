package com.eclatsol.dipractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.eclatsol.dipractice.di.Computer
import com.eclatsol.dipractice.di.Test
import com.eclatsol.dipractice.di.interfaces.MainOne
import com.eclatsol.dipractice.di.interfaces.MainTwo
import com.eclatsol.dipractice.di.qualifiers.Testing
import com.eclatsol.dipractice.retrofit.container.BaseApp
import com.eclatsol.dipractice.retrofit.viewmodel.PostViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

//    private lateinit var baseApp: BaseApp
//    private val download = DownloadFactory.create()

    @Inject //Field Injection //Anotation
    lateinit var computer: Computer

    @Inject
    lateinit var mainOne: MainOne

    @Inject
    lateinit var mainTwo: MainTwo

    @Inject
    lateinit var test: Test

    @Inject
    lateinit var testing: Testing

    private val postViewModel: PostViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        baseApp = BaseApp()
//        baseApp.car.getCar() //BoilerPlate Code Vadhi jay che
//        download.getDownload()
        computer.getComputer()
        // Main(ImplementOne()).main() //DI no use karelo nathi //Tame directly pass kaelu//Di ma another source per depend rahe che
        //ImplementOne Name no class te pass karvo pade kem ke interface object create nathi kartu
        //Interface ni implementation class ma karvi shavi
        //ImplementOne parent class che //Child Interface che child ne problem ave to parent handel kare che
        //BaseApp().main.main()
        //BaseApp().data.addData()  //Every time object create karvi shavi //Better way nathi
        val baseApp = BaseApp()
        baseApp.main.main()
        baseApp.data.addData() //Manually Di for Dependency Injection

        mainOne.demoOne()
        mainTwo.demoTwo()
        test.getNames()

        testing.getTesting()

        postViewModel.response.observe(this, Observer { response ->
            Log.e("main", "onCreate: ${response[0].id}")
            Log.e("main", "onCreate: ${response[1].userId}")
            Log.e("main", "onCreate: ${response[2].title}")
            Log.e("main", "onCreate: ${response[3].body}")
        })

    }

    companion object{
        val FName = "Jemis"
        val LName = "Virani"
    }


    //Dagger Hilt //Anotation
    //Class = @Inject

    //Interface = @Module,@Binds,@Provides

    //@InstallIn(SingletonComponent::class)

    //External DI = @Modules,@Provides

    //Class
    //Class mate dependency provide karvi hoi to @Inject anotation no use karvo pade che

    //Interface
    //Interface constructor contains nathi kartu tena mate pela module create karvi shavi tema apne @Binds,@Provide anotation no use karvi shavi
    //Bind ni sathe apne Module ne use kari shavi to abstract class create karvo pade
    //@InstallIn(SingletonComponent::class) no matlab e che ke module ne hu akhi app ma use kari shaku shu
    //Module ni je pan dependency hashe tene hu akhi app ma use kari shakish
    //@Singleton anotation no matlab e che ke depedency provide karavo shavo tenu ek single instance create thashe
    //@Singleton anotation ne jo remove kari desho ne to signletone nahi bane dar vakte object create karshe
    //@Bind anotation na through tame dependency provide karavo shavo to module ne abstract function ne pan abstract karvu pashe
    //With the help of bind anotation

    //Apni pase ghana component hoi che activity component // fragment component che

    //External DI
    //External dependency injection no matlab e thay ke retrofit ni dependency provide karvi che //RoomDataBase ni dependency provide karvi che
    //Modules create karvu padshe //Provide name na anotation through dependency perform kari shakvi



}