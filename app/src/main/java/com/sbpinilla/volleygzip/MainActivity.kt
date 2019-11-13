package com.sbpinilla.volleygzip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.AuthFailureError
import com.android.volley.VolleyError
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNetwork()


    }

    private fun setupNetwork() {

        val url = "http://10.121.168.33:8080/ChaxGW/rest/seguridad/autenticarUsuario"

        var data = "{\"canalId\": \"PVA\",\"clave\": \"C6C9686891996D754575C6330EC5049EE18EEA3379652CC47908C3B9D768C837\",\"codigoVendedor\": \"9865308\",\"codigoTerminal\": \"C83F-1C0C\",\"tipoUsuario\": \"VENDEDOR\"}"

        // Volley post request with parameters

        val sr =
            object : StringRequest(Method.POST, url,
                Response.Listener { response ->


                },
                Response.ErrorListener { error ->  }) {
                override fun getBody(): ByteArray {
                    return data.toByteArray()
                }
                @Throws(AuthFailureError::class)
                override fun getHeaders(): Map<String, String> {
                    val params = HashMap<String, String>()
                    params["Accept-Encoding"] = "gzip"
                    return params
                }
            }


        VolleySingleton.getInstance(this).addToRequestQueue(sr)


    }
}
