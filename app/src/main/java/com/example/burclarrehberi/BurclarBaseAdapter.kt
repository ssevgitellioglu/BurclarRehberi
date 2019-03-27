package com.example.burclarrehberi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.tek_satir.view.*

class BurclarBaseAdapter(context: Context,tumBurcBilgileri : ArrayList<Burc>) : BaseAdapter() {
    var TumBurclar = ArrayList<Burc>()

    var context: Context
    init {
        this.TumBurclar=tumBurcBilgileri
        this.context=context

    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var tek_satir_view=convertView
        var viewHolder:ViewHolder2
        if(tek_satir_view==null)
        {
            var inflater= LayoutInflater.from(context)
            tek_satir_view= inflater.inflate(R.layout.tek_satir,parent,false)
            viewHolder= ViewHolder2(tek_satir_view)
            tek_satir_view.tag=viewHolder
        }
        else{
            viewHolder=tek_satir_view.getTag() as ViewHolder2
        }

        viewHolder.burcResim.setImageResource(TumBurclar.get(position).burcSembol)
        viewHolder.burcAdi.setText(TumBurclar.get(position).burcAdi)
        viewHolder.burcTarihi.setText(TumBurclar.get(position).burcTarihi)


        return tek_satir_view
    }

    override fun getItem(position: Int): Any{
        return TumBurclar.get(position)
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return TumBurclar.size
    }

    class ViewHolder2(tek_satir_view : View){
        var burcResim : ImageView
        var burcAdi:TextView
        var burcTarihi: TextView
        init {
            this.burcResim=tek_satir_view.imgBurcSembolu
            this.burcAdi=tek_satir_view.txtBurcAdi
            this.burcTarihi=tek_satir_view.txtBurcTarihi
        }

    }


}
