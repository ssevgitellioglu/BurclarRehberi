package com.example.burclarrehberi

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit  var tumBurcBilgileri:ArrayList<Burc>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        veriKaynagiHazirla()

        var myBaseAdapter=BurclarBaseAdapter(this,tumBurcBilgileri)
        ListBurclar.adapter=myBaseAdapter

        ListBurclar.setOnItemClickListener { parent, view, position, id ->
            var intent= Intent(this@MainActivity,DetayActivity::class.java)
            intent.putExtra("tumBurcBilgileri",tumBurcBilgileri)

            startActivity(intent)
        }

    }

    private fun veriKaynagiHazirla() {

        tumBurcBilgileri=ArrayList<Burc>(12)
        var burclar=resources.getStringArray(R.array.burclar)
        var burcTarihi=resources.getStringArray(R.array.burcTarih)
        var burcSembolleri= arrayOf(R.drawable.koc,R.drawable.boga,R.drawable.ikizler,R.drawable.yengec,R.drawable.aslan,
            R.drawable.basak,R.drawable.terazi,R.drawable.akrep,
            R.drawable.yay,R.drawable.oglak,R.drawable.kova,R.drawable.balik)
        var burcArkaPlan= arrayOf(R.drawable.koc_burcu_2019,R.drawable.elle_boga,R.drawable.ikizler_burcu_1,
            R.drawable.elle_yengec,R.drawable.aslan_burcu_1,
            R.drawable.elle_basak,R.drawable.elle_terazi,R.drawable.elle_akrep,R.drawable.elle_yay,
            R.drawable.elle_oglak,R.drawable.kova_burcu_1_1,R.drawable.elle_balik)
        var burcGenelOzellikleri=resources.getStringArray(R.array.burcgenelozellikleri)

        for(i in 0..11)
        {
            var arrayListeAtanacakBurc=Burc(burclar[i],burcTarihi[i],burcSembolleri[i],burcArkaPlan[i],burcGenelOzellikleri[i])
            tumBurcBilgileri.add(arrayListeAtanacakBurc)
        }
    }
}
