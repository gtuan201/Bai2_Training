package com.example.bai2_training.viewmodel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bai2_training.model.Dish

class DishViewModel : ViewModel() {
    private var dessertLiveData : MutableLiveData<ArrayList<Dish>> = MutableLiveData()
    private var listDist : ArrayList<Dish>  = ArrayList()
    fun getDessert () : MutableLiveData<ArrayList<Dish>> {
        val list: ArrayList<Dish> = ArrayList()
        list.add(Dish("0001","Tráng miệng 1","Mô tả 1",1,10000,"https://firebasestorage.googleapis.com/v0/b/tcoffee-af872.appspot.com/o/Trathachvai.jpg?alt=media&token=ba35515c-9e6b-4d3f-8e51-617be8d6b48d",false))
        list.add(Dish("0002","Tráng miệng 2","Mô tả 2",1,10000,"https://firebasestorage.googleapis.com/v0/b/tcoffee-af872.appspot.com/o/cach-lam-tra-vai-0.jpg?alt=media&token=907e13de-7a48-4fa3-91eb-348acf49ff7e",false))
        list.add(Dish("0003","Tráng miệng 3","Mô tả 3",1,10000,"https://firebasestorage.googleapis.com/v0/b/tcoffee-af872.appspot.com/o/daosua.jpg?alt=media&token=25509e49-c67b-4a62-95fb-d63ebffed3cc",false))
        list.add(Dish("0004","Tráng miệng 4","Mô tả 4",1,10000,"https://firebasestorage.googleapis.com/v0/b/tcoffee-af872.appspot.com/o/hongtrachanh.jpg?alt=media&token=cf07091f-6f5e-4b4e-842c-b8d66a6c80a6",false))
        dessertLiveData.postValue(list)
        return dessertLiveData
    }
    fun getFood () : MutableLiveData<ArrayList<Dish>> {
        val list: ArrayList<Dish> = ArrayList()
        list.add(Dish("0001","Món chính 1","Mô tả 1",1,20000,"https://firebasestorage.googleapis.com/v0/b/tcoffee-af872.appspot.com/o/shop%2Faeonhadong.jpg?alt=media&token=9e30b64d-c871-45e1-977d-450cf0772dcc",false))
        list.add(Dish("0002","Món chính 2","Mô tả 2",1,20000,"https://firebasestorage.googleapis.com/v0/b/tcoffee-af872.appspot.com/o/shop%2Fnguyenvancu.jpg?alt=media&token=2ca97e0d-9781-4147-bd7e-6d4aeb91e658",false))
        list.add(Dish("0003","Món chính 3","Mô tả 3",1,20000,"https://firebasestorage.googleapis.com/v0/b/tcoffee-af872.appspot.com/o/shop%2Fparkhome.png?alt=media&token=f7519d6d-8ace-4cbf-b29c-cd933a9f4194",false))
        dessertLiveData.postValue(list)
        return dessertLiveData
    }
    fun getDrink () : MutableLiveData<ArrayList<Dish>> {
        val list: ArrayList<Dish> = ArrayList()
        list.add(Dish("0001","Đồ uống 1","Mô tả 1",1,30000,"https://firebasestorage.googleapis.com/v0/b/tcoffee-af872.appspot.com/o/bacxiuda.jpg?alt=media&token=5a1f6cce-240b-4d6c-b899-f93c062679b7",false))
        list.add(Dish("0002","Đồ uống 2","Mô tả 2",1,30000,"https://firebasestorage.googleapis.com/v0/b/tcoffee-af872.appspot.com/o/bruclee.jpg?alt=media&token=46c64da0-285f-4998-955c-852fb1a8630a",false))
        list.add(Dish("0003","Đồ uống 3","Mô tả 3",1,30000,"https://firebasestorage.googleapis.com/v0/b/tcoffee-af872.appspot.com/o/cafemocha.jpg?alt=media&token=e2a68ae3-bc09-4ccd-b578-e6883c7e02a2",false))
        dessertLiveData.postValue(list)
        return dessertLiveData
    }
    fun getDataList(): ArrayList<Dish> {
        return listDist
    }

    fun setDataList(dataList: ArrayList<Dish>) {
        this.listDist = dataList
    }
}