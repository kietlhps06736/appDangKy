package com.example.appdangky.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONObject;
import com.android.volley.VolleyError;
import com.example.appdangky.R;

import org.json.JSONException;
public class UserActivity extends AppCompatActivity {
    private RequestQueue mQueue;
    TextView tvId, tvMssv,tvTenSV,
            tvGioiTinh,tvSdt,tvEmail,
            tvDiaChi,tvNganh,tvTrangThai;
    int IdSV;
    String MaSV, TenSinhVien,GioiTinh,Phone,Email,DiaChi,Nganh,HocKy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        tvId = (TextView) findViewById(R.id.tvId);
        tvMssv = (TextView)findViewById(R.id.tvMSSV);
        tvTenSV = (TextView)findViewById(R.id.tvTen);
        tvGioiTinh = (TextView)findViewById(R.id.tvGioiTinh);
        tvSdt = (TextView)findViewById(R.id.tvSdt);
        tvEmail= (TextView)findViewById(R.id.tvEmail);
        tvDiaChi = (TextView)findViewById(R.id.tvDiachi);
        tvNganh = (TextView)findViewById(R.id.tvNganh);
        tvTrangThai = (TextView)findViewById(R.id.tvTrangThai);

        mQueue = Volley.newRequestQueue(this);

        jsonParse();
    }

    private void jsonParse() {
        String url = "https://dangkymonhoc.000webhostapp.com/API/getSinhVien.php/";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("data");
//                            Toast.makeText(UserActivity.this,response.toString(), Toast.LENGTH_SHORT).show();
                            for (int i = 0; i < jsonArray.length(); i++) {

                                JSONObject data = jsonArray.getJSONObject(i);

                                IdSV = data.getInt("IdSV");
                                MaSV = data.getString("MaSV");
                                TenSinhVien = data.getString("TenSinhVien");
                                GioiTinh = data.getString("GioiTinh");
                                Phone = data.getString("Phone");
                                Email = data.getString("Email");
                                DiaChi = data.getString("DiaChi");
                                Nganh = data.getString("Nganh");
                                HocKy = data.getString("HocKy");

                                tvId.setText(String.valueOf(IdSV));
                                tvMssv.setText(MaSV);
                                tvTenSV.setText(TenSinhVien);
                                tvGioiTinh.setText(GioiTinh);
                                tvEmail.setText(Email);
                                tvSdt.setText(Phone);
                                tvDiaChi.setText(DiaChi);
                                tvNganh.setText(Nganh);
                                tvTrangThai.setText(HocKy);



                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(UserActivity.this,"Error!!", Toast.LENGTH_SHORT).show();

                error.printStackTrace();
            }
        });
        mQueue.add(request);
    }
}
