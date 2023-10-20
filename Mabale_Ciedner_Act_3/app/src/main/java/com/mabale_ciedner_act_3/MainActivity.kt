package com.mabale_ciedner_act_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.mabale_ciedner_act_3.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val itemList = listOf(
            RecyclerAdapter.MyDataModel(
                "Gilbert Canete",
                "IT - STUDENT ",
                " Ako si Gilbert Canete nag puyo sa dakbayan sa Cebu. Ania ko karon sa Labangon kauban akong mama ug ang mga igsoun. Ako ang kinamaguwangan sa akong mga magigsoun"   ),

            RecyclerAdapter.MyDataModel(
                "Ryan Karlyle Bordadora",
                "IT - STUDENT",
                "Ako si Karlyle nag puyo ko karon sa Calero, Liloan Cebu. Akong kauban kay akong mama, kami ra duha diri sa akong mama ug akoy pinaka gwapo diri sa balay" ),

            RecyclerAdapter.MyDataModel(
                "Junas Nazarito",
                "IT - STUDENT",
                "Ako si Junas Nazarito Gutib, nag puyo diri sa Cubacub Mandaue City. Akong kauban diri sa balay akong mama ug papa. Wa koy igsoun kay bugtong anak ko nila. Nag skwela ko sa Banilad Cebu" ),

            RecyclerAdapter.MyDataModel(
                "Richard Macol",
                "IT - STUDENT",
                "Ako si Richard Macol, anggaan ko nilag Ricardo. Maayo ko mo duwag dota akong rank kay Immortal, ug masuya sila mo duwa ko kay maayo ko unya akong mga kauban wala katungtung ug ancient na bracket" ),

            RecyclerAdapter.MyDataModel(
                "Mark Nino Rocaberte",
                "IT - STUDENT",
                "Ako si Mark Nino Rocaberte nag puyo dire sa Talamban Cebu, kauban akong mga igsoun, ig agaw, akong lolo, akong lola, akong mama, akong uyab ug uban pang mga tao diri. Nag skwela ako sa UC Banilad Cebu" ),

            RecyclerAdapter.MyDataModel(
                "Hans Bernard Erguero",
                "IT - STUDENT",
                "Ako si Hans nag puyo sa Cabancalan Mandaue City. Akong edad kay 23 anyos nako, hilig ko mag Club kay mao man akong lingaw. ug mahuman ang klase ug mahuman kos buhaton sa skwelahan kay mag club ko ug ganahan ko" ),

            RecyclerAdapter.MyDataModel(
                "James Stephen Bulfa",
                "IT - STUDENT",
                "Ako si James Stephen Bulfa, usa ko sa mga kuyog ni Hans ug ni Ian ug mag club sila. Mego nako sila pero ug mag club mi unahon namo among project kay d mi ganahan mahagbong mi "),

            RecyclerAdapter.MyDataModel(
                "Ian Bencee",
                "IT - STUDENT",
                "Ako si Ian, kauban ko nila James ug Hans mag club ug mahuman mis among mga project sa skwelahan. Ako pud kay ganahan pud ko makapasar sa akong pag skwela kay sayang ang tuition gi bayad ni mama"),

            RecyclerAdapter.MyDataModel(
                "Joey Dawe",
                "IT - STUDENT",
                "Ako si Joey Dawe lumulopyo sa Danao Cebu, ug ako nag skwela didto UC Banilad. Usa ko ka IT Student. Graduating student ko karon ug palaron nga makapasar. "   ),
        )




        val adapter = RecyclerAdapter(itemList, ::onItemClick)

        with(binding.recyclerView) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            this.adapter = adapter
        }
    }

    private fun onItemClick(item: RecyclerAdapter.MyDataModel) {
        // Handle the item click here
        val intent = Intent(this, DetailActivity::class.java).apply {
            putExtra("NAME_PARAMS", item.name)
            putExtra("SUBJECT_PARAMS", item.subject)
            putExtra("MESSAGE_PARAMS", item.body)
        }
        startActivity(intent)
    }
}