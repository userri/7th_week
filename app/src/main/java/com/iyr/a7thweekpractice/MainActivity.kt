package com.iyr.a7thweekpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.iyr.a7thweekpractice.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.invoke
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    var dataList1 = ArrayList<MyStringEntity>() // 초기화 해야함
//    var dataList2 : ArrayList<String> = arrayListOf() // null로 선언
//    var myStringDatabase : MyStringDatabase? = null // 데이터베이스 객체 만듦
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        myStringDatabase = MyStringDatabase.getInstance(this)
//        myStringDatabase!!.getMyStringDAO().addMyString(MyStringEntity("item0"))
//        myStringDatabase!!.getMyStringDAO().addMyString(MyStringEntity("item1"))
//        myStringDatabase!!.getMyStringDAO().addMyString(MyStringEntity("item2"))
//        myStringDatabase!!.getMyStringDAO().addMyString(MyStringEntity("item3"))
//        myStringDatabase!!.getMyStringDAO().addMyString(MyStringEntity("item4"))
//        myStringDatabase!!.getMyStringDAO().addMyString(MyStringEntity("item5"))
//        myStringDatabase!!.getMyStringDAO().addMyString(MyStringEntity("item6"))
//        myStringDatabase!!.getMyStringDAO().addMyString(MyStringEntity("item7"))
//        myStringDatabase!!.getMyStringDAO().addMyString(MyStringEntity("item8"))
//        myStringDatabase!!.getMyStringDAO().addMyString(MyStringEntity("item9"))
//        myStringDatabase!!.getMyStringDAO().addMyString(MyStringEntity("item10"))
//
//        dataList1.addAll(myStringDatabase!!.getMyStringDAO().getAllMyStrings())


        CoroutineScope(Dispatchers.IO).launch {
            while (true) {
                delay(1000)
                dataList1.add(MyStringEntity("item" + count++))
//                myStringDatabase!!.getMyStringDAO().addMyString(MyStringEntity("item" + count++))

//                val arrList = arrayListOf<MyStringEntity>()
//                arrList.addAll(myStringDatabase!!.getMyStringDAO().getAllMyStrings())

                withContext(Dispatchers.Main) {
                    binding.rvHome.adapter!!.notifyDataSetChanged()
//                    (binding.rvHome.adapter as JustAdapter).setData(arrList)
                }
                Log.d("coroutineScope", "코루틴작동")
            }
        }

        binding.rvHome.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvHome.adapter = JustAdapter(dataList1)

    }
}